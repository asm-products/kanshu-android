package com.kanshu.kanshu;

import retrofit.RestAdapter;

public class ApiHandler {
    public static RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://kanshu-ds.herokuapp.com").setLogLevel(RestAdapter.LogLevel.FULL).build();
    public static KanshuApi kanshuApi = restAdapter.create(KanshuApi.class);
}
