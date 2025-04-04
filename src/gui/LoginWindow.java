package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginWindow extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JButton btnLogin;

    public LoginWindow() {
        setSize(400, 720);
        setTitle("Đăng nhập");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(45, 45, 45));
        
        JLabel lblTitle = new JLabel("Đăng Nhập");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblTitle.setForeground(Color.WHITE);
        
        lblUsername = new JLabel("Tên đăng nhập: ");
        lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblUsername.setForeground(Color.WHITE);
        
        lblPassword = new JLabel("Password: ");
        lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblPassword.setForeground(Color.WHITE);
        
        lblUsername.setPreferredSize(lblUsername.getPreferredSize());
        lblPassword.setPreferredSize(lblUsername.getPreferredSize());
        
        txtUsername = new JTextField();
        txtPassword = new JTextField();
        
        Box box1 = new Box(BoxLayout.X_AXIS);
        Box box2 = new Box(BoxLayout.X_AXIS);
        Box boxCenter = new Box(BoxLayout.Y_AXIS);
        
        box1.setOpaque(true);
        box2.setOpaque(true);
        boxCenter.setOpaque(true);
        
        box1.setBackground(new Color(45, 45, 45));
        box2.setBackground(new Color(45, 45, 45));
        boxCenter.setBackground(new Color(45, 45, 45));
        
        box1.add(lblUsername);
        box1.add(txtUsername);
        
        box2.add(lblPassword);
        box2.add(txtPassword);
        
        btnLogin = new JButton("Đăng Nhập");
        
        boxCenter.add(lblTitle);
        boxCenter.add(box1);
        boxCenter.add(box2);
        boxCenter.add(btnLogin);
        add(boxCenter, BorderLayout.CENTER);
        
        btnLogin.addActionListener(this);
        setVisible(true);
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == btnLogin) {
			this.dispose();
			new MainWindow();
		}
	}

}
