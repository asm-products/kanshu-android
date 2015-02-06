package com.kanshu.kanshu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

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
        Tvcopyright = (TextView)findViewById(R.id.copyright);

        //set the values
        Tvapp_name.setText("Kanshu " + BuildConfig.VERSION_NAME);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);

        Tvcopyright.setText("Copyright (c) " + year);
    }

    public void OnOslibClick(View view) {
        startActivity(new Intent(this, OsLibActivity.class));
    }

}
