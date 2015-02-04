package com.kanshu.kanshu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.kanshu.kanshu.activity.BaseNavigationDrawerActivity;

public class ArticleActivity extends BaseNavigationDrawerActivity {

    @Override
    protected FragmentStatePagerAdapter getPagerAdapter() {
        return new ArticlePagerAdapter(getSupportFragmentManager());
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    public class ArticlePagerAdapter extends FragmentStatePagerAdapter {

        //the list of titles of pages
        private String[] pageTitles = {"News", "Technology", "Politics", "Art", "Spirituality",
                "Photography"};

        public ArticlePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = new ArticleListFragment();
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
