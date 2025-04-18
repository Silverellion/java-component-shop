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

    public boolean them(TaiKhoan taiKhoan) {
        for (TaiKhoan curTaiKhoan : danhSachTaiKhoan) {
            if (curTaiKhoan.getMaNhanVien().equals(taiKhoan.getMaNhanVien()) ||
                    curTaiKhoan.getTenDangNhap().equals(taiKhoan.getTenDangNhap()))
                return false;
        }

        boolean inserted = dao.them(taiKhoan);
        if (inserted) danhSachTaiKhoan.add(taiKhoan);
        return inserted;
    }

    public boolean xoa(int index) {
        //add DAO deletion logic later
        danhSachTaiKhoan.remove(index);
        return true;
    }

    public boolean capNhat(int index, TaiKhoan taiKhoan) {
        //add DAO update logic later
        danhSachTaiKhoan.set(index, taiKhoan);
        return true;
    }

    public ArrayList<TaiKhoan> getDanhSach() {
        return danhSachTaiKhoan;
    }
}
