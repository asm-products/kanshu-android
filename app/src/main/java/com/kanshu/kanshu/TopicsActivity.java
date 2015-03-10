package com.kanshu.kanshu;

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

import com.kanshu.kanshu.controller.TopicsController;
import com.kanshu.kanshu.model.Topic;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by alouanemed on 22-01-2015.
 */
public class TopicsActivity extends BaseActivity {

    ProgressDialog dialog = null;
    TopicsController mTopicsController;
    //we will store the selected IDs instead of titles
    private ArrayList<Integer> mChosenTopicsListIDs;

    GridView mGridview;
    Button btnTopics_Next;
    ArrayList<Topic> mTopicsList;
    TopicsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);
        btnTopics_Next = (Button) findViewById(R.id.Topics_Next);
        mGridview = (GridView) findViewById(R.id.list);

        mTopicsController = new TopicsController(this);
        mChosenTopicsListIDs = new ArrayList<Integer>();
        new getTopicsAsync().execute();

        mGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                if (!mChosenTopicsListIDs.isEmpty()) {
                    if (mChosenTopicsListIDs.contains(position)) {
                        //duplicate !
                        mChosenTopicsListIDs.remove(mChosenTopicsListIDs.indexOf(position));
                        String current_path = mTopicsList.get(position).getImgURL();
                        String helper_str  =current_path.substring(0,current_path.length()-8);
                        mTopicsList.get(position).setImgURL(helper_str);
                        mAdapter.notifyDataSetChanged();
                    } else {
                        //we are good let's add new one
                        mChosenTopicsListIDs.add(position);
                        mTopicsList.get(position).setImgURL( mTopicsList.get(position).getImgURL()+"_updated");
                        /*String current_path = mTopicsList.get(position).getImgURL();
                        String helper_str  =current_path.substring(0,current_path.length()-9);
                        System.out.println("helper_str>" + helper_str);
                        mTopicsList.get(position).setImgURL(helper_str+"48dp");*/
                        mAdapter.notifyDataSetChanged();

                    }
                } else {
                    mChosenTopicsListIDs.add(position);
                    mTopicsList.get(position).setImgURL( mTopicsList.get(position).getImgURL()+"_updated");
                    mAdapter.notifyDataSetChanged();
                }

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
            mTopicsList = mTopicsController.getmTopicsList();
            mAdapter = new TopicsAdapter(TopicsActivity.this, mTopicsList, tfBold, mTopicsController);
            mGridview.setAdapter(mAdapter);
            this.cancel(true);
        }

    }


}
