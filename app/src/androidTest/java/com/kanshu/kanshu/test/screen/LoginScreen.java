package com.kanshu.kanshu.test.screen;

import android.widget.Button;
import android.widget.EditText;

import com.kanshu.kanshu.LoginActivity;
import com.kanshu.kanshu.R;

/**
 * 'Page Object design pattern' for Login Activity Screen
 * @author Victor Sima
 *
 */
public class LoginScreen {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;

    public LoginScreen(LoginActivity loginActivity) {
        emailEditText = (EditText) loginActivity.findViewById(R.id.email);
        passwordEditText = (EditText) loginActivity.findViewById(R.id.password);
        loginButton = (Button) loginActivity.findViewById(R.id.login_button);
    }


    public EditText getEmailEditText() {
        return emailEditText;
    }

    public EditText getPasswordEditText() {
        return passwordEditText;
    }

    public Button getLoginButton() {
        return loginButton;
    }
}
