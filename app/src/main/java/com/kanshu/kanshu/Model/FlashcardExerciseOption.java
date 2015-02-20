package com.kanshu.kanshu.model;

/**
 * Created by alouanemed on 17-02-2015.
 */
public class FlashcardExerciseOption {
    private static int count_ = 0;
    private int number ;
    private String Title;
    private Boolean correct_answer;


    public FlashcardExerciseOption(String title, Boolean correct_answer) {
        Title = title;
        this.correct_answer = correct_answer;
        count_++;
        this.number = count_;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int nb) {
        this.number = nb;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Boolean isCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(Boolean correct_answer) {
        this.correct_answer = correct_answer;
    }
}
