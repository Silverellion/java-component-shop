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
    public static String saveImage(JLabel lblImage) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select an image");
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            // Create the cache directory if it doesn't exist
            File cacheDir = new File("C:\\componentShopCache");
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            String newFilePath = "C:\\componentShopCache\\" + selectedFile.getName();
            File newFile = new File(newFilePath);

            try {
                // Copy the image to the cache directory
                Files.copy(selectedFile.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // Read and scale the image
                BufferedImage originalImage = ImageIO.read(newFile);
                Image scaledImage = originalImage.getScaledInstance(
                        lblImage.getPreferredSize().width,
                        lblImage.getPreferredSize().height,
                        Image.SCALE_SMOOTH
                );

                // Set the image to the label
                lblImage.setIcon(new ImageIcon(scaledImage));
                lblImage.revalidate();
                lblImage.repaint();

                return newFilePath;
            } catch (IOException _) {
                return null;
            }
        }

        return null;
    }

    public static void loadImage(JLabel label, String imagePath) {
        if (imagePath == null || imagePath.isEmpty()) {
            label.setIcon(null);
            label.setText("No image available");
            return;
        }

        File imageFile = new File(imagePath);
        if (!imageFile.exists() || !imageFile.isFile()) {
            label.setIcon(null);
            label.setText("Image file not found");
            System.err.println("Image file does not exist: " + imagePath);
            return;
        }

        try {
            System.out.println("Loading image from: " + imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            if (image == null) {
                label.setIcon(null);
                label.setText("Invalid image format");
                System.err.println("Could not read image as a valid image format: " + imagePath);
                return;
            }

            Image scaledImage = image.getScaledInstance(
                    label.getPreferredSize().width,
                    label.getPreferredSize().height,
                    Image.SCALE_SMOOTH
            );
            label.setIcon(new ImageIcon(scaledImage));
            label.setText(null);
            label.revalidate();
            label.repaint();
        } catch (IOException e) {
            label.setIcon(null);
            label.setText("Error loading image");
            System.err.println("Error loading image: " + e.getMessage());
        }
    }
}
