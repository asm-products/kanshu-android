package com.kanshu.kanshu.controller;

import com.kanshu.kanshu.Model.Topic;

import java.util.ArrayList;

/**
 * Created by alouanemed on 22-01-2015.
 * this class is responsable for all the operations related to topics
 */
public class TopicsController {

    private ArrayList<Topic> mTopicsList;

    public TopicsController(){
        mTopicsList = new ArrayList<Topic>();
    }

    //Let's fill the list with dummy data
    public void getTopics(){
        mTopicsList.add( new Topic("Science","tpic"));
        mTopicsList.add( new Topic("Technology",""));
        mTopicsList.add( new Topic("Gaming",""));
        mTopicsList.add( new Topic("Culture",""));
        mTopicsList.add( new Topic("Art","tpic"));
        mTopicsList.add( new Topic("Design",""));
        mTopicsList.add( new Topic("Locales",""));
        mTopicsList.add( new Topic("Travel",""));
        mTopicsList.add( new Topic("Stores","tpic"));
        mTopicsList.add( new Topic("Photography",""));
        mTopicsList.add( new Topic("Dance",""));
        mTopicsList.add( new Topic("Music",""));

    }


    public ArrayList<Topic> getmTopicsList() {
        return mTopicsList;
    }

    public void setmTopicsList(ArrayList<Topic> mTopicsList) {
        this.mTopicsList = mTopicsList;
    }
}
