package com.onlineexamsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LoginPanel extends JPanel{
    private MainFrame mainFrame;
    private ExamSystem examSystem;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginPanel(MainFrame mainFrame, ExamSystem examSystem) {
        this.mainFrame = mainFrame;
        this.examSystem = examSystem;
        setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (examSystem.login(username, password)) {
                    mainFrame.showPanel("MainMenu");
                } else {
                    JOptionPane.showMessageDialog(mainFrame, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel()); // empty cell
        add(loginButton);
    }
}
