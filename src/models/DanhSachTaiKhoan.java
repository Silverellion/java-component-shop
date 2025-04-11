package models;

import java.io.Serializable;
import java.util.ArrayList;

public class DanhSachTaiKhoan implements Serializable {
    private final ArrayList<TaiKhoan> danhSachTaiKhoan;
    public DanhSachTaiKhoan() {
        danhSachTaiKhoan = new ArrayList<>();
    }
    public boolean themTaiKhoan(TaiKhoan taiKhoan) {
        for(TaiKhoan curTaiKhoan : danhSachTaiKhoan) {
            if(curTaiKhoan.getMaNhanVien().equals(taiKhoan.getMaNhanVien())
            ||curTaiKhoan.getTenDangNhap().equals(taiKhoan.getTenDangNhap()))
                return false;
        }
        danhSachTaiKhoan.add(taiKhoan);
        return true;
    }
    public boolean xoaTaiKhoan(int index) {
        danhSachTaiKhoan.remove(index);
        //database shit later on
        return true;
    }
}
