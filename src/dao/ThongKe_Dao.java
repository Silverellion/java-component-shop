package dao;

import database.ConnectDB;
import entity.ThongKeSanPham;
import entity.ThongKeNhanVien;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ThongKe_Dao {
    private Connection conn;

    public ThongKe_Dao() {
        conn = ConnectDB.getConn();
    }

    public List<ThongKeSanPham> getProductRevenue(String timeFilter) throws SQLException {
        List<ThongKeSanPham> list = new ArrayList<>();

        String timeCondition = getTimeCondition(timeFilter);

        String sql =
                "SELECT sp.maSP, sp.tenSP, SUM(ct.soLuong) as SoLuongBan, SUM(ct.donGia) as DoanhThu " +
                        "FROM SanPham sp " +
                        "JOIN ChiTietHoaDon ct ON sp.maSP = ct.maSP " +
                        "JOIN HoaDon hd ON ct.maHD = hd.maHD " +
                        (timeCondition.isEmpty() ? "" : "WHERE " + timeCondition) +
                        " GROUP BY sp.maSP, sp.tenSP " +
                        "ORDER BY DoanhThu DESC";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            int count = 0;
            while (rs.next() && count < 10) { // Limiting to top 10
                String maSP = rs.getString("maSP");
                String tenSP = rs.getString("tenSP");
                int soLuongBan = rs.getInt("SoLuongBan");
                double doanhThu = rs.getDouble("DoanhThu");

                list.add(new ThongKeSanPham(maSP, tenSP, soLuongBan, doanhThu));
                count++;
            }
        }

        return list;
    }

    public List<ThongKeNhanVien> getEmployeeRevenue(String timeFilter) throws SQLException {
        List<ThongKeNhanVien> list = new ArrayList<>();

        String timeCondition = getTimeCondition(timeFilter);

        String sql =
                "SELECT nv.maNhanVien, nv.hoTen, COUNT(DISTINCT hd.maHD) as SoHoaDon, SUM(hd.thanhTien) as DoanhThu " +
                        "FROM NhanVien nv " +
                        "JOIN HoaDon hd ON nv.maNhanVien = hd.maNhanVien " +
                        (timeCondition.isEmpty() ? "" : "WHERE " + timeCondition) +
                        " GROUP BY nv.maNhanVien, nv.hoTen " +
                        "ORDER BY DoanhThu DESC";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maNV = rs.getString("maNhanVien");
                String tenNV = rs.getString("hoTen");
                int soHoaDon = rs.getInt("SoHoaDon");
                double doanhThu = rs.getDouble("DoanhThu");

                list.add(new ThongKeNhanVien(maNV, tenNV, soHoaDon, doanhThu));
            }
        }

        return list;
    }

    public double getTotalRevenue(String timeFilter) throws SQLException {
        double totalRevenue = 0;

        String timeCondition = getTimeCondition(timeFilter);

        String sql =
                "SELECT SUM(thanhTien) as TongDoanhThu FROM HoaDon " +
                        (timeCondition.isEmpty() ? "" : "WHERE " + timeCondition);

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                totalRevenue = rs.getDouble("TongDoanhThu");
            }
        }

        return totalRevenue;
    }

    private String getTimeCondition(String timeFilter) {
        switch (timeFilter) {
            case "today":
                return "CONVERT(DATE, hd.ngayLapHD) = CONVERT(DATE, GETDATE())";
            case "week":
                return "DATEDIFF(WEEK, hd.ngayLapHD, GETDATE()) = 0";
            case "month":
                return "MONTH(hd.ngayLapHD) = MONTH(GETDATE()) AND YEAR(hd.ngayLapHD) = YEAR(GETDATE())";
            case "year":
                return "YEAR(hd.ngayLapHD) = YEAR(GETDATE())";
            default: // "all" or any other value
                return "";
        }
    }
}