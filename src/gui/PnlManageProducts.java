package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PnlManageProducts extends JPanel{
	private static final long serialVersionUID = 1L;
	public PnlManageProducts() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(new Color(30, 30, 30));
		JLabel lblTitle = new JLabel("Panel quản lý linh kiện");
		lblTitle.setForeground(Color.white);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitle.setAlignmentX(CENTER_ALIGNMENT);
		add(lblTitle);
	}
}
