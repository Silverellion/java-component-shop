package entity;

import java.util.Objects;

public class ChiTietHoaDon {
	private SanPham sanpham;
	private int soLuong;
	private  double thanhTien;
	
	public ChiTietHoaDon(SanPham sanpham, int soLuong, double thanhTien) {
		super();
		this.sanpham = sanpham;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}
	public SanPham getSanpham() {
		return sanpham;
	}
	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	@Override
	public int hashCode() {
		return Objects.hash(sanpham, soLuong, thanhTien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDon other = (ChiTietHoaDon) obj;
		return Objects.equals(sanpham, other.sanpham) && soLuong == other.soLuong
				&& Double.doubleToLongBits(thanhTien) == Double.doubleToLongBits(other.thanhTien);
	}
	
}
