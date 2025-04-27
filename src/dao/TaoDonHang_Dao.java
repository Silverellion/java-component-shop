package dao;

import entity.SanPham;
import entity.NhaCungCap;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;

public class TaoDonHang_Dao {

    private Connection connection;

    public TaoDonHang_Dao() {
        this.connection = ConnectDB.getConn();
    }

    public List<SanPham> getSanPhamList() {
        List<SanPham> sanPhamList = new ArrayList<>();
        String sql = "SELECT * FROM SanPham";

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String maSP = rs.getString("maSP");
                String tenSP = rs.getString("tenSP");
                String loaiSP = rs.getString("loaiSP");          
                double giaBan = rs.getDouble("giaBan");
                int soLuongTon = rs.getInt("soLuongTon");
                String maNCC = rs.getString("maNCC");

                NhaCungCap ncc = getNhaCungCap(maNCC);
                SanPham sanPham = new SanPham(maSP, tenSP, loaiSP, giaBan, soLuongTon, ncc);
                sanPhamList.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sanPhamList;
    }

    private NhaCungCap getNhaCungCap(String maNCC) {
        NhaCungCap ncc = null;
        String sql = "SELECT * FROM NhaCungCap WHERE maNCC = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, maNCC);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String tenNCC = rs.getString("tenNCC");
                    String diaChi = rs.getString("diaChi");
                    String soDienThoai = rs.getString("soDienThoai");
                    String email = rs.getString("email");
                    ncc = new NhaCungCap(maNCC, tenNCC, diaChi, email, soDienThoai);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ncc;
    }
    
    public List<String> getTenSanPhamList() {
        List<String> tenSPList = new ArrayList<>();
        String sql = "SELECT tenSP FROM SanPham";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                tenSPList.add(rs.getString("tenSP"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tenSPList;
    }
    
    
    public List<String> getTenNhanVienList() {
    	List<String> tenNVList = new ArrayList<>();
        String sql = "SELECT hoTen from nhanVien";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
            	tenNVList.add(rs.getString("hoTen"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tenNVList;
    }


//    public SanPham timSanPhamByMa(String maSPCanTim) {
//        SanPham sanPham = null;
//        String sql = "SELECT * FROM SanPham WHERE maSP = ?";
//
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, maSPCanTim);
//            try (ResultSet rs = stmt.executeQuery()) {
//                if (rs.next()) {
//                    String maSP = rs.getString("maSP");
//                    String tenSP = rs.getString("tenSP");
//                    String loaiSP = rs.getString("loaiSP");
//                    double giaBan = rs.getDouble("giaBan");
//                    int soLuongTon = rs.getInt("soLuongTon");
//                    String maNCC = rs.getString("maNCC");
//
//                    NhaCungCap ncc = getNhaCungCap(maNCC);
//                    sanPham = new SanPham(maSP, tenSP, loaiSP, giaBan, soLuongTon, ncc);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return sanPham;
//    }
    //
    public SanPham getSanPhamByMa(String maSPCanTim) {
        SanPham sanPham = null;
        String sql = "{call sp_TimSanPhamByMa(?)}";

        try (CallableStatement stmt = connection.prepareCall(sql)) {
            stmt.setString(1, maSPCanTim);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String maSP = rs.getString("maSP");
                    String tenSP = rs.getString("tenSP");
                    String loaiSP = rs.getString("loaiSP");
                    double giaBan = rs.getDouble("giaBan");
                    int soLuongTon = rs.getInt("soLuongTon");
                    String maNCC = rs.getString("maNCC");

                    NhaCungCap ncc = getNhaCungCap(maNCC); // Hàm lấy nhà cung cấp
                    sanPham = new SanPham(maSP, tenSP, loaiSP, giaBan, soLuongTon, ncc);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sanPham;
    }

// tạo hóa đơn
    public boolean insertKhachHang(String maKH, String tenKH, String diaChi, String soDienThoai, String email) {
        String sql = "INSERT INTO KhachHang (maKH, tenKH, diaChi, soDienThoai, email) VALUES (?, ?, ?, ?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, maKH);
            stmt.setString(2, tenKH);
            stmt.setString(3, diaChi);
            stmt.setString(4, soDienThoai);
            stmt.setString(5, email);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertHoaDon(String maHD, Date ngayLapHD, double thanhTien, String maKH, String maNhanVien) {
        String sql = "INSERT INTO HoaDon (maHD, ngayLapHD, thanhTien, maKH, maNhanVien) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, maHD);
            stmt.setDate(2, ngayLapHD);
            stmt.setDouble(3, thanhTien);
            stmt.setString(4, maKH);
            stmt.setString(5, maNhanVien);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean insertChiTietHoaDon(String maHD, String maSP, int soLuong, double donGia) {
        String sql = "INSERT INTO ChiTietHoaDon (maHD, maSP, soLuong, donGia) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, maHD);
            stmt.setString(2, maSP);
            stmt.setInt(3, soLuong);
            stmt.setDouble(4, donGia);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getMaNhanVienByTen(String tenNhanVien) {
        String sql = "SELECT maNhanVien FROM NhanVien WHERE hoTen = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, tenNhanVien);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("maNhanVien");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Không tìm thấy
    }
    

}
