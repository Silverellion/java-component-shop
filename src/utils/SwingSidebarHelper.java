package utils;

import gui.NhanVien.PnlCapNhatNhanVien;

import javax.swing.*;
import javax.swing.plaf.basic.BasicMenuItemUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class SwingSidebarHelper {
    private static final Map<JButton, JPopupMenu> buttonMenuMap = new HashMap<>();
    public static void registerDropdown(JButton button, String itemName, JPanel panel, JPanel pnlMain, Runnable backgroundResetter) {
        JPopupMenu menu = buttonMenuMap.computeIfAbsent(button, btn -> {
            JPopupMenu newMenu = new JPopupMenu();
            newMenu.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            newMenu.setBackground(new Color(200, 60, 60));
            newMenu.setFocusable(false);

            btn.addMouseListener(new MouseAdapter() {
                Timer hoverTimer;

                @Override
                public void mouseEntered(MouseEvent e) {
                    hoverTimer = new Timer(100, _ ->  newMenu.show(btn, btn.getWidth(), 0));
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

        menuItem.addActionListener(_ -> {
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

    private static void styleMenuItem(JMenuItem menuItem) {
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
