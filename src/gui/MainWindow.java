package gui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;

public class MainWindow extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;

	public MainWindow () {
		setTitle("Cửa hàng linh kiện PC");
		setSize(1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new GridLayout(1, 3, 20, 0));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel emptyFramePanel = createEmptyFrame();
        
        JPanel bookFrame = createProductFrame(
            "Book", 
            "Regular book for regular readers",
            "230,000 VND",
            5,
            null
        );
        
        JPanel boxedSetFrame = createProductFrame(
            "The Hobbit & The Lord Of The Rings Boxed Book Sets",
            "Boxed gift set of Tolkien's classic masterpieces, fully illustrated throughout in watercolour by the acclaimed and award-winning artist",
            "1,500,000 VND",
            5,
            null
        );
        
        mainPanel.add(emptyFramePanel);
        mainPanel.add(bookFrame);
        mainPanel.add(boxedSetFrame);
        
        add(mainPanel);
    }
    
    private JPanel createEmptyFrame() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new DashedBorder(new Color(173, 216, 230), 2, 5, 5, true));
        
        JButton plusButton = new JButton("+");
        plusButton.setFont(new Font("Arial", Font.PLAIN, 24));
        plusButton.setForeground(Color.GRAY);
        plusButton.setBackground(new Color(245, 245, 245));
        plusButton.setBorderPainted(false);
        plusButton.setFocusPainted(false);
        
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.WHITE);
        centerPanel.add(plusButton);
        
        panel.add(centerPanel, BorderLayout.CENTER);
        return panel;
    }
    
    private JPanel createProductFrame(String title, String description, String price, int rating, ImageIcon image) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        panel.setBackground(Color.WHITE);
        
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.WHITE);
        
        JLabel titleLabel = new JLabel("Frame " + (title.contains("Hobbit") ? "29" : "5"));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        titleLabel.setForeground(Color.GRAY);
        
        JButton cogButton = new JButton("\u2699");
        cogButton.setFont(new Font("Arial", Font.BOLD, 18));
        cogButton.setBorderPainted(false);
        cogButton.setContentAreaFilled(false);
        cogButton.setFocusPainted(false);
        
        topPanel.add(titleLabel, BorderLayout.CENTER);
        topPanel.add(cogButton, BorderLayout.EAST);
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel imagePanel = new JPanel();
        imagePanel.setPreferredSize(new Dimension(120, 150));
        imagePanel.setBackground(Color.WHITE);
        imagePanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        
        if (title.contains("Hobbit")) {
            JPanel boxHolder = new JPanel();
            boxHolder.setPreferredSize(new Dimension(100, 120));
            boxHolder.setBackground(new Color(139, 69, 19));
            imagePanel.add(boxHolder);
        } else {
            JPanel bookCover = new JPanel();
            bookCover.setPreferredSize(new Dimension(90, 120));
            bookCover.setBackground(Color.BLACK);
            bookCover.setBorder(BorderFactory.createLineBorder(new Color(218, 165, 32), 1));
            imagePanel.add(bookCover);
        }
        
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel bookTitle = new JLabel(title);
        bookTitle.setFont(new Font("Arial", Font.BOLD, 14));
        bookTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JTextArea descriptionText = new JTextArea(description);
        descriptionText.setFont(new Font("Arial", Font.PLAIN, 12));
        descriptionText.setLineWrap(true);
        descriptionText.setWrapStyleWord(true);
        descriptionText.setEditable(false);
        descriptionText.setBackground(Color.WHITE);
        descriptionText.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JPanel ratingPanel = new JPanel();
        ratingPanel.setBackground(Color.WHITE);
        for (int i = 0; i < rating; i++) {
            JLabel star = new JLabel("★");
            star.setForeground(Color.BLACK);
            ratingPanel.add(star);
        }
        ratingPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel priceLabel = new JLabel(price);
        priceLabel.setFont(new Font("Arial", Font.BOLD, 14));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(bookTitle);
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(descriptionText);
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(ratingPanel);
        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(priceLabel);
        
        centerPanel.add(imagePanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(infoPanel);
        
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        
        return panel;
    }
    
    private static class DashedBorder extends AbstractBorder {
        private Color color;
        private int thickness;
        private int dashLength;
        private int spaceLength;
        private boolean roundedCorners;
        
        public DashedBorder(Color color, int thickness, int dashLength, int spaceLength, boolean roundedCorners) {
            this.color = color;
            this.thickness = thickness;
            this.dashLength = dashLength;
            this.spaceLength = spaceLength;
            this.roundedCorners = roundedCorners;
        }
        
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(color);
            g2d.setStroke(new BasicStroke(thickness, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 
                                           0, new float[]{dashLength, spaceLength}, 0));
            
            if (roundedCorners) {
                g2d.drawRoundRect(x + thickness/2, y + thickness/2, width - thickness, height - thickness, 10, 10);
            } else {
                g2d.drawRect(x + thickness/2, y + thickness/2, width - thickness, height - thickness);
            }
            g2d.dispose();
        }
        
        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(thickness, thickness, thickness, thickness);
        }
        
        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.top = insets.right = insets.bottom = thickness;
            return insets;
        }
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
	}
}
