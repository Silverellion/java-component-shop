package gui;

import models.DanhSachTaiKhoan;
import models.NhanVien;
import models.TaiKhoan;
import utils.SwingHelper;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class PnlTaiKhoan extends JPanel implements ActionListener {
    private final JTextField txtMaNV, txtTenNV, txtLuong, txtSoDienThoai, txtDiaChi, txtTenDangNhap, txtMatKhau;
    private final JComboBox<String> comboChucVu;
    private final JTable tblTaiKhoan;
    private final DefaultTableModel tblModelTaiKhoan;
    private final JButton btnThem, btnXoa, btnCapNhat, btnXuat, btnXoaRong, btnTim;
    private final JTextField txtTim;
    private DanhSachTaiKhoan danhSachTaiKhoan;

    public PnlTaiKhoan() {
        danhSachTaiKhoan = new DanhSachTaiKhoan();
        setLayout(new BorderLayout());
        setBackground(new Color(30, 30, 30));

        JLabel lblTitle = SwingHelper.createDarkModeJLabel("Quản lý nhân viên", 30);
        Box boxTitle = new Box(BoxLayout.X_AXIS);
        boxTitle.add(lblTitle);

        JLabel lblMaNV = SwingHelper.createDarkModeJLabel("Mã nhân viên: ");
        JLabel lblTenNV = SwingHelper.createDarkModeJLabel("Tên nhân viên: ");
        JLabel lblChucVu = SwingHelper.createDarkModeJLabel("Chức vụ: ");
        JLabel lblLuong = SwingHelper.createDarkModeJLabel("Lương: ");
        JLabel lblSoDienThoai = SwingHelper.createDarkModeJLabel("Số điện thoại: ");
        JLabel lblDiaChi = SwingHelper.createDarkModeJLabel("Địa chỉ");

        JLabel lblTenDangNhap = SwingHelper.createDarkModeJLabel("Tên đăng nhập: ");
        JLabel lblMatKhau = SwingHelper.createDarkModeJLabel("Mật khẩu: ");

        lblMaNV.setPreferredSize(lblTenDangNhap.getPreferredSize());
        lblTenNV.setPreferredSize(lblTenDangNhap.getPreferredSize());
        lblChucVu.setPreferredSize(lblTenDangNhap.getPreferredSize());
        lblLuong.setPreferredSize(lblTenDangNhap.getPreferredSize());
        lblSoDienThoai.setPreferredSize(lblTenDangNhap.getPreferredSize());
        lblDiaChi.setPreferredSize(lblTenDangNhap.getPreferredSize());

        lblTenDangNhap.setPreferredSize(lblTenDangNhap.getPreferredSize());
        lblMatKhau.setPreferredSize(lblTenDangNhap.getPreferredSize());

        txtMaNV = new JTextField();
        txtTenNV = new JTextField();
        comboChucVu = new JComboBox<>();
        txtLuong = new JTextField();
        txtSoDienThoai = new JTextField();
        txtDiaChi = new JTextField();

        txtTenDangNhap = new JTextField();
        txtMatKhau = new JTextField();

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

        box1.add(Box.createHorizontalStrut(10));
        box1.add(lblMaNV);
        box1.add(txtMaNV);
        box1.add(Box.createHorizontalStrut(10));
        box1.add(lblTenNV);
        box1.add(txtTenNV);
        box1.add(Box.createHorizontalStrut(10));

        box2.add(Box.createHorizontalStrut(10));
        box2.add(lblChucVu);
        box2.add(comboChucVu);
        box2.add(Box.createHorizontalStrut(10));
        box2.add(lblLuong);
        box2.add(txtLuong);
        box2.add(Box.createHorizontalStrut(10));

        box3.add(Box.createHorizontalStrut(10));
        box3.add(lblSoDienThoai);
        box3.add(txtSoDienThoai);
        box3.add(Box.createHorizontalStrut(10));
        box3.add(lblDiaChi);
        box3.add(txtDiaChi);
        box3.add(Box.createHorizontalStrut(10));

        box4.add(Box.createHorizontalStrut(10));
        box4.add(lblTenDangNhap);
        box4.add(txtTenDangNhap);
        box4.add(Box.createHorizontalStrut(10));
        box4.add(lblMatKhau);
        box4.add(txtMatKhau);
        box4.add(Box.createHorizontalStrut(10));

        Box boxThongTin = new Box(BoxLayout.Y_AXIS);
        boxThongTin.add(Box.createVerticalStrut(10));
        boxThongTin.add(box1);
        boxThongTin.add(Box.createVerticalStrut(10));
        boxThongTin.add(box2);
        boxThongTin.add(Box.createVerticalStrut(10));
        boxThongTin.add(box3);
        boxThongTin.add(Box.createVerticalStrut(10));
        TitledBorder borderThongTin = BorderFactory.createTitledBorder("Thông tin nhân viên");
        borderThongTin.setTitleColor(Color.WHITE);
        borderThongTin.setTitleFont(new Font("Segoe UI", Font.BOLD, 16));
        boxThongTin.setBorder(borderThongTin);


        Box boxTaiKhoan = new Box(BoxLayout.Y_AXIS);
        boxTaiKhoan.add(Box.createVerticalStrut(10));
        boxTaiKhoan.add(box4);
        boxTaiKhoan.add(Box.createVerticalStrut(10));
        TitledBorder borderTaiKhoan = BorderFactory.createTitledBorder("Tài khoản nhân viên");
        borderTaiKhoan.setTitleColor(Color.WHITE);
        borderTaiKhoan.setTitleFont(new Font("Segoe UI", Font.BOLD, 16));
        boxTaiKhoan.setBorder(borderTaiKhoan);

        Box boxThongTinWrapper = new Box(BoxLayout.X_AXIS);
        boxThongTinWrapper.add(Box.createHorizontalStrut(20));
        boxThongTinWrapper.add(boxThongTin);
        boxThongTinWrapper.add(Box.createHorizontalStrut(20));

        Box boxTaiKhoanWrapper = new Box(BoxLayout.X_AXIS);
        boxTaiKhoanWrapper.add(Box.createHorizontalStrut(20));
        boxTaiKhoanWrapper.add(boxTaiKhoan);
        boxTaiKhoanWrapper.add(Box.createHorizontalStrut(20));

        Box boxNorth = new Box(BoxLayout.Y_AXIS);
        boxNorth.add(boxTitle);
        boxNorth.add(Box.createVerticalStrut(10));
        boxNorth.add(boxThongTinWrapper);
        boxNorth.add(Box.createVerticalStrut(10));
        boxNorth.add(boxTaiKhoanWrapper);
        boxNorth.add(Box.createVerticalStrut(20));

        add(boxNorth, BorderLayout.NORTH);

        tblModelTaiKhoan = new DefaultTableModel();
        tblModelTaiKhoan.addColumn("Mã nhân viên");
        tblModelTaiKhoan.addColumn("Tên nhân viên");
        tblModelTaiKhoan.addColumn("Chức vụ");
        tblModelTaiKhoan.addColumn("Lương");
        tblModelTaiKhoan.addColumn("Số điện thoại");
        tblModelTaiKhoan.addColumn("Địa chỉ");
        tblModelTaiKhoan.addColumn("Tên đăng nhập");
        tblModelTaiKhoan.addColumn("Mật khẩu");

        tblTaiKhoan = new JTable(tblModelTaiKhoan);
        JScrollPane scrTaiKhoan = new JScrollPane(tblTaiKhoan);

        JPanel pnlTableTaiKhoan = new JPanel(new BorderLayout());
        pnlTableTaiKhoan.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20)); // Margin-X: 20px
        pnlTableTaiKhoan.setBackground(new Color(30,30,30));
        pnlTableTaiKhoan.add(scrTaiKhoan, BorderLayout.CENTER);
        add(pnlTableTaiKhoan, BorderLayout.CENTER);

        btnThem = SwingHelper.createDarkModeJButton("Thêm");
        btnXoa = SwingHelper.createDarkModeJButton("Xóa");
        btnCapNhat = SwingHelper.createDarkModeJButton("Cập nhật");
        btnXuat = SwingHelper.createDarkModeJButton("Xuất Excel");
        btnXoaRong = SwingHelper.createDarkModeJButton("Xóa rỗng");

        JLabel lblTim = SwingHelper.createDarkModeJLabel("Nhập dữ liệu cần tìm: ");
        txtTim = new JTextField(15);
        btnTim = SwingHelper.createDarkModeJButton("Tìm");

        JPanel pnlSouthwest = new JPanel();
        JPanel pnlSoutheast = new JPanel();
        pnlSouthwest.setBackground(new Color(30,30,30));
        pnlSoutheast.setBackground(new Color(30,30,30));
        pnlSoutheast.setMinimumSize(new Dimension(480, getHeight()));

        pnlSouthwest.add(btnThem);
        pnlSouthwest.add(btnXoa);
        pnlSouthwest.add(btnCapNhat);
        pnlSouthwest.add(btnXuat);
        pnlSouthwest.add(btnXoaRong);

        pnlSoutheast.add(lblTim);
        pnlSoutheast.add(txtTim);
        pnlSoutheast.add(btnTim);

        TitledBorder pnlSouthWestTitledBorder = BorderFactory.createTitledBorder("Điều khiển");
        pnlSouthWestTitledBorder.setTitleColor(Color.WHITE);
        pnlSouthWestTitledBorder.setTitleFont(new Font("Segoe UI", Font.BOLD, 16));
        Border pnlSouthWestBorder = BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 20, 10, 20),
                pnlSouthWestTitledBorder
        );

        TitledBorder pnlSouthEastTitledBorder = BorderFactory.createTitledBorder("Tìm kiếm");
        pnlSouthEastTitledBorder.setTitleColor(Color.WHITE);
        pnlSouthEastTitledBorder.setTitleFont(new Font("Segoe UI", Font.BOLD, 16));
        Border pnlSouthEastBorder = BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 20, 10, 20),
                pnlSouthEastTitledBorder
        );

        pnlSouthwest.setBorder(pnlSouthWestBorder);
        pnlSoutheast.setBorder(pnlSouthEastBorder);

        JSplitPane pnlSouth = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnlSouthwest, pnlSoutheast);
        pnlSouth.setBackground(new Color(45,45,45));
        add(pnlSouth, BorderLayout.SOUTH);

        btnThem.addActionListener(this);
        btnXoa.addActionListener(this);
        btnCapNhat.addActionListener(this);
        btnXoaRong.addActionListener(this);
        btnTim.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src == btnThem)
            add();
        if(src == btnXoa)
            remove();
        if(src == btnCapNhat)
            update();
        if(src == btnXoaRong)
            clear();
        if(src == btnTim)
            find();
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
        String password = txtMatKhau.getText();

        if(!ma.matches("^[A-Z][0-9]{3}$")) {
            txtMaNV.requestFocus();
            JOptionPane.showMessageDialog(this,
                    "Mã phải bắt đẩu bằng 1 chử cái viết hoa và gồm 3 ký tự số");
            return false;
        }
        if(!ten.matches("^[A-Z][a-z]*( [A-Z][a-z]*)*$")) {
            txtTenNV.requestFocus();
            JOptionPane.showMessageDialog(this,
                    "Tên không được chứa số hay ký tự đặc biệt.\nTên phải viết hoa chữ cái đầu và sau dấu cách");
            return false;
        }
        int luong = 0;
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
                    "Số điện thoại phải bắt đầu bằng số 0 và có từ 9 đến 14 số");
            return false;
        }
        if(!username.matches("^[a-zA-Z0-9_]{5,}$")) {
            txtTenDangNhap.requestFocus();
            JOptionPane.showMessageDialog(this, "Tên đăng nhập chỉ có thể chứa chữ, số và _");
            return false;
        }
        if(!password.matches("^.{8,}$")) {
            txtMatKhau.requestFocus();
            JOptionPane.showMessageDialog(this, "Mật khẩu phải có ít nhất 8 ký tự");
            return false;
        }
        return true;
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
        String password = txtMatKhau.getText();

        int luong = Integer.parseInt(luongString);
        TaiKhoan taiKhoan = new TaiKhoan(username, password, new NhanVien(ma, ten, chucVu, luong, sdt, diaChi));
    }
    private void remove() {

    }
    private void update() {

    }
    private void clear() {

    }
    private void find() {

    }
}
