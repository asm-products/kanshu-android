package com.kanshu.kanshu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kanshu.kanshu.R;

/**
 * Fragment for more settings tab in Settings
 * @author vic.sima@gmail.com
 */
public class MoreSettingsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_more_settings, container, false);
    }
}