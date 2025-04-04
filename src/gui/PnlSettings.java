package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PnlSettings extends JPanel {
	private static final long serialVersionUID = 1L;
	public PnlSettings() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(new Color(30, 30, 30));
		JLabel lblTitle = new JLabel("Panel cài đặt");
		lblTitle.setForeground(Color.white);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitle.setAlignmentX(CENTER_ALIGNMENT);
		add(lblTitle);
	}
}
