package gui;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.Serial;

import javax.swing.*;

public class PnlTrangChu extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;

    public PnlTrangChu() {
        setLayout(new BorderLayout());
        setBackground(new Color(240,100,100));
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(240,100,100));
        topPanel.setPreferredSize(new Dimension(getWidth(), 170));

        // This pane helps with the overlapping of the profile picture
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBackground(new Color(255,255,255));
        layeredPane.setPreferredSize(new Dimension(getWidth(), 250));

        // Small panel in between the header and body to make sure that the profile picture is inbetween the header and body
        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(new Color(255,255,255));
        whitePanel.setBounds(0, 170, 10000, 300);
        layeredPane.add(whitePanel, JLayeredPane.DEFAULT_LAYER);

        JButton profileButton = createProfilePictureButton();
        profileButton.setPreferredSize(new Dimension(100,100));

        // Precise setBounds to make sure the profile picture is in the middle of header and main pane
        profileButton.setBounds(getWidth() - 170, 105, 130, 130);
        layeredPane.add(profileButton, JLayeredPane.PALETTE_LAYER);

        // Component listener to adjust the profile button position when the panel is resized
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                profileButton.setBounds(getWidth() - 170, 105, 130, 130);
                layeredPane.repaint();
            }
        });

        JPanel middlePanel = new JPanel();
        middlePanel.setBackground(Color.WHITE);
        middlePanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(40, 40, 40, 40);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        JButton btnCard1 = createCardButton();
        JButton btnCard2 = createCardButton();
        JButton btnCard3 = createCardButton();

        gbc.gridx = 0;
        gbc.gridy = 0;
        middlePanel.add(btnCard1, gbc);

        gbc.gridx = 1;
        middlePanel.add(btnCard2, gbc);

        gbc.gridx = 2;
        middlePanel.add(btnCard3, gbc);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBackground(Color.WHITE);
        JLabel bottomLabel = new JLabel("Example Text bottom right");
        bottomPanel.add(bottomLabel);

        add(layeredPane, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private JButton createCardButton() {
        JButton button = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2d.setColor(new Color(240,100,100));
                g2d.fillRect(0, 0, getWidth(), getHeight());

                if (getModel().isRollover()) {
                    g2d.setColor(new Color(0,0,0,40)); //the 'a' in RGBA helps darken the color
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                }

                g2d.dispose();
                super.paintComponent(g);
            }
        };

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);

        button.setLayout(new BorderLayout());
        button.add(textPanel, BorderLayout.SOUTH);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(150, 200));

        return button;
    }

    private JButton createProfilePictureButton() {
        JButton button = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2d.setColor(Color.WHITE);
                g2d.fill(new Ellipse2D.Double(0, 0, getWidth() - 1, getHeight() - 1));

                if (getModel().isRollover()) {
                    g2d.setColor(new Color(0,0,0,40)); //the 'a' in RGBA helps darken the color
                    g2d.fill(new Ellipse2D.Double(0, 0, getWidth() - 1, getHeight() - 1));
                }

                g2d.dispose();
                super.paintComponent(g);
            }
        };

        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        return button;
    }
}