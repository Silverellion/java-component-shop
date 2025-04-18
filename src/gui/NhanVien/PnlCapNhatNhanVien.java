package gui.NhanVien;

import entity.DanhSachTaiKhoan;
import entity.NhanVien;
import entity.TaiKhoan;
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
import java.util.Objects;

import static utils.SwingHelper.createProjectJTable;

public class PnlCapNhatNhanVien extends JPanel implements ActionListener {
    private final JTextField txtMaNV, txtTenNV, txtLuong, txtSoDienThoai, txtDiaChi, txtTenDangNhap;
    private final JPasswordField txtMatKhau;
    private final JComboBox<String> comboChucVu;
    private final JTable tblTaiKhoan;
    private final DefaultTableModel tblModelTaiKhoan;
    private final JButton btnXoa, btnCapNhat, btnXuat, btnLamMoi;
    private final JTextField txtTim;
    private final DanhSachTaiKhoan danhSachTaiKhoan;

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

        JPanel pnlTableTaiKhoan = new JPanel(new BorderLayout());
        pnlTableTaiKhoan.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20)); // Margin-X: 20px
        pnlTableTaiKhoan.add(scrTaiKhoan, BorderLayout.CENTER);
        add(pnlTableTaiKhoan, BorderLayout.CENTER);

        btnXoa = SwingHelper.createProjectJButton("Xóa", "icons8-delete-50.png");
        btnCapNhat = SwingHelper.createProjectJButton("Cập nhật", "icons8-up-50.png");
        btnXuat = SwingHelper.createProjectJButton("Xuất Excel", "icons8-excel-50.png");
        btnLamMoi = SwingHelper.createProjectJButton("Làm mới", "icons8-reload-50.png");

        JLabel lblTim = SwingHelper.createProjectJLabel("Nhập dữ liệu cần tìm: ");
        txtTim = new JTextField(20);

        JPanel pnlSouthwest = new JPanel();
        JPanel pnlSoutheast = new JPanel();
        pnlSoutheast.setMinimumSize(new Dimension(450, getHeight()));

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

        btnXoa.addActionListener(this);
        btnCapNhat.addActionListener(this);
        btnLamMoi.addActionListener(this);
        tableClickListener();
        txtTim.getDocument().addDocumentListener(new FilterListener()); //Real time filtering function
        load();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src == btnXoa)
            remove();
        if(src == btnCapNhat)
            update();
        if(src == btnLamMoi)
            clear();
    }

    private void tableClickListener() {
        tblTaiKhoan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tblTaiKhoan.getSelectedRow();
                if(row >= 0) {
                    txtMaNV.setText(tblTaiKhoan.getValueAt(row, 0).toString());
                    txtTenNV.setText(tblTaiKhoan.getValueAt(row, 1).toString());
                    comboChucVu.setSelectedItem(tblTaiKhoan.getValueAt(row, 2).toString());
                    txtLuong.setText(tblTaiKhoan.getValueAt(row, 3).toString());
                    txtSoDienThoai.setText(tblTaiKhoan.getValueAt(row, 4).toString());
                    txtDiaChi.setText(tblTaiKhoan.getValueAt(row, 5).toString());
                    txtTenDangNhap.setText(tblTaiKhoan.getValueAt(row, 6).toString());
                    txtMatKhau.setText("********");
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
        } else {
            JOptionPane.showMessageDialog(this, "Xoá tài khoản thất bại");
        }
    }
    private void update() {
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

        String pathHinhAnh = danhSachTaiKhoan.tim(ma).getPathHinhAnhNhanVien();

        int luong = Integer.parseInt(luongString);
        TaiKhoan taiKhoan = new TaiKhoan(username, password, new NhanVien(ma, ten, chucVu, luong, sdt, diaChi, pathHinhAnh));

        int row = tblTaiKhoan.getSelectedRow();
        if(danhSachTaiKhoan.capNhat(row, taiKhoan)) {
            JOptionPane.showMessageDialog(this, "Cập nhật tài khoản thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật tài khoản thất bại");
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

        txtMaNV.requestFocus();
    }

}
