package com.kanshu.kanshu;

/**
 * Created by alouanemed on 26-01-2015.
 */

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * A placeholder fragment containing a simple view.
 */
public class UserMyProgressFragment extends Fragment {

    private LinearLayoutManager mLayoutManager;
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public static UserMyProgressFragment newInstance(int sectionNumber) {
        UserMyProgressFragment fragment = new UserMyProgressFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_my_progress, container, false);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        BarChart chartArticles = (BarChart) rootView.findViewById(R.id.articles_read);
        BarChart chartCharSaved = (BarChart) rootView.findViewById(R.id.characters_saved);
        BarChart chartTotalProgress = (BarChart) rootView.findViewById(R.id.character_progress);
        chartArticles.setDescription("");
        chartCharSaved.setDescription("");
        XAxis xl = chartArticles.getXAxis();
        xl.setCenterXLabelText(true);
        xl.setSpaceBetweenLabels(2);
        xl.setTextSize(10.0f);
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);
        xl = chartCharSaved.getXAxis();
        xl.setSpaceBetweenLabels(2);
        xl.setCenterXLabelText(true);
        xl.setTextSize(10.0f);
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);
        xl = chartTotalProgress.getXAxis();
        xl.setSpaceBetweenLabels(2);
        xl.setCenterXLabelText(true);
        xl.setTextSize(10.0f);
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);
        chartTotalProgress.setDescription("");
        ArrayList<String> vals = new ArrayList<String>();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd");
        ArrayList<BarEntry> readEntries = new ArrayList<BarEntry>();
        ArrayList<BarEntry> savedEntries = new ArrayList<BarEntry>();
        ArrayList<BarEntry> masteredEntries = new ArrayList<BarEntry>();
        float[] nOfArticlesRead = {4,3,0,0,1,3,2}; //sample data
        float [] nOfCharsSaved = {10,15,2,4,5,15,20};
        float [] nOfCharsMastered = {5,7,2,0,8,8,4};
        float [] learnedCharsByLevel = {100,40,20,40,0,2,2};
        cal.add(Calendar.DATE, -7);
        for(int i = 0; i < 7; i++)
        {
            cal.add(Calendar.DATE, 1);
            vals.add(dateFormat.format(cal.getTime()));
            readEntries.add(new BarEntry(nOfArticlesRead[i],i));
            masteredEntries.add(new BarEntry(nOfCharsMastered[i],i));
            savedEntries.add(new BarEntry(nOfCharsSaved[i],i));
        }
        BarDataSet dataset = new BarDataSet(readEntries, getResources().getString(R.string.legend_chart_read_articles));
        dataset.setColor(getResources().getColor(R.color.chart_green));
        dataset.setBarSpacePercent(50f);
        chartArticles.setData(new BarData(vals, dataset));
        YAxis axis = chartArticles.getAxisRight();
        axis.setEnabled(false);
        BarDataSet savedDataset = new BarDataSet(savedEntries, getResources().getString(R.string.legend_chart_saved_chars));
        savedDataset.setColor(getResources().getColor(R.color.chart_green));
        BarDataSet masteredDataset = new BarDataSet(masteredEntries, getResources().getString(R.string.legend_chart_mastered_chars));
        masteredDataset.setColor(getResources().getColor(R.color.chart_orange));
        ArrayList<BarDataSet> datasets = new ArrayList<BarDataSet>();
        datasets.add(savedDataset);
        datasets.add(masteredDataset);
        chartCharSaved.setData(new BarData(vals, datasets));
        axis = chartCharSaved.getAxisRight();
        axis.setEnabled(false);

        ArrayList<BarEntry> progressEntries = new ArrayList<BarEntry>();
        ArrayList<BarEntry> currentProgressEntries = new ArrayList<BarEntry>();
        String[] hskLevels = getResources().getStringArray(R.array.hsk_levels);
        final float[] nOfCharactersByLevel = {150,152,302,600,1300,2500};
        for(int i = 0; i < 6; i++)
        {
            progressEntries.add(new BarEntry(nOfCharactersByLevel[i],i));
            currentProgressEntries.add(new BarEntry(learnedCharsByLevel[i],i));
        }
        currentProgressEntries.add(new BarEntry(learnedCharsByLevel[6],6));
        ArrayList<BarDataSet> sets = new ArrayList<BarDataSet>();
        BarDataSet totalProgressSet = new BarDataSet(progressEntries, getResources().getString(R.string.legend_chart_total_chars));
        totalProgressSet.setColor(getResources().getColor(R.color.chart_green));
        totalProgressSet.setDrawValues(false);
        sets.add(totalProgressSet);
        BarDataSet currentProgressSet = new BarDataSet(currentProgressEntries, getResources().getString(R.string.legend_chart_reading_progress));
        currentProgressSet.setColor(getResources().getColor(R.color.chart_orange));
        currentProgressSet.setDrawValues(false);
        sets.add(currentProgressSet);
        chartTotalProgress.setData(new BarData(hskLevels, sets));
        axis = chartTotalProgress.getAxisLeft();
        axis.setEnabled(false);
        axis = chartTotalProgress.getAxisRight();
        axis.setEnabled(false);

        return rootView;
    }

}