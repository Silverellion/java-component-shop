package gui;

import utils.SwingHelper;

import javax.swing.*;
import java.awt.*;

public class PnlTaiKhoan extends JPanel {
    private final JLabel lblTenDangNhap, lblMatKhau, lblMaNV, lblTenNV, lblChucVu, lblLuong, lblSoDienThoai, lblDiaChi;
    private final JTextField txtTenDangNhap, txtMatKhau, txtMaNV, txtTenNV, txtLuong, txtSoDienThoai, txtDiaChi;
    private final JComboBox<String> comboChucVu;

    public PnlTaiKhoan() {
        setLayout(new BorderLayout());
        setBackground(new Color(30, 30, 30));

        JLabel lblTitle = SwingHelper.createDarkModeJLabel("Panel tài khoản", 30);
        Box boxTitle = new Box(BoxLayout.X_AXIS);
        boxTitle.add(lblTitle);

        lblTenDangNhap = SwingHelper.createDarkModeJLabel("Tên đăng nhập: ");
        lblMatKhau =  SwingHelper.createDarkModeJLabel("Mật khẩu: ");
        lblMaNV =  SwingHelper.createDarkModeJLabel("Mã nhân viên: ");
        lblTenNV =  SwingHelper.createDarkModeJLabel("Tên nhân viên: ");

        lblChucVu =  SwingHelper.createDarkModeJLabel("Chức vụ: ");
        lblLuong =  SwingHelper.createDarkModeJLabel("Lương: ");
        lblSoDienThoai =  SwingHelper.createDarkModeJLabel("Số điện thoại: ");
        lblDiaChi =  SwingHelper.createDarkModeJLabel("Địa chỉ");

        lblTenDangNhap.setPreferredSize(lblSoDienThoai.getPreferredSize());
        lblMatKhau.setPreferredSize(lblSoDienThoai.getPreferredSize());
        lblMaNV.setPreferredSize(lblSoDienThoai.getPreferredSize());
        lblTenNV.setPreferredSize(lblSoDienThoai.getPreferredSize());

        lblChucVu.setPreferredSize(lblSoDienThoai.getPreferredSize());
        lblLuong.setPreferredSize(lblSoDienThoai.getPreferredSize());
        lblSoDienThoai.setPreferredSize(lblSoDienThoai.getPreferredSize());
        lblDiaChi.setPreferredSize(lblSoDienThoai.getPreferredSize());

        txtTenDangNhap = new JTextField();
        txtMatKhau = new JTextField();
        txtMaNV = new JTextField();
        txtTenNV = new JTextField();

        comboChucVu = new JComboBox<String>();
        txtLuong = new JTextField();
        txtSoDienThoai = new JTextField();
        txtDiaChi = new JTextField();

        comboChucVu.addItem("Nhân viên bán hàng");
        comboChucVu.addItem("Nhân viên quản lý kho");
        comboChucVu.addItem("Nhân viên kỹ thuật");
        comboChucVu.addItem("Nhân viên marketing");
        comboChucVu.addItem("Nhân viên chăm sóc khách hàng");
        comboChucVu.addItem("Nhân viên giao hàng");
        comboChucVu.addItem("Quản lý cửa hàng");

        Box box1 = new Box(BoxLayout.X_AXIS);
        Box box2 = new Box(BoxLayout.X_AXIS);
        Box box3 = new Box(BoxLayout.X_AXIS);
        Box box4 = new Box(BoxLayout.X_AXIS);

        box1.add(lblTenDangNhap);
        box1.add(txtTenDangNhap);
        box1.add(lblMatKhau);
        box1.add(txtMatKhau);

        box2.add(lblMaNV);
        box2.add(txtMaNV);
        box2.add(lblTenNV);
        box2.add(txtTenNV);

        box3.add(lblChucVu);
        box3.add(comboChucVu);
        box3.add(lblLuong);
        box3.add(txtLuong);

        box4.add(lblSoDienThoai);
        box4.add(txtSoDienThoai);
        box4.add(lblDiaChi);
        box4.add(txtDiaChi);

        Box boxNorth = new Box(BoxLayout.Y_AXIS);
        boxNorth.add(boxTitle);
        boxNorth.add(Box.createVerticalStrut(10));
        boxNorth.add(box1);
        boxNorth.add(Box.createVerticalStrut(5));
        boxNorth.add(box2);
        boxNorth.add(Box.createVerticalStrut(5));
        boxNorth.add(box3);
        boxNorth.add(Box.createVerticalStrut(5));
        boxNorth.add(box4);
        boxNorth.add(Box.createVerticalStrut(5));

        add(boxNorth, BorderLayout.NORTH);
    }
}
