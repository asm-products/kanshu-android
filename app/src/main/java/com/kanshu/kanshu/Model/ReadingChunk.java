package com.kanshu.kanshu.model;

import android.content.Context;
import android.graphics.Rect;
import android.util.TypedValue;
import android.widget.TextView;

import com.kanshu.kanshu.R;

import uk.co.chrisjenx.calligraphy.TypefaceUtils;

public class ReadingChunk {

    private final float width;
    private String pinyin;
    private String hanzi;
    private String definition;

    public ReadingChunk(Context context, String pinyin, String hanzi, String definition) {
        this.pinyin = pinyin;
        this.hanzi = hanzi;
        this.definition = definition;

        // Calculate the width of each line of text to find the widest
        TextView pinyinTextView = new TextView(context);
        pinyinTextView.setText(getPinyin());
        pinyinTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R
                .dimen.item_reading_default_pinyin_text_size));
        Rect pinyinBounds = new Rect();
        pinyinTextView.getPaint().getTextBounds(getPinyin(), 0, pinyin.length(), pinyinBounds);

        TextView hanziTextView = new TextView(context);
        hanziTextView.setText(getHanzi());
        hanziTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension
                (R.dimen
                .item_reading_default_hanzi_text_size));
        hanziTextView.setTypeface(TypefaceUtils.load(context.getAssets(), "fonts/BabelStoneHan.ttf"));
        Rect hanziBounds = new Rect();
        hanziTextView.getPaint().getTextBounds(getHanzi(), 0, hanzi.length(), hanziBounds);

        TextView definitionTextView = new TextView(context);
        definitionTextView.setText(getDefinition());
        definitionTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R
                .dimen.item_reading_default_definition_text_size));
        Rect definitionBounds = new Rect();
        definitionTextView.getPaint().getTextBounds(getDefinition(), 0, definitionTextView.length(),
                definitionBounds);

        width = Math.max(Math.max(pinyinBounds.width(), hanziBounds.width()),
                definitionBounds.width()) + context.getResources().getDimensionPixelSize(R.dimen.item_reading_padding);
    }

    public String getPinyin() {
        return pinyin;
    }

    public String getHanzi() {
        return hanzi;
    }

    public String getDefinition() {
        return definition;
    }

    public float getWidth() {
        return width;
    }
}
