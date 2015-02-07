package com.kanshu.kanshu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class DevelopmentActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

    public void onAboutActivity(View view) {
        startActivity(new Intent(this, AboutActivity.class));
    }

    public void onFeedbackActivity(View view) {
        startActivity(new Intent(this, FeedbackActivity.class));
    }
}
