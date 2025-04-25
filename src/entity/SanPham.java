package entity;

import java.util.Objects;

public class SanPham {
	private String maSP;
	private String tenSP;
	private String loaiSP;
	private double giaBan;
	private int soLuongTon;
	private NhaCungCap ncc;
	
	public SanPham(String maSP, String tenSP, String loaiSP, double giaBan, int soLuongTon, NhaCungCap ncc) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.loaiSP = loaiSP;
		this.giaBan = giaBan;
		this.soLuongTon = soLuongTon;
		this.ncc = ncc;
	}
	
	public SanPham(String maSP) {
		// TODO Auto-generated constructor stub
		this(maSP,"","",0.0,0,null);
	}
	
	public NhaCungCap getNcc() {
		return ncc;
	}


	public void setNcc(NhaCungCap ncc) {
		this.ncc = ncc;
	}

	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public String getLoaiSP() {
		return loaiSP;
	}
	public void setLoaiSP(String loaiSP) {
		this.loaiSP = loaiSP;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	@Override
	public int hashCode() {
		return Objects.hash(giaBan, loaiSP, maSP, ncc, soLuongTon, tenSP);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Double.doubleToLongBits(giaBan) == Double.doubleToLongBits(other.giaBan)
				&& Objects.equals(loaiSP, other.loaiSP) && Objects.equals(maSP, other.maSP)
				&& Objects.equals(ncc, other.ncc) && soLuongTon == other.soLuongTon
				&& Objects.equals(tenSP, other.tenSP);
	}
	
	
}
