package com.kanshu.kanshu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kanshu.kanshu.model.Exercise;

import java.util.List;

/**
 * Created by alouanemed on 07-02-2015.
 */
public class ExerciseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Exercise> exercisesList;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class UserExercisesViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        //Exo refers to exericice
        public TextView ExTitleTV;
        public TextView ExDescriptionTV;
        public TextView ExFileSizeTV;
        public ImageView ExThumbIV;
        public ImageView DeleteBtn;

        public Exercise exercise;

        public UserExercisesViewHolder(View v) {
            super(v);
            exercise = new Exercise();
            ExTitleTV = (TextView) v.findViewById(R.id.ex_title);
            ExDescriptionTV = (TextView) v.findViewById(R.id.ex_description);
            ExFileSizeTV = (TextView) v.findViewById(R.id.ex_file_size);
            ExThumbIV = (ImageView) v.findViewById(R.id.ex_thumbnail);
            DeleteBtn = (ImageView) v.findViewById(R.id.ex_delete);
        }
    }


    public ExerciseAdapter(List<Exercise> lst) {
        exercisesList = lst;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_practice_exercices, parent, false);

        RecyclerView.ViewHolder vh = new UserExercisesViewHolder(v);
        return vh;
    }

    @Override
    public int getItemViewType(int position) {
        //@todo replace this with a real get item new type method based on the real data
        //right now I would just make every 5th card an indicator
        if (position % 5 == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Exercise _exercise = exercisesList.get(position);
        //@todo set the real data here.

    }

    @Override
    public int getItemCount() {
        return exercisesList.size();
    }
}