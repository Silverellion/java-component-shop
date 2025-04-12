package main;

import database.JDBC;
import gui.LoginWindow;

public class App {
	private static final String url = "jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;integratedSecurity=true";
	private static final String user = "sa";
	private static final String password = "sapassword";
	public static void main(String[] args) {
		JDBC.connect(url, user, password);
		new LoginWindow();
	}
}
