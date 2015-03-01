package com.kanshu.kanshu.test.screen;

import android.widget.Button;
import android.widget.ListView;

import com.kanshu.kanshu.AboutActivity;
import com.kanshu.kanshu.ExercisePageActivity;
import com.kanshu.kanshu.R;

/**
 * 'Page Object design pattern' for Exercise Activity Screen
 * @author Victor Sima
 *
 */
public class ExerciseScreen {

    private int practiceExerciseFragmentId = R.id.exercise_pane;

//    private ListView optionsList;


    public ExerciseScreen(ExercisePageActivity exercisePageActivity) {
//        optionsList = (ListView) exercisePageActivity.findViewById(R.id.options_list);
    }

    public int getPracticeExerciseFragmentId() {
        return practiceExerciseFragmentId;
    }

//    public ListView getOptionsList() {
//        return optionsList;
//    }
}
