package dao;

import java.sql.*;
import java.util.ArrayList;
import entity.NhaCungCap;
import entity.SanPham;
import database.ConnectDB;

public class NhapHang_Dao {

    public ArrayList<NhaCungCap> getAllNhaCungCap() {
        ArrayList<NhaCungCap> list = new ArrayList<>();
        Connection conn = ConnectDB.getConn();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM NhaCungCap");

            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap(
                    rs.getString("maNCC"),
                    rs.getString("tenNCC"),
                    rs.getString("soDienThoai"),
                    rs.getString("email"),
                    rs.getString("diaChi")
                );
                list.add(ncc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
        }

        return list;
    }

    public boolean themSanPham(SanPham sp) {
        Connection conn = ConnectDB.getConn();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO SanPham VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, sp.getMaSP());
            stmt.setString(2, sp.getTenSP());
            stmt.setString(3, sp.getLoaiSP());
            stmt.setDouble(4, sp.getGiaBan());
            stmt.setInt(5, sp.getSoLuongTon());
            stmt.setString(6, sp.getNcc().getMaNCC());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
        }
        return false;
    }

    public boolean xoaSanPham(String maSP) {
        Connection conn = ConnectDB.getConn();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("DELETE FROM SanPham WHERE maSP = ?");
            stmt.setString(1, maSP);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
        }
        return false;
    }

    public boolean suaSanPham(SanPham sp) {
        Connection conn = ConnectDB.getConn();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("UPDATE SanPham SET tenSP=?, loaiSP=?, giaBan=?, soLuongTon=?, maNCC=? WHERE maSP=?");
            stmt.setString(1, sp.getTenSP());
            stmt.setString(2, sp.getLoaiSP());
            stmt.setDouble(3, sp.getGiaBan());
            stmt.setInt(4, sp.getSoLuongTon());
            stmt.setString(5, sp.getNcc().getMaNCC());
            stmt.setString(6, sp.getMaSP());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
        }
        return false;
    }

    public SanPham timSanPhamTheoMa(String maSP) {
        Connection conn = ConnectDB.getConn();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("SELECT * FROM SanPham WHERE maSP = ?");
            stmt.setString(1, maSP);
            rs = stmt.executeQuery();

            if (rs.next()) {
                NhaCungCap ncc = getNhaCungCapTheoMa(rs.getString("maNCC"));
                return new SanPham(
                    rs.getString("maSP"),
                    rs.getString("tenSP"),
                    rs.getString("loaiSP"),
                    rs.getDouble("giaBan"),
                    rs.getInt("soLuongTon"),
                    ncc
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
        }
        return null;
    }

    private NhaCungCap getNhaCungCapTheoMa(String maNCC) {
        Connection conn = ConnectDB.getConn();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("SELECT * FROM NhaCungCap WHERE maNCC = ?");
            stmt.setString(1, maNCC);
            rs = stmt.executeQuery();

            if (rs.next()) {
                return new NhaCungCap(
                    rs.getString("maNCC"),
                    rs.getString("tenNCC"),
                    rs.getString("soDienThoai"),
                    rs.getString("email"),
                    rs.getString("diaChi")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
        }
        return null;
    }

    public ArrayList<SanPham> getAllSanPham() {
        ArrayList<SanPham> list = new ArrayList<>();
        Connection conn = ConnectDB.getConn();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM SanPham");

            while (rs.next()) {
                NhaCungCap ncc = getNhaCungCapTheoMa(rs.getString("maNCC"));
                SanPham sp = new SanPham(
                    rs.getString("maSP"),
                    rs.getString("tenSP"),
                    rs.getString("loaiSP"),
                    rs.getDouble("giaBan"),
                    rs.getInt("soLuongTon"),
                    ncc
                );
                list.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
        }

        return list;
    }
}
