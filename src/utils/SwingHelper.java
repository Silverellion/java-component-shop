package utils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.net.URL;

public class SwingHelper {
    public static JLabel createProjectJLabel(String name) {
        JLabel label = new JLabel(name);
        label.setFont(new Font("Segoe UI", Font.BOLD, 16));
        return label;
    }

    public static JLabel createProjectJLabel(String name, int fontSize) {
        JLabel label = new JLabel(name);
        label.setFont(new Font("Segoe UI", Font.BOLD, fontSize));
        return label;
    }

    public static JButton createProjectJButton(String name) {
        JButton button = new JButton(name) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Create background
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);

                g2.dispose();
                setContentAreaFilled(false);
                super.paintComponent(g);
            }

            @Override
            protected void paintBorder(Graphics g) {
                // No border
            }
        };

        return defaultButtonStyling(button);
    }

    public static JButton createProjectJButton(String name, String iconName) {
        String resourcePath = "/resources/icons/" + iconName;
        ImageIcon icon = null;
        try {
            URL imgURL = SwingHelper.class.getResource(resourcePath);
            if (imgURL != null) {
                Image img = new ImageIcon(imgURL).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                icon = new ImageIcon(img);
            }
        } catch (Exception e) {}
        JButton button = new JButton(name, icon) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Create background
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);

                g2.dispose();
                setContentAreaFilled(false);
                super.paintComponent(g);
            }

            @Override
            protected void paintBorder(Graphics g) {
                // No border
            }
        };

        return defaultButtonStyling(button);
    }

    private static JButton defaultButtonStyling(JButton button) {
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setBackground(new Color(200, 60, 60));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(200, 0, 0));
                button.repaint();
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(200, 60, 60));
                button.repaint();
            }
        });
        return button;
    }

    public static JTable createProjectJTable(DefaultTableModel tblModel) {
        JTable table = new JTable(tblModel) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (!isRowSelected(row))
                    c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(240, 140, 140));
                else
                    c.setBackground(new Color(240, 100, 100));
                return c;
            }
        };

        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0)); // No cell spacing = no fake lines
        table.setDefaultEditor(Object.class, null);

        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(240, 140, 140));
        header.setForeground(Color.BLACK);
        header.setFont(new Font("Segoe UI", Font.BOLD, 13));
            ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        header.setBorder(BorderFactory.createEmptyBorder());

        return table;
    }
}
