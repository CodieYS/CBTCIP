package com.onlineexamsystem;
import java.util.ArrayList;
import java.util.List;

public class ExamSystem {
    private List<User> users;
    private User loggedInUser;
    private List<Question> questions;

    public ExamSystem() {
        users = new ArrayList<>();
        users.add(new User("user1", "password1"));
        // Add more users as needed

        questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", List.of("Paris", "London", "Berlin", "Rome"), 0));
        questions.add(new Question("What is 2 + 2?", List.of("3", "4", "5", "6"), 1));
        questions.add(new Question("What is the largest planet?", List.of("Earth", "Mars", "Jupiter", "Saturn"), 2));
        // Add more questions as needed
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                loggedInUser = user;
                return true;
            }
        }
        return false;
    }

    public void logout() {
        loggedInUser = null;
    }

    public void updateProfile(String newProfile) {
        if (loggedInUser != null) {
            loggedInUser.setProfile(newProfile);
        }
    }

    public void updatePassword(String newPassword) {
        if (loggedInUser != null) {
            loggedInUser.setPassword(newPassword);
        }
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
