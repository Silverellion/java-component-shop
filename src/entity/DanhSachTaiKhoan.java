package entity;

import dao.DanhSachTaiKhoan_DAO;

import java.io.Serializable;
import java.util.ArrayList;

public class DanhSachTaiKhoan implements Serializable {
    private final ArrayList<TaiKhoan> danhSachTaiKhoan;
    private final DanhSachTaiKhoan_DAO dao;

    public DanhSachTaiKhoan() {
        dao = new DanhSachTaiKhoan_DAO();
        danhSachTaiKhoan = dao.load();
    }

    public TaiKhoan tim(String maNV) {
        for(TaiKhoan tk : danhSachTaiKhoan) {
            if(tk.getMaNhanVien().equals(maNV))
                return tk;
        }
        return null;
    }

    public boolean them(TaiKhoan taiKhoan) {
        for (TaiKhoan curTaiKhoan : danhSachTaiKhoan) {
            if (curTaiKhoan.getMaNhanVien().equals(taiKhoan.getMaNhanVien()) ||
                    curTaiKhoan.getTenDangNhap().equals(taiKhoan.getTenDangNhap())) {
                return false;
            }
        }
        return dao.add(taiKhoan);
    }

    public boolean xoa(int index) {
        if(!dao.delete(danhSachTaiKhoan.get(index))) {
            return false;
        }
        danhSachTaiKhoan.remove(index);
        return true;
    }

    public boolean capNhat(int index, TaiKhoan taiKhoan) {
        if(!dao.update(taiKhoan)){
            return false;
        }
        danhSachTaiKhoan.set(index, taiKhoan);
        return true;
    }

    public boolean login(String username, String password) {
        return dao.login(username, password);
    }

    public ArrayList<TaiKhoan> getDanhSach() {
        return danhSachTaiKhoan;
    }
}
