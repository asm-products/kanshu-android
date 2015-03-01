package com.kanshu.kanshu.test.activity;

import android.test.ActivityInstrumentationTestCase2;

import com.kanshu.kanshu.TopicsActivity;
import com.kanshu.kanshu.test.screen.ReadingScreen;
import com.kanshu.kanshu.test.screen.TopicsScreen;
import com.robotium.solo.Solo;

import junit.framework.Assert;

/**
 * TopicsActivity instrumentation test
 * @author Victor Sima
 */
public class TopicsActivityTest extends ActivityInstrumentationTestCase2<TopicsActivity> {
    public TopicsActivityTest() {
        super(TopicsActivity.class);
    }

    private static final int DEFAULT_TIMEOUT = 2000; //2 secs
    private Solo solo;
    private TopicsActivity topicsActivity;
    private TopicsScreen topicsScreen;

    public void setUp() throws Exception {
        super.setUp();
        topicsActivity = getActivity();
        solo = new Solo(getInstrumentation(), topicsActivity);
        topicsScreen = new TopicsScreen(topicsActivity);
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testTopicsScreenAppeared() throws Exception {
        Assert.assertTrue(solo.waitForActivity(TopicsActivity.class, DEFAULT_TIMEOUT));
    }

    public void testTopicsContent() throws Exception {
        solo.waitForView(topicsScreen.getGridView(), DEFAULT_TIMEOUT, false);
        Assert.assertTrue("Article view pager has no fragments.", topicsScreen.getGridView().getAdapter().getCount() > 0);
    }

}
