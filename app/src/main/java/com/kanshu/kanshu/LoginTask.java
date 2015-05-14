package com.kanshu.kanshu;

import android.os.AsyncTask;

import com.google.gson.JsonObject;

public class LoginTask extends AsyncTask<String, Integer, JsonObject> {
    @Override
    protected JsonObject doInBackground(String... params) {
        JsonObject userData = ApiHandler.kanshuApi.login(params[0]);

        return userData.getAsJsonObject("user");
    }
}
