package gui;

import utils.SwingHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PnlTaiKhoan extends JPanel implements ActionListener {
    private final JTextField txtTenDangNhap, txtMatKhau, txtMaNV, txtTenNV, txtLuong, txtSoDienThoai, txtDiaChi;
    private final JComboBox<String> comboChucVu;

    public PnlTaiKhoan() {
        setLayout(new BorderLayout());
        setBackground(new Color(30, 30, 30));

        JLabel lblTitle = SwingHelper.createDarkModeJLabel("Quản lý tài khoản", 30);
        Box boxTitle = new Box(BoxLayout.X_AXIS);
        boxTitle.add(lblTitle);

        JLabel lblTenDangNhap = SwingHelper.createDarkModeJLabel("Tên đăng nhập: ");
        JLabel lblMatKhau = SwingHelper.createDarkModeJLabel("Mật khẩu: ");
        JLabel lblMaNV = SwingHelper.createDarkModeJLabel("Mã nhân viên: ");
        JLabel lblTenNV = SwingHelper.createDarkModeJLabel("Tên nhân viên: ");

        JLabel lblChucVu = SwingHelper.createDarkModeJLabel("Chức vụ: ");
        JLabel lblLuong = SwingHelper.createDarkModeJLabel("Lương: ");
        JLabel lblSoDienThoai = SwingHelper.createDarkModeJLabel("Số điện thoại: ");
        JLabel lblDiaChi = SwingHelper.createDarkModeJLabel("Địa chỉ");

        lblTenDangNhap.setPreferredSize(lblTenDangNhap.getPreferredSize());
        lblMatKhau.setPreferredSize(lblTenDangNhap.getPreferredSize());
        lblMaNV.setPreferredSize(lblTenDangNhap.getPreferredSize());
        lblTenNV.setPreferredSize(lblTenDangNhap.getPreferredSize());

        lblChucVu.setPreferredSize(lblTenDangNhap.getPreferredSize());
        lblLuong.setPreferredSize(lblTenDangNhap.getPreferredSize());
        lblSoDienThoai.setPreferredSize(lblTenDangNhap.getPreferredSize());
        lblDiaChi.setPreferredSize(lblTenDangNhap.getPreferredSize());

        txtTenDangNhap = new JTextField();
        txtMatKhau = new JTextField();
        txtMaNV = new JTextField();
        txtTenNV = new JTextField();

        comboChucVu = new JComboBox<>();
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

        //Dynamic resizing function for comboChucVu
        comboChucVu.setPreferredSize(txtTenDangNhap.getPreferredSize());
        txtTenDangNhap.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                comboChucVu.setPreferredSize(txtTenDangNhap.getSize());
                comboChucVu.revalidate();
            }
        });

        Box box1 = new Box(BoxLayout.X_AXIS);
        Box box2 = new Box(BoxLayout.X_AXIS);
        Box box3 = new Box(BoxLayout.X_AXIS);
        Box box4 = new Box(BoxLayout.X_AXIS);

        box1.add(Box.createHorizontalStrut(50));
        box1.add(lblTenDangNhap);
        box1.add(txtTenDangNhap);
        box1.add(Box.createHorizontalStrut(10));
        box1.add(lblMatKhau);
        box1.add(txtMatKhau);
        box1.add(Box.createHorizontalStrut(50));

        box2.add(Box.createHorizontalStrut(50));
        box2.add(lblMaNV);
        box2.add(txtMaNV);
        box2.add(Box.createHorizontalStrut(10));
        box2.add(lblTenNV);
        box2.add(txtTenNV);
        box2.add(Box.createHorizontalStrut(50));

        box3.add(Box.createHorizontalStrut(50));
        box3.add(lblChucVu);
        box3.add(comboChucVu);
        box3.add(Box.createHorizontalStrut(10));
        box3.add(lblLuong);
        box3.add(txtLuong);
        box3.add(Box.createHorizontalStrut(50));

        box4.add(Box.createHorizontalStrut(50));
        box4.add(lblSoDienThoai);
        box4.add(txtSoDienThoai);
        box4.add(Box.createHorizontalStrut(10));
        box4.add(lblDiaChi);
        box4.add(txtDiaChi);
        box4.add(Box.createHorizontalStrut(50));

        Box boxNorth = new Box(BoxLayout.Y_AXIS);
        boxNorth.add(Box.createVerticalStrut(10));
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
