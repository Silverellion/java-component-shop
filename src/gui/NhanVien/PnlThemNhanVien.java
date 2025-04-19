package gui.NhanVien;

import entity.DanhSachTaiKhoan;
import entity.NhanVien;
import entity.TaiKhoan;
import utils.ImageHelper;
import utils.SwingHelper;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import java.util.Objects;

public class PnlThemNhanVien extends JPanel implements ActionListener {
    @Serial
    private static final long serialVersionUID = 1L;
    private final JTextField txtMaNV, txtTenNV, txtLuong, txtSoDienThoai, txtDiaChi, txtTenDangNhap;
    private final JPasswordField txtMatKhau;
    private final JComboBox<String> comboChucVu;
    private final JLabel lblHinhAnh;
    private String pathHinhAnh = null;
    private final JButton btnLamMoi, btnThem, btnChonAnh;
    private final DanhSachTaiKhoan danhSachTaiKhoan;

    public PnlThemNhanVien() {
        danhSachTaiKhoan = new DanhSachTaiKhoan();
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
        lblHinhAnh = new JLabel();
        lblHinhAnh.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblHinhAnh.setPreferredSize(new Dimension(350, 480));

        JPanel pnlImageHolder = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlImageHolder.add(lblHinhAnh);
        pnlRight.add(pnlImageHolder, BorderLayout.CENTER);
        pnlMain.add(pnlForm);
        pnlMain.add(pnlRight);

        JPanel pnlButtons = new JPanel(new GridLayout(1, 2));
        pnlButtons.setBorder(new EmptyBorder(0, 0,50, 0));
        JPanel pnlLeftButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnThem = SwingHelper.createProjectJButton("Thêm", "icons8-add-50.png");
        btnLamMoi = SwingHelper.createProjectJButton("Làm mới", "icons8-reload-50.png");

        btnThem.setPreferredSize(new Dimension(150, 40));
        btnLamMoi.setPreferredSize(new Dimension(150, 40));

        pnlLeftButtons.add(btnThem);
        pnlLeftButtons.add(btnLamMoi);

        JPanel pnlRightButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnChonAnh = SwingHelper.createProjectJButton("Chọn ảnh", "icons8-folder-50.png");
        btnChonAnh.setPreferredSize(new Dimension(150, 40));
        pnlRightButton.add(btnChonAnh);

        pnlButtons.add(pnlLeftButtons);
        pnlButtons.add(pnlRightButton);

        add(pnlMain, BorderLayout.CENTER);
        add(pnlButtons, BorderLayout.SOUTH);

        btnThem.addActionListener(this);
        btnLamMoi.addActionListener(this);
        btnChonAnh.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src == btnThem) {
            add();
        }
        if(src == btnLamMoi) {
            clear();
        }
        if(src == btnChonAnh) {
            addImage();
        }
    }

    private boolean isTextFieldBlank(JTextField input, String inputName) {
        String string = input.getText();
        if(string.isBlank()) {
            input.requestFocus();
            JOptionPane.showMessageDialog(this, inputName + " nhân viên không được để chống");
            return true;
        }
        return false;
    }

    private boolean validateData() {
        if(isTextFieldBlank(txtMaNV, "Mã") || isTextFieldBlank(txtTenNV, "Tên") ||
                isTextFieldBlank(txtLuong, "Lương") || isTextFieldBlank(txtSoDienThoai, "Số điễn thoại") ||
                isTextFieldBlank(txtDiaChi, "Địa chỉ") || isTextFieldBlank(txtTenDangNhap, "Tên đăng nhập") ||
                isTextFieldBlank(txtMatKhau, "Mật khẩu"))
            return false;

        String ma = txtMaNV.getText();
        String ten = txtTenNV.getText();
        String luongString = txtLuong.getText();
        String sdt = txtSoDienThoai.getText();
        String username = txtTenDangNhap.getText();
        String password = new String(txtMatKhau.getPassword());

        if(!ma.matches("^[A-Z]{2}[0-9]{6}$")) {
            txtMaNV.requestFocus();
            JOptionPane.showMessageDialog(this,
                    "Mã phải bắt đẩu bằng 2 chử cái viết hoa và gồm 6 ký tự số");
            return false;
        }
        if(!ten.matches("^\\p{Lu}\\p{Ll}*( \\p{Lu}\\p{Ll}*)*$")) {
            txtTenNV.requestFocus();
            JOptionPane.showMessageDialog(this,
                    "Tên không được chứa số hay ký tự đặc biệt.\nTên phải viết hoa chữ cái đầu và sau dấu cách");
            return false;
        }
        int luong;
        try {
            luong = Integer.parseInt(luongString);
        } catch (NumberFormatException e) {
            txtLuong.requestFocus();
            JOptionPane.showMessageDialog(this, "Lương phải là một số nguyên");
            return false;
        }
        if(luong <= 0) {
            txtLuong.requestFocus();
            JOptionPane.showMessageDialog(this, "Lương phải lớn hơn 0");
            return false;
        }
        if(!sdt.matches("^(0|84)[0-9]{8,12}$")) {
            txtSoDienThoai.requestFocus();
            JOptionPane.showMessageDialog(this,
                    "Số điện thoại phải bắt đầu bằng 0 hoặc 84 và có từ 9 đến 14 số");
            return false;
        }
        if(!username.matches("^[a-zA-Z0-9_]{5,}$")) {
            txtTenDangNhap.requestFocus();
            JOptionPane.showMessageDialog(this,
                    "Tên đăng nhập chỉ có thể chứa chữ, số và _\nTên đăng nhập phải có tối thiểu 5 ký tự");
            return false;
        }
        if(!password.matches("^.{8,}$")) {
            txtMatKhau.requestFocus();
            JOptionPane.showMessageDialog(this, "Mật khẩu phải có ít nhất 8 ký tự");
            return false;
        }
        if(pathHinhAnh == null) {
            JOptionPane.showMessageDialog(this, "Hình ảnh không được để trống");
            return false;
        }
        return true;
    }

    private void add() {
        if(!validateData())
            return;
        String ma = txtMaNV.getText();
        String ten = txtTenNV.getText();
        String chucVu = Objects.requireNonNull(comboChucVu.getSelectedItem()).toString();
        String luongString = txtLuong.getText();
        String sdt = txtSoDienThoai.getText();
        String diaChi = txtDiaChi.getText();
        String username = txtTenDangNhap.getText();
        String password = new String(txtMatKhau.getPassword());

        int luong = Integer.parseInt(luongString);
        TaiKhoan taiKhoan = new TaiKhoan(username, password, new NhanVien(ma, ten, chucVu, luong, sdt, diaChi, pathHinhAnh));
        if(danhSachTaiKhoan.them(taiKhoan)) {
            JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công!");
            clear();
        }
        else
            JOptionPane.showMessageDialog(this, "Mã nhân viên hoặc tên đăng nhập đã tồn tại");
    }

    private void clear() {
        txtMaNV.setText("");
        txtTenNV.setText("");
        comboChucVu.setSelectedIndex(0);
        txtLuong.setText("");
        txtSoDienThoai.setText("");
        txtDiaChi.setText("");
        txtTenDangNhap.setText("");
        txtMatKhau.setText("");

        txtMaNV.requestFocus();
    }

    private void addImage() {
        pathHinhAnh = ImageHelper.saveImage(lblHinhAnh);
        if(pathHinhAnh == null)
            JOptionPane.showMessageDialog(this, "Chọn hình ảnh thất bại");
    }
}