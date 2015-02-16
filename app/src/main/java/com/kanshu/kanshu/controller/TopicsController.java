package com.kanshu.kanshu.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

import com.kanshu.kanshu.model.Topic;

import java.util.ArrayList;

/**
 * Created by alouanemed on 22-01-2015.
 */
public class TopicsController {

    private ArrayList<Topic> mTopicsList;
    private Context mContext;

    public TopicsController( Context mContext) {
        mTopicsList = new ArrayList<Topic>();
        this.mContext = mContext;
    }

    //Let's fill the list with dummy data
    public void getTopics() {
        mTopicsList.add(new Topic("Science/Technology", "topic_science_and_tech_48dp"));
        mTopicsList.add(new Topic("Gaming","topic_games_48dp"));
        mTopicsList.add(new Topic("Culture And History","topic_history_and_culture_48dp"));
        mTopicsList.add(new Topic("Art", "topic_art_48dp"));
        mTopicsList.add(new Topic("China", "topic_china_48dp"));
        mTopicsList.add(new Topic("Humour", "topic_humour_48dp"));
        mTopicsList.add(new Topic("Entertainment", "topic_entertainment_48dp"));
        mTopicsList.add(new Topic("News and Politics", "topic_news_and_politics_48dp"));
        mTopicsList.add(new Topic("Travel", "topic_travel_48dp"));
        mTopicsList.add(new Topic("Finance and Economic", "topic_finance_and_economics_48dp"));
        mTopicsList.add(new Topic("Spirituality", "topic_spirituality_48dp"));
        mTopicsList.add(new Topic("Fashion and Lifestyle", "topic_fashion_and_lifestyle_48dp"));
        mTopicsList.add(new Topic("Sports", "topic_sports_48dp"));
        mTopicsList.add(new Topic("Auto", "topic_auto_48dp"));
        mTopicsList.add(new Topic("Literature", "topic_literature_48dp"));
    }


    public ArrayList<Topic> getmTopicsList() {
        return mTopicsList;
    }

    public void setmTopicsList(ArrayList<Topic> mTopicsList) {
        this.mTopicsList = mTopicsList;
    }

    public Bitmap toGrayscale(String Img_url)
    {
        int width, height;
        int drawable_id = mContext.getResources().getIdentifier((Img_url
        ), "drawable", mContext.getPackageName());

        Bitmap bmpOriginal = BitmapFactory.decodeResource( mContext.getResources(), drawable_id);

        height = bmpOriginal.getHeight();
        width = bmpOriginal.getWidth();

        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
        paint.setColorFilter(f);
        c.drawBitmap(bmpOriginal, 0, 0, paint);
        return bmpGrayscale;
    }
}
