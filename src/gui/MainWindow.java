package gui;

import utils.DropdownHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serial;
import java.net.URL;

public class MainWindow extends JFrame implements ActionListener {
    @Serial
    private static final long serialVersionUID = 1L;

    private JButton btnSelected = null;
    private final JButton btnQuanLyKhoPanel;
    private final JButton btnDonHangPnl;
    private final JButton btnQuanLyNhanVienPnl;
    private final JButton btnCaiDatPanel;
    private final JButton btnDangNhap;
    private final JButton btnDangXuat;
    private final JPanel pnlSidebar;
    private final JPanel pnlEast;
    private boolean isLoggedIn = false;

    // Main content panels
    PnlQuanLyKho pnlQuanLyKho;
    PnlDonHang pnlDonHang;
    PnlQuanLyNhanVien pnlQuanLyNhanVien;
    PnlCaiDat pnlCaiDat;

    public MainWindow() {
        setTitle("Cửa hàng linh kiện");
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        pnlQuanLyKho = new PnlQuanLyKho();
        pnlDonHang = new PnlDonHang();
        pnlQuanLyNhanVien = new PnlQuanLyNhanVien();
        pnlCaiDat = new PnlCaiDat();

        JPanel pnlMain = new JPanel(new BorderLayout());

        pnlSidebar = new JPanel();
        pnlSidebar.setPreferredSize(new Dimension(220, getHeight()));
        pnlSidebar.setBackground(new Color(200, 60, 60));
        pnlSidebar.setLayout(new BoxLayout(pnlSidebar, BoxLayout.Y_AXIS));

        btnQuanLyKhoPanel = createSidebarButton("Quản lý kho", "icons8-manage-50.png");
        btnDonHangPnl = createSidebarButton("Đơn hàng", "icons8-order-50.png");
        btnQuanLyNhanVienPnl = createSidebarButton("Quản lý nhân viên", "icons8-user-50.png");
        btnCaiDatPanel = createSidebarButton("Cài đặt", "icons8-settings-50.png");
        btnDangNhap = createSidebarButton("Đăng nhập", "icons8-login-50.png");
        btnDangXuat = createSidebarButton("Đăng xuất", "icons8-logout-50.png");

        pnlSidebar.add(btnQuanLyKhoPanel);
        pnlSidebar.add(btnDonHangPnl);
        pnlSidebar.add(btnQuanLyNhanVienPnl);
        pnlSidebar.add(btnCaiDatPanel);
        pnlMain.add(pnlSidebar, BorderLayout.WEST);

        updateLoginStatus();

        pnlEast = new JPanel(new BorderLayout());
        pnlMain.add(pnlEast);

        add(pnlMain);
        setVisible(true);

        // Action listeners for non-dropdown buttons
        btnCaiDatPanel.addActionListener(this);
        btnDangNhap.addActionListener(this);
        btnDangXuat.addActionListener(this);

        DropdownHelper.register(btnQuanLyKhoPanel, "Nhập hàng", createPanel("Nhập hàng"), pnlEast, this::resetSidebarColors);
        DropdownHelper.register(btnQuanLyKhoPanel, "Thống kê kho", createPanel("Thống kê kho"), pnlEast, this::resetSidebarColors);

        DropdownHelper.register(btnDonHangPnl, "Tạo đơn hàng", createPanel("Tạo đơn hàng"), pnlEast, this::resetSidebarColors);
        DropdownHelper.register(btnDonHangPnl, "Thống kê đơn hàng", createPanel("Thống kê đơn hàng"), pnlEast, this::resetSidebarColors);

        DropdownHelper.register(btnQuanLyNhanVienPnl, "Thêm nhân viên", createPanel("Thêm nhân viên"), pnlEast, this::resetSidebarColors);
        DropdownHelper.register(btnQuanLyNhanVienPnl, "Tra cứu nhân viên", createPanel("Tra cứu nhân viên"), pnlEast, this::resetSidebarColors);
        DropdownHelper.register(btnQuanLyNhanVienPnl, "Thống kê nhân viên", createPanel("Thống kê nhân viên"), pnlEast, this::resetSidebarColors);
    }

    private JPanel createPanel(String title) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel(title, SwingConstants.CENTER), BorderLayout.CENTER);
        return panel;
    }

    private JButton createSidebarButton(String text, String iconPath) {
        String resourcePath = "/resources/icons/" + iconPath;
        ImageIcon icon = null;
        try {
            URL imgURL = getClass().getResource(resourcePath);
            if (imgURL != null) {
                Image img = new ImageIcon(imgURL).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
                icon = new ImageIcon(img);
            }
        } catch (Exception ignored) {}

        JButton button = new JButton(text, icon);
        button.setHorizontalAlignment(JButton.LEFT);
        button.setHorizontalTextPosition(JButton.RIGHT);
        button.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        button.setAlignmentX(LEFT_ALIGNMENT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        button.setBackground(new Color(200, 60, 60));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setIconTextGap(10);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (button != btnSelected)
                    button.setBackground(new Color(200, 0, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (button != btnSelected)
                    button.setBackground(new Color(200, 60, 60));
            }
        });

        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnCaiDatPanel) {
            loadPnlEast(btnCaiDatPanel, pnlCaiDat);
        } else if (src == btnDangNhap) {
            isLoggedIn = true;
            updateLoginStatus();
            this.dispose();
            new LoginWindow();
        } else if (src == btnDangXuat) {
            isLoggedIn = false;
            updateLoginStatus();
            this.dispose();
        }
    }

    private void updateLoginStatus() {
        pnlSidebar.remove(btnDangNhap);
        pnlSidebar.remove(btnDangXuat);
        pnlSidebar.add(isLoggedIn ? btnDangXuat : btnDangNhap);
        pnlSidebar.revalidate();
        pnlSidebar.repaint();
    }

    private void loadPnlEast(JButton jButton, JPanel jPanel) {
        pnlEast.removeAll();
        pnlEast.add(jPanel);
        resetSidebarColors();

        btnSelected = jButton;
        jButton.setBackground(new Color(200, 0, 0));
        pnlEast.revalidate();
        pnlEast.repaint();
    }

    private void resetSidebarColors() {
        btnQuanLyKhoPanel.setBackground(new Color(200, 60, 60));
        btnDonHangPnl.setBackground(new Color(200, 60, 60));
        btnQuanLyNhanVienPnl.setBackground(new Color(200, 60, 60));
        btnCaiDatPanel.setBackground(new Color(200, 60, 60));
    }
}
