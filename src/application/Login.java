package application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Login {
    public static void main(String[] args) {
        JFrame login = new JFrame("Login");
        JPanel panel = new JPanel();
        JTextField loginName = new JTextField(20);
        JButton enter = new JButton("Login");

        panel.add(loginName);
        panel.add(enter);
        login.setSize(300, 100);
        login.add(panel);
        login.setVisible(true);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ChatClient client = new ChatClient(loginName.getText());
                    login.setVisible(false);
                    login.dispose();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
