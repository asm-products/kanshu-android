package com.kanshu.kanshu.test.screen;

import android.widget.Button;
import android.widget.EditText;

import com.kanshu.kanshu.AboutActivity;
import com.kanshu.kanshu.LoginActivity;
import com.kanshu.kanshu.R;

/**
 * 'Page Object design pattern' for About Activity Screen
 * @author Victor Sima
 *
 */
public class AboutScreen {

    private Button termsOfUseButton;
    private Button privacyPolicyButton;
    private Button openSourceLicensesButton;
    

    public AboutScreen(AboutActivity aboutActivity) {
        termsOfUseButton = (Button) aboutActivity.findViewById(R.id.TOS_btn);
        privacyPolicyButton = (Button) aboutActivity.findViewById(R.id.pp_btn);
        openSourceLicensesButton = (Button) aboutActivity.findViewById(R.id.Osslib_btn);
    }

    public Button getTermsOfUseButton() {
        return termsOfUseButton;
    }

    public Button getPrivacyPolicyButton() {
        return privacyPolicyButton;
    }

    public Button getOpenSourceLicensesButton() {
        return openSourceLicensesButton;
    }
}
