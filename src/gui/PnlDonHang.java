package gui;

import utils.SwingHelper;

import javax.swing.*;
import java.awt.*;

public class PnlDonHang extends JPanel {
    PnlDonHang() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(30, 30, 30));
        JLabel lblTitle = SwingHelper.createDarkModeJLabel("Panel đơn hàng", 30);
        lblTitle.setAlignmentX(CENTER_ALIGNMENT);
        add(lblTitle);
    }
}
