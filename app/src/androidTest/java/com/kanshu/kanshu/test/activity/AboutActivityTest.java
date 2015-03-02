package com.kanshu.kanshu.test.activity;

import android.test.ActivityInstrumentationTestCase2;

import com.kanshu.kanshu.AboutActivity;
import com.kanshu.kanshu.OpenSourceLicensesActivity;
import com.kanshu.kanshu.test.screen.AboutScreen;
import com.robotium.solo.Solo;

import junit.framework.Assert;

/**
 * AboutActivity instrumentation test
 * @author Victor Sima
 */
public class AboutActivityTest extends ActivityInstrumentationTestCase2<AboutActivity> {
    public AboutActivityTest() {
        super(AboutActivity.class);
    }

    private static final int DEFAULT_TIMEOUT = 2000; //2 secs
    private Solo solo;
    private AboutActivity aboutActivity;
    private AboutScreen aboutScreen;

    public void setUp() throws Exception {
        super.setUp();
        aboutActivity = getActivity();
        solo = new Solo(getInstrumentation(), aboutActivity);
        aboutScreen = new AboutScreen(aboutActivity);
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testAboutScreenAppeared() throws Exception {
        Assert.assertTrue(solo.waitForActivity(AboutActivity.class, DEFAULT_TIMEOUT));
    }

    public void testOpenSourceLibButton() throws Exception {
        solo.waitForView(aboutScreen.getOpenSourceLicensesButton(), DEFAULT_TIMEOUT, false);
        solo.clickOnView(aboutScreen.getOpenSourceLicensesButton());
        Assert.assertTrue("Expected OpenSourceLicensesActivity to start", solo.waitForActivity(OpenSourceLicensesActivity.class, 5000));
    }

}
