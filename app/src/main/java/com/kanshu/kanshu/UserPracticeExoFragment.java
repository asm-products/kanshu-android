package com.kanshu.kanshu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kanshu.kanshu.model.Exercise;
import com.kanshu.kanshu.widget.SimpleDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alouanemed on 26-01-2015.
 */
public class UserPracticeExoFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public static UserPracticeExoFragment newInstance(int sectionNumber) {
        UserPracticeExoFragment fragment = new UserPracticeExoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_practice_exo, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.user_practice_exo_rec_view);
        mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //add data to the list
        List<Exercise> list_Exercises = new ArrayList<Exercise>();
        list_Exercises.add(new Exercise());
        list_Exercises.add(new Exercise());
        list_Exercises.add(new Exercise());
        list_Exercises.add(new Exercise());
        list_Exercises.add(new Exercise());
        list_Exercises.add(new Exercise());
        list_Exercises.add(new Exercise());
        list_Exercises.add(new Exercise());
        list_Exercises.add(new Exercise());


        mAdapter = new ExerciseAdapter(list_Exercises);
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

}