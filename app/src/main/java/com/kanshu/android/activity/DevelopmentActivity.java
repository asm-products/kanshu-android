package com.kanshu.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kanshu.android.R;


public class DevelopmentActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_development);
    }

    public void onLoginActivity(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void onSignupActivity(View view) {
        startActivity(new Intent(this, SignupActivity.class));
    }

    public void onArticleActivity(View view) {
        startActivity(new Intent(this, ArticleActivity.class));
    }

    public void onReadingActivity(View view) {
        startActivity(new Intent(this, ReadingActivity.class));
    }

    public void onTopicsActivity(View view) {
        startActivity(new Intent(this, TopicsActivity.class));
    }

    public void onUserMetricsActivity(View view) {
        startActivity(new Intent(this, UserMetricsActivity.class));
    }

}
