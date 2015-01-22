package com.kanshu.kanshu.Model;

/**
 * Created by alouanemed on 22-01-2015.
 * This is a data wrapper for a topic
 */
public class Topic {

    private String Title;
    private String imgURL;

    public Topic(String title, String imgURL) {
        Title = title;
        this.imgURL = imgURL;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getTitle() {

        return Title;
    }

    public String getImgURL() {
        return imgURL;
    }
}
