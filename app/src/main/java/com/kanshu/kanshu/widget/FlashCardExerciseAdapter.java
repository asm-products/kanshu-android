package com.kanshu.kanshu.widget;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kanshu.kanshu.R;
import com.kanshu.kanshu.model.FlashcardExerciseOption;

import java.util.List;


/**
 * Created by alouanemed on 17-02-2015.
 */
public class FlashCardExerciseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<FlashcardExerciseOption> flashcardExerciseOptionsList;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class FlashCardExerciseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView optionNbTV;
        public TextView optionTitleTV;
        public ImageView deleteBtn;

        public FlashCardExerciseViewHolder(View v) {
            super(v);
            optionNbTV = (TextView) v.findViewById(R.id.option_nb);
            optionTitleTV = (TextView) v.findViewById(R.id.option_title);
            deleteBtn = (ImageView) v.findViewById(R.id.option_delete);
        }

        @Override
        public void onClick(View view) {
            Log.d("FlashCardExerciseAdapter", "onClick " + getPosition()  );
        }
    }


    public FlashCardExerciseAdapter(List<FlashcardExerciseOption> lst) {
        flashcardExerciseOptionsList = lst;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_falshcard_exercise_options, parent, false);

        RecyclerView.ViewHolder vh = new FlashCardExerciseViewHolder(v);
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
        FlashcardExerciseOption _Flashcard_ExerciseOption = flashcardExerciseOptionsList.get(position);
        //@todo set the real data here.

    }

    @Override
    public int getItemCount() {
        return flashcardExerciseOptionsList.size();
    }
}