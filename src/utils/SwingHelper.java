package utils;

import javax.swing.*;
import java.awt.*;

public class SwingHelper {
    public static JLabel createProjectJLabel(String name) {
        JLabel jLabel = new JLabel(name);
        jLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        return jLabel;
    }

    public static JLabel createProjectJLabel(String name, int fontSize) {
        JLabel jLabel = new JLabel(name);
        jLabel.setFont(new Font("Segoe UI", Font.BOLD, fontSize));
        return jLabel;
    }

    public static JButton createProjectJButton(String name) {
        JButton jButton = new JButton(name);
        jButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        jButton.setBackground(new Color(200, 40, 40));
        jButton.setForeground(Color.WHITE);
        return jButton;
    }
}
