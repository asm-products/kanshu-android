package com.kanshu.android.activity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.kanshu.android.R;
import com.kanshu.android.adapter.TopicsAdapter;
import com.kanshu.android.controller.TopicsController;
import com.kanshu.android.model.Topic;

import java.util.ArrayList;
import java.util.Iterator;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by alouanemed on 22-01-2015.
 */
public class TopicsActivity extends BaseActivity {

    //dialog
    ProgressDialog dialog = null;
    //controller var
    TopicsController mTopicsController;
    //we will store the selected IDs instead of titles
    private ArrayList<Integer> mChosenTopicsListIDs;
    int inc = 0;

    //TextView tvTopicsTitle;
    GridView mGridview;
    Button btnTopics_Next;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);
        btnTopics_Next = (Button) findViewById(R.id.Topics_Next);
        mGridview = (GridView) findViewById(R.id.list);

        mTopicsController = new TopicsController();
        mChosenTopicsListIDs = new ArrayList<Integer>();
        new getTopicsAsync().execute();

        mGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                String mTopicTitle = ((TextView) v.findViewById(R.id.topicTitle))
                        .getText().toString();
                CircleImageView mTopicPic = ((CircleImageView) v.findViewById(R.id.topic_image));

                if (!mChosenTopicsListIDs.isEmpty()) {
                    if (mChosenTopicsListIDs.contains(position)) {
                        //duplicate !
                        mChosenTopicsListIDs.remove(mChosenTopicsListIDs.indexOf(position));
                        mTopicPic.setBorderWidth(0);
                    } else {
                        //we are good let's add new one
                        mChosenTopicsListIDs.add(position);
                        mTopicPic.setBorderColor(Color.parseColor("#D5FF79"));
                        mTopicPic.setBorderWidth(8);
                    }
                } else {
                    mChosenTopicsListIDs.add(position);
                    mTopicPic.setBorderColor(Color.parseColor("#D5FF79"));
                    mTopicPic.setBorderWidth(8);
                }
                Log.e("Msg", "size===>" + mChosenTopicsListIDs.size());
                if (!mChosenTopicsListIDs.isEmpty()) {
                    btnTopics_Next.setEnabled(true);
                    btnTopics_Next.setBackgroundColor(Color.parseColor("#d32f2f"));
                } else {
                    btnTopics_Next.setEnabled(false);
                    btnTopics_Next.setBackgroundColor(Color.parseColor("#ffffffff"));
                }
            }
        });

        btnTopics_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mChosenTopicsListIDs.isEmpty()) {
                    getIDS();
                }
            }
        });
    }


    public void getIDS() {
        Iterator it = mChosenTopicsListIDs.iterator();
        Log.e("Msg", "size===>" + mChosenTopicsListIDs.size());
        while (it.hasNext()) {
            Log.e("Msg", it.next() + "");
        }
    }

    //AsyncTask class to get the topics
    private class getTopicsAsync extends AsyncTask<Void, Void, Void> {

        //before executing let's show a dialog to the user
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(TopicsActivity.this, "", "please wait...", true);

        }

        //do the job in InBackground while the dialog is shown
        @Override
        protected Void doInBackground(Void... arg0) {
            mTopicsController.getTopics();
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            Typeface tfBold = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
            ArrayList<Topic> mTopicsList = mTopicsController.getmTopicsList();
            ListAdapter adapter = new TopicsAdapter(TopicsActivity.this, mTopicsList, tfBold, mTopicsController);
            mGridview.setAdapter(adapter);
            this.cancel(true);
        }

    }
}
