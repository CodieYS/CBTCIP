package com.onlineexamsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel{
    private MainFrame mainFrame;
    private ExamSystem examSystem;

    public MainMenuPanel(MainFrame mainFrame, ExamSystem examSystem) {
        this.mainFrame = mainFrame;
        this.examSystem = examSystem;
        setLayout(new GridLayout(4, 1));

        JButton updateProfileButton = new JButton("Update Profile");
        JButton updatePasswordButton = new JButton("Update Password");
        JButton takeExamButton = new JButton("Take Exam");
        JButton logoutButton = new JButton("Logout");

        updateProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showPanel("UpdateProfile");
            }
        });

        updatePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showPanel("UpdatePassword");
            }
        });

        takeExamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showPanel("Exam");
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                examSystem.logout();
                mainFrame.showPanel("Login");
            }
        });

        add(updateProfileButton);
        add(updatePasswordButton);
        add(takeExamButton);
        add(logoutButton);
    }
}
