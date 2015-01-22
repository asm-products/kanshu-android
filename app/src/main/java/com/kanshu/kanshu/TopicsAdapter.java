package com.kanshu.kanshu;

/**
 * Created by med on 22-01-2015.
 */

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.text.TextUtils;
import com.kanshu.kanshu.Model.Topic;
import com.kanshu.kanshu.controller.TopicsController;

import com.squareup.picasso.Picasso;

public class TopicsAdapter extends BaseAdapter {
    private ArrayList<Topic> mTopicsList;
    private Activity activity;
    private final Typeface tf;
    TopicsController mTopicsController;

    public TopicsAdapter(Activity context,
                         ArrayList<Topic> mTopicsList, Typeface tfBold, TopicsController mTopicsController) {
        super();
        this.mTopicsList = mTopicsList;
        activity = context;
        this.tf = tfBold;
        this.mTopicsController = mTopicsController;

    }


    public static class ViewHolder {

        public TextView tvTopicTitle;
        public ImageView IvTopicImg;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        ViewHolder holder;
        if (v == null) {
            LayoutInflater vi =
                    (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.topic_card, null);

            holder = new ViewHolder();

            holder.tvTopicTitle = (TextView) v.findViewById(R.id.topicTitle);
            holder.IvTopicImg = (ImageView) v.findViewById(R.id.topic_image);

            v.setTag(holder);
        } else holder = (ViewHolder) v.getTag();

        if (!TextUtils.isEmpty(mTopicsList.get(position).getTitle())) {
            holder.tvTopicTitle.setText(mTopicsList.get(position).getTitle());
            holder.tvTopicTitle.setTypeface(tf);
        } else {
            holder.tvTopicTitle.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(mTopicsList.get(position).getImgURL())) {
            Picasso.with(activity).load(R.drawable.kanshu).into(holder.IvTopicImg);

         } else {
            holder.IvTopicImg.setVisibility(View.GONE);
        }
         return v;
    }

    @Override
    public int getCount() {
        return mTopicsList == null ? 0 : mTopicsList.size();
    }

    @Override
    public Object getItem(int position) {
        return mTopicsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}