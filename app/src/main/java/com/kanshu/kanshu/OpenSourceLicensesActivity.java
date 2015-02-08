package com.kanshu.kanshu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

import com.kanshu.kanshu.model.User;
import com.mikepenz.aboutlibraries.Libs;
import com.mikepenz.aboutlibraries.ui.LibsFragment;

public class OpenSourceLicensesActivity extends BaseActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks,
        NavigationDrawerFragment.NavigationDrawerData {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private SlidingTabLayout mSlidingTabLayout;
    private OpenSourceLibrariesPagerAdapter mOpenSourceLibrariesPagerAdapter;
    private ViewPager mViewPager;
    private Toolbar mToolbar;
    private User mCurrentUser;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_source_libs);
        if (getIntent().hasExtra("user")) {
            mCurrentUser = getIntent().getExtras().getParcelable("user");
        }
        if (mCurrentUser == null) {
            mCurrentUser = new User("name", "level");
        }

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        //Set up the pager
        mOpenSourceLibrariesPagerAdapter = new OpenSourceLibrariesPagerAdapter(
                        getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mOpenSourceLibrariesPagerAdapter);
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.white));
        mSlidingTabLayout.setViewPager(mViewPager);
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
    public User getCurrentUser() {
        return mCurrentUser;
    }

    public class OpenSourceLibrariesPagerAdapter extends FragmentStatePagerAdapter {

        //the list of titles of pages
        private String[] pageTitles = {getString(R.string.about_open_source_licenses)};

        public OpenSourceLibrariesPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            LibsFragment fragment = new Libs.Builder()
                    .withFields(R.string.class.getFields())
                    .withLibraries( "calligraphy", "circleimageview")
                    .withVersionShown(true)
                    .withLicenseShown(true)
                    .withLibraryModification("aboutlibraries", Libs.LibraryFields.LIBRARY_NAME, "AboutLibraries")
                    .fragment();

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