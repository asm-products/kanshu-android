package com.kanshu.kanshu;

/**
 * Created by zhou on 1/15/15.
 * This is a data wrapper for an article, @todo add more stuff here later (such as image source)
 */
public class Article {

    public String title;
    public String summary;
    public int like = 0;

    public Article(){}

    public void setTitle(String nTitle){
        title = nTitle;
    }

    public String getTitle(){
        return title;
    }

    public void setSummary(String nSummary){
        summary = nSummary;
    }

    public String getSummary(){
        return summary;
    }

    public int getLike(){
        return like;
    }

    public void setLike(int l){
        like = l;
    }
}
