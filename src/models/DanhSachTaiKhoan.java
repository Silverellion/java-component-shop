package models;

import java.io.Serializable;
import java.util.ArrayList;

public class DanhSachTaiKhoan implements Serializable {
    private final ArrayList<TaiKhoan> danhSachTaiKhoan;
    public DanhSachTaiKhoan() {
        danhSachTaiKhoan = new ArrayList<>();
    }
    public boolean them(TaiKhoan taiKhoan) {
        for(TaiKhoan curTaiKhoan : danhSachTaiKhoan) {
            if(curTaiKhoan.getMaNhanVien().equals(taiKhoan.getMaNhanVien())
            ||curTaiKhoan.getTenDangNhap().equals(taiKhoan.getTenDangNhap()))
                return false;
        }
        danhSachTaiKhoan.add(taiKhoan);
        return true;
    }
    public boolean xoa(int index) {
        //database shit later on
        danhSachTaiKhoan.remove(index);
        return true;
    }
    public boolean capNhat(int index, TaiKhoan taiKhoan) {
        //database shit later on
        danhSachTaiKhoan.set(index, taiKhoan);
        return true;
    }
    public ArrayList<TaiKhoan> getDanhSach() {
        return danhSachTaiKhoan;
    }
}
