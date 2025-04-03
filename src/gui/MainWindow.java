package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton btnManageProducts;
	private JButton btnSettings;
	private JButton btnLogin;
	private JButton btnLogout;
    private JPanel pnlSidebar;
    private boolean isLoggedIn = false;

    public MainWindow() {
        setTitle("Cửa hàng linh kiện");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        pnlSidebar = new JPanel();
        pnlSidebar.setPreferredSize(new Dimension(250, getHeight()));
        pnlSidebar.setBackground(new Color(45, 45, 45));
        pnlSidebar.setLayout(new BoxLayout(pnlSidebar, BoxLayout.Y_AXIS));

        btnManageProducts = createSidebarButton("Quản lý linh kiện", "icons8-manage-50.png");
        btnSettings = createSidebarButton("Cài đặt", "icons8-settings-50.png");
        btnLogin = createSidebarButton("Đăng nhập", "icons8-login-50.png");
        btnLogout = createSidebarButton("Đăng xuất", "icons8-logout-50.png");

        pnlSidebar.add(btnManageProducts);
        pnlSidebar.add(btnSettings);
        updateLoginStatus();

        btnLogin.addActionListener(e -> {
            isLoggedIn = true;
            updateLoginStatus();
        });

        btnLogout.addActionListener(e -> {
            isLoggedIn = false;
            updateLoginStatus();
        });

        JPanel pnlMain = new JPanel(new BorderLayout());
        pnlMain.setBackground(new Color(30, 30, 30));
        pnlMain.add(pnlSidebar, BorderLayout.WEST);
        add(pnlMain);
    }
    
    private JButton createSidebarButton(String text, String iconPath) {
        JButton button = new JButton(text, new ImageIcon(getClass().getResource(iconPath)));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        button.setBackground(new Color(45, 45, 45));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        return button;
    }

    private void updateLoginStatus() {
        pnlSidebar.remove(btnLogin);
        pnlSidebar.remove(btnLogout);

        if (isLoggedIn) {
            pnlSidebar.add(btnLogout);
        } else {
            pnlSidebar.add(btnLogin);
        }

        pnlSidebar.revalidate();
        pnlSidebar.repaint();
    }

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
