package com.kanshu.kanshu;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.kanshu.kanshu.model.User;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class SignupActivity extends BaseActivity implements AdapterView.OnItemSelectedListener{


    //skip button
    TextView skipTv;
    Spinner signUpSpinner;
    String selectedLevel;
    int selectedLevelID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signUpSpinner = (Spinner) findViewById(R.id.spinner);
        String[] levelsArray = getResources().getStringArray(R.array.readinglevels);;
        skipTv = (TextView) findViewById(R.id.skipText);

        ArrayAdapter adapter = new ArrayAdapter<String>(
                this, R.layout.support_simple_spinner_dropdown_item, levelsArray) {
            @Override
            public View getView(int position, View convertView,
                                ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
//                ((TextView) v).setTypeface(roboto);
//                ((TextView) v).setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
//                v.setPadding(0, 0, 0, 0);
                return v;
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View v = super.getDropDownView(position, convertView,
                        parent);
//                ((TextView) v).setTypeface(roboto);
//                ((TextView) v).setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
//                v.setPadding(0, 0, 0, 0);
                return v;
            }
        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        signUpSpinner.setAdapter(adapter);
        signUpSpinner.setOnItemSelectedListener(this);
        TextView kanshuText = (TextView) findViewById(R.id.mainheadline);
        kanshuText.setText(R.string.kanshucaption, TextView.BufferType.SPANNABLE);
        int startPos = getString(R.string.kanshucaption).indexOf("Kanshu");
        ((Spannable) kanshuText.getText()).setSpan(new StyleSpan(Typeface.BOLD), startPos,
                startPos + 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((Spannable) kanshuText.getText()).setSpan(new ForegroundColorSpan(Color.parseColor
                ("#ff9800")), startPos, startPos + 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_signup, menu);
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

    public void onClick(View v) {
        int id = v.getId();
        //intent var, we will need after
        Intent in = new Intent();
        if (id == skipTv.getId()) {
            in = new Intent(this, TopicsActivity.class);
        }
        startActivity(in);
    }

    public void onSelectLogInPage(View clicked) {
        User userData = new User("Username", "Intermediate Level");
        Intent signupIntent = new Intent(this, LoginActivity.class);
        signupIntent.putExtra("user", userData);
        startActivity(signupIntent);
    }

    public void onSignUp(View clicked) {
        final Intent signupIntent = new Intent(this, UserMetricsActivity.class);
        ApiHandler.kanshuApi.createUser(new SignupPacket(((EditText) findViewById(R.id.password)).getText().toString(), ((EditText) findViewById(R.id.email)).getText().toString(), "Test user", "somewhere"), new Callback<String>() {
            @Override

            public void success(String s, Response response) {
                //Log.i("SignupActivity", s);
                String credentials = ((EditText)findViewById(R.id.email)).getText().toString() + ":" + ((EditText)findViewById(R.id.password)).getText().toString();
                String string = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                ApiHandler.kanshuApi.login(string, new Callback<JsonObject>() {
                    @Override
                    public void success(JsonObject s, Response response) {
                        User userData = new User(((EditText) findViewById(R.id.username)).getText().toString(), selectedLevel);
                        userData.setSessionId(s.get("sessionId").toString());
                        signupIntent.putExtra("user", userData);
                        startActivity(signupIntent);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.i("SignupActivity -- Login", "Epic Fail!");
                    }
                });
                   }

                   @Override
                   public void failure(RetrofitError error) {
                       Log.i("SignupActivity", "Epic Fail!");
                   }
               });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedLevelID = position;
        selectedLevel = signUpSpinner.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public class SignupPacket{
        public String password;
        public String email;
        public String userBio;
        public String country;

        public SignupPacket(String password, String email, String userBio, String country){
            this.password = password;
            this.email = email;
            this.userBio = userBio;
            this.country = country;
        }
    }
}
