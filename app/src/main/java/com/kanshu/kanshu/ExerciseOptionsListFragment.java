package com.kanshu.kanshu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kanshu.kanshu.model.FlashcardExerciseOption;
import com.kanshu.kanshu.widget.FlashCardExerciseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alouanemed on 17-02-2015.
 */


public class ExerciseOptionsListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ExerciseOptionsListFragment newInstance(int sectionNumber) {
        ExerciseOptionsListFragment fragment = new ExerciseOptionsListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public ExerciseOptionsListFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_flashcard_exercise, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //@todo use the real data to replace dummy data
        List<FlashcardExerciseOption> mFlashcardExerciseOptions = new ArrayList<FlashcardExerciseOption>();
        mFlashcardExerciseOptions.add(new FlashcardExerciseOption("Airplane",false));
        mFlashcardExerciseOptions.add(new FlashcardExerciseOption("You",false));
        mFlashcardExerciseOptions.add(new FlashcardExerciseOption("Car",true));
        mFlashcardExerciseOptions.add(new FlashcardExerciseOption("Person",false));
        mFlashcardExerciseOptions.add(new FlashcardExerciseOption("Asm",false));
        mFlashcardExerciseOptions.add(new FlashcardExerciseOption("Git",false));
        mFlashcardExerciseOptions.add(new FlashcardExerciseOption("Afourer",false));


        // specify an adapter
        mAdapter = new FlashCardExerciseAdapter(mFlashcardExerciseOptions);
        mRecyclerView.setAdapter(mAdapter);
        return rootView;
    }

}
