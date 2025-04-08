package gui;

import javax.swing.*;
import java.awt.*;

public class PnlTaiKhoan extends JPanel {
    public PnlTaiKhoan() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(30, 30, 30));
        JLabel lblTitle = new JLabel("Panel Tài Khoản");
        lblTitle.setForeground(Color.white);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblTitle.setAlignmentX(CENTER_ALIGNMENT);
        add(lblTitle);
    }
}
