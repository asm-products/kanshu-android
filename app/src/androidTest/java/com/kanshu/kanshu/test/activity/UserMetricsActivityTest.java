package com.kanshu.kanshu.test.activity;

import android.test.ActivityInstrumentationTestCase2;

import com.kanshu.kanshu.UserMetricsActivity;
import com.kanshu.kanshu.test.screen.UserMetricsScreen;
import com.robotium.solo.Solo;

import junit.framework.Assert;

/**
 * UserMetricsActivity instrumentation test
 * @author Victor Sima
 */
public class UserMetricsActivityTest extends ActivityInstrumentationTestCase2<UserMetricsActivity> {
    public UserMetricsActivityTest() {
        super(UserMetricsActivity.class);
    }

    private static final int DEFAULT_TIMEOUT = 2000; //2 secs
    private Solo solo;
    private UserMetricsActivity userMetricsActivity;
    private UserMetricsScreen userMetricsScreen;

    public void setUp() throws Exception {
        super.setUp();
        userMetricsActivity = getActivity();
        solo = new Solo(getInstrumentation(), userMetricsActivity);
        userMetricsScreen = new UserMetricsScreen(userMetricsActivity);
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testUserMetricsScreenAppeared() throws Exception {
        Assert.assertTrue(solo.waitForActivity(UserMetricsActivity.class, DEFAULT_TIMEOUT));
    }
    
    public void testUserMetricsContent() throws Exception {
        solo.waitForView(userMetricsScreen.getViewPager(), DEFAULT_TIMEOUT, false);
        Assert.assertTrue("Article view pager has no fragments.", userMetricsScreen.getViewPager().getAdapter().getCount() > 0);
    }
}
