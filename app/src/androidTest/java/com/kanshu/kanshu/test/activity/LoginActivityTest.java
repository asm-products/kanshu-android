package com.kanshu.kanshu.test.activity;

import android.test.ActivityInstrumentationTestCase2;

import com.kanshu.kanshu.LoginActivity;
import com.kanshu.kanshu.test.screen.LoginScreen;
import com.robotium.solo.Solo;

import junit.framework.Assert;

/**
 * LoginActivity instrumentation test
 * @author Victor Sima
 */
public class LoginActivityTest extends ActivityInstrumentationTestCase2<LoginActivity> {
    public LoginActivityTest() {
        super(LoginActivity.class);
    }

    private static final int DEFAULT_TIMEOUT = 2000; //2 secs
    private Solo solo;
    private LoginActivity loginActivity;
    private LoginScreen loginScreen;

    public void setUp() throws Exception {
        super.setUp();
        loginActivity = getActivity();
        solo = new Solo(getInstrumentation(), loginActivity);
        loginScreen = new LoginScreen(loginActivity);
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testLoginScreenAppeared() throws Exception {
        Assert.assertTrue(solo.waitForActivity(LoginActivity.class, DEFAULT_TIMEOUT));
        Assert.assertTrue(solo.waitForView(loginScreen.getEmailEditText(), DEFAULT_TIMEOUT, true));
        Assert.assertTrue(solo.waitForView(loginScreen.getPasswordEditText(), DEFAULT_TIMEOUT, true));
        Assert.assertTrue(solo.waitForView(loginScreen.getLoginButton(), DEFAULT_TIMEOUT, true));
    }

    public void testUserLogin() throws Exception {
        solo.typeText(loginScreen.getEmailEditText(), "test_email@kansu.com");
        solo.typeText(loginScreen.getPasswordEditText(), "my_password");
        solo.clickOnView(loginScreen.getLoginButton());

    }
}
