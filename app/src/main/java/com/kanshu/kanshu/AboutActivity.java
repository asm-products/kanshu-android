package com.kanshu.kanshu;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


import com.mikepenz.aboutlibraries.Libs;
import com.mikepenz.aboutlibraries.ui.LibsFragment;

import java.util.Calendar;

public class AboutActivity extends ActionBarActivity {

    TextView Tvapp_name;
    TextView Tvcopyright;
    TextView TvRrelease_info;
    TextView TvRrelease_info2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Tvapp_name = (TextView)findViewById(R.id.app_name);
        TvRrelease_info = (TextView)findViewById(R.id.release_info);
        TvRrelease_info2 = (TextView)findViewById(R.id.release_info);
        Tvcopyright = (TextView)findViewById(R.id.copyright);

        //set teh values
        Tvapp_name.setText("Kanshu " + BuildConfig.VERSION_NAME);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);

        Tvcopyright.setText("Copyright (c) " + year);


    }

    public void OnOslibClick(View view) {
        startActivity(new Intent(this, OsLibActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_about, menu);
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
}
