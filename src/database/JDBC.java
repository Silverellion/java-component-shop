package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
    public static void connect(String url, String user, String password) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("IF DB_ID('dbTienLoi') IS NULL CREATE DATABASE dbTienLoi");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void loadTaiKhoan() {

    }
    public static void loadNhanVien() {

    }
}
