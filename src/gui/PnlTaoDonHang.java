package gui;

import utils.SwingHelper;
import javax.swing.*;
import java.io.Serial;

public class PnlTaoDonHang extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;
    PnlTaoDonHang() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel lblTitle = SwingHelper.createProjectJLabel("Tạo đơn hàng", 30);
        lblTitle.setAlignmentX(CENTER_ALIGNMENT);
        add(lblTitle);
    }
}
