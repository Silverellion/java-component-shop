package utils;

import javax.swing.*;
import java.awt.*;

public class SwingHelper {
    public static JLabel createDarkModeJLabel(String name) {
        JLabel jLabel = new JLabel(name);
        jLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        jLabel.setForeground(Color.WHITE);
        return jLabel;
    }

    public static JLabel createDarkModeJLabel(String name, int fontSize) {
        JLabel jLabel = new JLabel(name);
        jLabel.setFont(new Font("Segoe UI", Font.BOLD, fontSize));
        jLabel.setForeground(Color.WHITE);
        return jLabel;
    }

    public static JButton createDarkModeJButton(String name) {
        JButton jButton = new JButton(name);
        jButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        jButton.setBackground(new Color(30, 30, 30));
        jButton.setForeground(Color.white);
        return jButton;
    }
}
