package com.kanshu.kanshu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.kanshu.kanshu.model.User;

/**
 * Created by alouanemed on 26-01-2015.
 */
public class UserMetricsActivity extends BaseActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks,
        NavigationDrawerFragment.NavigationDrawerData {


    private NavigationDrawerFragment mNavigationDrawerFragment;
    private SlidingTabLayout mSlidingTabLayout;
    private UserMetricsPagerAdapter mArticlePagerAdapter;
    private ViewPager mViewPager;
    private Toolbar mToolbar;
    private User mCurrentUser;

    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getIntent().hasExtra("user")) {
            mCurrentUser = getIntent().getExtras().getParcelable("user");
        }
        if (mCurrentUser == null) {
            mCurrentUser = new User("name", "level");
        }

        //set custom toolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        //the pager
        mArticlePagerAdapter = new UserMetricsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mArticlePagerAdapter);
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.white));
        mSlidingTabLayout.setViewPager(mViewPager);
        mViewPager.setOffscreenPageLimit(3);


    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        mToolbar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.article, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public User getCurrentUser() {
        return mCurrentUser;
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
                    fragment = new UserPracticeExerciseFragment();
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