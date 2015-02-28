package com.kanshu.kanshu.test.activity;

import android.test.ActivityInstrumentationTestCase2;

import com.kanshu.kanshu.ReadingActivity;
import com.kanshu.kanshu.test.screen.ReadingScreen;
import com.robotium.solo.Solo;

import junit.framework.Assert;

/**
 * ReadingActivity instrumentation test
 * @author Victor Sima
 */
public class ReadingActivityTest extends ActivityInstrumentationTestCase2<ReadingActivity> {
    public ReadingActivityTest() {
        super(ReadingActivity.class);
    }

    private static final int DEFAULT_TIMEOUT = 2000; //2 secs
    private Solo solo;
    private ReadingActivity readingActivity;
    private ReadingScreen readingScreen;

    public void setUp() throws Exception {
        super.setUp();
        readingActivity = getActivity();
        solo = new Solo(getInstrumentation(), readingActivity);
        readingScreen = new ReadingScreen(readingActivity);
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testReadingScreenAppeared() throws Exception {
        Assert.assertTrue(solo.waitForActivity(ReadingActivity.class, DEFAULT_TIMEOUT));
        //make sure fragment also appears
        Assert.assertTrue(solo.waitForFragmentById(readingScreen.getReadingViewFragmentId(), DEFAULT_TIMEOUT));
    }

}
