package gui;

import utils.SwingHelper;

import javax.swing.*;
import java.awt.*;

public class PnlTaiKhoan extends JPanel {
    private final JLabel lblTenDangNhap, lblMatKhau, lblMaNV, lblTenNV, lblChucVu, lblLuong, lblSoDienThoai, lblDiaChi;

    public PnlTaiKhoan() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(30, 30, 30));
        JLabel lblTitle = SwingHelper.createDarkModeJLabel("Panel tài khoản", 30);
        lblTitle.setAlignmentX(CENTER_ALIGNMENT);
        add(lblTitle);

        lblTenDangNhap = new JLabel("Tên đăng nhập: ");
        lblMatKhau = new JLabel("Mật khẩu: ");
        lblMaNV = new JLabel("");
        lblTenNV = new JLabel();
        lblChucVu = new JLabel();
        lblLuong = new JLabel();
        lblSoDienThoai = new JLabel();
        lblDiaChi = new JLabel();
    }
}
