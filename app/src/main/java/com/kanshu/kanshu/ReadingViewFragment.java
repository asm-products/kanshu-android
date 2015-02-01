package com.kanshu.kanshu;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ReadingViewFragment.OnFragmentClickListener} interface
 * to handle interaction events.
 */
public class ReadingViewFragment extends Fragment {


    private OnFragmentClickListener mListener;
    private boolean mIsSliderCollapsed;


    public ReadingViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIsSliderCollapsed = true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_reading_view, container, false);
        final LinearLayout seekBarLayout = ((LinearLayout) v.findViewById(R.id.levelSliderFrame));
        final RelativeLayout hanziLayout = ((RelativeLayout) v.findViewById(R.id.hanziSlider));
        final RelativeLayout textSizeLayout = ((RelativeLayout) v.findViewById(R.id.alphaSlider));
        seekBarLayout.setAlpha(0.3f);
        LayoutTransition transition = new LayoutTransition();
        transition.setStagger(LayoutTransition.DISAPPEARING,1);
        transition.setStagger(LayoutTransition.APPEARING,1);
        transition.setStartDelay(LayoutTransition.DISAPPEARING, 1);
        transition.setStartDelay(LayoutTransition.APPEARING, 1);
        transition.setStartDelay(LayoutTransition.CHANGE_DISAPPEARING,1);
        transition.setStartDelay(LayoutTransition.CHANGE_APPEARING,1);
        seekBarLayout.setLayoutTransition(transition);
        seekBarLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                  if(mIsSliderCollapsed){
                      hanziLayout.setVisibility(View.VISIBLE);
                      textSizeLayout.setVisibility(View.VISIBLE);
                      seekBarLayout.getLayoutTransition().addTransitionListener(new LayoutTransition.TransitionListener() {
                          @Override
                          public void startTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {

                          }

                          @Override
                          public void endTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {
                              if (view == hanziLayout) {
                                  seekBarLayout.setAlpha(1.0f);
                                  seekBarLayout.getLayoutTransition().removeTransitionListener(this);
                              }
                          }
                      });
                      mIsSliderCollapsed = false;
                  }
                }
                return true;
            }
        });

        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (!mIsSliderCollapsed) {
                        textSizeLayout.setVisibility(View.GONE);
                        hanziLayout.setVisibility(View.GONE);
                        seekBarLayout.getLayoutTransition().addTransitionListener(new LayoutTransition.TransitionListener() {
                            @Override
                            public void startTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {

                            }

                            @Override
                            public void endTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {
                                if(view == hanziLayout){
                                    seekBarLayout.setAlpha(0.3f);
                                    seekBarLayout.getLayoutTransition().removeTransitionListener(this);
                                }
                            }
                        });
                        mIsSliderCollapsed = true;
                    }
                }
                return true;
            }
        });
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onClick(View v) {
        if (mListener != null) {
            mListener.onFragmentClick(v);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentClickListener {
        // TODO: Update argument type and name
        public void onFragmentClick(View v);
    }

}
