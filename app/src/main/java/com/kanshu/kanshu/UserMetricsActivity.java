package com.kanshu.kanshu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.kanshu.kanshu.activity.BaseNavigationDrawerActivity;

/**
 * Created by alouanemed on 26-01-2015.
 */
public class UserMetricsActivity extends BaseNavigationDrawerActivity {

    @Override
    protected FragmentStatePagerAdapter getPagerAdapter() {
        return new UserMetricsPagerAdapter(getSupportFragmentManager());
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    public class UserMetricsPagerAdapter extends FragmentStatePagerAdapter {

        private String[] pageTitles = {getString(R.string.title_progress),
                getString(R.string.title_my_saved_characters)
                , getString(R.string.title_practice_exercises), getString(R.string.title_add_ons)};

        public UserMetricsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = null;
            switch (i) {
                case 0:
                    fragment = new UserMyProgressFragment();
                    break;
                case 1:
                    fragment = new UserMySavedCharsFragment();
                    break;
                case 2:
                    fragment = new UserPracticeExoFragment();
                    break;
                case 3:
                    fragment = new UserAddOnsFragment();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return pageTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return pageTitles[position];
        }
    }

}