package gui;

import utils.SwingHelper;

import javax.swing.*;
import java.io.Serial;

public class PnlThemNhanVien extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;
    PnlThemNhanVien() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel lblTitle = SwingHelper.createProjectJLabel("Thêm nhân viên", 30);
        lblTitle.setAlignmentX(CENTER_ALIGNMENT);
        add(lblTitle);
    }
}