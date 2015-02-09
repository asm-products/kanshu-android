package com.kanshu.kanshu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kanshu.kanshu.model.SavedChars;
import com.kanshu.kanshu.widget.SimpleDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alouanemed on 26-01-2015.
 */
public class UserMySavedCharsFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

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
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));

        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(layoutManager);

        //add data to the list
        List<SavedChars> savedCharsList = new ArrayList<SavedChars>();
        savedCharsList.add(new SavedChars());
        savedCharsList.add(new SavedChars());
        savedCharsList.add(new SavedChars());
        savedCharsList.add(new SavedChars());
        savedCharsList.add(new SavedChars());
        savedCharsList.add(new SavedChars());
        savedCharsList.add(new SavedChars());


        mAdapter = new MySavedCharsAdapter(savedCharsList);
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

}