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
public class UserPracticeExerciseFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public static UserPracticeExerciseFragment newInstance(int sectionNumber) {
        UserPracticeExerciseFragment fragment = new UserPracticeExerciseFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_practice_exercise, container,
                false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        //add data to the list
        List<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(new Exercise());
        exerciseList.add(new Exercise());
        exerciseList.add(new Exercise());
        exerciseList.add(new Exercise());
        exerciseList.add(new Exercise());
        exerciseList.add(new Exercise());
        exerciseList.add(new Exercise());
        exerciseList.add(new Exercise());
        exerciseList.add(new Exercise());

        adapter = new ExerciseAdapter(exerciseList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}