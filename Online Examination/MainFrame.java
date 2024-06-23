package com.onlineexamsystem;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private LoginPanel loginPanel;
    private MainMenuPanel mainMenuPanel;
    private UpdateProfilePanel updateProfilePanel;
    private UpdatePasswordPanel updatePasswordPanel;
    private ExamPanel examPanel;
    private ExamSystem examSystem;

    public MainFrame() {
        // Initialize the ExamSystem
        examSystem = new ExamSystem();

        // Set up the frame
        setTitle("Online Examination System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up CardLayout
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Create panels
        loginPanel = new LoginPanel(this, examSystem);
        mainMenuPanel = new MainMenuPanel(this, examSystem);
        updateProfilePanel = new UpdateProfilePanel(this, examSystem);
        updatePasswordPanel = new UpdatePasswordPanel(this, examSystem);
        examPanel = new ExamPanel(this, examSystem);

        // Add panels to cardPanel
        cardPanel.add(loginPanel, "Login");
        cardPanel.add(mainMenuPanel, "MainMenu");
        cardPanel.add(updateProfilePanel, "UpdateProfile");
        cardPanel.add(updatePasswordPanel, "UpdatePassword");
        cardPanel.add(examPanel, "Exam");

        // Add cardPanel to frame
        add(cardPanel);

        // Show login panel initially
        showPanel("Login");
    }

    public void showPanel(String panelName) {
        cardLayout.show(cardPanel, panelName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
