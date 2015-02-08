package com.kanshu.kanshu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class AboutActivity extends ActionBarActivity {

    TextView appName;
    TextView copyright;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        appName = (TextView)findViewById(R.id.app_name);
        copyright = (TextView)findViewById(R.id.copyright);

        appName.setText("Kanshu " + BuildConfig.VERSION_NAME);

        int year = Calendar.getInstance().get(Calendar.YEAR);
        copyright.setText("Copyright (c) " + year);
    }

    public void onOpenSourceLicensesClick(View view) {
        startActivity(new Intent(this, OpenSourceLicensesActivity.class));
    }
}
