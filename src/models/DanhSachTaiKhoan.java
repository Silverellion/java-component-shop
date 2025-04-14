package models;

import database.JDBC;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DanhSachTaiKhoan implements Serializable {
    private final ArrayList<TaiKhoan> danhSachTaiKhoan;
    private final Connection conn;
    private final String SQL_PATH = "src/database/sql/taiKhoan/";
    public DanhSachTaiKhoan() {
        danhSachTaiKhoan = new ArrayList<>();
        conn = JDBC.getConnection();
        load();
    }

    private void load() {
        try {
            String sql = Files.readString(Paths.get(SQL_PATH + "selectTaiKhoan.sql"));
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
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
                                rs.getString("trangThai")
                        )
                );
                danhSachTaiKhoan.add(taiKhoan);
            }
        } catch (IOException | SQLException _) {}
    }

    public boolean them(TaiKhoan taiKhoan) {
        for(TaiKhoan curTaiKhoan : danhSachTaiKhoan) {
            if(curTaiKhoan.getMaNhanVien().equals(taiKhoan.getMaNhanVien())
            ||curTaiKhoan.getTenDangNhap().equals(taiKhoan.getTenDangNhap()))
                return false;
        }
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

            stmt.setString(10, taiKhoan.getTenDangNhap());
            stmt.setString(11, taiKhoan.getMatKhau());
            stmt.setString(12, taiKhoan.getMaNhanVien());
            stmt.executeUpdate();
        } catch (IOException | SQLException e) {
            return false;
        }
        danhSachTaiKhoan.add(taiKhoan);
        return true;
    }
    public boolean xoa(int index) {
        //database shit later on
        danhSachTaiKhoan.remove(index);
        return true;
    }
    public boolean capNhat(int index, TaiKhoan taiKhoan) {
        //database shit later on
        danhSachTaiKhoan.set(index, taiKhoan);
        return true;
    }
    public ArrayList<TaiKhoan> getDanhSach() {
        return danhSachTaiKhoan;
    }
}
