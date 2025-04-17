package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class DropdownHelper {
    private static final Map<JButton, JPopupMenu> buttonMenuMap = new HashMap<>();
    public static void register(JButton button, String itemName, JPanel panel, JPanel pnlMain, Runnable backgroundResetter) {
        JPopupMenu dropdownMenu = buttonMenuMap.computeIfAbsent(button, btn -> {
            JPopupMenu menu = new JPopupMenu();
            // Show menu on hover
            btn.addMouseListener(new MouseAdapter() {
                Timer hoverTimer;

                @Override
                public void mouseEntered(MouseEvent e) {
                    hoverTimer = new Timer(200, evt -> {
                        menu.show(btn, btn.getWidth(), 0);
                    });
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
                    SwingUtilities.convertPointFromScreen(location, menu);

                    if (!menu.getBounds().contains(location)) {
                        menu.setVisible(false);
                    }
                }
            });
            return menu;
        });

        // Create menu item
        JMenuItem menuItem = new JMenuItem(itemName);
        dropdownMenu.add(menuItem);

        menuItem.addActionListener(e -> {
            backgroundResetter.run();
            button.setBackground(new Color(200, 0, 0));

            pnlMain.removeAll();
            pnlMain.add(panel);
            pnlMain.revalidate();
            pnlMain.repaint();
        });
    }
}
