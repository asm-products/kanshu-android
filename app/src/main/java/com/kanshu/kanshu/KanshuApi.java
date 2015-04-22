package com.kanshu.kanshu;

import com.google.gson.JsonObject;
import com.kanshu.kanshu.model.SavedChars;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;

public interface KanshuApi {
    @GET("/login")
    public void login(@Header("Authorization")String hash, Callback<JsonObject> session);

    @POST("/createUser")
    public void createUser(@Body SignupActivity.SignupPacket packet, Callback<String> callback);

    @POST("/deleteword")
    public void deleteWord(@Header("sessionid")String token, @Body SavedChars.WordPacket wordPacket, Callback<String> callback);

    @POST("/saveword")
    public void saveWord(@Header("sessionid")String token, @Body SavedChars.WordPacket wordPacket, Callback<String> callback);

    @Headers("Cache-Control: no-cache")
    @GET("/getwords")
    public void getWords(@Header("sessionid")String token, Callback<JsonObject> wordList);
}
