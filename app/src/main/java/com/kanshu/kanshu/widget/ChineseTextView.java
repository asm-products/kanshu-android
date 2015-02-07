package com.kanshu.kanshu.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.TypefaceUtils;

public class ChineseTextView extends TextView {
    public ChineseTextView(Context context) {
        super(context);
        init();
    }

    public ChineseTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ChineseTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ChineseTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
        setTypeface(TypefaceUtils.load(getContext().getAssets(), "fonts/BabelStoneHan.ttf"));
//      setTypeface(TypefaceUtils.load(getContext().getAssets(), "fonts/NotoSansCJKsc-Regular.otf"));
        }
    }
}
