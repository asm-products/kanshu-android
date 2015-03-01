package com.kanshu.kanshu.test.screen;

import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.kanshu.kanshu.FeedbackActivity;
import com.kanshu.kanshu.R;

/**
 * 'Page Object design pattern' for Feedback Activity Screen
 * @author Victor Sima
 *
 */
public class FeedbackScreen {

    private EditText emailEditText;
    private Spinner topicSpinner;
    private EditText subjectEditText;
    private EditText feedbackEditText;
    private View sendButton;

    public FeedbackScreen(FeedbackActivity feedbackActivity) {
        emailEditText = (EditText) feedbackActivity.findViewById(R.id.textemail);
        topicSpinner = (Spinner) feedbackActivity.findViewById(R.id.topicType);
        subjectEditText = (EditText) feedbackActivity.findViewById(R.id.textSubjectField);
        feedbackEditText = (EditText) feedbackActivity.findViewById(R.id.feedbackField);
        //this is technically a android.support.v7.internal.view.menu.ActionMenuItemView so leave it as a view
        sendButton = feedbackActivity.findViewById(R.id.action_send);
    }

    public EditText getEmailEditText() {
        return emailEditText;
    }

    public Spinner getTopicSpinner() {
        return topicSpinner;
    }

    public EditText getSubjectEditText() {
        return subjectEditText;
    }

    public EditText getFeedbackEditText() {
        return feedbackEditText;
    }

    public View getSendButton() {
        return sendButton;
    }
}
