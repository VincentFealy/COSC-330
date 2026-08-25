//Vincent Fealy
//COSC 330 Lab 5

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingletonGUI {
    private static SingletonGUI instance;
    private JFrame mainFrame;
    private JFrame childFrame;

    private SingletonGUI() {
        initialize();
    }

    public static SingletonGUI getInstance() {
        if (instance == null) {
            instance = new SingletonGUI();
        }
        return instance;
    }

    private void initialize() {
        mainFrame = new JFrame("Main Window");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(300, 200);

        JButton button = new JButton("Open Another Window");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openChildWindow();
            }
        });

        mainFrame.getContentPane().add(button);
    }

    private void openChildWindow() {
        if (childFrame == null) {
            childFrame = new JFrame("Child Window");
            JLabel label = new JLabel("Another Window");
            childFrame.getContentPane().add(label);
            childFrame.setSize(200, 100);
            childFrame.setVisible(true);
        }
    }

    public void display() {
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SingletonGUI.getInstance().display();
    }
}
