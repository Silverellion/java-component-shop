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
    public static String loadImageAndCache(JLabel lblImage) {
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
}
