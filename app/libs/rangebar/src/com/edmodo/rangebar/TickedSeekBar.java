package com.edmodo.rangebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class TickedSeekBar extends RangeBar{
    private Bar mBar;
    private Thumb mThumb;
    private int mIndex;
    private TickedSeekBar.OnTickChangeListener mListener;

    public TickedSeekBar(Context context) {
        super(context);
    }

    public TickedSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        tickedSeekBarInit(context, attrs);
    }

    public TickedSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        tickedSeekBarInit(context, attrs);
    }

    // View Methods ////////////////////////////////////////////////////////////

    @Override
    public Parcelable onSaveInstanceState() {

        final Bundle bundle = new Bundle();

        bundle.putParcelable("RangeBar",super.onSaveInstanceState());

        bundle.putInt("TICK_INDEX", mIndex);


        return bundle;
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {

        if (state instanceof Bundle) {

            final Bundle bundle = (Bundle) state;
            super.onRestoreInstanceState(bundle.getParcelable("RangeBar"));

            mIndex = bundle.getInt("TICK_INDEX");

            setThumbIndex(mIndex);


        } else {

            super.onRestoreInstanceState(state);
        }
    }

    @Override
    protected float getMarginLeft() {
        return ((mThumb != null) ? mThumb.getHalfWidth() : 0);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        super.onSizeChanged(w, h, oldw, oldh);

        final Context ctx = getContext();

        // This is the initial point at which we know the size of the View.

        // Create the two thumb objects.
        final float yPos = h / 2f;
        mThumb = new Thumb(ctx,
                yPos,
                mThumbColorNormal,
                mThumbColorPressed,
                mThumbRadiusDP,
                mThumbImageNormal,
                mThumbImagePressed);

        // Create the underlying bar.
        final float marginLeft = mThumb.getHalfWidth();
        final float barLength = w - 2 * marginLeft;
        mBar = new Bar(ctx, marginLeft, yPos, barLength, mTickCount, mTickHeightDP, mBarWeight, mBarColor);

        // Initialize thumbs to the desired indices
        mThumb.setX(marginLeft + (mIndex / (float) (mTickCount - 1)) * barLength);

        // Set the thumb indices.
        final int newIndex = mBar.getNearestTickIndex(mThumb);

        // Call the listener.
        if (newIndex != mIndex) {

            mIndex = newIndex;

            if (mListener != null) {
                mListener.onIndexChangeListener(this, mIndex);
            }
        }

        // Create the line connecting the two thumbs.
        mConnectingLine = new ConnectingLine(ctx, yPos, mConnectingLineWeight, mConnectingLineColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //super.onDraw(canvas);

        mBar.draw(canvas);

        mConnectingLine.draw(canvas, mLeftThumb, mThumb);

        mThumb.draw(canvas);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        // If this View is not enabled, don't allow for touch interactions.
        if (!isEnabled()) {
            return false;
        }

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                onActionDown(event.getX(), event.getY());
                return true;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                this.getParent().requestDisallowInterceptTouchEvent(false);
                onActionUp(event.getX(), event.getY());
                return true;

            case MotionEvent.ACTION_MOVE:
                onActionMove(event.getX());
                this.getParent().requestDisallowInterceptTouchEvent(true);
                return true;

            default:
                return false;
        }
    }

    public void OnTickChangeListener(TickedSeekBar.OnTickChangeListener listener) {
        mListener = listener;
    }

    public int getIndex() {
        return mIndex;
    }

    public void setThumbIndex(int thumbIndex)
    {
        if (indexOutOfRange(thumbIndex, thumbIndex)) {
            throw new IllegalArgumentException("A thumb index is out of bounds. Check that it is between 0 and mTickCount - 1");

        } else {

            if (mFirstSetTickCount == true)
                mFirstSetTickCount = false;

            mIndex = thumbIndex;
            createThumb();

            if (mListener != null) {
                mListener.onIndexChangeListener(this, mIndex);
            }
        }

        invalidate();
        requestLayout();
    }

    private void tickedSeekBarInit(Context context, AttributeSet attrs)
    {
        mIndex = 0;

        if (mListener != null) {
            mListener.onIndexChangeListener(this, mIndex);
        }

        createThumb();
    }

    private void createThumb() {

        Context ctx = getContext();
        float yPos = getYPos();

        mThumb = new Thumb(ctx,
                yPos,
                mThumbColorNormal,
                mThumbColorPressed,
                mThumbRadiusDP,
                mThumbImageNormal,
                mThumbImagePressed);

        float marginLeft = getMarginLeft();
        float barLength = getBarLength();

        // Initialize thumbs to the desired indices
        mThumb.setX(marginLeft + (mIndex / (float) (mTickCount - 1)) * barLength);

        invalidate();
    }

    /**
     * Handles a {@link MotionEvent#ACTION_DOWN} event.
     *
     * @param x the x-coordinate of the down action
     * @param y the y-coordinate of the down action
     */
    private void onActionDown(float x, float y) {

        if (!mThumb.isPressed() && mThumb.isInTargetZone(x, y)) {

            pressThumb(mThumb);
        }
    }

    /**
     * Handles a {@link MotionEvent#ACTION_UP} or
     * {@link MotionEvent#ACTION_CANCEL} event.
     *
     * @param x the x-coordinate of the up action
     * @param y the y-coordinate of the up action
     */
    private void onActionUp(float x, float y) {

        if (mThumb.isPressed()) {

            releaseThumb(mThumb);

        } else {

            float thumbXDistance = Math.abs(mThumb.getX() - x);

            // Get the updated nearest tick marks for thumb.
            final int newIndex = mBar.getNearestTickIndex(mThumb);

            if (newIndex != mIndex) {

                mIndex = newIndex;

                if (mListener != null) {
                    mListener.onIndexChangeListener(this, mIndex);
                }
            }
        }
    }

    /**
     * Handles a {@link MotionEvent#ACTION_MOVE} event.
     *
     * @param x the x-coordinate of the move event
     */
    private void onActionMove(float x) {

        // Move the pressed thumb to the new x-position.
        if (mThumb.isPressed()) {
            moveThumb(mThumb, x);
        }
        // Get the updated nearest tick marks for each thumb.
        final int newIndex = mBar.getNearestTickIndex(mThumb);

        // If either of the indices have changed, update and call the listener.
        if (newIndex != mIndex) {

            mIndex = newIndex;

            if (mListener != null) {
                mListener.onIndexChangeListener(this, mIndex);
            }
        }
    }

    // Inner Classes ///////////////////////////////////////////////////////////

    /**
     * A callback that notifies clients when the TickedSeekBar has changed. The
     * listener will only be called when the thumb's index has changed - not
     * for every movement of the thumb.
     */
    public static interface OnTickChangeListener {

        public void onIndexChangeListener(TickedSeekBar seekBar, int thumbIndex);
    }
}