package com.kanshu.kanshu.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.gson.JsonObject;
import com.kanshu.kanshu.ApiHandler;
import com.kanshu.kanshu.R;
import com.kanshu.kanshu.SignupPacket;
import com.kanshu.kanshu.fragment.MoreSettingsFragment;
import com.kanshu.kanshu.fragment.MyAccountFragment;

import java.util.logging.Logger;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

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
    public void saveAccountInfo(View v) {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String sessionId = sharedPreferences.getString("sessionId", "");
        String password = sharedPreferences.getString("password", "password");
        int hskLevel = sharedPreferences.getInt("hsklevel", 0);
        ApiHandler.kanshuApi.updateUser(sessionId,"application/json", new SignupPacket(password, ((EditText) findViewById(R.id.emailField)).getText().toString(),((EditText) findViewById(R.id.user_name)).getText().toString(),((EditText)findViewById(R.id.userBio)).getText().toString(), ((EditText) findViewById((R.id.countryField))).getText().toString(), hskLevel), new Callback< JsonObject>(){

            @Override
            public void success(JsonObject jsonObject, Response response) {
                Log.i("updateUser", "succes");
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
