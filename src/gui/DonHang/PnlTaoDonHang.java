package gui.DonHang;

import utils.SwingHelper;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import dao.TaoDonHang_Dao;
import entity.SanPham;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serial;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PnlTaoDonHang extends JPanel implements ActionListener, MouseListener{
    @Serial
    private static final long serialVersionUID = 1L;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtMaDH;
	private JComboBox cboxNhanVien;
	private DefaultTableModel tableModel;
	private JTable table;
	private JComboBox cboxSanPham;
	private JLabel lblMaDon;
	private JLabel lblTenKH_HD;
	private JLabel lblNgayTao_HD;
	private JLabel lblNhanVien_HD;
	private JLabel lblSanPham_HD;
	private JLabel lblTongTien;
	private JLabel lblSDT_HD;
	
	private TaoDonHang_Dao taoDonHangDao;
	private JButton btnTaoDon;
	private JButton btnLamMoi;
	private JButton btnTim;
	private JTextField txtTimKiem;
	private JLabel lblDiaChi_HD;
	private JSpinner spinner;
	
	
    public PnlTaoDonHang() {
        setLayout(new BorderLayout());
        
        // phan north
        JPanel pnNorth = new JPanel();
        pnNorth.setLayout(new BoxLayout(pnNorth, BoxLayout.Y_AXIS));
        JLabel lblTitle = SwingHelper.createProjectJLabel("Tạo Hóa Đơn", 30);
       
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
        JLabel lblMaDH = SwingHelper.createProjectJLabel("Mã hóa đơn:");
        txtMaDH = new JTextField();
        
        JLabel lblNgayTao = SwingHelper.createProjectJLabel("Ngày lập:");

	     // Tạo SpinnerDateModel và JSpinner để chọn ngày
        spinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
        spinner.setEditor(editor);
        spinner.setPreferredSize(new Dimension(200, 20));

        // Thay đổi kích thước chữ của JSpinner
        Font font = new Font("Arial", Font.BOLD, 12); // Kích thước font là 16
        editor.getTextField().setFont(font);

        
        JLabel lblNhanVien = SwingHelper.createProjectJLabel("Tên nhân viên:");
        cboxNhanVien = new JComboBox();
        
        JLabel lblSanPham = SwingHelper.createProjectJLabel("Tên sản phẩm:");
        cboxSanPham = new JComboBox();
        
        
        p3.add(Box.createHorizontalStrut(10));
        p3.add(lblMaDH);
        p3.add(txtMaDH);
        p3.add(Box.createHorizontalStrut(15));
        p3.add(lblNgayTao);
        p3.add(spinner);
        p3.add(Box.createHorizontalStrut(320));
        
        p4.add(Box.createHorizontalStrut(10));
        p4.add(lblNhanVien);
        p4.add(cboxNhanVien);
        p4.add(Box.createHorizontalStrut(120));
        p4.add(lblSanPham);
        p4.add(cboxSanPham);
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
        lblSanPham.setPreferredSize(lblTenKH.getPreferredSize());
        
        // phan center
        JPanel pCenter = new JPanel();
        pCenter.setLayout(new BorderLayout()); 
        pCenter.setBorder(BorderFactory.createTitledBorder("Chi tiết sản phẩm"));
        String[] tieude = {"Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng", "Thành tiền"};
        tableModel = new DefaultTableModel(tieude, 0);
        table = SwingHelper.createProjectJTable(tableModel);
        pCenter.add(new JScrollPane(table), BorderLayout.CENTER); 

        
     // phần hóa đơn đẹp hơn
        JPanel pnHD = new JPanel();
        pnHD.setBorder(BorderFactory.createTitledBorder("Hóa đơn được tạo"));
        pnHD.setLayout(new BoxLayout(pnHD, BoxLayout.Y_AXIS));

        // Tiêu đề
        JLabel lblTitleHD = SwingHelper.createProjectJLabel("THÔNG TIN HÓA ĐƠN             ", 15);
        lblTitleHD.setAlignmentX(LEFT_ALIGNMENT);
        pnHD.add(lblTitleHD);
        pnHD.add(Box.createVerticalStrut(10));

        // Thông tin hóa đơn hiển thị dạng lưới
        JPanel pnHDInfo = new JPanel(new GridLayout(0, 2, 10, 10));
        pnHDInfo.setMaximumSize(new Dimension(350, 250));
        pnHDInfo.setAlignmentX(CENTER_ALIGNMENT);

        // Các label hiển thị (sau này bạn có thể gán .setText(...) để cập nhật)
        lblMaDon = new JLabel("...");
        lblTenKH_HD = new JLabel("...");
        lblSDT_HD = new JLabel("...");
        lblNgayTao_HD = new JLabel("...");
        lblNhanVien_HD = new JLabel("...");
        lblSanPham_HD = new JLabel("...");
        lblTongTien = new JLabel("...");
        lblDiaChi_HD = new JLabel("...");


        pnHDInfo.add(SwingHelper.createProjectJLabel("Mã hóa đơn:"));
        pnHDInfo.add(lblMaDon);

        pnHDInfo.add(SwingHelper.createProjectJLabel("Tên khách hàng:"));
        pnHDInfo.add(lblTenKH_HD);

        pnHDInfo.add(SwingHelper.createProjectJLabel("Số điện thoại:"));
        pnHDInfo.add(lblSDT_HD);
        
        pnHDInfo.add(SwingHelper.createProjectJLabel("Địa chỉ:"));
        pnHDInfo.add(lblDiaChi_HD);


        pnHDInfo.add(SwingHelper.createProjectJLabel("Ngày lập:"));
        pnHDInfo.add(lblNgayTao_HD);

        pnHDInfo.add(SwingHelper.createProjectJLabel("Nhân viên xử lý:"));
        pnHDInfo.add(lblNhanVien_HD);

        pnHDInfo.add(SwingHelper.createProjectJLabel("Tên sản phẩm:"));
        pnHDInfo.add(lblSanPham_HD);

        pnHDInfo.add(SwingHelper.createProjectJLabel("Tổng tiền:"));
        pnHDInfo.add(lblTongTien);

        pnHD.add(pnHDInfo);




     // ==== Phần south: các nút điều khiển và thanh tìm kiếm ====
        JPanel pnSouth = new JPanel();
        pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.X_AXIS));
        // ====== Panel chứa các nút ======
        JPanel pnButtons = new JPanel();

        pnButtons.setBorder(BorderFactory.createTitledBorder("Chức năng"));
        btnTaoDon = SwingHelper.createProjectJButton("Tạo đơn hàng");
        btnLamMoi = SwingHelper.createProjectJButton("Làm mới");
        JButton btnThoat = SwingHelper.createProjectJButton("Thoát");
        pnButtons.add(btnTaoDon);
        pnButtons.add(btnLamMoi);
        pnButtons.add(btnThoat);

        // ====== Panel chứa thanh tìm kiếm ======
        JPanel pnSearch = new JPanel();
        pnSearch.setBorder(BorderFactory.createTitledBorder("Tìm kiếm"));
        txtTimKiem = new JTextField(15);
        btnTim = SwingHelper.createProjectJButton("Tìm");
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
        btnTaoDon.addActionListener(this);
        btnTim.addActionListener(this);
        table.addMouseListener(this);
        btnLamMoi.addActionListener(this);
        cboxSanPham.addActionListener(this);  


        // Nút Thoát: đóng cửa sổ nếu panel nằm trong JFrame
        btnThoat.addActionListener(e -> {
            SwingUtilities.getWindowAncestor(this).dispose();
        });
              
        taoDonHangDao = new TaoDonHang_Dao();  // đảm bảo đã khởi tạo DAO
        loadSanPhamToTable();
        loadNhanVienToComboBox();
        loadSanPhamToComboBox();
    }
    
   

    private void loadSanPhamToTable() {
        tableModel.setRowCount(0); // Xóa dữ liệu cũ
        try {
            java.util.List<SanPham> list = taoDonHangDao.getSanPhamList();
            for (SanPham sp : list) {
                Object[] rowData = {
                    sp.getMaSP(),
                    sp.getTenSP(),
                    sp.getGiaBan(),
                    sp.getSoLuongTon(),
                    sp.getGiaBan() * sp.getSoLuongTon() // Thành tiền
                };
                tableModel.addRow(rowData);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu sản phẩm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
 // Tải danh sách nhân viên vào JComboBox
    private void loadNhanVienToComboBox() {
        try {
            // Lấy danh sách tên nhân viên từ DAO
            java.util.List<String> tenNhanVienList = taoDonHangDao.getTenNhanVienList();
            // Clear dữ liệu cũ trong comboBox
            cboxNhanVien.removeAllItems();
            // Thêm nhân viên vào ComboBox
            for (String tenNV : tenNhanVienList) {
                cboxNhanVien.addItem(tenNV);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu nhân viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Tải danh sách sản phẩm vào JComboBox
    private void loadSanPhamToComboBox() {
        try {
            // Lấy danh sách tên sản phẩm từ DAO
            java.util.List<String> tenSanPhamList = taoDonHangDao.getTenSanPhamList();
            // Clear dữ liệu cũ trong comboBox
            cboxSanPham.removeAllItems();
            // Thêm sản phẩm vào ComboBox
            for (String tenSP : tenSanPhamList) {
                cboxSanPham.addItem(tenSP);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu sản phẩm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }


	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == btnTaoDon) {
			taoDH();
		}
		if(o == btnLamMoi) {
			xoaRong();
            loadSanPhamToTable();
		}
		if(o == btnTim) {
			timkiem();
			txtTimKiem.setText("");
		}
		if (o == cboxSanPham) {        
		     loadSanPhamByTen();
		 }

	}




	private void loadSanPhamByTen() {
	    String tenSP = (String) cboxSanPham.getSelectedItem();
	    try {
	        // Lấy danh sách sản phẩm từ DAO
	        List<SanPham> sanPhamList = taoDonHangDao.getSanPhamList();
	        
	        // Xóa dữ liệu cũ trong bảng
	        tableModel.setRowCount(0);
	        
	        // Duyệt qua danh sách sản phẩm và thêm sản phẩm trùng tên vào bảng
	        for (SanPham sp : sanPhamList) {
	            if (sp.getTenSP().equalsIgnoreCase(tenSP)) { // Kiểm tra tên sản phẩm
	                Object[] rowData = {
	                    sp.getMaSP(),
	                    sp.getTenSP(),
	                    sp.getGiaBan(),
	                    sp.getSoLuongTon(),
	                    sp.getGiaBan() * sp.getSoLuongTon() // Thành tiền
	                };
	                tableModel.addRow(rowData);
	            }
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Lỗi khi tải sản phẩm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    }
	}






	private void timkiem() {
	    String keyword = txtTimKiem.getText().trim();

	    if (keyword.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sản phẩm cần tìm!", "Thông báo", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    SanPham ketQua = taoDonHangDao.timSanPhamByMa(keyword);

	    if (ketQua != null) {
	        tableModel.setRowCount(0); // Chỉ xoá nếu tìm thấy để thay thế bằng kết quả mới

	        Object[] rowData = {
	            ketQua.getMaSP(),
	            ketQua.getTenSP(),
	            ketQua.getGiaBan(),
	            ketQua.getSoLuongTon(),
	            ketQua.getGiaBan() * ketQua.getSoLuongTon()
	        };
	        tableModel.addRow(rowData);
	    } else {
	        JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        // KHÔNG xoá dữ liệu cũ trong bảng
	    }
	}


	private void xoaRong() {
		txtMaKH.setText("");
        txtTenKH.setText("");
        txtSDT.setText("");
        txtDiaChi.setText("");
        txtMaDH.setText("");
        spinner.setValue(new java.util.Date()); 
        cboxNhanVien.setSelectedIndex(0);
        cboxSanPham.setSelectedIndex(0);
		
	}
	// kiểm tra nhập liệu
	public boolean validData() {
        String maKhachHang = txtMaKH.getText().trim();
        String tenKhachHang = txtTenKH.getText().trim();
        String soDienThoai = txtSDT.getText().trim();
        String diaChi = txtDiaChi.getText().trim();
        String maDonHang = txtMaDH.getText().trim();

        if (maKhachHang.isEmpty() || tenKhachHang.isEmpty() || soDienThoai.isEmpty() || diaChi.isEmpty() || maDonHang.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không được để trống ô nhập liệu.");
            return false;
        }

        if (!maKhachHang.matches("^KH\\d{3}$")) {
            JOptionPane.showMessageDialog(null, "Mã khách hàng phải có dạng KH###.");
            txtMaKH.requestFocus();
            return false;
        }

        if (!tenKhachHang.matches("([A-Z][a-z]*)(\\s[A-Z][a-z]*)*")) {
            JOptionPane.showMessageDialog(null, "Tên khách hàng bắt đầu bằng kí tự hoa và ngăn cách bởi dấy phẩy.");
            txtTenKH.requestFocus();
            return false;
        }

        if (!soDienThoai.matches("^0\\d{9}$")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại phải bắt đầu bằng 0 và gồm 10 chữ số.");
            txtSDT.requestFocus();
            return false;
        }

        if (!maDonHang.matches("^DH\\d{3}$")) {
            JOptionPane.showMessageDialog(null, "Mã đơn hàng phải có dạng DH###.");
            txtMaDH.requestFocus();
            return false;
        }

        return true;
    }
	
	private void taoDH() {
		if(validData()) {
			lblMaDon.setText(txtMaDH.getText());
			lblTenKH_HD.setText(txtTenKH.getText());
			lblSDT_HD.setText(txtSDT.getText());
			lblDiaChi_HD.setText(txtDiaChi.getText());
			lblNgayTao_HD.setText(String.valueOf((Date)spinner.getValue()));
			lblNhanVien_HD.setText(cboxNhanVien.getSelectedItem().toString());
			lblSanPham_HD.setText(cboxSanPham.getSelectedItem().toString());
			// lblTongTien.setText(...) // bạn tự tính dựa trên bảng chi tiết sản phẩm
			JOptionPane.showMessageDialog(this, "Tạo hóa đơn thành công!!");
			xoaRong();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	    int selectedRow = table.getSelectedRow();
	    if (selectedRow != -1) {
	        String maSP = table.getValueAt(selectedRow, 0).toString();
	        String tenSP = table.getValueAt(selectedRow, 1).toString();
	        String donGia = table.getValueAt(selectedRow, 2).toString();
	        String soLuong = table.getValueAt(selectedRow, 3).toString();
	        String thanhTien = table.getValueAt(selectedRow, 4).toString();
	        
	        // Ví dụ: set vào các JLabel hoặc in log
	        System.out.println("Clicked SP: " + tenSP + ", SL: " + soLuong);
	        lblSanPham_HD.setText(tenSP);
	        // Có thể update lblTongTien nếu muốn...
	    }
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
