package gui;

import utils.SwingHelper;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginWindow_GUI extends JFrame implements ActionListener {
    @Serial
    private static final long serialVersionUID = 1L;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JButton btnDangNhap;

    public LoginWindow_GUI() {
        setTitle("Đăng nhập");
        setSize(400, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblLogin = SwingHelper.createProjectJLabel("Đăng Nhập", 30);
        lblLogin.setHorizontalAlignment(JLabel.CENTER);

        JPanel formPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        lblUsername = SwingHelper.createProjectJLabel("Tên đăng nhập:");
        lblPassword = SwingHelper.createProjectJLabel("Mật khẩu:");
        
        txtUsername = new JTextField(15);
        txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtUsername.setPreferredSize(new Dimension(150, 25));
        
        txtPassword = new JPasswordField(15);
        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPassword.setPreferredSize(new Dimension(150, 25));
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        formPanel.add(lblUsername, gbc);
        
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        formPanel.add(txtUsername, gbc);
        
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        formPanel.add(lblPassword, gbc);
        
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        formPanel.add(txtPassword, gbc);
        
        btnDangNhap = SwingHelper.createProjectJButton("Đăng nhập");
        btnDangNhap.setPreferredSize(new Dimension(150, 30));
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnDangNhap);
        
        JPanel headerPanel = new JPanel(new BorderLayout(0, 10));
        headerPanel.add(lblLogin, BorderLayout.CENTER);
        
        JPanel mainPanel = new JPanel(new BorderLayout(0, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
        
        btnDangNhap.addActionListener(this);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src == btnDangNhap) {
            this.dispose();
            new MainWindow_GUI();
        }
    }
}