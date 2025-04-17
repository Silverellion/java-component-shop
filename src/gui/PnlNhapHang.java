package gui;

import utils.SwingHelper;
import java.io.Serial;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PnlNhapHang extends JPanel{
	@Serial
	private static final long serialVersionUID = 1L;
	public PnlNhapHang() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel lblTitle = SwingHelper.createProjectJLabel("Nhập hàng", 30);
		lblTitle.setAlignmentX(CENTER_ALIGNMENT);
		add(lblTitle);
	}
}
