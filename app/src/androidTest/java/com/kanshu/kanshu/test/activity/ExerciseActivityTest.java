package com.kanshu.kanshu.test.activity;

import android.test.ActivityInstrumentationTestCase2;

import com.kanshu.kanshu.ExercisePageActivity;
import com.kanshu.kanshu.test.screen.ExerciseScreen;
import com.robotium.solo.Solo;

import junit.framework.Assert;

/**
 * ExercisePageActivity instrumentation test
 * @author Victor Sima
 */
public class ExerciseActivityTest extends ActivityInstrumentationTestCase2<ExercisePageActivity> {
    public ExerciseActivityTest() {
        super(ExercisePageActivity.class);
    }

    private static final int DEFAULT_TIMEOUT = 2000; //2 secs
    private Solo solo;
    private ExercisePageActivity exercisePageActivity;
    private ExerciseScreen exerciseScreen;

    public void setUp() throws Exception {
        super.setUp();
        exercisePageActivity = getActivity();
        solo = new Solo(getInstrumentation(), exercisePageActivity);
        exerciseScreen = new ExerciseScreen(exercisePageActivity);
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testExerciseScreenAppeared() throws Exception {
        Assert.assertTrue(solo.waitForActivity(ExercisePageActivity.class, DEFAULT_TIMEOUT));
        //make sure fragment also appears
        Assert.assertTrue(solo.waitForFragmentById(exerciseScreen.getPracticeExerciseFragmentId(), DEFAULT_TIMEOUT));
    }

}
