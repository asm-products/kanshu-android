package com.kanshu.kanshu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kanshu.kanshu.R;

/**
 * Fragment for more settings tab in Settings
 * @author vic.sima@gmail.com
 */
public class MoreSettingsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_more_settings, container, false);
        TextView tv = (TextView)v.findViewById(R.id.tvSendFeedback);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                FeedbackDialogFragment feedbackDg =new FeedbackDialogFragment();
                feedbackDg.show(getActivity().getFragmentManager(), "Feedback");
            }
        });
        return v;
    }
}