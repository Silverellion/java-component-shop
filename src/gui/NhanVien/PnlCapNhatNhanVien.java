package gui.NhanVien;

import entity.DanhSachTaiKhoan;
import entity.NhanVien;
import entity.TaiKhoan;
import utils.ImageHelper;
import utils.SwingHelper;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Objects;

import static utils.ImageHelper.loadImage;
import static utils.SwingHelper.createProjectJTable;

public class PnlCapNhatNhanVien extends JPanel implements ActionListener {
    private final JTextField txtMaNV, txtTenNV, txtLuong, txtSoDienThoai, txtDiaChi, txtTenDangNhap;
    private final JPasswordField txtMatKhau;
    private final JComboBox<String> comboChucVu;
    private final JTable tblTaiKhoan;
    private final DefaultTableModel tblModelTaiKhoan;
    private final JLabel lblHinhAnh;
    private final JButton btnThem, btnXoa, btnCapNhat, btnXuat, btnLamMoi, btnChonAnh;
    private final JTextField txtTim;
    private String pathHinhAnh = null;
    private DanhSachTaiKhoan danhSachTaiKhoan;

    public PnlCapNhatNhanVien() {
        danhSachTaiKhoan = new DanhSachTaiKhoan();
        setLayout(new BorderLayout());

        JLabel lblTitle = SwingHelper.createProjectJLabel("Cập nhật nhân viên", 30);
        Box boxTitle = new Box(BoxLayout.X_AXIS);
        boxTitle.add(lblTitle);

        JLabel lblMaNV = SwingHelper.createProjectJLabel("Mã nhân viên: ");
        JLabel lblTenNV = SwingHelper.createProjectJLabel("Tên nhân viên: ");
        JLabel lblChucVu = SwingHelper.createProjectJLabel("Chức vụ: ");
        JLabel lblLuong = SwingHelper.createProjectJLabel("Lương: ");
        JLabel lblSoDienThoai = SwingHelper.createProjectJLabel("Số điện thoại: ");
        JLabel lblDiaChi = SwingHelper.createProjectJLabel("Địa chỉ: ");
        JLabel lblTenDangNhap = SwingHelper.createProjectJLabel("Tên đăng nhập: ");
        JLabel lblMatKhau = SwingHelper.createProjectJLabel("Mật khẩu: ");

        lblMaNV.setPreferredSize(lblTenDangNhap.getPreferredSize());
        lblTenNV.setPreferredSize(lblTenDangNhap.getPreferredSize());
        lblChucVu.setPreferredSize(lblTenDangNhap.getPreferredSize());
        lblLuong.setPreferredSize(lblTenDangNhap.getPreferredSize());
        lblSoDienThoai.setPreferredSize(lblTenDangNhap.getPreferredSize());
        lblDiaChi.setPreferredSize(lblTenDangNhap.getPreferredSize());
        lblMatKhau.setPreferredSize(lblTenDangNhap.getPreferredSize());

        txtMaNV = new JTextField();
        txtTenNV = new JTextField();
        comboChucVu = new JComboBox<>();
        txtLuong = new JTextField();
        txtSoDienThoai = new JTextField();
        txtDiaChi = new JTextField();
        txtTenDangNhap = new JTextField();
        txtMatKhau = new JPasswordField();

        Dimension textFieldSize = new Dimension(200, txtMaNV.getPreferredSize().height);
        txtMaNV.setPreferredSize(textFieldSize);
        txtTenNV.setPreferredSize(textFieldSize);
        txtLuong.setPreferredSize(textFieldSize);
        txtSoDienThoai.setPreferredSize(textFieldSize);
        txtDiaChi.setPreferredSize(textFieldSize);
        txtTenDangNhap.setPreferredSize(textFieldSize);
        txtMatKhau.setPreferredSize(textFieldSize);

        comboChucVu.addItem("Nhân viên bán hàng");
        comboChucVu.addItem("Nhân viên quản lý kho");
        comboChucVu.addItem("Nhân viên kỹ thuật");
        comboChucVu.addItem("Nhân viên giao hàng");
        comboChucVu.addItem("Quản lý cửa hàng");
        comboChucVu.setPreferredSize(textFieldSize);

        //LEFT PANEL
        JPanel leftPanel = new JPanel(new GridLayout(3, 1, 0, 10));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 0,10, 0));
        leftPanel.setOpaque(false); // Transparent background

        JPanel panelMaNV = new JPanel(new BorderLayout(5, 0));
        panelMaNV.setOpaque(false);
        panelMaNV.add(lblMaNV, BorderLayout.WEST);
        panelMaNV.add(txtMaNV, BorderLayout.CENTER);

        JPanel panelChucVu = new JPanel(new BorderLayout(5, 0));
        panelChucVu.setOpaque(false);
        panelChucVu.add(lblChucVu, BorderLayout.WEST);
        panelChucVu.add(comboChucVu, BorderLayout.CENTER);

        JPanel panelSoDienThoai = new JPanel(new BorderLayout(5, 0));
        panelSoDienThoai.setOpaque(false);
        panelSoDienThoai.add(lblSoDienThoai, BorderLayout.WEST);
        panelSoDienThoai.add(txtSoDienThoai, BorderLayout.CENTER);

        leftPanel.add(panelMaNV);
        leftPanel.add(panelChucVu);
        leftPanel.add(panelSoDienThoai);

        //RIGHT PANEL
        JPanel rightPanel = new JPanel(new GridLayout(3, 1, 0, 10));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 0,10, 0));
        rightPanel.setOpaque(false);

        JPanel panelTenNV = new JPanel(new BorderLayout(5, 0));
        panelTenNV.setOpaque(false);
        panelTenNV.add(lblTenNV, BorderLayout.WEST);
        panelTenNV.add(txtTenNV, BorderLayout.CENTER);

        JPanel panelLuong = new JPanel(new BorderLayout(5, 0));
        panelLuong.setOpaque(false);
        panelLuong.add(lblLuong, BorderLayout.WEST);
        panelLuong.add(txtLuong, BorderLayout.CENTER);

        JPanel panelDiaChi = new JPanel(new BorderLayout(5, 0));
        panelDiaChi.setOpaque(false);
        panelDiaChi.add(lblDiaChi, BorderLayout.WEST);
        panelDiaChi.add(txtDiaChi, BorderLayout.CENTER);

        rightPanel.add(panelTenNV);
        rightPanel.add(panelLuong);
        rightPanel.add(panelDiaChi);

        JPanel panelThongTin = new JPanel();
        panelThongTin.setOpaque(false);
        panelThongTin.setLayout(new BoxLayout(panelThongTin, BoxLayout.X_AXIS));
        panelThongTin.add(Box.createHorizontalStrut(10));
        panelThongTin.add(leftPanel);
        panelThongTin.add(Box.createHorizontalStrut(20));
        panelThongTin.add(rightPanel);
        panelThongTin.add(Box.createHorizontalStrut(10));

        TitledBorder borderThongTin = BorderFactory.createTitledBorder("Thông tin nhân viên");
        borderThongTin.setTitleFont(new Font("Segoe UI", Font.BOLD, 16));
        panelThongTin.setBorder(borderThongTin);

        JPanel panelTaiKhoan = new JPanel();
        panelTaiKhoan.setOpaque(false);
        panelTaiKhoan.setLayout(new BoxLayout(panelTaiKhoan, BoxLayout.X_AXIS));

        JPanel panelUsername = new JPanel(new BorderLayout(5, 0));
        panelUsername.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panelUsername.setOpaque(false);
        panelUsername.add(lblTenDangNhap, BorderLayout.WEST);
        panelUsername.add(txtTenDangNhap, BorderLayout.CENTER);

        JPanel panelPassword = new JPanel(new BorderLayout(5, 0));
        panelPassword.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panelPassword.setOpaque(false);
        panelPassword.add(lblMatKhau, BorderLayout.WEST);
        panelPassword.add(txtMatKhau, BorderLayout.CENTER);

        panelTaiKhoan.add(Box.createHorizontalStrut(10));
        panelTaiKhoan.add(panelUsername);
        panelTaiKhoan.add(Box.createHorizontalStrut(20));
        panelTaiKhoan.add(panelPassword);
        panelTaiKhoan.add(Box.createHorizontalStrut(10));

        TitledBorder borderTaiKhoan = BorderFactory.createTitledBorder("Tài khoản nhân viên");
        borderTaiKhoan.setTitleFont(new Font("Segoe UI", Font.BOLD, 16));
        panelTaiKhoan.setBorder(borderTaiKhoan);

        // WRAPPERS (For padding purposes)
        JPanel pnlThongTinWrapper = new JPanel(new BorderLayout());
        pnlThongTinWrapper.setOpaque(false);
        pnlThongTinWrapper.add(panelThongTin, BorderLayout.CENTER);
        pnlThongTinWrapper.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        JPanel pnlTaiKhoanWrapper = new JPanel(new BorderLayout());
        pnlTaiKhoanWrapper.setOpaque(false);
        pnlTaiKhoanWrapper.add(panelTaiKhoan, BorderLayout.CENTER);
        pnlTaiKhoanWrapper.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        JPanel pnlNorth = new JPanel();
        pnlNorth.setOpaque(false);
        pnlNorth.setLayout(new BoxLayout(pnlNorth, BoxLayout.Y_AXIS));

        boxTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlNorth.add(boxTitle);
        pnlNorth.add(Box.createVerticalStrut(10));
        pnlNorth.add(pnlThongTinWrapper);
        pnlNorth.add(Box.createVerticalStrut(10));
        pnlNorth.add(pnlTaiKhoanWrapper);
        pnlNorth.add(Box.createVerticalStrut(20));

        add(pnlNorth, BorderLayout.NORTH);

        tblModelTaiKhoan = new DefaultTableModel();
        tblModelTaiKhoan.addColumn("Mã nhân viên");
        tblModelTaiKhoan.addColumn("Tên nhân viên");
        tblModelTaiKhoan.addColumn("Chức vụ");
        tblModelTaiKhoan.addColumn("Lương");
        tblModelTaiKhoan.addColumn("Số điện thoại");
        tblModelTaiKhoan.addColumn("Địa chỉ");
        tblModelTaiKhoan.addColumn("Tên đăng nhập");
        tblModelTaiKhoan.addColumn("Mật khẩu");

        tblTaiKhoan = createProjectJTable(tblModelTaiKhoan);
        JScrollPane scrTaiKhoan = new JScrollPane(tblTaiKhoan);

        lblHinhAnh = new JLabel();
        lblHinhAnh.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblHinhAnh.setPreferredSize(new Dimension(300, 500));
        btnChonAnh = SwingHelper.createProjectJButton("Chọn ảnh", "icons8-folder-50.png");
        JPanel pnlHinhAnh = new JPanel(new BorderLayout());
        pnlHinhAnh.add(lblHinhAnh, BorderLayout.CENTER);
        pnlHinhAnh.add(btnChonAnh, BorderLayout.SOUTH);

        JPanel pnlTableTaiKhoan = new JPanel(new BorderLayout());
        pnlTableTaiKhoan.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        pnlTableTaiKhoan.add(scrTaiKhoan, BorderLayout.CENTER);
        pnlTableTaiKhoan.add(pnlHinhAnh, BorderLayout.EAST);
        add(pnlTableTaiKhoan, BorderLayout.CENTER);

        btnThem = SwingHelper.createProjectJButton("Thêm", "icons8-add-50.png");
        btnXoa = SwingHelper.createProjectJButton("Xóa", "icons8-delete-50.png");
        btnCapNhat = SwingHelper.createProjectJButton("Cập nhật", "icons8-up-50.png");
        btnXuat = SwingHelper.createProjectJButton("Xuất Excel", "icons8-excel-50.png");
        btnLamMoi = SwingHelper.createProjectJButton("Làm mới", "icons8-reload-50.png");

        JLabel lblTim = SwingHelper.createProjectJLabel("Nhập dữ liệu cần tìm: ");
        txtTim = new JTextField(20);

        JPanel pnlSouthwest = new JPanel();
        JPanel pnlSoutheast = new JPanel();
        pnlSoutheast.setMinimumSize(new Dimension(450, getHeight()));

        pnlSouthwest.add(btnThem);
        pnlSouthwest.add(btnXoa);
        pnlSouthwest.add(btnCapNhat);
        pnlSouthwest.add(btnXuat);
        pnlSouthwest.add(btnLamMoi);

        pnlSoutheast.add(lblTim);
        pnlSoutheast.add(txtTim);

        TitledBorder pnlSouthWestTitledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createEmptyBorder(),
                "Điều khiển"
        );
        pnlSouthWestTitledBorder.setTitleFont(new Font("Segoe UI", Font.BOLD, 16));
        Border pnlSouthWestBorder = BorderFactory.createCompoundBorder(
                pnlSouthWestTitledBorder,
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        );

        TitledBorder pnlSouthEastTitledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createEmptyBorder(),
                "Tìm kiếm"
        );
        pnlSouthEastTitledBorder.setTitleFont(new Font("Segoe UI", Font.BOLD, 16));
        Border pnlSouthEastBorder = BorderFactory.createCompoundBorder(
                pnlSouthEastTitledBorder,
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        );

        pnlSouthwest.setBorder(pnlSouthWestBorder);
        pnlSoutheast.setBorder(pnlSouthEastBorder);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnlSouthwest, pnlSoutheast);
        JPanel pnlSouth = new JPanel(new BorderLayout());
        pnlSouth.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
        pnlSouth.add(splitPane);
        add(pnlSouth, BorderLayout.SOUTH);

        btnThem.addActionListener(this);
        btnXoa.addActionListener(this);
        btnCapNhat.addActionListener(this);
        btnLamMoi.addActionListener(this);
        tableClickListener();
        txtTim.getDocument().addDocumentListener(new FilterListener()); //Real time filtering function
        btnXuat.addActionListener(this);
        btnChonAnh.addActionListener(this);
        load();
    }

    // Reinitialize danhSachTaiKhoan after adding it in PnlThemNhanVien
    public void refreshData() {
        danhSachTaiKhoan = new DanhSachTaiKhoan();
        tblModelTaiKhoan.setRowCount(0);
        load();
    }

    private void load() {
        for (TaiKhoan taiKhoan : danhSachTaiKhoan.getDanhSach()) {
            if ("KhongConHoatDong".equalsIgnoreCase(taiKhoan.getTrangThai())) {
                continue;
            }
            String ma = taiKhoan.getMaNhanVien();
            String ten = taiKhoan.getHoTen();
            String chucVu = taiKhoan.getChucVu();
            int luong = taiKhoan.getLuong();
            String sdt = taiKhoan.getSoDienThoai();
            String diaChi = taiKhoan.getDiaChi();
            String username = taiKhoan.getTenDangNhap();

            tblModelTaiKhoan.addRow(new Object[]{ma, ten, chucVu, luong, sdt, diaChi, username, "********"});
        }
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
        if(src == btnXuat)
            export();
        if(src == btnLamMoi)
            clear();
        if(src == btnChonAnh)
            addImage();
    }

    private void tableClickListener() {
        tblTaiKhoan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tblTaiKhoan.getSelectedRow();
                if(row >= 0) {
                    String maNV = tblTaiKhoan.getValueAt(row, 0).toString();
                    txtMaNV.setText(maNV);
                    txtTenNV.setText(tblTaiKhoan.getValueAt(row, 1).toString());
                    comboChucVu.setSelectedItem(tblTaiKhoan.getValueAt(row, 2).toString());
                    txtLuong.setText(tblTaiKhoan.getValueAt(row, 3).toString());
                    txtSoDienThoai.setText(tblTaiKhoan.getValueAt(row, 4).toString());
                    txtDiaChi.setText(tblTaiKhoan.getValueAt(row, 5).toString());
                    txtTenDangNhap.setText(tblTaiKhoan.getValueAt(row, 6).toString());
                    txtMatKhau.setText("********");

                    String pathHinhAnh = danhSachTaiKhoan.tim(maNV).getPathHinhAnh();
                    loadImage(lblHinhAnh, pathHinhAnh);
                }
            }
        });
    }

    private class FilterListener implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) {
            filterTable(txtTim.getText());
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
            filterTable(txtTim.getText());
        }
        @Override
        public void changedUpdate(DocumentEvent e) {
            filterTable(txtTim.getText());
        }
    }

    private void filterTable(String searchText) {
        DefaultTableModel model = (DefaultTableModel) tblTaiKhoan.getModel();
        // Remove all rows from the table
        model.setRowCount(0);
        if (searchText == null || searchText.trim().isEmpty()) {
            for (TaiKhoan tk : danhSachTaiKhoan.getDanhSach()) {
                model.addRow(new Object[]{
                    tk.getMaNhanVien(),
                    tk.getHoTen(),
                    tk.getChucVu(),
                    tk.getLuong(),
                    tk.getSoDienThoai(),
                    tk.getDiaChi(),
                    tk.getTenDangNhap(),
                    "********"
                });
            }
            return;
        }
        String searchLower = searchText.toLowerCase();
        for (TaiKhoan tk : danhSachTaiKhoan.getDanhSach()) {
            if (containsSearchText(tk.getMaNhanVien(), searchLower) ||
                    containsSearchText(tk.getHoTen(), searchLower) ||
                    containsSearchText(tk.getChucVu(), searchLower) ||
                    containsSearchText(String.valueOf(tk.getLuong()), searchLower) ||
                    containsSearchText(tk.getSoDienThoai(), searchLower) ||
                    containsSearchText(tk.getDiaChi(), searchLower) ||
                    containsSearchText(tk.getTenDangNhap(), searchLower)) {
                        model.addRow(new Object[]{
                            tk.getMaNhanVien(),
                            tk.getHoTen(),
                            tk.getChucVu(),
                            tk.getLuong(),
                            tk.getSoDienThoai(),
                            tk.getDiaChi(),
                            tk.getTenDangNhap(),
                            "********"
                        });
            }
        }
    }

    private boolean containsSearchText(String text, String searchText) {
        if(text == null || searchText == null)
            return false;
        return text.toLowerCase().contains(searchText.toLowerCase());
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
            removeImage();
            refreshData();
        }
        else
            JOptionPane.showMessageDialog(this, "Mã nhân viên hoặc tên đăng nhập đã tồn tại");
    }

    private void remove() {
        int choice = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc chắn muốn xóa tải khoản này không?",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.NO_OPTION)
            return;
        int row = tblTaiKhoan.getSelectedRow();
        if(danhSachTaiKhoan.xoa(row)) {
            tblModelTaiKhoan.removeRow(row);
            JOptionPane.showMessageDialog(this, "Xoá tài khoản thành công");
            refreshData();
        } else {
            JOptionPane.showMessageDialog(this, "Xoá tài khoản thất bại");
        }
    }
    private void update() {
        if (!validateData())
            return;
        int row = tblTaiKhoan.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một nhân viên để cập nhật");
            return;
        }

        String ma = tblTaiKhoan.getValueAt(row, 0).toString();
        String ten = txtTenNV.getText();
        String chucVu = Objects.requireNonNull(comboChucVu.getSelectedItem()).toString();
        String luongString = txtLuong.getText();
        String sdt = txtSoDienThoai.getText();
        String diaChi = txtDiaChi.getText();
        String username = txtTenDangNhap.getText();
        String password = new String(txtMatKhau.getPassword());
        int luong = Integer.parseInt(luongString);

        String pathHinhAnh = ImageHelper.getImagePath(lblHinhAnh);
        if (pathHinhAnh == null) {
            pathHinhAnh = danhSachTaiKhoan.tim(ma).getPathHinhAnh();
        }

        NhanVien nv = new NhanVien(ma, ten, chucVu, luong, sdt, diaChi, pathHinhAnh);
        TaiKhoan taiKhoan = new TaiKhoan(username, password, nv);

        if (danhSachTaiKhoan.capNhat(row, taiKhoan)) {
            DefaultTableModel model = (DefaultTableModel) tblTaiKhoan.getModel();
            model.setValueAt(ma, row, 0);
            model.setValueAt(ten, row, 1);
            model.setValueAt(chucVu, row, 2);
            model.setValueAt(luong, row, 3);
            model.setValueAt(sdt, row, 4);
            model.setValueAt(diaChi, row, 5);
            model.setValueAt(username, row, 6);
            model.setValueAt("********", row, 7);

            JOptionPane.showMessageDialog(this, "Cập nhật tài khoản thành công");
            refreshData();
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật tài khoản thất bại");
        }
    }


    private void export() {
        try {
            File cacheDir = new File("C:\\componentShopCache");
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }

            LocalDateTime now = LocalDateTime.now();
            String fileName = "DanhSachNhanVien_" + now.getYear() + now.getMonthValue() +
                    now.getDayOfMonth() + "_" + now.getHour() + now.getMinute() + ".csv";
            File csvFile = new File(cacheDir, fileName);

            try (OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream(csvFile), StandardCharsets.UTF_8);
                 BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

                // Add UTF-8 BOM so Excel recognizes the encoding correctly
                bufferedWriter.write('\ufeff');

                String header = "Mã NV,Tên NV,Chức vụ,Lương,Số điện thoại,Địa chỉ,Tên đăng nhập,Mật khẩu,Trạng thái";
                bufferedWriter.write(header);
                bufferedWriter.newLine();

                for (TaiKhoan tk : danhSachTaiKhoan.getDanhSach()) {
                    if ("KhongConHoatDong".equalsIgnoreCase(tk.getTrangThai())) {
                        continue;
                    }

                    String line = tk.getMaNhanVien() + "," +
                            tk.getHoTen() + "," +
                            tk.getChucVu() + "," +
                            tk.getLuong() + "," +
                            tk.getSoDienThoai() + "," +
                            tk.getDiaChi() + "," +
                            tk.getTenDangNhap() + "," +
                            "********," +
                            tk.getTrangThai();

                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }

                int option = JOptionPane.showConfirmDialog(
                        this,
                        "File đã xuất thành công tại:\n" + csvFile.getAbsolutePath() + "\nBạn có muốn mở file?",
                        "Xuất file thành công",
                        JOptionPane.YES_NO_OPTION
                );

                if (option == JOptionPane.YES_OPTION) {
                    openFile(csvFile);
                }

            } catch (Exception e) {
                JOptionPane.showConfirmDialog(this, "Lỗi xuất file");
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this, "Lỗi xuất file");
        }
    }

    private void openFile(File file) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Không thể mở file tự động. File được lưu tại:\n" + file.getAbsolutePath());
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this, "Lỗi xuất file");
        }
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
        txtTim.setText("");

        txtMaNV.requestFocus();
    }

    private void addImage() {
        pathHinhAnh = ImageHelper.saveImage(lblHinhAnh);
        if(pathHinhAnh == null)
            JOptionPane.showMessageDialog(this, "Chọn hình ảnh thất bại");
    }

    private void removeImage() {
        lblHinhAnh.setIcon(null);
        lblHinhAnh.revalidate();
        lblHinhAnh.repaint();
    }

}
