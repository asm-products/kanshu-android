package com.kanshu.kanshu;

import android.os.StrictMode;
import android.util.Base64;
import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ApiHandler {


    public static RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://kanshu-ds.herokuapp.com").setLogLevel(RestAdapter.LogLevel.FULL).build();
    public static KanshuApi kanshuApi = restAdapter.create(KanshuApi.class);

    public static JsonObject login(String username, String password) {
        String credentials = username + ":" + password;
        String authentication = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
        JsonObject user = null;
        try {
            user = new LoginTask().execute(authentication).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //Log.i("ApiHandler",info.getUser().toString());

            return user;

        }
    }

