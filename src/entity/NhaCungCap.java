package entity;

import java.util.Objects;

public class NhaCungCap {
	private String maNCC;
	private String tenNCC;
	private String soDienThoai;
	private String email;
	private String diaChi;
	
	public NhaCungCap(String maNCC, String tenNCC, String soDienThoai, String email, String diaChi) {
		super();
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.diaChi = diaChi;
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
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

	@Override
	public int hashCode() {
		return Objects.hash(diaChi, email, maNCC, soDienThoai, tenNCC);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhaCungCap other = (NhaCungCap) obj;
		return Objects.equals(diaChi, other.diaChi) && Objects.equals(email, other.email)
				&& Objects.equals(maNCC, other.maNCC) && Objects.equals(soDienThoai, other.soDienThoai)
				&& Objects.equals(tenNCC, other.tenNCC);
	}
	
	@Override
	public String toString() {
	    return this.getTenNCC(); // hoặc "maNCC - tenNCC"
	}

	
}
