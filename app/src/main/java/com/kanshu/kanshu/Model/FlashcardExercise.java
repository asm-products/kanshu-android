package com.kanshu.kanshu.model;

import java.util.ArrayList;

/**
 * Created by alouanemed on 18-02-2015.
 */
public class FlashcardExercise {
    private String ChineseWord;
    private String ChineseWordSpelling;
    private ArrayList<FlashcardExerciseOption> options;

    public FlashcardExercise(String chineseWord, String chineseWordSpelling, ArrayList<FlashcardExerciseOption> options) {
        ChineseWord = chineseWord;
        ChineseWordSpelling = chineseWordSpelling;
        this.options = options;
    }

    public String getChineseWord() {
        return ChineseWord;
    }

    public void setChineseWord(String chineseWord) {
        ChineseWord = chineseWord;
    }

    public String getChineseWordSpelling() {
        return ChineseWordSpelling;
    }

    public void setChineseWordSpelling(String chineseWordSpelling) {
        ChineseWordSpelling = chineseWordSpelling;
    }

    public ArrayList<FlashcardExerciseOption> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<FlashcardExerciseOption> options) {
        this.options = options;
    }
}
