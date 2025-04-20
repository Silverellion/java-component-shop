package gui;

import gui.DonHang.PnlTaoDonHang;
import gui.Kho.PnlNhapHang;
import gui.NhanVien.PnlCapNhatNhanVien;
import utils.SwingHelper;
import entity.TaiKhoan;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.Serial;
import java.util.Objects;

import javax.swing.*;

public class PnlTrangChu extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;
    private final TaiKhoan taiKhoan;
    public PnlTrangChu() {
        this(null);
    }

    public PnlTrangChu(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;

        setLayout(new BorderLayout());
        setBackground(new Color(240,100,100));

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(240,100,100));
        topPanel.setPreferredSize(new Dimension(getWidth(), 170));

        JLabel welcomeLabel = SwingHelper.createProjectJLabel("Chào mừng trở lại, " + taiKhoan.getHoTen(), 35, Color.WHITE);
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 0));
        topPanel.add(welcomeLabel, BorderLayout.WEST);

        // This pane helps with the overlapping of the profile picture
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBackground(new Color(255,255,255));
        layeredPane.setPreferredSize(new Dimension(getWidth(), 250));

        // Small panel in between the header and body to make sure that the profile picture is inbetween the header and body
        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(new Color(255,255,255));
        whitePanel.setBounds(0, 170, 10000, 300);
        layeredPane.add(whitePanel, JLayeredPane.DEFAULT_LAYER);

        // Add the top panel to the layered pane
        topPanel.setBounds(0, 0, 10000, 170);
        layeredPane.add(topPanel, JLayeredPane.DEFAULT_LAYER);

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

        JPanel pnlCenter = new JPanel();
        pnlCenter.setBackground(Color.WHITE);
        pnlCenter.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(40, 40, 40, 40);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        PnlNhapHang pnlNhapHang = new PnlNhapHang();
        PnlTaoDonHang pnlTaoDonHang = new PnlTaoDonHang();
        PnlCapNhatNhanVien pnlCapNhatNhanVien = new PnlCapNhatNhanVien();

        JButton btnCard1 = createCardButton("inventory.png", "Quản lý kho", pnlNhapHang);
        JButton btnCard2 = createCardButton("receipt.png", "Đơn hàng", pnlTaoDonHang);
        JButton btnCard3 = createCardButton("multiple-users.png",  "Quản lý nhân viên", pnlCapNhatNhanVien);

        gbc.gridx = 0;
        gbc.gridy = 0;
        pnlCenter.add(btnCard1, gbc);

        gbc.gridx = 1;
        pnlCenter.add(btnCard2, gbc);

        gbc.gridx = 2;
        pnlCenter.add(btnCard3, gbc);

        add(layeredPane, BorderLayout.NORTH);
        add(pnlCenter, BorderLayout.CENTER);
    }

    private JButton createCardButton(String iconName, String title, JPanel targetPanel) {
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

        try {
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/icons/" + iconName)));
            Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(img));
            button.setHorizontalAlignment(JButton.CENTER);
            button.setVerticalAlignment(JButton.CENTER);
            button.setIconTextGap(20);
        } catch (Exception e) {}

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);

        JLabel lblDescription = SwingHelper.createProjectJLabel(title, 25, Color.WHITE);
        lblDescription.setAlignmentX(Component.CENTER_ALIGNMENT);
        textPanel.add(lblDescription);

        button.setLayout(new BorderLayout());
        button.add(textPanel, BorderLayout.SOUTH);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(150, 200));

        // Add action listener if a target panel is specified
        if (targetPanel != null) {
            button.addActionListener(e -> {
                Container parent = getParent();
                if (parent != null) {
                    parent.removeAll();
                    parent.add(targetPanel);
                    parent.revalidate();
                    parent.repaint();
                }
            });
        }

        return button;
    }

    //READ HOW THIS FUNCTION WORKS AT PnlTrangChuREADME.md
    private JButton createProfilePictureButton() {
        JLabel tempLabel = new JLabel();
        tempLabel.setPreferredSize(new Dimension(130, 130));

        final BufferedImage[] circularImage = {null};

        if (taiKhoan != null && taiKhoan.getPathHinhAnh() != null) {
            String imagePath = taiKhoan.getPathHinhAnh();

            if (!imagePath.isEmpty()) {
                utils.ImageHelper.loadImage(tempLabel, imagePath);

                if (tempLabel.getIcon() != null) {
                    ImageIcon originalIcon = (ImageIcon) tempLabel.getIcon();
                    Image img = originalIcon.getImage();

                    circularImage[0] = new BufferedImage(130, 130, BufferedImage.TYPE_INT_ARGB);
                    Graphics2D g2 = circularImage[0].createGraphics();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setClip(new Ellipse2D.Double(0, 0, 130, 130));
                    g2.drawImage(img, 0, 0, null);
                    g2.dispose();
                }
            }
        }

        JButton button = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2d.setColor(Color.WHITE);
                g2d.fill(new Ellipse2D.Double(0, 0, getWidth() - 1, getHeight() - 1));

                if (circularImage[0] != null) {
                    g2d.drawImage(circularImage[0], 0, 0, null);
                }

                // Apply darkening overlay on hover
                if (getModel().isRollover()) {
                    g2d.setColor(new Color(0, 0, 0, 40));
                    g2d.fill(new Ellipse2D.Double(0, 0, getWidth() - 1, getHeight() - 1));
                }

                g2d.dispose();
            }

            @Override
            protected void paintBorder(Graphics g) {
                // Don't draw the border
            }
        };

        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        return button;
    }
}