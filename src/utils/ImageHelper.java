package utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ImageHelper {
    private static String currentImagePath;

    public static String saveImage(JLabel lblImage) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select an image");
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            File cacheDir = new File("C:\\componentShopCache");
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            String newFilePath = "C:\\componentShopCache\\" + selectedFile.getName();
            File newFile = new File(newFilePath);

            try {
                Files.copy(selectedFile.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // Read and scale the image
                BufferedImage originalImage = ImageIO.read(newFile);
                Image scaledImage = originalImage.getScaledInstance(
                        lblImage.getPreferredSize().width,
                        lblImage.getPreferredSize().height,
                        Image.SCALE_SMOOTH
                );

                // Set the image to the label
                ImageIcon icon = new ImageIcon(scaledImage);
                icon.setDescription(newFilePath); // Set the description to store the path so we can load it later
                lblImage.setIcon(icon);
                lblImage.revalidate();
                lblImage.repaint();

                currentImagePath = newFilePath;

                return newFilePath;
            } catch (IOException e) {
                return null;
            }
        }

        return null;
    }

    public static void loadImage(JLabel label, String imagePath) {
        if (imagePath == null || imagePath.isEmpty())
            return;
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            Image scaledImage = image.getScaledInstance(
                    label.getPreferredSize().width,
                    label.getPreferredSize().height,
                    Image.SCALE_SMOOTH
            );
            ImageIcon icon = new ImageIcon(scaledImage);
            icon.setDescription(imagePath); // Set the description to store the path so we can load it later
            label.setIcon(icon);
            label.revalidate();
            label.repaint();

            currentImagePath = imagePath;
        } catch (IOException e) {
            System.err.println("Error loading image: " + e.getMessage());
            label.setIcon(null);
            currentImagePath = null;
        }
    }

    public static String getImagePath(JLabel label) {
        if (label == null || label.getIcon() == null) {
            return currentImagePath; // Return the last known path if available
        }

        if (label.getIcon() instanceof ImageIcon icon) {
            String description = icon.getDescription();
            return description != null ? description : currentImagePath;
        }

        return currentImagePath;
    }
}