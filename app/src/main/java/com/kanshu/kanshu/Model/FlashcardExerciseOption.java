package com.kanshu.kanshu.model;

/**
 * Created by alouanemed on 17-02-2015.
 */
public class FlashcardExerciseOption {
    private static int nb = 0;
    private String Title;
    private Boolean correct_answer;


    public FlashcardExerciseOption(String title, Boolean correct_answer) {
        Title = title;
        this.correct_answer = correct_answer;
        nb++;
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Boolean getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(Boolean correct_answer) {
        this.correct_answer = correct_answer;
    }
}
