package models;

import java.io.Serializable;
import java.util.Objects;

public class NhanVien implements Serializable {
    private String maNhanVien;
    private String hoTen;
    private String chucVu;
    private int luong;
    private String soDienThoai;
    private String diaChi;
    private String trangThai;

    public NhanVien(String maNhanVien, String hoTen, String chucVu, int luong, String soDienThoai,
                    String diaChi) {
        setMaNhanVien(maNhanVien);
        setHoTen(hoTen);
        setChucVu(chucVu);
        setLuong(luong);
        setSoDienThoai(soDienThoai);
        setDiaChi(diaChi);
        setTrangThai("HoatDong");
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NhanVien nhanVien = (NhanVien) o;
        return luong == nhanVien.luong && Objects.equals(maNhanVien, nhanVien.maNhanVien) && Objects.equals(hoTen, nhanVien.hoTen) && Objects.equals(chucVu, nhanVien.chucVu) && Objects.equals(soDienThoai, nhanVien.soDienThoai) && Objects.equals(diaChi, nhanVien.diaChi) && Objects.equals(trangThai, nhanVien.trangThai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maNhanVien, hoTen, chucVu, luong, soDienThoai, diaChi, trangThai);
    }
}
