package gui;

import utils.SwingHelper;

import java.io.Serial;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PnlTrangChu extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;
    public PnlTrangChu() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel lblTitle = SwingHelper.createProjectJLabel("Panel trang chủ", 30);
        lblTitle.setAlignmentX(CENTER_ALIGNMENT);
        add(lblTitle);


    }
}
