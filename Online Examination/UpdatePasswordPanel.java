package com.onlineexamsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatePasswordPanel extends JPanel {
    private MainFrame mainFrame;
    private ExamSystem examSystem;
    private JPasswordField passwordField;

    public UpdatePasswordPanel(MainFrame mainFrame, ExamSystem examSystem) {
        this.mainFrame = mainFrame;
        this.examSystem = examSystem;
        setLayout(new BorderLayout());

        JLabel passwordLabel = new JLabel("New Password:");
        passwordField = new JPasswordField();
        JButton updateButton = new JButton("Update");

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newPassword = new String(passwordField.getPassword());
                examSystem.updatePassword(newPassword);
                JOptionPane.showMessageDialog(mainFrame, "Password updated successfully.", "Update Password", JOptionPane.INFORMATION_MESSAGE);
                mainFrame.showPanel("MainMenu");
            }
        });

        add(passwordLabel, BorderLayout.NORTH);
        add(passwordField, BorderLayout.CENTER);
        add(updateButton, BorderLayout.SOUTH);
    }
}
