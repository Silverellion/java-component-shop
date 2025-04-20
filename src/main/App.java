package main;

import database.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;
import gui.WindowLogin_GUI;
import gui.WindowMain_GUI;

import java.io.IOException;
import java.sql.SQLException;

public class App {
	private static final String url = "jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;integratedSecurity=true";
	private static final String user = "sa";
	private static final String password = "sapassword";
	public static void main(String[] args) {
		try {
			ConnectDB.initialize(url, user, password);
//			new WindowLogin_GUI();
			new WindowMain_GUI(new TaiKhoan("admin", "12345678",
					new NhanVien(
							"AD000001", "Admininstrator",
							"Admininstrator", 90000,
							"012345678910", "asd",
							"C:\\componentShopCache\\cat2.jpg")));
		} catch (SQLException | IOException e) {
			throw new RuntimeException(e);
		}
	}
}
