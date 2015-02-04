package com.kanshu.kanshu.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.preference.PreferenceFragment;
import android.view.View;

import com.kanshu.kanshu.R;

/**
 * Created by victorsima on 2/4/15.
 */
public class MoreSettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        getListView().setDivider(null);
        getListView().setDivider(getResources().getDrawable(R.drawable.preferences_divider));
        getListView().setDividerHeight(getResources().getDimensionPixelOffset(R.dimen.preferences_divider));

    }
}