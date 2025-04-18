package entity;

import java.io.Serializable;
import java.util.Objects;

public class TaiKhoan implements Serializable {
    private String tenDangNhap;
    private String matKhau;
    private final NhanVien nhanVien;

    public TaiKhoan(String tenDangNhap, String matKhau, NhanVien nhanVien) {
        setTenDangNhap(tenDangNhap);
        setMatKhau(matKhau);
        this.nhanVien = nhanVien;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getMaNhanVien() {
        return nhanVien.getMaNhanVien();
    }

    public String getHoTen() {
        return nhanVien.getHoTen();
    }

    public String getChucVu() {
        return nhanVien.getChucVu();
    }

    public int getLuong() {
        return nhanVien.getLuong();
    }

    public String getSoDienThoai() {
        return nhanVien.getSoDienThoai();
    }

    public String getDiaChi() {
        return nhanVien.getDiaChi();
    }

    public String getPathHinhAnhNhanVien() {
        return nhanVien.getPathHinhAnhNhanVien();
    }

    public String getTrangThai() {
        return nhanVien.getTrangThai();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaiKhoan taiKhoan = (TaiKhoan) o;
        return Objects.equals(tenDangNhap, taiKhoan.tenDangNhap) && Objects.equals(matKhau, taiKhoan.matKhau) && Objects.equals(nhanVien, taiKhoan.nhanVien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenDangNhap, matKhau, nhanVien);
    }
}
