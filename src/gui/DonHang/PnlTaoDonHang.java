package gui.DonHang;

import utils.SwingHelper;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.TaoDonHang_Dao;
import entity.SanPham;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.text.SimpleDateFormat;
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
	private JLabel lblSanPham_HD;
	
	private TaoDonHang_Dao taoDonHangDao;
	private JButton btnTaoDon;
	private JButton btnLamMoi;
	private JButton btnTim;
	private JTextField txtTimKiem;
	private JLabel lblDiaChi_HD;
	private JSpinner spinner;
	private JTextField txtSoLuong;
	private JLabel lblMaNV_HD;
	private JLabel lblMaSP_HD;
	private JLabel lblDonGia_HD;
	private JLabel lblSoLuong_HD;
	private JLabel lblThanhTien_HD;
	private JLabel lblTenNV_HD;
	private JButton btnXuatHD;
	private JLabel lblMaKH_HD;
	private JTextField txtEmail;
	
	
    public PnlTaoDonHang() {
        setLayout(new BorderLayout());
        
        // phan north
        JPanel pnNorth = new JPanel();
        pnNorth.setLayout(new BoxLayout(pnNorth, BoxLayout.Y_AXIS));
        JLabel lblTitle = SwingHelper.createProjectJLabel("Tạo Hóa Đơn", 30);
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel titlePanel = new JPanel();
        titlePanel.add(lblTitle);
       
        // Phần thông tin khách hàng
        JPanel pnKH = new JPanel();
        pnKH.setLayout(new BoxLayout(pnKH, BoxLayout.Y_AXIS));
        pnKH.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));

        JPanel pnMaTenKH = new JPanel(); 
        pnMaTenKH.setLayout(new BoxLayout(pnMaTenKH, BoxLayout.X_AXIS));
        JPanel pnSDTDiaChi = new JPanel(); 
        pnSDTDiaChi.setLayout(new BoxLayout(pnSDTDiaChi, BoxLayout.X_AXIS));
        JPanel pnEmail = new JPanel(); 
        pnEmail.setLayout(new BoxLayout(pnEmail, BoxLayout.X_AXIS));

        JLabel lblMaKH = SwingHelper.createProjectJLabel("Mã khách hàng:");
        txtMaKH = new JTextField();
        JLabel lblTenKH = SwingHelper.createProjectJLabel("Tên khách hàng:");
        txtTenKH = new JTextField();
        JLabel lblSDT = SwingHelper.createProjectJLabel("Số điện thoại:");
        txtSDT = new JTextField();
        JLabel lblDiaChi = SwingHelper.createProjectJLabel("Địa chỉ:");
        txtDiaChi = new JTextField();
        JLabel lblEmail = SwingHelper.createProjectJLabel("Email:");
        txtEmail = new JTextField(); 

        // Đồng bộ kích thước nhãn
        Dimension labelSize = lblTenKH.getPreferredSize();
        lblMaKH.setPreferredSize(labelSize);
        lblSDT.setPreferredSize(labelSize);
        lblDiaChi.setPreferredSize(labelSize);
        lblEmail.setPreferredSize(labelSize); 


        Dimension inputSize = new Dimension(150, 20);

        // Thêm vào pnMaTenKH
        pnMaTenKH.add(Box.createHorizontalStrut(10));
        pnMaTenKH.add(lblMaKH);
        pnMaTenKH.add(txtMaKH);
        pnMaTenKH.add(Box.createHorizontalStrut(20));
        pnMaTenKH.add(lblTenKH);
        pnMaTenKH.add(txtTenKH);
        pnMaTenKH.add(Box.createHorizontalStrut(10));

        // Thêm vào pnSDTDiaChi
        pnSDTDiaChi.add(Box.createHorizontalStrut(10));
        pnSDTDiaChi.add(lblSDT);
        pnSDTDiaChi.add(txtSDT);
        pnSDTDiaChi.add(Box.createHorizontalStrut(20));
        pnSDTDiaChi.add(lblDiaChi);
        pnSDTDiaChi.add(txtDiaChi);
        pnSDTDiaChi.add(Box.createHorizontalStrut(10));

        // Thêm vào pnEmail
        pnEmail.add(Box.createHorizontalStrut(10));
        pnEmail.add(lblEmail);
        pnEmail.add(txtEmail);
        pnEmail.add(Box.createHorizontalStrut(665));

        // Thêm vào pnKH
        pnKH.add(Box.createVerticalStrut(10));
        pnKH.add(pnMaTenKH);
        pnKH.add(Box.createVerticalStrut(10));
        pnKH.add(pnSDTDiaChi);
        pnKH.add(Box.createVerticalStrut(10));
        pnKH.add(pnEmail);
        pnKH.add(Box.createVerticalStrut(10));

        // Phần thông tin đơn hàng
        JPanel pnDH = new JPanel();
        pnDH.setBorder(BorderFactory.createTitledBorder("Thông tin đơn hàng"));
        pnDH.setLayout(new BoxLayout(pnDH, BoxLayout.Y_AXIS));

        // Tạo các panel con
        JPanel pnMaDHNhanVien = new JPanel(); // Thay p3
        pnMaDHNhanVien.setLayout(new BoxLayout(pnMaDHNhanVien, BoxLayout.X_AXIS));
        JPanel pnNgaySanPham = new JPanel(); // Thay p4
        pnNgaySanPham.setLayout(new BoxLayout(pnNgaySanPham, BoxLayout.X_AXIS));
        JPanel pnSoLuong = new JPanel(); // Thay p5
        pnSoLuong.setLayout(new BoxLayout(pnSoLuong, BoxLayout.X_AXIS));

        // Tạo nhãn và trường nhập liệu
        JLabel lblMaDH = SwingHelper.createProjectJLabel("Mã hóa đơn:");
        txtMaDH = new JTextField();
        JLabel lblNgayTao = SwingHelper.createProjectJLabel("Ngày lập:");
        spinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
        spinner.setEditor(editor);
        JLabel lblNhanVien = SwingHelper.createProjectJLabel("Tên nhân viên:");
        cboxNhanVien = new JComboBox();
        JLabel lblSanPham = SwingHelper.createProjectJLabel("Tên sản phẩm:");
        cboxSanPham = new JComboBox();
        JLabel lblSoLuong = SwingHelper.createProjectJLabel("Số lượng:");
        txtSoLuong = new JTextField();

        // Cài đặt font và kích thước
        Font font = new Font("Arial", Font.BOLD, 12);
        editor.getTextField().setFont(font);

        // Đồng bộ kích thước nhãn
        lblMaDH.setPreferredSize(labelSize);
        lblNgayTao.setPreferredSize(labelSize);
        lblNhanVien.setPreferredSize(labelSize);
        lblSanPham.setPreferredSize(labelSize);
        lblSoLuong.setPreferredSize(labelSize);

        // Đồng bộ kích thước trường nhập liệu
        txtMaDH.setPreferredSize(inputSize);
        spinner.setPreferredSize(inputSize);
        cboxNhanVien.setPreferredSize(inputSize);
        cboxSanPham.setPreferredSize(inputSize);
        txtSoLuong.setPreferredSize(inputSize);

        // Thêm vào panel pnMaDHNhanVien: Mã hóa đơn và Tên nhân viên
        pnMaDHNhanVien.add(Box.createHorizontalStrut(10));
        pnMaDHNhanVien.add(lblMaDH);
        pnMaDHNhanVien.add(txtMaDH);
        pnMaDHNhanVien.add(Box.createHorizontalStrut(20));
        pnMaDHNhanVien.add(lblNhanVien);
        pnMaDHNhanVien.add(cboxNhanVien);
        pnMaDHNhanVien.add(Box.createHorizontalStrut(370));

        // Thêm vào panel pnNgaySanPham: Ngày lập và Tên sản phẩm
        pnNgaySanPham.add(Box.createHorizontalStrut(10));
        pnNgaySanPham.add(lblNgayTao);
        pnNgaySanPham.add(spinner);
        pnNgaySanPham.add(Box.createHorizontalStrut(20));
        pnNgaySanPham.add(lblSanPham);
        pnNgaySanPham.add(cboxSanPham);
        pnNgaySanPham.add(Box.createHorizontalStrut(10));

        // Thêm vào panel pnSoLuong: Số lượng
        pnSoLuong.add(Box.createHorizontalStrut(10));
        pnSoLuong.add(lblSoLuong);
        pnSoLuong.add(txtSoLuong);
        pnSoLuong.add(Box.createHorizontalStrut(665)); 

        // Thêm các panel con vào pnDH
        pnDH.add(Box.createVerticalStrut(10));
        pnDH.add(pnMaDHNhanVien);
        pnDH.add(Box.createVerticalStrut(10));
        pnDH.add(pnNgaySanPham);
        pnDH.add(Box.createVerticalStrut(10));
        pnDH.add(pnSoLuong);
        pnDH.add(Box.createVerticalStrut(10));

        pnNorth.add(lblTitle);
        pnNorth.add(pnKH);
        pnNorth.add(pnDH);
        
        // phan center
        JPanel pCenter = new JPanel();
        pCenter.setLayout(new BorderLayout()); 
        pCenter.setBorder(BorderFactory.createTitledBorder("Chi tiết sản phẩm"));
        String[] tieude = {"Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng tồn", "Loại sản phẩm"};
        tableModel = new DefaultTableModel(tieude, 0);
        table = SwingHelper.createProjectJTable(tableModel);
        pCenter.add(new JScrollPane(table), BorderLayout.CENTER); 

        
     // Phần hóa đơn đẹp hơn
        JPanel pnHD = new JPanel();
        pnHD.setBackground(new Color(255, 245, 245)); 

        TitledBorder borderHD = BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.RED, 2), "HÓA ĐƠN"
        );
        borderHD.setTitleColor(new Color(220, 20, 60));
        borderHD.setTitleFont(new Font("Arial", Font.BOLD, 16)); 
        pnHD.setBorder(borderHD);

        pnHD.setLayout(new BoxLayout(pnHD, BoxLayout.Y_AXIS));

        // Tiêu đề
        JLabel lblTitleHD = SwingHelper.createProjectJLabel("THÔNG TIN HÓA ĐƠN", 20);
        lblTitleHD.setForeground(new Color(178, 34, 34)); 
        lblTitleHD.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnHD.add(lblTitleHD);
        pnHD.add(Box.createVerticalStrut(15));

        // Panel thông tin hóa đơn
        JPanel pnHDInfo = new JPanel(new GridLayout(8, 2, 12, 12)); 
        pnHDInfo.setBackground(new Color(255, 245, 245));
        pnHDInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnHDInfo.setMaximumSize(new Dimension(450, 320)); 

        // Tạo nhãn giá trị
        lblMaDon = SwingHelper.createProjectJLabel("...");
        lblMaKH_HD = SwingHelper.createProjectJLabel("...");
        lblMaSP_HD = SwingHelper.createProjectJLabel("...");
        lblTenNV_HD = SwingHelper.createProjectJLabel("...");
        lblNgayTao_HD = SwingHelper.createProjectJLabel("...");
        lblDonGia_HD = SwingHelper.createProjectJLabel("...");
        lblSoLuong_HD = SwingHelper.createProjectJLabel("...");
        lblThanhTien_HD = SwingHelper.createProjectJLabel("...");

        // Thêm nhãn và giá trị vào grid
        pnHDInfo.add(SwingHelper.createProjectJLabel("Mã hóa đơn:"));
        pnHDInfo.add(lblMaDon);

        pnHDInfo.add(SwingHelper.createProjectJLabel("Mã khách hàng:"));
        pnHDInfo.add(lblMaKH_HD);

        pnHDInfo.add(SwingHelper.createProjectJLabel("Mã sản phẩm:"));
        pnHDInfo.add(lblMaSP_HD);

        pnHDInfo.add(SwingHelper.createProjectJLabel("Tên nhân viên:"));
        pnHDInfo.add(lblTenNV_HD);

        pnHDInfo.add(SwingHelper.createProjectJLabel("Ngày lập hóa đơn:"));
        pnHDInfo.add(lblNgayTao_HD);

        pnHDInfo.add(SwingHelper.createProjectJLabel("Đơn giá:"));
        pnHDInfo.add(lblDonGia_HD);

        pnHDInfo.add(SwingHelper.createProjectJLabel("Số lượng:"));
        pnHDInfo.add(lblSoLuong_HD);

        pnHDInfo.add(SwingHelper.createProjectJLabel("Thành tiền:"));
        pnHDInfo.add(lblThanhTien_HD);

        // Thêm vào panel chính
        pnHD.add(pnHDInfo);

        // Nút lưu hóa đơn
        pnHD.add(Box.createVerticalStrut(20));
        btnXuatHD = SwingHelper.createProjectJButton("Xuất hóa đơn", "export.png");
        btnXuatHD.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnHD.add(btnXuatHD);

     // ==== Phần south: các nút điều khiển và thanh tìm kiếm ====
        JPanel pnSouth = new JPanel();
        pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.X_AXIS));
        // ====== Panel chứa các nút ======
        JPanel pnButtons = new JPanel();

        pnButtons.setBorder(BorderFactory.createTitledBorder("Chức năng"));
        btnTaoDon = SwingHelper.createProjectJButton("Tạo hóa đơn", "icons8-add-50.png");
        btnLamMoi = SwingHelper.createProjectJButton("Làm mới", "icons8-reload-50.png");
        pnButtons.add(btnTaoDon);
        pnButtons.add(btnLamMoi);

        // ====== Panel chứa thanh tìm kiếm ======
        JPanel pnSearch = new JPanel();
        pnSearch.setBorder(BorderFactory.createTitledBorder("Tìm kiếm"));
        txtTimKiem = new JTextField(15);
        btnTim = SwingHelper.createProjectJButton("Tìm", "search.png");
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
        btnXuatHD.addActionListener(this);

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
                    sp.getLoaiSP() 
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
            cboxSanPham.addItem("-- Chọn sản phẩm --");
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
		if(o == btnXuatHD) {
            xuatHoaDon();
		}
	}

    private void xuatHoaDon() {
        try {
            String maHD = lblMaDon.getText();
            String maSP = lblMaSP_HD.getText();
            String tenNV = lblTenNV_HD.getText();
            String ngayLapStr = lblNgayTao_HD.getText();
            double donGia = Double.parseDouble(lblDonGia_HD.getText());
            int soLuong = Integer.parseInt(lblSoLuong_HD.getText());
            double thanhTien = Double.parseDouble(lblThanhTien_HD.getText());
            String maKH = lblMaKH_HD.getText();

            String maNhanVien = taoDonHangDao.getMaNhanVienByTen(tenNV);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = sdf.parse(ngayLapStr);
            java.sql.Date ngayLapHD = new java.sql.Date(utilDate.getTime());

            boolean insertedKh = false;
            try {
                insertedKh = taoDonHangDao.insertKhachHang(maKH, txtTenKH.getText(), txtDiaChi.getText(), txtSDT.getText(), txtEmail.getText());
                if (!insertedKh) {
                    JOptionPane.showMessageDialog(null, "Không thể thêm khách hàng - Mã khách hàng có thể đã tồn tại!");
                    return;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Lỗi khi thêm khách hàng: " + e.getMessage());
                return;
            }

            boolean insertedHD = false;
            try {
                insertedHD = taoDonHangDao.insertHoaDon(maHD, ngayLapHD, thanhTien, maKH, maNhanVien);
                if (!insertedHD) {
                    JOptionPane.showMessageDialog(null, "Không thể thêm hóa đơn - Mã hóa đơn có thể đã tồn tại!");
                    return;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Lỗi khi thêm hóa đơn: " + e.getMessage());
                return;
            }

            boolean insertedCT = false;
            try {
                insertedCT = taoDonHangDao.insertChiTietHoaDon(maHD, maSP, soLuong, donGia);
                if (!insertedCT) {
                    JOptionPane.showMessageDialog(null, "Không thể thêm chi tiết hóa đơn!");
                    return;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Lỗi khi thêm chi tiết hóa đơn: " + e.getMessage());
                return;
            }

            // Sau khi lưu thành công vào database, xuất file txt
            File cacheDir = new File("C:\\componentShopCache");
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }

            // Tạo tên file với timestamp
            java.time.LocalDateTime now = java.time.LocalDateTime.now();
            String fileName = "HoaDon_" + maHD + "_" + now.getYear() + now.getMonthValue() +
                    now.getDayOfMonth() + "_" + now.getHour() + now.getMinute() + ".txt";
            File txtFile = new File(cacheDir, fileName);

            try (OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream(txtFile), java.nio.charset.StandardCharsets.UTF_8);
                 BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

                // Add UTF-8 BOM
                bufferedWriter.write('\ufeff');

                bufferedWriter.write("===========================================");
                bufferedWriter.newLine();
                bufferedWriter.write("             HÓA ĐƠN BÁN HÀNG             ");
                bufferedWriter.newLine();
                bufferedWriter.write("===========================================");
                bufferedWriter.newLine();
                bufferedWriter.newLine();

                bufferedWriter.write("Mã hóa đơn: " + maHD);
                bufferedWriter.newLine();
                bufferedWriter.write("Ngày lập: " + ngayLapStr);
                bufferedWriter.newLine();
                bufferedWriter.write("Nhân viên: " + tenNV);
                bufferedWriter.newLine();
                bufferedWriter.newLine();

                bufferedWriter.write("THÔNG TIN KHÁCH HÀNG:");
                bufferedWriter.newLine();
                bufferedWriter.write("Mã khách hàng: " + maKH);
                bufferedWriter.newLine();
                bufferedWriter.write("Tên khách hàng: " + txtTenKH.getText());
                bufferedWriter.newLine();
                bufferedWriter.write("Số điện thoại: " + txtSDT.getText());
                bufferedWriter.newLine();
                bufferedWriter.write("Địa chỉ: " + txtDiaChi.getText());
                bufferedWriter.newLine();
                bufferedWriter.write("Email: " + txtEmail.getText());
                bufferedWriter.newLine();
                bufferedWriter.newLine();

                bufferedWriter.write("CHI TIẾT SẢN PHẨM:");
                bufferedWriter.newLine();
                bufferedWriter.write(String.format("%-15s %-30s %-15s %-10s %-15s",
                        "Mã SP", "Tên SP", "Đơn giá", "Số lượng", "Thành tiền"));
                bufferedWriter.newLine();

                // Lấy tên sản phẩm từ bảng
                String tenSP = "";
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    if (tableModel.getValueAt(i, 0).equals(maSP)) {
                        tenSP = tableModel.getValueAt(i, 1).toString();
                        break;
                    }
                }

                bufferedWriter.write(String.format("%-15s %-30s %-15.2f %-10d %-15.2f",
                        maSP, tenSP, donGia, soLuong, thanhTien));
                bufferedWriter.newLine();
                bufferedWriter.newLine();
                bufferedWriter.write("===========================================");
                bufferedWriter.newLine();
                bufferedWriter.write(String.format("TỔNG TIỀN: %.2f VNĐ", thanhTien));
                bufferedWriter.newLine();
                bufferedWriter.write("===========================================");
                bufferedWriter.newLine();
                bufferedWriter.write("        Cảm ơn quý khách đã mua hàng!     ");
                bufferedWriter.newLine();

                int option = JOptionPane.showConfirmDialog(
                        this,
                        "Xuất hóa đơn thành công tại:\n" + txtFile.getAbsolutePath() + "\nBạn có muốn mở file?",
                        "Xuất hóa đơn thành công",
                        JOptionPane.YES_NO_OPTION
                );

                if (option == JOptionPane.YES_OPTION) {
                    openFile(txtFile);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi xuất hóa đơn: " + e.getMessage());
                e.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "Lưu và xuất hóa đơn thành công!");
            xoaTrangHoaDon();
            xoaRong();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi xuất hóa đơn: " + ex.getMessage());
        }
    }

	private void xoaTrangHoaDon() {
		lblMaDon.setText("");
		lblMaKH_HD.setText("");
		lblMaSP_HD.setText("");
		lblTenNV_HD.setText("");
		lblNgayTao_HD.setText("");
		lblDonGia_HD.setText("");
		lblSoLuong_HD.setText("");
		lblThanhTien_HD.setText("");
	}

	private void loadSanPhamByTen() {
	    String tenSP = (String) cboxSanPham.getSelectedItem();
	    try {
	        // Lấy danh sách sản phẩm từ DAO
	        List<SanPham> sanPhamList = taoDonHangDao.getSanPhamList();
	        if (cboxSanPham.getSelectedIndex() <= 0) return; // bỏ qua dòng mặc định

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
	                    sp.getLoaiSP()
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

	    SanPham ketQua = taoDonHangDao.getSanPhamByMa(keyword);

	    if (ketQua != null) {
	        tableModel.setRowCount(0); // Chỉ xoá nếu tìm thấy để thay thế bằng kết quả mới

	        Object[] rowData = {
	            ketQua.getMaSP(),
	            ketQua.getTenSP(),
	            ketQua.getGiaBan(),
	            ketQua.getSoLuongTon(),
	            ketQua.getLoaiSP()
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
		txtSoLuong.setText("");
		txtEmail.setText("");
	}
	// kiểm tra nhập liệu
	public boolean validData() {
	    String maKhachHang = txtMaKH.getText().trim();
	    String tenKhachHang = txtTenKH.getText().trim();
	    String soDienThoai = txtSDT.getText().trim();
	    String diaChi = txtDiaChi.getText().trim();
	    String maDonHang = txtMaDH.getText().trim();
	    String soLuong = txtSoLuong.getText().trim();
	    String email = txtEmail.getText().trim();

	    if (maKhachHang.isEmpty() || tenKhachHang.isEmpty() || soDienThoai.isEmpty() || diaChi.isEmpty() || maDonHang.isEmpty() || soLuong.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Không được để trống ô nhập liệu.");
	        return false;
	    }

	    if (!maKhachHang.matches("^KH\\d{3}$")) {
	        JOptionPane.showMessageDialog(null, "Mã khách hàng phải có dạng KH###.");
	        txtMaKH.requestFocus();
	        return false;
	    }

	    if (!tenKhachHang.matches("([A-Z][a-z]*)(\\s[A-Z][a-z]*)*")) {
	        JOptionPane.showMessageDialog(null, "Tên khách hàng bắt đầu bằng kí tự hoa và ngăn cách bởi dấu cách.");
	        txtTenKH.requestFocus();
	        return false;
	    }

	    if (!soDienThoai.matches("^0\\d{9}$")) {
	        JOptionPane.showMessageDialog(null, "Số điện thoại phải bắt đầu bằng 0 và gồm 10 chữ số.");
	        txtSDT.requestFocus();
	        return false;
	    }
	    if (!email.matches("[\\w]+@gmail\\.com")) {
	        JOptionPane.showMessageDialog(null, "Email phải theo định dạng @gmai.com");
	        txtEmail.requestFocus();
	        return false;
	    }
	    if (!maDonHang.matches("^HD\\d{3}$")) {
	        JOptionPane.showMessageDialog(null, "Mã HD phải có dạng HD###.");
	        txtMaDH.requestFocus();
	        return false;
	    }

	    Object soLuongTon =  table.getValueAt(0, 3);
	    // Kiểm tra số lượng phải là số nguyên dương
	    if (!soLuong.matches("\\d+") || Integer.parseInt(soLuong) <= 0 ) {
	        JOptionPane.showMessageDialog(null, "Số lượng phải là số nguyên dương lớn hơn 0");
	        txtSoLuong.requestFocus();
	        return false;
	    }
	    if (Integer.parseInt(soLuong) > Integer.parseInt(soLuongTon.toString())) {
	        JOptionPane.showMessageDialog(null, "Số lượng phải nhỏ hơn hoặc bằng số lượng tồn.");
	        txtSoLuong.requestFocus();
	        return false;
	    }

	    return true;
	}

	private void taoDH() {
	    if (validData()) {
	        // Lấy dữ liệu từ bảng
	        String maDH = txtMaDH.getText();
	        String tenNV = (String) cboxNhanVien.getSelectedItem();  
	        String maSP = tableModel.getValueAt(0, 0).toString();
	        String maKH = txtMaKH.getText();
	        String donGiaStr = tableModel.getValueAt(0, 2).toString(); 
	        String soLuongStr = txtSoLuong.getText(); 

	        // Tính thành tiền
	        int soLuong = Integer.parseInt(soLuongStr);
	        double donGia = Double.parseDouble(donGiaStr);
	        double thanhTien = soLuong * donGia;

	        // Cập nhật các JLabel trong pnHD
	        lblMaDon.setText(maDH);
	        lblMaKH_HD.setText(maKH);
	        lblTenNV_HD.setText(tenNV);
	        lblMaSP_HD.setText(maSP);
	        lblNgayTao_HD.setText(java.time.LocalDate.now().toString());
	        lblDonGia_HD.setText(String.format("%.2f", donGia));
	        lblSoLuong_HD.setText(String.valueOf(soLuong));
	        lblThanhTien_HD.setText(String.format("%.2f", thanhTien));
	    }
	}

    private void openFile(File file) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Không thể tự động mở file. File được lưu tại:\n" + file.getAbsolutePath());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Lỗi khi mở file: " + e.getMessage(),
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
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
