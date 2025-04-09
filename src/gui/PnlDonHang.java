package gui;

import utils.SwingHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;

public class PnlDonHang extends JPanel implements ActionListener {
    @Serial
    private static final long serialVersionUID = 1L;
    PnlDonHang() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(30, 30, 30));
        JLabel lblTitle = SwingHelper.createDarkModeJLabel("Panel đơn hàng", 30);
        lblTitle.setAlignmentX(CENTER_ALIGNMENT);
        add(lblTitle);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
