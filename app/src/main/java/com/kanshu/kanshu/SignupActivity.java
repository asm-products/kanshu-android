    package com.kanshu.kanshu;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SignupActivity extends ActionBarActivity {


    //skip button
    TextView skipTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Spinner signUpSpinner;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signUpSpinner = (Spinner)findViewById(R.id.spinner);
        String[] levelsArray = getResources().getStringArray(R.array.readinglevels);
        final Typeface roboto = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Thin.ttf");
        final Typeface robotoMedium = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Medium.ttf");
        skipTv = (TextView) findViewById(R.id.skipText);

        ArrayAdapter adapter = new ArrayAdapter<String>(
                this, R.layout.support_simple_spinner_dropdown_item, levelsArray) {
            @Override
            public View getView(int position, View convertView,
                                ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
                ((TextView)v).setTypeface(roboto);
                ((TextView)v).setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                v.setPadding(0,0,0,0);
                return v;
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View v = super.getDropDownView(position, convertView,
                        parent);
                ((TextView)v).setTypeface(roboto);
                ((TextView)v).setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                v.setPadding(0,0,0,0);
                return v;
            }
        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        signUpSpinner.setAdapter(adapter);
        TextView kanshuText = (TextView) findViewById(R.id.mainheadline);
        kanshuText.setText(R.string.kanshucaption, TextView.BufferType.SPANNABLE);
        kanshuText.setTypeface(roboto);
        int startPos = getString(R.string.kanshucaption).indexOf("Kanshu");
        ((Spannable) kanshuText.getText()).setSpan(new StyleSpan(Typeface.BOLD), startPos, startPos + 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((Spannable) kanshuText.getText()).setSpan(new ForegroundColorSpan(Color.parseColor("#ff9800")),startPos, startPos+6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((TextView) findViewById(R.id.signin)).setTypeface(roboto);
        ((EditText) findViewById(R.id.username)).setTypeface(roboto);
        ((EditText) findViewById(R.id.password)).setTypeface(roboto);
        ((EditText) findViewById(R.id.email)).setTypeface(roboto);
        ((TextView) findViewById(R.id.registerText)).setTypeface(roboto);
        ((TextView) findViewById(R.id.skipText)).setTypeface(roboto);
        ((Button) findViewById(R.id.button)).setTypeface(robotoMedium);
        ((TextView) findViewById(R.id.next)).setTypeface(robotoMedium);
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
    public void onClick(View v){
        int id = v.getId();
        //intent var, we will need after
        Intent in = new Intent();
        if (id == skipTv.getId()){
            in = new Intent(this,TopicsActivity.class);
        }
        startActivity(in);
    }

    public void onSelectLogInPage(View clicked)
    {
        User userData = new User("Username", "Intermediate Level");
        Intent signupIntent = new Intent(this, LoginActivity.class);
        signupIntent.putExtra("user", userData);
        startActivity(signupIntent);
    }

    public void onSignUp(View clicked)
    {
        User userData = new User("Username", "Intermediate Level");
        Intent signupIntent = new Intent(this, ArticleActivity.class);
        signupIntent.putExtra("user", userData);
        startActivity(new Intent(this, UserMetricsActivity.class));
    }
}
