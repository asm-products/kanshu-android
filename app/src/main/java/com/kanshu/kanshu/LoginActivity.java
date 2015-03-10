package com.kanshu.kanshu;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.gson.JsonObject;

import org.apache.http.HttpRequest;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.auth.BasicScheme;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.Header;


public class LoginActivity extends BaseActivity {

    RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://kanshu-ds.herokuapp.com").setLogLevel(RestAdapter.LogLevel.FULL).build();

    KanshuApi kanshuApi = restAdapter.create(KanshuApi.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Login(View v){

        HttpGet request = new HttpGet("https://kanshu-ds.herokuapp.com/login");

        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(((EditText)findViewById(R.id.email)).getText().toString(), ((EditText)findViewById(R.id.password)).getText().toString());
        BasicScheme scheme = new BasicScheme();
           try{
              org.apache.http.Header authorizationHeader = scheme.authenticate(credentials, request);
              ;
               kanshuApi.login(authorizationHeader.getValue(), new Callback<JsonObject>() {
                   @Override
                   public void success(JsonObject s, Response response) {
                       Log.i("LoginActivity", s.get("sessionId").toString());
                   }

                   @Override
                   public void failure(RetrofitError error) {
                       Log.i("LoginActivity", "EPIC FAIL!");
                       Log.i("LoginActivity", error.toString());
                   }
               });
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }


    }



}
