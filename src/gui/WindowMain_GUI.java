package gui;

import gui.DonHang.PnlTaoDonHang;
import gui.DonHang.PnlThongKeDonHang;
import gui.Kho.PnlNhapHang;
import gui.Kho.PnlThongKeKho;
import gui.NhanVien.PnlCapNhatNhanVien;
import gui.NhanVien.PnlThemNhanVien;

import javax.swing.*;
import javax.swing.plaf.basic.BasicMenuItemUI;
import java.awt.*;
import java.awt.event.*;
import java.io.Serial;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class WindowMain_GUI extends JFrame implements ActionListener {
    @Serial
    private static final long serialVersionUID = 1L;

    private JButton btnSelected = null;
    private final JButton btnQuanLyKhoPanel;
    private final JButton btnDonHangPnl;
    private final JButton btnQuanLyNhanVienPnl;
    private JButton btnTrangChuPanel;
    private final JButton btnCaiDatPanel;
    private final JButton btnDangNhap;
    private final JButton btnDangXuat;
    private final JPanel pnlSidebar;
    private final JPanel pnlEast;
    private boolean isLoggedIn = false;

    PnlNhapHang pnlNhapHang;
    PnlThongKeKho pnlThongKeKho;
    PnlTaoDonHang pnlTaoDonHang;
    PnlThongKeDonHang pnlThongKeDonHang;
    PnlThemNhanVien pnlThemNhanVien;
    PnlCapNhatNhanVien pnlCapNhatNhanVien;
    PnlTrangChu pnlTrangChu;
    PnlCaiDat pnlCaiDat;

    private final Map<JButton, JPopupMenu> buttonMenuMap = new HashMap<>();

    public WindowMain_GUI() {
        setTitle("Cửa hàng linh kiện");
        setSize(1600, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        pnlTrangChu = new PnlTrangChu();
        pnlNhapHang = new PnlNhapHang();
        pnlThongKeKho = new PnlThongKeKho();
        pnlTaoDonHang = new PnlTaoDonHang();
        pnlThongKeDonHang = new PnlThongKeDonHang();
        pnlThemNhanVien = new PnlThemNhanVien();
        pnlCapNhatNhanVien = new PnlCapNhatNhanVien();
        pnlCaiDat = new PnlCaiDat();

        JPanel pnlMain = new JPanel(new BorderLayout());

        pnlSidebar = new JPanel();
        pnlSidebar.setPreferredSize(new Dimension(220, getHeight()));
        pnlSidebar.setBackground(new Color(200, 60, 60));
        pnlSidebar.setLayout(new BoxLayout(pnlSidebar, BoxLayout.Y_AXIS));

        btnTrangChuPanel = createSidebarButton("Trang chủ", "icons8-home-50.png");
        btnQuanLyKhoPanel = createSidebarButton("Quản lý kho", "icons8-manage-50.png");
        btnDonHangPnl = createSidebarButton("Đơn hàng", "icons8-order-50.png");
        btnQuanLyNhanVienPnl = createSidebarButton("Quản lý nhân viên", "icons8-user-50.png");
        btnCaiDatPanel = createSidebarButton("Cài đặt", "icons8-settings-50.png");
        btnDangNhap = createSidebarButton("Đăng nhập", "icons8-login-50.png");
        btnDangXuat = createSidebarButton("Đăng xuất", "icons8-logout-50.png");

        pnlSidebar.add(btnTrangChuPanel);
        pnlSidebar.add(btnQuanLyKhoPanel);
        pnlSidebar.add(btnDonHangPnl);
        pnlSidebar.add(btnQuanLyNhanVienPnl);
        pnlSidebar.add(btnCaiDatPanel);
        pnlMain.add(pnlSidebar, BorderLayout.WEST);

        updateLoginStatus();

        pnlEast = new JPanel(new BorderLayout());
        pnlEast.add(pnlTrangChu); //pnlTrangChu starts by default
        pnlMain.add(pnlEast);

        add(pnlMain);
        setVisible(true);

        btnTrangChuPanel.addActionListener(this);
        btnCaiDatPanel.addActionListener(this);
        btnDangNhap.addActionListener(this);
        btnDangXuat.addActionListener(this);

        registerDropdown(btnQuanLyKhoPanel, "Nhập hàng", pnlNhapHang, pnlEast, this::resetSidebarColors);
        registerDropdown(btnQuanLyKhoPanel, "Thống kê kho", pnlThongKeKho, pnlEast, this::resetSidebarColors);

        registerDropdown(btnDonHangPnl, "Tạo đơn hàng", pnlTaoDonHang, pnlEast, this::resetSidebarColors);
        registerDropdown(btnDonHangPnl, "Thống kê đơn hàng", pnlThongKeDonHang, pnlEast, this::resetSidebarColors);

        registerDropdown(btnQuanLyNhanVienPnl, "Thêm nhân viên", pnlThemNhanVien, pnlEast, this::resetSidebarColors);
        registerDropdown(btnQuanLyNhanVienPnl, "Cập nhật nhân viên", pnlCapNhatNhanVien, pnlEast, this::resetSidebarColors);
    }

    private JPanel createPanel(String title) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel(title, SwingConstants.CENTER), BorderLayout.CENTER);
        return panel;
    }

    private JButton createSidebarButton(String text, String iconName) {
        String resourcePath = "/resources/icons/" + iconName;
        ImageIcon icon = null;
        try {
            URL imgURL = getClass().getResource(resourcePath);
            if (imgURL != null) {
                Image img = new ImageIcon(imgURL).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
                icon = new ImageIcon(img);
            }
        } catch (Exception e) {}

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

        if(src == btnTrangChuPanel)
            loadPnlEast(btnTrangChuPanel, pnlTrangChu);
        if (src == btnCaiDatPanel) {
            loadPnlEast(btnCaiDatPanel, pnlCaiDat);
        } if (src == btnDangNhap) {
            isLoggedIn = true;
            updateLoginStatus();
            this.dispose();
            new WindowLogin_GUI();
        } if (src == btnDangXuat) {
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

    private void loadPnlEast(JButton button, JPanel panel) {
        pnlEast.removeAll();
        pnlEast.add(panel);
        resetSidebarColors();

        btnSelected = button;
        button.setBackground(new Color(200, 0, 0));
        pnlEast.revalidate();
        pnlEast.repaint();
    }

    private void resetSidebarColors() {
        btnTrangChuPanel.setBackground(new Color(200, 60, 60));
        btnQuanLyKhoPanel.setBackground(new Color(200, 60, 60));
        btnDonHangPnl.setBackground(new Color(200, 60, 60));
        btnQuanLyNhanVienPnl.setBackground(new Color(200, 60, 60));
        btnCaiDatPanel.setBackground(new Color(200, 60, 60));
    }

    private void registerDropdown(JButton button, String itemName, JPanel panel, JPanel pnlMain, Runnable backgroundResetter) {
        JPopupMenu menu = buttonMenuMap.computeIfAbsent(button, btn -> {
            JPopupMenu newMenu = new JPopupMenu();
            newMenu.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            newMenu.setBackground(new Color(200, 60, 60));
            newMenu.setFocusable(false);

            btn.addMouseListener(new MouseAdapter() {
                Timer hoverTimer;

                @Override
                public void mouseEntered(MouseEvent e) {
                    hoverTimer = new Timer(100, u ->  newMenu.show(btn, btn.getWidth(), 0));
                    hoverTimer.setRepeats(false);
                    hoverTimer.start();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (hoverTimer != null && hoverTimer.isRunning()) {
                        hoverTimer.stop();
                    }

                    PointerInfo pi = MouseInfo.getPointerInfo();
                    Point location = pi.getLocation();
                    SwingUtilities.convertPointFromScreen(location, newMenu);

                    if (!newMenu.getBounds().contains(location)) {
                        newMenu.setVisible(false);
                    }
                }
            });

            return newMenu;
        });

        JMenuItem menuItem = new JMenuItem(itemName);
        styleMenuItem(menuItem);

        menuItem.addActionListener(e -> {
            backgroundResetter.run();
            button.setBackground(new Color(200, 0, 0));
            pnlMain.removeAll();
            pnlMain.add(panel);

            // Refresh data if switching to X panel that needs to sync with any given dynamic array
            if (panel instanceof PnlCapNhatNhanVien) {
                ((PnlCapNhatNhanVien) panel).refreshData();
            }

            pnlMain.revalidate();
            pnlMain.repaint();
            menu.setVisible(false);
        });

        menu.add(menuItem);
    }

    private void styleMenuItem(JMenuItem menuItem) {
        menuItem.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuItem.setOpaque(true);
        menuItem.setBackground(new Color(200, 60, 60));
        menuItem.setForeground(Color.WHITE);
        menuItem.setPreferredSize(new Dimension(200, 50));
        menuItem.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        menuItem.setFocusPainted(false);
        menuItem.setContentAreaFilled(false);
        menuItem.setBorderPainted(false);
        menuItem.setUI(new BasicMenuItemUI() {
            @Override
            protected void installDefaults() {
                super.installDefaults();
                selectionBackground = new Color(200, 0, 0);
                selectionForeground = Color.WHITE;
            }
        });

        menuItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                menuItem.setBackground(new Color(200, 0, 0));
                menuItem.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                menuItem.setBackground(new Color(200, 60, 60));
                menuItem.setForeground(Color.WHITE);
            }
        });
    }
}
