package com.kanshu.kanshu.test.screen;

import com.kanshu.kanshu.BaseActivity;
import com.kanshu.kanshu.activity.SettingsActivity;

/**
 * 'Page Object design pattern' for Settings Activity Screen
 * @author Victor Sima
 *
 */
public class SettingsScreen extends BasePagerScreen {


    public SettingsScreen(BaseActivity articleActivity) {
        super(articleActivity);
    }

    public SettingsScreen(SettingsActivity settingsActivity) {
        super(settingsActivity);
    }
}
