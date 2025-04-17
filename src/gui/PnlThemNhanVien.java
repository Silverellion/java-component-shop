package gui;

import utils.SwingHelper;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.Serial;

public class PnlThemNhanVien extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;
    private final JTextField txtMaNV, txtTenNV, txtLuong, txtSoDienThoai, txtDiaChi, txtTenDangNhap;
    private final JPasswordField txtMatKhau;
    private final JComboBox<String> comboChucVu;

    PnlThemNhanVien() {
        setLayout(new BorderLayout());

        JLabel lblTitle = SwingHelper.createProjectJLabel("Thêm Nhân viên", 30);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblTitle, BorderLayout.NORTH);

        JPanel pnlMain = new JPanel(new GridLayout(1, 2, 20, 0));
        pnlMain.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        JPanel pnlForm = new JPanel();
        pnlForm.setLayout(new BoxLayout(pnlForm, BoxLayout.Y_AXIS));
        pnlForm.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Form nhân viên", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 16)));

        JLabel lblMaNV = SwingHelper.createProjectJLabel("Mã nhân viên: ");
        JLabel lblTenNV = SwingHelper.createProjectJLabel("Tên nhân viên: ");
        JLabel lblChucVu = SwingHelper.createProjectJLabel("Chức vụ: ");
        JLabel lblLuong = SwingHelper.createProjectJLabel("Lương: ");
        JLabel lblSoDienThoai = SwingHelper.createProjectJLabel("Số điện thoại: ");
        JLabel lblDiaChi = SwingHelper.createProjectJLabel("Địa chỉ: ");
        JLabel lblTenDangNhap = SwingHelper.createProjectJLabel("Tên đăng nhập: ");
        JLabel lblMatKhau = SwingHelper.createProjectJLabel("Mật khẩu: ");

        txtMaNV = new JTextField();
        txtTenNV = new JTextField();
        txtSoDienThoai = new JTextField();
        txtDiaChi = new JTextField();
        comboChucVu = new JComboBox<>();
        txtLuong = new JTextField();
        txtTenDangNhap = new JTextField();
        txtMatKhau = new JPasswordField();

        Dimension textFieldSize = new Dimension(180, 25);
        txtMaNV.setPreferredSize(textFieldSize);
        txtTenNV.setPreferredSize(textFieldSize);
        txtSoDienThoai.setPreferredSize(textFieldSize);
        txtDiaChi.setPreferredSize(textFieldSize);
        comboChucVu.setPreferredSize(textFieldSize);
        txtLuong.setPreferredSize(textFieldSize);
        txtTenDangNhap.setPreferredSize(textFieldSize);
        txtMatKhau.setPreferredSize(textFieldSize);

        comboChucVu.addItem("Nhân viên bán hàng");
        comboChucVu.addItem("Nhân viên quản lý kho");
        comboChucVu.addItem("Nhân viên kỹ thuật");
        comboChucVu.addItem("Nhân viên giao hàng");
        comboChucVu.addItem("Quản lý cửa hàng");

        JPanel pnlFields = new JPanel(new GridLayout(10, 10, 10, 10));
        pnlFields.add(SwingHelper.createProjectJLabel("Thông tin nhân viên"));
        pnlFields.add(lblMaNV);
        pnlFields.add(txtMaNV);
        pnlFields.add(lblTenNV);
        pnlFields.add(txtTenNV);

        pnlFields.add(lblSoDienThoai);
        pnlFields.add(txtSoDienThoai);
        pnlFields.add(lblDiaChi);
        pnlFields.add(txtDiaChi);

        pnlFields.add(lblChucVu);
        pnlFields.add(comboChucVu);
        pnlFields.add(lblLuong);
        pnlFields.add(txtLuong);

        pnlFields.add(SwingHelper.createProjectJLabel("Tài khoản nhân viên"));
        pnlFields.add(lblTenDangNhap);
        pnlFields.add(txtTenDangNhap);
        pnlFields.add(lblMatKhau);
        pnlFields.add(txtMatKhau);

        pnlForm.add(pnlFields);
        pnlForm.add(Box.createVerticalGlue());

        JPanel pnlRight = new JPanel(new BorderLayout());
        JLabel lblImage = new JLabel();
        lblImage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblImage.setPreferredSize(new Dimension(375, 500));

        JPanel pnlImageHolder = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlImageHolder.add(lblImage);
        pnlRight.add(pnlImageHolder, BorderLayout.CENTER);
        pnlMain.add(pnlForm);
        pnlMain.add(pnlRight);

        JPanel pnlButtons = new JPanel(new GridLayout(1, 2));
        JPanel pnlLeftButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnLamMoi = new JButton("Làm mới");
        JButton btnThem = new JButton("Thêm");

        btnLamMoi.setPreferredSize(new Dimension(150, 40));
        btnThem.setPreferredSize(new Dimension(150, 40));

        pnlLeftButtons.add(btnLamMoi);
        pnlLeftButtons.add(btnThem);

        JPanel pnlRightButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnChonAnh = new JButton("Chọn ảnh");
        btnChonAnh.setPreferredSize(new Dimension(150, 40));
        pnlRightButton.add(btnChonAnh);

        pnlButtons.add(pnlLeftButtons);
        pnlButtons.add(pnlRightButton);

        add(pnlMain, BorderLayout.CENTER);
        add(pnlButtons, BorderLayout.SOUTH);
    }
}