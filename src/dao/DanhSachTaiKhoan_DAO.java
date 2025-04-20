package dao;

import database.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;

public class DanhSachTaiKhoan_DAO {
    private final Connection conn;
    private final String SQL_PATH = "src/sql/taiKhoan/";

    public DanhSachTaiKhoan_DAO() {
        conn = ConnectDB.getConnection();
    }

    public ArrayList<TaiKhoan> load() {
        ArrayList<TaiKhoan> danhSach = new ArrayList<>();
        try {
            String sql = Files.readString(Paths.get(SQL_PATH + "selectTaiKhoan.sql"));
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TaiKhoan taiKhoan = new TaiKhoan(
                        rs.getString("tenDangNhap"),
                        rs.getString("matKhau"),
                        new NhanVien(
                                rs.getString("maNhanVien"),
                                rs.getString("hoTen"),
                                rs.getString("chucVu"),
                                rs.getInt("luong"),
                                rs.getString("soDienThoai"),
                                rs.getString("diaChi"),
                                rs.getString("pathHinhAnh"),
                                rs.getString("trangThai")
                        )
                );
                danhSach.add(taiKhoan);
            }
        } catch (IOException | SQLException e) {}
        return danhSach;
    }

    public boolean add(TaiKhoan taiKhoan) {
        try {
            String sql = Files.readString(Paths.get(SQL_PATH + "insertTaiKhoan.sql"));
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, taiKhoan.getMaNhanVien());
            stmt.setString(2, taiKhoan.getHoTen());

            stmt.setString(3, taiKhoan.getMaNhanVien());
            stmt.setString(4, taiKhoan.getHoTen());
            stmt.setString(5, taiKhoan.getChucVu());
            stmt.setInt(6, taiKhoan.getLuong());
            stmt.setString(7, taiKhoan.getSoDienThoai());
            stmt.setString(8, taiKhoan.getDiaChi());
            stmt.setString(9, "HoatDong");
            stmt.setString(10, taiKhoan.getPathHinhAnh());

            stmt.setString(11, taiKhoan.getTenDangNhap());
            stmt.setString(12, taiKhoan.getMatKhau());
            stmt.setString(13, taiKhoan.getMaNhanVien());
            stmt.executeUpdate();
            return true;
        } catch (IOException | SQLException e) {
            return false;
        }
    }

    public boolean delete(TaiKhoan taiKhoan) {
        try {
            String sql = Files.readString(Paths.get(SQL_PATH + "deleteTaiKhoan.sql"));
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, taiKhoan.getMaNhanVien());
            stmt.setString(2, taiKhoan.getMaNhanVien());
            stmt.executeUpdate();
            return true;
        } catch (IOException | SQLException e) {
            return false;
        }
    }

    public boolean update(TaiKhoan taiKhoan) {
        try {
            String sql = Files.readString(Paths.get(SQL_PATH + "updateTaiKhoan.sql"));
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, taiKhoan.getMaNhanVien());
            stmt.setString(2, taiKhoan.getHoTen());
            stmt.setString(3, taiKhoan.getChucVu());
            stmt.setInt(4, taiKhoan.getLuong());
            stmt.setString(5, taiKhoan.getSoDienThoai());
            stmt.setString(6, taiKhoan.getDiaChi());
            stmt.setString(7, taiKhoan.getTrangThai());
            stmt.setString(8, taiKhoan.getPathHinhAnh());

            stmt.setString(9, taiKhoan.getMaNhanVien());

            stmt.setString(10, taiKhoan.getTenDangNhap());
            stmt.setString(11, taiKhoan.getMatKhau());
            stmt.setString(12, taiKhoan.getMaNhanVien());

            stmt.setString(13, taiKhoan.getMaNhanVien());
            stmt.executeUpdate();
            return true;
        } catch (IOException | SQLException e) {
            return false;
        }
    }

    // Update the login method to return a TaiKhoan object instead of boolean
    public TaiKhoan login(String username, String password) {
        try {
            String sql = Files.readString(Paths.get(SQL_PATH + "selectTaiKhoanLogin.sql"));
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new TaiKhoan(
                        rs.getString("tenDangNhap"),
                        rs.getString("matKhau"),
                        new NhanVien(
                                rs.getString("maNhanVien"),
                                rs.getString("hoTen"),
                                rs.getString("chucVu"),
                                rs.getInt("luong"),
                                rs.getString("soDienThoai"),
                                rs.getString("diaChi"),
                                rs.getString("pathHinhAnh"),
                                rs.getString("trangThai")
                        )
                );
            }
            return null;
        } catch (IOException | SQLException e) {
            return null;
        }
    }
}
