package com.kanshu.kanshu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kanshu.kanshu.model.Article;
import com.kanshu.kanshu.model.SavedChars;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alouanemed on 26-01-2015.
 */
public class UserMySavedCharsFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public static UserMySavedCharsFragment newInstance(int sectionNumber) {
        UserMySavedCharsFragment fragment = new UserMySavedCharsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_my_saved_chars, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.saved_chars__rec_view);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //add data to the list
        List<SavedChars> list_SavedChars = new ArrayList<SavedChars>();
        list_SavedChars.add(new SavedChars());
        list_SavedChars.add(new SavedChars());
        list_SavedChars.add(new SavedChars());
        list_SavedChars.add(new SavedChars());
        list_SavedChars.add(new SavedChars());
        list_SavedChars.add(new SavedChars());
        list_SavedChars.add(new SavedChars());


        mAdapter = new MySavedCharsAdapter(list_SavedChars);
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

}