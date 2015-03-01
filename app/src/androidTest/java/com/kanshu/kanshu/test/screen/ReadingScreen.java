package com.kanshu.kanshu.test.screen;

import com.kanshu.kanshu.R;
import com.kanshu.kanshu.ReadingActivity;

/**
 * 'Page Object design pattern' for Reading Activity Screen
 * @author Victor Sima
 */
public class ReadingScreen {
    
    private int readingViewFragmentId = R.id.reading_view;
    
    public ReadingScreen(ReadingActivity readingActivity) {

    }

    public int getReadingViewFragmentId() {
        return readingViewFragmentId;
    }
}
