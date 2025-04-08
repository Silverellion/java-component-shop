package gui;

import java.awt.Color;
import java.awt.Font;
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
		JLabel lblTitle = new JLabel("Panel quản lý kho");
		lblTitle.setForeground(Color.white);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitle.setAlignmentX(CENTER_ALIGNMENT);
		add(lblTitle);
	}
}
