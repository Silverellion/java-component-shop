package main;

import database.JDBC;
import gui.LoginWindow;

public class App {
	private static final String url = "jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true";
	private static final String user = "sa";
	private static final String password = "your_password";
	public static void main(String[] args) {
		JDBC.connect(url, user, password);
		new LoginWindow();
	}
}
