package entity;

import java.util.ArrayList;


public class QuanLyKho {
	private ArrayList<SanPham> danhSachSanPham;
	
	public QuanLyKho() {
		// TODO Auto-generated constructor stub
		danhSachSanPham=new ArrayList<>();
	}
	
	public boolean themSanPham(SanPham sp) {
		for(SanPham x: danhSachSanPham) {
			if(x.getMaSP().equalsIgnoreCase(sp.getMaSP())) {
				return false;
			}
		}
		danhSachSanPham.add(sp);
		return true;
	}
	
	public boolean xoaSanPham(String maSP) {
		for(SanPham x: danhSachSanPham) {
			if(x.getMaSP().equalsIgnoreCase(maSP)) {
				danhSachSanPham.remove(x);
				return true;
			}
		}
		return false;
	}
	
	public boolean suaSanPham(SanPham spNew) {
		for(int i=0;i<danhSachSanPham.size();i++) {
			SanPham sp=danhSachSanPham.get(i);
			if(sp.getMaSP().equalsIgnoreCase(spNew.getMaSP())) {
				sp.setTenSP(spNew.getTenSP());
				sp.setLoaiSP(spNew.getLoaiSP());
				sp.setGiaBan(spNew.getGiaBan());
				sp.setSoLuongTon(spNew.getSoLuongTon());
				sp.setNcc(spNew.getNcc());
				return true;
			}
		}
		return false;
	}
	
	public SanPham timSanPham(String maSP) {
		SanPham sp=new SanPham(maSP);
		if(danhSachSanPham.contains(sp)) {
			return danhSachSanPham.get(danhSachSanPham.indexOf(sp));
		}
		return null;
	}
	
	public SanPham getSanPham(int i) {
		if(i>=0 && i<danhSachSanPham.size()) {
			return danhSachSanPham.get(i);
		}
		return null;
	}
	
	public ArrayList<SanPham> getListSP(){
		return danhSachSanPham;
	}
	
	public int tong() {
		return danhSachSanPham.size();
	}
	
}
