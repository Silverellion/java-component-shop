package utils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

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
        JButton button = new JButton(name);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setBackground(new Color(200, 40, 40));
        button.setForeground(Color.WHITE);
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
