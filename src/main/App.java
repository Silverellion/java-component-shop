package main;

import database.ConnectDB;
import gui.LoginWindow_GUI;

import java.io.IOException;
import java.sql.SQLException;

public class App {
	private static final String url = "jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;integratedSecurity=true";
	private static final String user = "sa";
	private static final String password = "sapassword";
	public static void main(String[] args) {
		try {
			ConnectDB.initialize(url, user, password);
			new LoginWindow_GUI();
		} catch (SQLException | IOException e) {
			throw new RuntimeException(e);
		}
	}
}
