package com.onlineexamsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateProfilePanel extends JPanel{
    private MainFrame mainFrame;
    private ExamSystem examSystem;
    private JTextField profileField;

    public UpdateProfilePanel(MainFrame mainFrame, ExamSystem examSystem) {
        this.mainFrame = mainFrame;
        this.examSystem = examSystem;
        setLayout(new BorderLayout());

        JLabel profileLabel = new JLabel("New Profile:");
        profileField = new JTextField();
        JButton updateButton = new JButton("Update");

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newProfile = profileField.getText();
                examSystem.updateProfile(newProfile);
                JOptionPane.showMessageDialog(mainFrame, "Profile updated successfully.", "Update Profile", JOptionPane.INFORMATION_MESSAGE);
                mainFrame.showPanel("MainMenu");
            }
        });

        add(profileLabel, BorderLayout.NORTH);
        add(profileField, BorderLayout.CENTER);
        add(updateButton, BorderLayout.SOUTH);
    }
}
