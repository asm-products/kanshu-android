package com.kanshu.kanshu.test.screen;

import android.widget.Button;
import android.widget.GridView;

import com.kanshu.kanshu.R;
import com.kanshu.kanshu.TopicsActivity;

/**
 * 'Page Object design pattern' for Topics Activity Screen
 * @author Victor Sima
 */
public class TopicsScreen {

    private Button doneButton;
    private GridView gridView;

    public TopicsScreen(TopicsActivity topicsActivity) {
        doneButton = (Button) topicsActivity.findViewById(R.id.Topics_Next);//TODO: id's should be camel case!
        gridView = (GridView) topicsActivity.findViewById(R.id.list);
    }

    public Button getDoneButton() {
        return doneButton;
    }

    public GridView getGridView() {
        return gridView;
    }
}
