package gui;

import utils.SwingHelper;

import java.awt.Color;
import java.io.Serial;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PnlQuanLyKho extends JPanel{
	@Serial
	private static final long serialVersionUID = 1L;
	public PnlQuanLyKho() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(new Color(30, 30, 30));
		JLabel lblTitle = SwingHelper.createDarkModeJLabel("Panel quản lý kho", 30);
		lblTitle.setAlignmentX(CENTER_ALIGNMENT);
		add(lblTitle);
	}
}
