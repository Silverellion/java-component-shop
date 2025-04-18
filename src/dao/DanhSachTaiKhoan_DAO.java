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
        } catch (IOException | SQLException _) {}
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
        } catch (IOException | SQLException _) {
            return false;
        }
    }
}
