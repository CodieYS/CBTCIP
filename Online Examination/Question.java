package com.onlineexamsystem;
import java.util.List;

public class Question {
    private String question;
    private List<String> choices;
    private int correctAnswer;

    public Question(String question, List<String> choices, int correctAnswer) {
        this.question = question;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getChoices() {
        return choices;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

}
