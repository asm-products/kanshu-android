package com.kanshu.kanshu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kanshu.kanshu.model.FlashcardExerciseOption;
import com.kanshu.kanshu.widget.SimpleDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import com.kanshu.kanshu.FlashCardExerciseAdapter.OnItemClickListener;

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
        mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(layoutManager);

        //@todo use the real data to replace dummy data
        final List<FlashcardExerciseOption> mFlashcardExerciseOptions = new ArrayList<FlashcardExerciseOption>();
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

        ((FlashCardExerciseAdapter)mAdapter).SetOnItemClickListener(new OnItemClickListener() {
        View vHelper;
            @Override
            public void onItemClick(View v , int position) {
                vHelper = v;
                System.out.println("clicked pos :>" + position);
                FlashCardExerciseAdapter.ViewHolder holder = (FlashCardExerciseAdapter.ViewHolder )(v.getTag());
                if (mFlashcardExerciseOptions.get(position).isCorrect_answer()){
                    //holder.correctOptionIV.setVisibility(View.VISIBLE);
                    //holder.wrongOptionIV.setVisibility(View.GONE);
                    vHelper.setBackgroundColor(getResources().getColor(R.color.white));
                    v.setBackgroundColor(getResources().getColor(R.color.correct_answer_green));
                }else{
                    vHelper.setBackgroundColor(getResources().getColor(R.color.white));
                    v.setBackgroundColor(getResources().getColor(R.color.primary_light_red));
                    //holder.wrongOptionIV.setVisibility(View.VISIBLE);
                    //holder.correctOptionIV.setVisibility(View.GONE);
                }

            }
        });
        return rootView;
    }

}
