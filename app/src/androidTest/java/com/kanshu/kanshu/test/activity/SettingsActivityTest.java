package com.kanshu.kanshu.test.activity;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;

import com.kanshu.kanshu.activity.SettingsActivity;
import com.kanshu.kanshu.test.screen.SettingsScreen;
import com.robotium.solo.Solo;

import junit.framework.Assert;

/**
 * SettingsActivity instrumentation test
 * @author Victor Sima
 */
public class SettingsActivityTest extends ActivityInstrumentationTestCase2<SettingsActivity> {
    public SettingsActivityTest() {
        super(SettingsActivity.class);
    }

    private static final int DEFAULT_TIMEOUT = 2000; //2 secs
    private Solo solo;
    private SettingsActivity settingsActivity;
    private SettingsScreen settingsScreen;

    public void setUp() throws Exception {
        super.setUp();
        settingsActivity = getActivity();
        solo = new Solo(getInstrumentation(), settingsActivity);
        settingsScreen = new SettingsScreen(settingsActivity);
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testSettingsScreenAppeared() throws Exception {
        Assert.assertTrue(solo.waitForActivity(SettingsActivity.class, DEFAULT_TIMEOUT));
    }
    
    public void testSettingsContent() throws Exception {
        solo.waitForView(settingsScreen.getViewPager(), DEFAULT_TIMEOUT, false);
        Assert.assertTrue("Settings view pager has no fragments.", settingsScreen.getViewPager().getAdapter().getCount() > 0);
    }
}
