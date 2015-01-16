package com.kanshu.kanshu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zhou on 1/15/15.
 */
public class ArticleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Article> articleList;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ArticleViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        // add image source later
        public TextView titleTextView;
        public TextView summaryTextView;

        public ArticleViewHolder(View v) {
            super(v);
            titleTextView = (TextView)v.findViewById(R.id.article_title);
            summaryTextView = (TextView)v.findViewById(R.id.article_summary);
        }
    }

    public static class IndicatorViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        // add image source later
        public TextView indicatorTextView;

        public IndicatorViewHolder(View v) {
            super(v);
            indicatorTextView = (TextView)v.findViewById(R.id.article_indicator);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ArticleAdapter(List<Article> lst) {
        articleList = lst;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        switch (viewType) {
            case 1:
                // create a new view
                View v2 = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.date_indicator, parent, false);
                RecyclerView.ViewHolder vh2 = new IndicatorViewHolder(v2);
                return vh2;
            default:
                // create a new view
                View v1 = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.article_card, parent, false);
                RecyclerView.ViewHolder vh1 = new ArticleViewHolder(v1);
                return vh1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        //@todo replace this with a real get item new type method based on the real data
        //right now I would just make every 5th card an indicator
        if (position % 5 == 0){
            return 1;
        }
        else{
            return 0;
        }
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Article article = articleList.get(position);
        //@todo set the real data here.
        // holder.titleTextView.setText(article.getTitle())
        // For illustrative purpose, do nothing here

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return articleList.size();
    }
}
