package com.kanshu.kanshu.controller;

import com.kanshu.kanshu.model.Topic;

import java.util.ArrayList;

/**
 * Created by alouanemed on 22-01-2015.
 */
public class TopicsController {

    private ArrayList<Topic> mTopicsList;

    public TopicsController() {
        mTopicsList = new ArrayList<Topic>();
    }

    //Let's fill the list with dummy data
    public void getTopics() {
        mTopicsList.add(new Topic("Science/Technology", "topic_science_and_tech_gray_48dp"));
        mTopicsList.add(new Topic("Gaming","topic_games_gray_48dp"));
        mTopicsList.add(new Topic("Culture And History","topic_history_and_culture_gray_48dp"));
        mTopicsList.add(new Topic("Art", "topic_art_gray_48dp"));
        mTopicsList.add(new Topic("China", "topic_china_gray_48dp"));
        mTopicsList.add(new Topic("Humour", "topic_humour_gray_48dp"));
        mTopicsList.add(new Topic("Entertainment", "topic_entertainment_gray_48dp"));
        mTopicsList.add(new Topic("News and Politics", "topic_news_and_politics_gray_48dp"));
        mTopicsList.add(new Topic("Travel", "topic_travel_gray_48dp"));
        mTopicsList.add(new Topic("Finance and Economic", "topic_finance_and_economics_gray_48dp"));
        mTopicsList.add(new Topic("Spirituality", "topic_spirituality_gray_48dp"));
        mTopicsList.add(new Topic("Fashion and Lifestyle", "topic_fashion_and_lifestyle_gray_48dp"));
        mTopicsList.add(new Topic("Sports", "topic_sports_gray_48dp"));
        mTopicsList.add(new Topic("Auto", "topic_auto_gray_48dp"));
        mTopicsList.add(new Topic("Literature", "topic_literature_gray_48dp"));
    }


    public ArrayList<Topic> getmTopicsList() {
        return mTopicsList;
    }

    public void setmTopicsList(ArrayList<Topic> mTopicsList) {
        this.mTopicsList = mTopicsList;
    }
}
