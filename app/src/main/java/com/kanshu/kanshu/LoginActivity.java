package com.kanshu.kanshu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.gson.JsonObject;
import com.kanshu.kanshu.model.User;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


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
        final Intent loginIntent = new Intent(this,UserMetricsActivity.class);
        String credentials = ((EditText)findViewById(R.id.email)).getText().toString() + ":" + ((EditText)findViewById(R.id.password)).getText().toString();
        String string = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
               ApiHandler.kanshuApi.login(string, new Callback<JsonObject>() {
                   @Override
                   public void success(JsonObject s, Response response) {
                    User userData = new User(((EditText)findViewById(R.id.email)).getText().toString(), "Intermediate user");
                    loginIntent.putExtra("sessionId", s.get("sessionId").toString());
                    loginIntent.putExtra("User", userData);
                    startActivity(loginIntent);
                   }

                   @Override
                   public void failure(RetrofitError error) {
                       Log.i("LoginActivity", "EPIC FAIL!");
                       Log.i("LoginActivity", error.toString());
                   }
               });
    }
}
