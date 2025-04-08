package models;

import java.io.Serializable;
import java.util.ArrayList;

public class DanhSachTaiKhoan implements Serializable {
    private ArrayList<TaiKhoan> danhSachTaiKhoan;
    DanhSachTaiKhoan() {
        danhSachTaiKhoan = new ArrayList<>();
    }


}
