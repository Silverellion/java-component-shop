package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame implements ActionListener{
	@Serial
    private static final long serialVersionUID = 1L;
	private final JButton btnKhoPanel;
    private final JButton btnDonHangPnl;
    private final JButton btnTaiKhoanPnl;
	private final JButton btnCaiDatPanel;
	private final JButton btnDangNhap;
	private final JButton btnDangXuat;
    private final JPanel pnlSidebar;
    private boolean isLoggedIn = false;
	private final JPanel pnlEast;
	PnlQuanLyKho pnlQuanLyKho;
    PnlDonHang pnlDonHang;
    PnlTaiKhoan pnlTaiKhoan;
	PnlCaiDat pnlCaiDat;

    public MainWindow() {
        setTitle("Cửa hàng linh kiện");
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        pnlQuanLyKho = new PnlQuanLyKho();
        pnlDonHang = new PnlDonHang();
        pnlTaiKhoan = new PnlTaiKhoan();
        pnlCaiDat = new PnlCaiDat();
        
        JPanel pnlMain = new JPanel(new BorderLayout());
        pnlMain.setBackground(new Color(30, 30, 30));

        pnlSidebar = new JPanel();
        pnlSidebar.setPreferredSize(new Dimension(220, getHeight()));
        pnlSidebar.setBackground(new Color(45, 45, 45));
        pnlSidebar.setLayout(new BoxLayout(pnlSidebar, BoxLayout.Y_AXIS));

        btnKhoPanel = createSidebarButton("Quản lý kho", "icons8-manage-50.png");
        btnDonHangPnl = createSidebarButton("Đơn hàng", "icons8-order-50.png");
        btnTaiKhoanPnl = createSidebarButton("Quản lý nhân viên", "icons8-user-50.png");
        btnCaiDatPanel = createSidebarButton("Cài đặt", "icons8-settings-50.png");
        btnDangNhap = createSidebarButton("Đăng nhập", "icons8-login-50.png");
        btnDangXuat = createSidebarButton("Đăng xuất", "icons8-logout-50.png");

        pnlSidebar.add(btnKhoPanel);
        pnlSidebar.add(btnDonHangPnl);
        pnlSidebar.add(btnTaiKhoanPnl);
        pnlSidebar.add(btnCaiDatPanel);
        pnlMain.add(pnlSidebar, BorderLayout.WEST);
        updateLoginStatus();
        
        pnlEast = new JPanel();
        pnlEast.setLayout(new BorderLayout());
        pnlEast.setBackground(new Color(30, 30, 30));
        pnlMain.add(pnlEast);

        add(pnlMain);
        setVisible(true);
        
        btnKhoPanel.addActionListener(this);
        btnDonHangPnl.addActionListener(this);
        btnTaiKhoanPnl.addActionListener(this);
        btnCaiDatPanel.addActionListener(this);
        btnDangNhap.addActionListener(this);
        btnDangXuat.addActionListener(this);
    }
    
    private JButton createSidebarButton(String text, String iconPath) {
        String resourcePath = "/resources/icons/" + iconPath;
        ImageIcon icon = null;
        try {
            URL imgURL = getClass().getResource(resourcePath);
            if (imgURL != null) {
                ImageIcon originalIcon = new ImageIcon(imgURL);
                Image img = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
                icon = new ImageIcon(img);
            }
        } catch (Exception _) {}
        JButton jButton = new JButton(text, icon);
        jButton.setHorizontalAlignment(JButton.LEFT);
        jButton.setHorizontalTextPosition(JButton.RIGHT);

        jButton.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        jButton.setAlignmentX(LEFT_ALIGNMENT);
        jButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        jButton.setBackground(new Color(45, 45, 45));
        jButton.setForeground(Color.WHITE);
        jButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        jButton.setFocusPainted(false);
        jButton.setIconTextGap(10);

        return jButton;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == btnKhoPanel) {
			loadPnlEast(btnKhoPanel, pnlQuanLyKho);
		}
        if(src == btnDonHangPnl) {
            loadPnlEast(btnDonHangPnl, pnlDonHang);
        }
        if(src == btnTaiKhoanPnl) {
            loadPnlEast(btnTaiKhoanPnl, pnlTaiKhoan);
        }
		if(src == btnCaiDatPanel) {
			loadPnlEast(btnCaiDatPanel, pnlCaiDat);
		}
		if(src == btnDangNhap) {
            isLoggedIn = true;
            updateLoginStatus();
            this.dispose();
            new LoginWindow();
		}
		if(src == btnDangXuat) {
            isLoggedIn = false;
            updateLoginStatus();
            this.dispose();
		}
	}
	
	private void login() {
		
	}
	
    private void updateLoginStatus() {
        pnlSidebar.remove(btnDangNhap);
        pnlSidebar.remove(btnDangXuat);
        if (isLoggedIn) {
            pnlSidebar.add(btnDangXuat);
        } else {
            pnlSidebar.add(btnDangNhap);
        }
        pnlSidebar.revalidate();
        pnlSidebar.repaint();
    }
    
    private void loadPnlEast(JButton jButton, JPanel jPanel) {
    	pnlEast.removeAll();
    	pnlEast.add(jPanel);

    	btnKhoPanel.setBackground(new Color(45, 45, 45));
        btnDonHangPnl.setBackground(new Color(45, 45, 45));
        btnTaiKhoanPnl.setBackground(new Color(45, 45, 45));
    	btnCaiDatPanel.setBackground(new Color(45, 45, 45));
    	jButton.setBackground(new Color(30, 30, 30));
    	
    	pnlEast.revalidate();
    	pnlEast.repaint();
    }
}
