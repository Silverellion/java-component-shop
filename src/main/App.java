package main;

import gui.MainWindow;
import utils.FontHelper;

@SuppressWarnings("unused")
public class App {
	public static void main(String[] args) {
//		FontHelper.printFonts();
		MainWindow mainWindow = new MainWindow();
		mainWindow.setVisible(true);
	}
}
