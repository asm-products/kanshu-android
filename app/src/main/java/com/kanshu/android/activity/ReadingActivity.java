package com.kanshu.android.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.kanshu.android.fragment.NavigationDrawerFragment;
import com.kanshu.android.R;
import com.kanshu.android.fragment.ReadingViewFragment;
import com.kanshu.android.model.User;


public class ReadingActivity extends BaseActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks,
        ReadingViewFragment.OnFragmentClickListener, NavigationDrawerFragment.NavigationDrawerData {
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private User mCurrentUser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
        if (getIntent().hasExtra("user")) {
            mCurrentUser = getIntent().getExtras().getParcelable("user");
        }
        if (mCurrentUser == null) {
            mCurrentUser = new User("name", "level");
        }

        //Needed to set up the drawer.
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle(R.string.app_name);
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reading, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
    }

    @Override
    public void onFragmentClick(View v) {

    }

    @Override
    public User getCurrentUser() {
        return mCurrentUser;
    }
}
