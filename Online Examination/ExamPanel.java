package com.onlineexamsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ExamPanel extends JPanel{
    private MainFrame mainFrame;
    private ExamSystem examSystem;
    private List<Question> questions;
    private int currentQuestionIndex;
    private int score;
    private JLabel questionLabel;
    private JRadioButton[] options;
    private ButtonGroup buttonGroup;
    private JButton nextButton;

    public ExamPanel(MainFrame mainFrame, ExamSystem examSystem) {
        this.mainFrame = mainFrame;
        this.examSystem = examSystem;
        setLayout(new BorderLayout());

        questionLabel = new JLabel();
        options = new JRadioButton[4];
        buttonGroup = new ButtonGroup();
        JPanel optionsPanel = new JPanel(new GridLayout(4, 1));
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            buttonGroup.add(options[i]);
            optionsPanel.add(options[i]);
        }
        nextButton = new JButton("Next");

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.size()) {
                    loadQuestion(currentQuestionIndex);
                } else {
                    JOptionPane.showMessageDialog(mainFrame, "Exam finished. Your score: " + score + "/" + questions.size(), "Exam Finished", JOptionPane.INFORMATION_MESSAGE);
                    mainFrame.showPanel("MainMenu");
                }
            }
        });

        add(questionLabel, BorderLayout.NORTH);
        add(optionsPanel, BorderLayout.CENTER);
        add(nextButton, BorderLayout.SOUTH);

        startExam();
    }

    private void startExam() {
        questions = examSystem.getQuestions();
        currentQuestionIndex = 0;
        score = 0;
        if (!questions.isEmpty()) {
            loadQuestion(currentQuestionIndex);
        }
    }

    private void loadQuestion(int index) {
        Question question = questions.get(index);
        questionLabel.setText(question.getQuestion());
        List<String> choices = question.getChoices();
        for (int i = 0; i < choices.size(); i++) {
            options[i].setText(choices.get(i));
        }
        buttonGroup.clearSelection();
    }

    private void checkAnswer() {
        Question question = questions.get(currentQuestionIndex);
        int selectedOption = -1;
        for (int i = 0; i < options.length; i++) {
            if (options[i].isSelected()) {
                selectedOption = i;
                break;
            }
        }
        if (selectedOption == question.getCorrectAnswer()) {
            score++;
        }
    }
}
