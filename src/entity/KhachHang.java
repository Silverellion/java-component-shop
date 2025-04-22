package entity;

import java.util.Objects;

public class KhachHang {
	@Override
	public int hashCode() {
		return Objects.hash(diaChi, diemTichLuy, email, maKH, soDienThoai, tenKH);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(diaChi, other.diaChi) && diemTichLuy == other.diemTichLuy
				&& Objects.equals(email, other.email) && Objects.equals(maKH, other.maKH)
				&& Objects.equals(soDienThoai, other.soDienThoai) && Objects.equals(tenKH, other.tenKH);
	}
	private String maKH;
	private String tenKH;
	private String soDienThoai;
	private String email;
	private String diaChi;
	private int diemTichLuy;
	public KhachHang(String maKH, String tenKH, String soDienThoai, String email, String diaChi, int diemTichLuy) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.diaChi = diaChi;
		this.diemTichLuy = diemTichLuy;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public int getDiemTichLuy() {
		return diemTichLuy;
	}
	public void setDiemTichLuy(int diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
	}
	
	
}
