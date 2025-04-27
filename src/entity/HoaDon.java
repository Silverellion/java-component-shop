package entity;

import java.util.Date;
import java.util.Objects;

public class HoaDon {
	private String hoaDon;
	private Date ngayLapHD;
	private double tongTien;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	private ChiTietHoaDon chitiethoadon;
	public HoaDon(String hoaDon, Date ngayLapHD, double tongTien, KhachHang khachHang, NhanVien nhanVien,
			ChiTietHoaDon chitiethoadon) {
		super();
		this.hoaDon = hoaDon;
		this.ngayLapHD = ngayLapHD;
		this.tongTien = tongTien;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.chitiethoadon = chitiethoadon;
	}
	public String getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(String hoaDon) {
		this.hoaDon = hoaDon;
	}
	public Date getNgayLapHD() {
		return ngayLapHD;
	}
	public void setNgayLapHD(Date ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public ChiTietHoaDon getChitiethoadon() {
		return chitiethoadon;
	}
	public void setChitiethoadon(ChiTietHoaDon chitiethoadon) {
		this.chitiethoadon = chitiethoadon;
	}

	@Override
	public int hashCode() {
		return Objects.hash(chitiethoadon, hoaDon, khachHang, ngayLapHD, nhanVien, tongTien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(chitiethoadon, other.chitiethoadon) && Objects.equals(hoaDon, other.hoaDon)
				&& Objects.equals(khachHang, other.khachHang) && Objects.equals(ngayLapHD, other.ngayLapHD)
				&& Objects.equals(nhanVien, other.nhanVien)
				&& Double.doubleToLongBits(tongTien) == Double.doubleToLongBits(other.tongTien);
	}
	
}
