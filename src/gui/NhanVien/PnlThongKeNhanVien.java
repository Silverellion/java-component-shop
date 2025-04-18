package gui.NhanVien;

import utils.SwingHelper;

import javax.swing.*;
import java.io.Serial;

public class PnlThongKeNhanVien extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;

    public PnlThongKeNhanVien() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel lblTitle = SwingHelper.createProjectJLabel("Thống kê nhân viên", 30);
        lblTitle.setAlignmentX(CENTER_ALIGNMENT);
        add(lblTitle);
    }
}