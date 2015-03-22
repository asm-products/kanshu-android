package com.kanshu.kanshu.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.kanshu.kanshu.R;

public class FeedbackDialogFragment extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View v = inflater.inflate(R.layout.fragment_dialog_feedback, container, false);
        // add listener to the buttons
        ImageView option1 = (ImageView)v.findViewById(R.id.dialog_feedback_option_1);
        ImageView option2 = (ImageView)v.findViewById(R.id.dialog_feedback_option_2);
        ImageView option3 = (ImageView)v.findViewById(R.id.dialog_feedback_option_3);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                SendFeedbackDialogFragment feedbackDg =new SendFeedbackDialogFragment();
                feedbackDg.show(getActivity().getFragmentManager(), "Feedback");
            }
        };
        option2.setOnClickListener(listener);
        option3.setOnClickListener(listener);

        return v;
    }

}
