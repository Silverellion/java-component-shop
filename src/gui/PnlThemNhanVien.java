package gui;

import utils.SwingHelper;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
        pnlMain.setBorder(BorderFactory.createEmptyBorder(50, 20, 0, 20));

        JPanel pnlForm = new JPanel();
        pnlForm.setLayout(new BoxLayout(pnlForm, BoxLayout.Y_AXIS));
        pnlForm.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Form nhân viên", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 20))
        );

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

        JPanel pnlFields = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 5, 10, 5);
        gbc.weightx = 1.0;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel lblThongTin = SwingHelper.createProjectJLabel("Thông tin nhân viên", 20);
        lblThongTin.setHorizontalAlignment(SwingConstants.CENTER);
        pnlFields.add(lblThongTin, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        pnlFields.add(lblMaNV, gbc);
        gbc.gridx = 1;
        pnlFields.add(txtMaNV, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        pnlFields.add(lblTenNV, gbc);
        gbc.gridx = 1;
        pnlFields.add(txtTenNV, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        pnlFields.add(lblSoDienThoai, gbc);
        gbc.gridx = 1;
        pnlFields.add(txtSoDienThoai, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        pnlFields.add(lblDiaChi, gbc);
        gbc.gridx = 1;
        pnlFields.add(txtDiaChi, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        pnlFields.add(lblChucVu, gbc);
        gbc.gridx = 1;
        pnlFields.add(comboChucVu, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        pnlFields.add(lblLuong, gbc);
        gbc.gridx = 1;
        pnlFields.add(txtLuong, gbc);

        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        JLabel lblTaiKhoan = SwingHelper.createProjectJLabel("Tài khoản nhân viên", 20);
        lblTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
        pnlFields.add(lblTaiKhoan, gbc);

        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        pnlFields.add(lblTenDangNhap, gbc);
        gbc.gridx = 1;
        pnlFields.add(txtTenDangNhap, gbc);

        gbc.gridy = 9;
        gbc.gridx = 0;
        pnlFields.add(lblMatKhau, gbc);
        gbc.gridx = 1;
        pnlFields.add(txtMatKhau, gbc);

        pnlForm.add(pnlFields);
        pnlForm.add(Box.createVerticalGlue());

        JPanel pnlRight = new JPanel(new BorderLayout());
        JLabel lblImage = new JLabel();
        lblImage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblImage.setPreferredSize(new Dimension(350, 480));

        JPanel pnlImageHolder = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlImageHolder.add(lblImage);
        pnlRight.add(pnlImageHolder, BorderLayout.CENTER);
            pnlMain.add(pnlForm);
        pnlMain.add(pnlRight);

        JPanel pnlButtons = new JPanel(new GridLayout(1, 2));
        pnlButtons.setBorder(new EmptyBorder(0, 0,50, 0));
        JPanel pnlLeftButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnLamMoi = SwingHelper.createProjectJButton("Làm mới", "icons8-reload-50.png");
        JButton btnThem = SwingHelper.createProjectJButton("Thêm", "icons8-add-50.png");

        btnLamMoi.setPreferredSize(new Dimension(150, 40));
        btnThem.setPreferredSize(new Dimension(150, 40));

        pnlLeftButtons.add(btnLamMoi);
        pnlLeftButtons.add(btnThem);

        JPanel pnlRightButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnChonAnh = SwingHelper.createProjectJButton("Chọn ảnh", "icons8-folder-50.png");
        btnChonAnh.setPreferredSize(new Dimension(150, 40));
        pnlRightButton.add(btnChonAnh);

        pnlButtons.add(pnlLeftButtons);
        pnlButtons.add(pnlRightButton);

        add(pnlMain, BorderLayout.CENTER);
        add(pnlButtons, BorderLayout.SOUTH);
    }
}