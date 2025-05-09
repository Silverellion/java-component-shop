package main;

import database.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;
import gui.WindowLogin_GUI;
import gui.WindowMain_GUI;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class App {
	private static final String url = "jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;integratedSecurity=true";
	private static final String user = "sa";
	private static final String password = "sapassword";
	public static void main(String[] args) throws ParseException  {
		try {
			ConnectDB.initialize(url, user, password);
			ConnectDB.generateTempData(); //Comment this code to not generate NhaCungCap and SanPham tables in SQL.
//			new WindowLogin_GUI(); //COMMENT THIS CODE THEN UNCOMMENT THE CODEBLOCK BELOW IF YOU DIDN'T CREATE AN ACCOUNT
			new WindowMain_GUI(new TaiKhoan("testAccount", "12345678",
					new NhanVien(
							"AD000001", "Test",
							"Test", 90000,
							"012345678910", "asd",
							"")));
		} catch (SQLException | IOException e) {
			throw new RuntimeException(e);
		}
	}
}
