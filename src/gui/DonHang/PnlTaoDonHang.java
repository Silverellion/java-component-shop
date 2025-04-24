package gui.DonHang;

import utils.SwingHelper;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.io.Serial;

public class PnlTaoDonHang extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtMaDH;
	private JTextField txtNgayTao;
	private JComboBox cboxNhanVien;
	private DefaultTableModel tableModel;
	private JTable table;
    public PnlTaoDonHang() {
        setLayout(new BorderLayout());
        
        // phan north
        JPanel pnNorth = new JPanel();
        pnNorth.setLayout(new BoxLayout(pnNorth, BoxLayout.Y_AXIS));
        JLabel lblTitle = SwingHelper.createProjectJLabel("Tạo đơn hàng", 30);
       
     // thong tin khach hang
        JPanel pnKH  = new JPanel();
        pnKH.setLayout(new BoxLayout(pnKH, BoxLayout.Y_AXIS));
        pnKH.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));
        
        JPanel p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS));
        JPanel p2 = new JPanel();
        p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
        JLabel lblMaKH = SwingHelper.createProjectJLabel("Mã khách hàng:");
        txtMaKH = new JTextField();
        JLabel lblTenKH = SwingHelper.createProjectJLabel("Tên khách hàng:");
        txtTenKH = new JTextField();
        
        p1.add(Box.createHorizontalStrut(10));
        p1.add(lblMaKH);
        p1.add(txtMaKH);
        p1.add(Box.createHorizontalStrut(10));
        p1.add(lblTenKH);
        p1.add(txtTenKH);
        p1.add(Box.createHorizontalStrut(10));
            
        JLabel lblSDT = SwingHelper.createProjectJLabel("Số điện thoại:");
        txtSDT = new JTextField();
        JLabel lblDiaChi = SwingHelper.createProjectJLabel("Địa chỉ:");
        txtDiaChi = new JTextField();
        
        p2.add(Box.createHorizontalStrut(10));
        p2.add(lblSDT);
        p2.add(txtSDT);
        p2.add(Box.createHorizontalStrut(10));
        p2.add(lblDiaChi);
        p2.add(txtDiaChi);
        p2.add(Box.createHorizontalStrut(10));
        
        
        pnKH.add(Box.createVerticalStrut(10));
        pnKH.add(p1);
        pnKH.add(Box.createVerticalStrut(10));
        pnKH.add(p2);
        pnKH.add(Box.createVerticalStrut(10));
        
        JPanel pnDH = new JPanel();
        pnDH.setBorder(BorderFactory.createTitledBorder("Thông tin đơn hàng"));
        pnDH.setLayout(new BoxLayout(pnDH, BoxLayout.Y_AXIS));
        JPanel p3 = new JPanel();
        p3.setLayout(new BoxLayout(p3, BoxLayout.X_AXIS));
        JPanel p4 = new JPanel();
        p4.setLayout(new BoxLayout(p4, BoxLayout.X_AXIS));
        JLabel lblMaDH = SwingHelper.createProjectJLabel("Mã đơn hàng:");
        txtMaDH = new JTextField();
        JLabel lblNgayTao = SwingHelper.createProjectJLabel("Ngày tạo:");
        txtNgayTao = new JTextField();
        JLabel lblNhanVien = SwingHelper.createProjectJLabel("Tên nhân viên:");
        String []dulieu = {"NhanVien1", "NhanVien2"};
        cboxNhanVien = new JComboBox(dulieu);
        
        p3.add(Box.createHorizontalStrut(10));
        p3.add(lblMaDH);
        p3.add(txtMaDH);
        p3.add(Box.createHorizontalStrut(10));
        p3.add(lblNgayTao);
        p3.add(txtNgayTao);
        p3.add(Box.createHorizontalStrut(10));
        
        p4.add(Box.createHorizontalStrut(10));
        p4.add(lblNhanVien);
        p4.add(cboxNhanVien);
        p4.add(Box.createHorizontalStrut(10));
        
        pnDH.add(Box.createVerticalStrut(10));
        pnDH.add(p3);
        pnDH.add(Box.createVerticalStrut(10));
        pnDH.add(p4);
        pnDH.add(Box.createVerticalStrut(10));
        
        pnNorth.add(lblTitle);
        pnNorth.add(pnKH);
        pnNorth.add(pnDH);
        
        lblMaKH.setPreferredSize(lblTenKH.getPreferredSize());
        lblSDT.setPreferredSize(lblTenKH.getPreferredSize());
        lblDiaChi.setPreferredSize(lblTenKH.getPreferredSize());
        lblMaDH.setPreferredSize(lblTenKH.getPreferredSize());
        lblNgayTao.setPreferredSize(lblTenKH.getPreferredSize());
        lblNhanVien.setPreferredSize(lblTenKH.getPreferredSize());
        
        // phan center
        JPanel pCenter = new JPanel();
        pCenter.setLayout(new BorderLayout()); 
        pCenter.setBorder(BorderFactory.createTitledBorder("Chi tiết sản phẩm"));
        String[] tieude = {"Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng", "Thành tiền"};
        tableModel = new DefaultTableModel(tieude, 0);
        table = SwingHelper.createProjectJTable(tableModel);
        pCenter.add(new JScrollPane(table), BorderLayout.CENTER); 

        
        JPanel pnHD = new JPanel();
        pnHD.setLayout(new BoxLayout(pnHD, BoxLayout.Y_AXIS));
        pnHD.setBorder(BorderFactory.createTitledBorder("Hóa đơn"));
        String[] columns = {"Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng", "Thành tiền"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable tableHD = new JTable(model);

        // Thêm bảng vào JScrollPane
        JScrollPane scrollPaneHD = new JScrollPane(tableHD);

        // Thêm JScrollPane vào pnHD (panel Hóa đơn)
        pnHD.add(scrollPaneHD);
              

     // ==== Phần south: các nút điều khiển và thanh tìm kiếm ====
        JPanel pnSouth = new JPanel();
        pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.X_AXIS));
        // ====== Panel chứa các nút ======
        JPanel pnButtons = new JPanel();

        pnButtons.setBorder(BorderFactory.createTitledBorder("Chức năng"));
        JButton btnTaoDon = SwingHelper.createProjectJButton("Tạo đơn hàng");
        JButton btnLamMoi = SwingHelper.createProjectJButton("Làm mới");
        JButton btnThoat = SwingHelper.createProjectJButton("Thoát");
        pnButtons.add(btnTaoDon);
        pnButtons.add(btnLamMoi);
        pnButtons.add(btnThoat);

        // ====== Panel chứa thanh tìm kiếm ======
        JPanel pnSearch = new JPanel();
        pnSearch.setBorder(BorderFactory.createTitledBorder("Tìm kiếm"));
        JTextField txtTimKiem = new JTextField(15);
        JButton btnTim = SwingHelper.createProjectJButton("Tìm");
        pnSearch.add(SwingHelper.createProjectJLabel("Tìm sản phẩm:"));
        pnSearch.add(txtTimKiem);
        pnSearch.add(btnTim);

        // Gộp hai panel vào pnSouth
        pnSouth.add(pnSearch);
        pnSouth.add(Box.createHorizontalStrut(40));
        pnSouth.add(pnButtons);
        

        add(pnHD, BorderLayout.EAST);
        add(pnNorth, BorderLayout.NORTH);
        add(pCenter, BorderLayout.CENTER);
        add(pnSouth, BorderLayout.SOUTH);
        

        // === Xử lý sự kiện các nút ===

        // Nút Thoát: đóng cửa sổ nếu panel nằm trong JFrame
        btnThoat.addActionListener(e -> {
            SwingUtilities.getWindowAncestor(this).dispose();
        });

        // Nút Làm mới: reset các trường nhập
        btnLamMoi.addActionListener(e -> {
            txtMaKH.setText("");
            txtTenKH.setText("");
            txtSDT.setText("");
            txtDiaChi.setText("");
            txtMaDH.setText("");
            txtNgayTao.setText("");
            cboxNhanVien.setSelectedIndex(0);
            tableModel.setRowCount(0); // Xóa dữ liệu bảng
        });

        // Nút Tạo đơn hàng / Lưu
        btnTaoDon.addActionListener(e -> {
            String maDH = txtMaDH.getText().trim();
            String ngayTao = txtNgayTao.getText().trim();
            String tenNV = (String) cboxNhanVien.getSelectedItem();

            String maKH = txtMaKH.getText().trim();
            String tenKH = txtTenKH.getText().trim();
            String sdt = txtSDT.getText().trim();
            String diaChi = txtDiaChi.getText().trim();

            if (maDH.isEmpty() || ngayTao.isEmpty() || maKH.isEmpty() || tenKH.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
                return;
            }

            // TODO: Kết nối DB và thực hiện insert vào bảng DonHang
            // Ví dụ:
            // DonHangDAO.insert(maDH, ngayTao, maKH, tenNV);
            // Lặp qua tableModel để insert vào ChiTietDonHang

            JOptionPane.showMessageDialog(this, "Lưu đơn hàng thành công!");
        });

        
        
    }

}
