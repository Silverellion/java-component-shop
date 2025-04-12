package database;

import java.sql.*;

public class JDBC {
    public static void connect(String url, String user, String password) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement statement = conn.createStatement();
            statement.executeUpdate("IF DB_ID('dbTienLoi') IS NULL CREATE DATABASE dbTienLoi");
            createTableNhanVien(conn);
            createTableTaiKhoan(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static void createTableNhanVien(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'nhanVien'");
        if (!rs.next()) {
            stmt.executeUpdate("CREATE TABLE nhanVien " +
                    "(" +
                        "maNhanVien NVARCHAR(50) PRIMARY KEY," +
                        "hoTen NVARCHAR(100)," +
                        "chucVu NVARCHAR(100)," +
                        "soDienThoai NVARCHAR(15)," +
                        "diaChi NVARCHAR(200)" +
                    ")");
        }
        rs.close();
        stmt.close();
    }
    private static void createTableTaiKhoan(Connection conn) throws SQLException  {
        Statement stmt = null;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'taiKhoan'");
        if (!rs.next()) {
            stmt.executeUpdate("CREATE TABLE taiKhoan " +
                    "(" +
                        "tenDangNhap NVARCHAR(50) PRIMARY KEY," +
                        "matKhau NVARCHAR(100)," +
                        "maNhanVien NVARCHAR(50) FOREIGN KEY REFERENCES nhanVien(maNhanVien)" +
                    ")");
        }
        rs.close();
        stmt.close();
    }
}
