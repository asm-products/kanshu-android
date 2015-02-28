package com.kanshu.kanshu.test.activity;

import android.test.ActivityInstrumentationTestCase2;

import com.kanshu.kanshu.ArticleActivity;
import com.kanshu.kanshu.LoginActivity;
import com.kanshu.kanshu.test.screen.ArticleScreen;
import com.kanshu.kanshu.test.screen.LoginScreen;
import com.robotium.solo.Solo;

import junit.framework.Assert;

/**
 * ArticleActivity instrumentation test
 * @author Victor Sima
 */
public class ArticleActivityTest extends ActivityInstrumentationTestCase2<ArticleActivity> {
    public ArticleActivityTest() {
        super(ArticleActivity.class);
    }

    private static final int DEFAULT_TIMEOUT = 2000; //2 secs
    private Solo solo;
    private ArticleActivity articleActivity;
    private ArticleScreen articleScreen;

    public void setUp() throws Exception {
        super.setUp();
        articleActivity = getActivity();
        solo = new Solo(getInstrumentation(), articleActivity);
        articleScreen = new ArticleScreen(articleActivity);
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testArticleScreenAppeared() throws Exception {
        Assert.assertTrue(solo.waitForActivity(ArticleActivity.class, DEFAULT_TIMEOUT));
    }
    
    public void testArticleContent() throws Exception {
        solo.waitForView(articleScreen.getViewPager(), DEFAULT_TIMEOUT, false);
        Assert.assertTrue("Article view pager has no fragments.", articleScreen.getViewPager().getAdapter().getCount() > 0);
    }
}
