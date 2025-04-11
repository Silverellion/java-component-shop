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
            if(curTaiKhoan.getMaNhanVien().equals(taiKhoan.getMaNhanVien()))
                return false;
        }
        danhSachTaiKhoan.add(taiKhoan);
        return true;
    }
}
