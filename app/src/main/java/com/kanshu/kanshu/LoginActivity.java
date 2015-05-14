package com.kanshu.kanshu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

    public void Login(View v) {
        String username = ((EditText) findViewById(R.id.email)).getText().toString();
        final String password = ((EditText) findViewById(R.id.password)).getText().toString();
        final Intent loginIntent = new Intent(this, UserMetricsActivity.class);
        JsonObject user = ApiHandler.login(username, password);
        if(user != null) {
            final SharedPreferences sharedPreferences = this.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

            User userData = new User(user.get("email").toString(), user.get("userBio").toString());
            userData.setSessionId(user.get("sessionId").toString().substring(1, user.get("sessionId").toString().length() -1));//remove the quotes around the sessionId
            loginIntent.putExtra("user", userData);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("sessionId", user.get("sessionId").toString().substring(1, user.get("sessionId").toString().length() - 1));//This gets stored so other activities can use it.(like the settingsAccount activity)
            editor.putString("password", password);//This gets stored because there is no password field in the settings activity. It is however needed for the updateUser call.
            editor.commit();
            startActivity(loginIntent);
        }
    }
}

