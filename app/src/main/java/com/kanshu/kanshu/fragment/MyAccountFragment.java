package com.kanshu.kanshu.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.kanshu.kanshu.ApiHandler;
import com.kanshu.kanshu.R;
import com.kanshu.kanshu.SignupActivity;
import com.kanshu.kanshu.SignupPacket;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Fragment for my account tab on settings screen
 *
 * @author vic.sima@gmail.com
 */
public class MyAccountFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_account, container, false);
    }
}
