package com.kanshu.kanshu.test.screen;

import android.support.v4.view.ViewPager;

import com.kanshu.kanshu.BaseActivity;
import com.kanshu.kanshu.R;
import com.kanshu.kanshu.SlidingTabLayout;

/**
 * Abstract 'Page Object design pattern' for activities with viewpagers
 *
 * @author Victor Sima
 */
public abstract class BasePagerScreen {


    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;

    public BasePagerScreen(BaseActivity articleActivity) {
        viewPager = (ViewPager) articleActivity.findViewById(R.id.pager);
        slidingTabLayout = (SlidingTabLayout) articleActivity.findViewById(R.id.sliding_tabs);
    }

    public SlidingTabLayout getSlidingTabLayout() {
        return slidingTabLayout;
    }

    public ViewPager getViewPager() {
        return viewPager;
    }
}
