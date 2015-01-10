package com.kanshu.kanshu;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SignupActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Spinner signUpSpinner;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signUpSpinner = (Spinner)findViewById(R.id.spinner);
        String[] levelsArray = getResources().getStringArray(R.array.readinglevels);
        final Typeface roboto = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Thin.ttf");
        ArrayAdapter adapter = new ArrayAdapter<String>(
                this, R.layout.support_simple_spinner_dropdown_item, levelsArray) {
            @Override
            public View getView(int position, View convertView,
                                ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
                ((TextView)v).setTypeface(roboto);
                ((TextView)v).setTextSize(14);
                return v;
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View v = super.getDropDownView(position, convertView,
                        parent);
                ((TextView)v).setTypeface(roboto);
                ((TextView)v).setTextSize(14);
                return v;
            }
        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        signUpSpinner.setAdapter(adapter);
        TextView kanshuText = (TextView) findViewById(R.id.mainheadline);
        kanshuText.setTypeface(roboto);
        ((TextView) findViewById(R.id.signin)).setTypeface(roboto);
        ((EditText) findViewById(R.id.username)).setTypeface(roboto);
        ((EditText) findViewById(R.id.password)).setTypeface(roboto);
        ((EditText) findViewById(R.id.email)).setTypeface(roboto);
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
}
