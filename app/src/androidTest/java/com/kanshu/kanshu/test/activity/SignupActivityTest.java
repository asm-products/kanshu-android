package com.kanshu.kanshu.test.activity;

import android.test.ActivityInstrumentationTestCase2;

import com.kanshu.kanshu.LoginActivity;
import com.kanshu.kanshu.SignupActivity;
import com.kanshu.kanshu.test.screen.LoginScreen;
import com.kanshu.kanshu.test.screen.SignupScreen;
import com.robotium.solo.Solo;

import junit.framework.Assert;

/**
 * SignupActivity instrumentation test
 * @author Victor Sima
 */
public class SignupActivityTest extends ActivityInstrumentationTestCase2<SignupActivity> {
    public SignupActivityTest() {
        super(SignupActivity.class);
    }

    private static final int DEFAULT_TIMEOUT = 2000; //2 secs
    private Solo solo;
    private SignupActivity signupActivity;
    private SignupScreen signupScreen;

    public void setUp() throws Exception {
        super.setUp();
        signupActivity = getActivity();
        solo = new Solo(getInstrumentation(), signupActivity);
        signupScreen = new SignupScreen(signupActivity);
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testSignupScreenAppeared() throws Exception {
        Assert.assertTrue(solo.waitForActivity(SignupActivity.class, DEFAULT_TIMEOUT));
        Assert.assertTrue(solo.waitForView(signupScreen.getEmailEditText(), DEFAULT_TIMEOUT, true));
        Assert.assertTrue(solo.waitForView(signupScreen.getUsernameEditText(), DEFAULT_TIMEOUT, true));
        Assert.assertTrue(solo.waitForView(signupScreen.getPasswordEditText(), DEFAULT_TIMEOUT, true));
        Assert.assertTrue(solo.waitForView(signupScreen.getSignupButton(), DEFAULT_TIMEOUT, true));
    }

    public void testUserSignup() throws Exception {
        solo.typeText(signupScreen.getEmailEditText(), "test_email@kansu.com");
        solo.typeText(signupScreen.getPasswordEditText(), "my_password");
        solo.typeText(signupScreen.getUsernameEditText(), "my_username");
        solo.clickOnView(signupScreen.getSignupButton());

    }
}
