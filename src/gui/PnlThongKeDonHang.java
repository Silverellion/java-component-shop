package gui;

import utils.SwingHelper;
import javax.swing.*;
import java.io.Serial;

public class PnlThongKeDonHang extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;
    PnlThongKeDonHang() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel lblTitle = SwingHelper.createProjectJLabel("Thống kê đơn hàng", 30);
        lblTitle.setAlignmentX(CENTER_ALIGNMENT);
        add(lblTitle);
    }
}
