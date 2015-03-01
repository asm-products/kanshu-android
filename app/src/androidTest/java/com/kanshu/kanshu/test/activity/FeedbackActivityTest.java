package com.kanshu.kanshu.test.activity;

import android.test.ActivityInstrumentationTestCase2;

import com.kanshu.kanshu.FeedbackActivity;
import com.kanshu.kanshu.R;
import com.kanshu.kanshu.test.screen.FeedbackScreen;
import com.robotium.solo.Solo;

import junit.framework.Assert;

/**
 * FeedbackActivity instrumentation test
 * @author Victor Sima
 */
public class FeedbackActivityTest extends ActivityInstrumentationTestCase2<FeedbackActivity> {
    public FeedbackActivityTest() {
        super(FeedbackActivity.class);
    }

    private static final int DEFAULT_TIMEOUT = 2000; //2 secs
    private Solo solo;
    private FeedbackActivity feedbackActivity;
    private FeedbackScreen feedbackScreen;

    public void setUp() throws Exception {
        super.setUp();
        feedbackActivity = getActivity();
        solo = new Solo(getInstrumentation(), feedbackActivity);
        feedbackScreen = new FeedbackScreen(feedbackActivity);
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testFeedbackScreenAppeared() throws Exception {
        Assert.assertTrue(solo.waitForActivity(FeedbackActivity.class, DEFAULT_TIMEOUT));
    }

    public void testFeedbackForm() throws Exception {
        solo.enterText(feedbackScreen.getEmailEditText(), "my_email@kanshu.com");
        solo.pressSpinnerItem(0, 2);//select second option
        solo.enterText(feedbackScreen.getSubjectEditText(), "Great app!");
        solo.enterText(feedbackScreen.getFeedbackEditText(), "I love Kanshu");
        solo.clickOnView(feedbackScreen.getSendButton());
    }

}
