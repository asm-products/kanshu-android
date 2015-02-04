package com.kanshu.kanshu.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.kanshu.kanshu.R;
import com.kanshu.kanshu.fragment.MoreSettingsFragment;
import com.kanshu.kanshu.fragment.MyAccountFragment;

/**
 * Activity for User account and app settings
 * @author Victor Sima
 */
public class SettingsActivity extends BaseNavigationDrawerActivity {

    @Override
    protected FragmentStatePagerAdapter getPagerAdapter() {
        return new SettingsPagerAdapter(getSupportFragmentManager());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    public class SettingsPagerAdapter extends FragmentStatePagerAdapter {

        private String[] tabTitles = getResources().getStringArray(R.array.settings_tabs);

        public SettingsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = null;
            switch (i) {
                case 0:
                    fragment = new MyAccountFragment();
                    break;
                case 1:
                    fragment = new MoreSettingsFragment();
                    break;

            }
            return fragment;
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }
}
