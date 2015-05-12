package com.kanshu.kanshu;

import com.google.gson.JsonObject;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;

public interface KanshuApi {
    @GET("/login")
    public void login(@Header("Authorization")String hash, Callback<JsonObject> session);

    @POST("/createUser")
    public void createUser(@Body SignupActivity.SignupPacket packet, Callback<String> callback);
}