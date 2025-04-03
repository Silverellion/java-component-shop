package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel pnlSidebar;

	public MainWindow () {
		setTitle("Cửa hàng linh kiện");
		setSize(1280,720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pnlSidebar = new JPanel();
		pnlSidebar.setPreferredSize(new Dimension(300, getHeight()));
		pnlSidebar.setBackground(new Color(45, 45, 45));
		
		JPanel pnlMain = new JPanel();
		pnlMain.setLayout(new BorderLayout());
		pnlMain.setBackground(new Color(30, 30, 30));
		pnlMain.add(pnlSidebar, BorderLayout.WEST);
		add(pnlMain);
    }



	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
