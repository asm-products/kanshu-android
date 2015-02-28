package com.kanshu.kanshu.test.screen;

import android.widget.Button;
import android.widget.EditText;

import com.kanshu.kanshu.LoginActivity;
import com.kanshu.kanshu.R;
import com.kanshu.kanshu.SignupActivity;

/**
 * 'Page Object design pattern' for Signup Activity Screen
 * @author Victor Sima
 *
 */
public class SignupScreen {

    private EditText emailEditText;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button signupButton;

    public SignupScreen(SignupActivity signupActivity) {
        emailEditText = (EditText) signupActivity.findViewById(R.id.email);
        usernameEditText = (EditText) signupActivity.findViewById(R.id.username);
        passwordEditText = (EditText) signupActivity.findViewById(R.id.password);
        signupButton = (Button) signupActivity.findViewById(R.id.button);
    }


    public EditText getEmailEditText() {
        return emailEditText;
    }

    public EditText getPasswordEditText() {
        return passwordEditText;
    }

    public EditText getUsernameEditText() {
        return usernameEditText;
    }

    public Button getSignupButton() {
        return signupButton;
    }
}
