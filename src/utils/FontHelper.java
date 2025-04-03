package utils;

import java.awt.GraphicsEnvironment;

public class FontHelper {
	public static void printFonts() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fonts = ge.getAvailableFontFamilyNames();
		for (String font : fonts) {
		    System.out.println(font);
		}
	}
}
