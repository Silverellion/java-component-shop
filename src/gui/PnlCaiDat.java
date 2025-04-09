package gui;

import utils.SwingHelper;

import java.awt.Color;
import java.awt.Font;
import java.io.Serial;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PnlCaiDat extends JPanel {
	@Serial
	private static final long serialVersionUID = 1L;
	public PnlCaiDat() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(new Color(30, 30, 30));
		JLabel lblTitle = SwingHelper.createDarkModeJLabel("Panel cài đặt", 30);
		lblTitle.setAlignmentX(CENTER_ALIGNMENT);
		add(lblTitle);
	}
}
