package com.kanshu.kanshu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by zhou on 1/21/15.
 */
public class ArticleListCommentAdapter extends ArrayAdapter<String>{

    private Context context;
    private String[] values;

    public ArticleListCommentAdapter(Context context, String[] values){
        super(context, R.layout.article_card_comment, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //@todo replace this view real data
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.article_card_comment, parent, false);
        return rowView;
    }
}
