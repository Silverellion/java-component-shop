package gui.Kho;

import utils.SwingHelper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serial;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.NhapHang_Dao;
import entity.NhaCungCap;
import entity.SanPham;

public class PnlNhapHang extends JPanel implements ActionListener, MouseListener{
	@Serial
	private static final long serialVersionUID = 1L;
	private JLabel lblMaSP;
	private JTextField txtMaSP;
	private JLabel lblTenSP;
	private JTextField txtTenSP;
	private JLabel lblLoaiSP;
	private JTextField txtLoaiSP;
	private JTextField txtGiaSP;
	private JLabel lblGiaSP;
	private JLabel lblSoLuong;
	private JTextField txtSoLuong;
	private JButton btnXoaTrang;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnThem;
	private DefaultTableModel tableModel;
	private JTable table;
	private JLabel lblNCC;
	private JButton btnTim;
	private JTextField txtTim;
	private JLabel lblTim;
	private NhapHang_Dao nhapHangDao = new NhapHang_Dao();
	private ArrayList<NhaCungCap> dsNCC;
	private JComboBox<String> cboxNCC;
	
	public PnlNhapHang() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel lblTitle = SwingHelper.createProjectJLabel("Nhập hàng", 30);
		lblTitle.setAlignmentX(CENTER_ALIGNMENT);
		add(lblTitle);

		JPanel pThongTin=new JPanel();
		pThongTin.setLayout(new BoxLayout(pThongTin, BoxLayout.Y_AXIS));
		pThongTin.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Thông tin sản phẩm", 
				TitledBorder.LEFT, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 20))
        );
		
		JPanel pMaSP=new JPanel();
		pMaSP.setLayout(new BoxLayout(pMaSP, BoxLayout.X_AXIS));
		pMaSP.add(Box.createHorizontalStrut(5));
		pMaSP.add(lblMaSP=SwingHelper.createProjectJLabel("Mã sản phẩm:  "));
		pMaSP.add(txtMaSP=new JTextField());
		pMaSP.add(Box.createHorizontalStrut(700));
		JPanel pTenSP=new JPanel();
		pTenSP.setLayout(new BoxLayout(pTenSP, BoxLayout.X_AXIS));
		pTenSP.add(Box.createHorizontalStrut(5));
		pTenSP.add(lblTenSP=SwingHelper.createProjectJLabel("Tên sản phẩm:"));
		pTenSP.add(txtTenSP=new JTextField());
		JPanel pLoaiSP=new JPanel();
		pLoaiSP.setLayout(new BoxLayout(pLoaiSP, BoxLayout.X_AXIS));
		pLoaiSP.add(Box.createHorizontalStrut(5));
		pLoaiSP.add(lblLoaiSP=SwingHelper.createProjectJLabel("Loại sản phẩm:  "));
		pLoaiSP.add(txtLoaiSP=new JTextField());
		JPanel pGiaSP=new JPanel();
		pGiaSP.setLayout(new BoxLayout(pGiaSP, BoxLayout.X_AXIS));
		pGiaSP.add(Box.createHorizontalStrut(5));
		pGiaSP.add(lblGiaSP=SwingHelper.createProjectJLabel("Giá sản phẩm:"));
		pGiaSP.add(txtGiaSP=new JTextField());
		JPanel pSoLuongTon=new JPanel();
		pSoLuongTon.setLayout(new BoxLayout(pSoLuongTon, BoxLayout.X_AXIS));
		pSoLuongTon.add(Box.createHorizontalStrut(5));
		pSoLuongTon.add(lblSoLuong=SwingHelper.createProjectJLabel("Số lượng tồn:"));
		pSoLuongTon.add(txtSoLuong=new JTextField());
		JPanel pNhaCungCap=new JPanel();
		pNhaCungCap.setLayout(new BoxLayout(pNhaCungCap, BoxLayout.X_AXIS));
		pNhaCungCap.add(Box.createHorizontalStrut(5));
		pNhaCungCap.add(lblNCC=SwingHelper.createProjectJLabel("Nhà cung cấp:"));
		pNhaCungCap.add(cboxNCC=new JComboBox<String>());
		cboxNCC.addItem("Intel");
		cboxNCC.addItem("XMD");
		cboxNCC.addItem("Snapdragon");

		lblMaSP.setPreferredSize(lblLoaiSP.getPreferredSize());
		lblTenSP.setPreferredSize(lblLoaiSP.getPreferredSize());
		lblGiaSP.setPreferredSize(lblLoaiSP.getPreferredSize());
		lblSoLuong.setPreferredSize(lblLoaiSP.getPreferredSize());
		lblNCC.setPreferredSize(lblLoaiSP.getPreferredSize());
		
		JPanel pNut=new JPanel();
		JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JPanel pTim=new JPanel();
		pTim.add(lblTim=SwingHelper.createProjectJLabel("Nhập mã sản phẩm cần tìm: "));
		pTim.add(txtTim=new JTextField(20));
		pTim.add(btnTim=SwingHelper.createProjectJButton("Tìm"));
		JPanel pButton=new JPanel();
		pButton.add(btnThem = SwingHelper.createProjectJButton("Thêm", "icons8-add-50.png"));
		pButton.add(btnSua=SwingHelper.createProjectJButton("Cập nhật", "icons8-up-50.png"));
		pButton.add(btnXoa=SwingHelper.createProjectJButton("Xóa", "icons8-delete-50.png"));
		pButton.add(btnXoaTrang=SwingHelper.createProjectJButton("Làm mới", "icons8-reload-50.png"));
		split.add(pTim);
		split.add(pButton);
		pNut.add(split);
		
		String[] headers="Mã Sản Phẩm;Tên Sản Phẩm;Loại Sản Phẩm;Giá Bán;Số Lượng Tồn;Nhà Cung Cấp".split(";");
		tableModel=new DefaultTableModel(headers, 0);
		JScrollPane scroll=new JScrollPane();
		scroll.setViewportView(table= SwingHelper.createProjectJTable(tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		
		add(Box.createVerticalStrut(5));
		pThongTin.add(pMaSP);
		pThongTin.add(Box.createVerticalStrut(5));
		pThongTin.add(pTenSP);
		pThongTin.add(Box.createVerticalStrut(5));
		pThongTin.add(pLoaiSP);
		pThongTin.add(Box.createVerticalStrut(5));
		pThongTin.add(pGiaSP);
		pThongTin.add(Box.createVerticalStrut(5));
		pThongTin.add(pSoLuongTon);
		pThongTin.add(Box.createVerticalStrut(5));
		pThongTin.add(pNhaCungCap);
		add(pThongTin);
		add(Box.createVerticalStrut(5));
		add(scroll);
		add(Box.createVerticalStrut(5));
		add(pNut);
		
		table.addMouseListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnTim.addActionListener(this);
		
		hienTable();
		loadComboBoxNCC();
	}
	
	private void loadComboBoxNCC() {
	    dsNCC = nhapHangDao.getAllNhaCungCap();
	    cboxNCC.removeAllItems();
	    for (NhaCungCap ncc : dsNCC) {
	        cboxNCC.addItem(ncc.getTenNCC());
	    }
	}

	
	public void hienTable() {
	    tableModel.setRowCount(0);
	    for (SanPham sp : nhapHangDao.getAllSanPham()) {
	        tableModel.addRow(new Object[]{
	            sp.getMaSP(),
	            sp.getTenSP(),
	            sp.getLoaiSP(),
	            sp.getGiaBan(),
	            sp.getSoLuongTon(),
	            sp.getNcc().getTenNCC()
	        });
	    }
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btnTim)) {
			timActions();
		}else if(o.equals(btnThem)) {
			themActions();
		}else if(o.equals(btnSua)) {
			suaActions();
		}else if(o.equals(btnXoaTrang)) {
			xoaTrangActions();
		}else if(o.equals(btnXoa)) {
			xoaActions();
		}
	}
	
	private boolean validateData() {
	    String maSP = txtMaSP.getText().trim();
	    String tenSP = txtTenSP.getText().trim();
	    String loaiSP = txtLoaiSP.getText().trim();
	    String giaStr = txtGiaSP.getText().trim();
	    String soLuongStr = txtSoLuong.getText().trim();
	    
	    // Regex cho maSP: SP + 3 chữ số
	    if (!maSP.matches("^SP\\d{3}$")) {
	        JOptionPane.showMessageDialog(this, "Mã sản phẩm phải có dạng SP + 3 chữ số (ví dụ: SP001).");
	        txtMaSP.requestFocus();
	        return false;
	    }
	    
	    // Tên sản phẩm không được để trống, cho phép chữ cái, số và khoảng trắng
	    if (!tenSP.matches("^[\\p{L}0-9\\s]+$")) {
	        JOptionPane.showMessageDialog(this, "Tên sản phẩm không được để trống và chỉ chứa chữ, số, khoảng trắng.");
	        txtTenSP.requestFocus();
	        return false;
	    }
	    
	    // Loại sản phẩm không được để trống
	    if (loaiSP.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Loại sản phẩm không được để trống.");
	        txtLoaiSP.requestFocus();
	        return false;
	    }
	    
	    // Giá bán phải là số > 0
	    try {
	        double gia = Double.parseDouble(giaStr);
	        if (gia <= 0) {
	            JOptionPane.showMessageDialog(this, "Giá bán phải lớn hơn 0.");
	            txtGiaSP.requestFocus();
	            return false;
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Giá bán phải là số hợp lệ.");
	        txtGiaSP.requestFocus();
	        return false;
	    }
	    
	    // Số lượng tồn phải là số nguyên >= 0
	    try {
	        int soLuong = Integer.parseInt(soLuongStr);
	        if (soLuong < 0) {
	            JOptionPane.showMessageDialog(this, "Số lượng tồn phải lớn hơn hoặc bằng 0.");
	            txtSoLuong.requestFocus();
	            return false;
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Số lượng tồn phải là số nguyên hợp lệ.");
	        txtSoLuong.requestFocus();
	        return false;
	    }
	    
	    return true; // Nếu tất cả hợp lệ
	}

	
	private void suaActions() {
		if (!validateData()) 
			return; // Thoát nếu dữ liệu sai
		 try {
		        SanPham sp = getSanPhamFromFields();
		        if (nhapHangDao.suaSanPham(sp)) {
		            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
		            hienTable();
		        } else {
		            JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
		        }
		    } catch (Exception e) {
		        JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật!");
		        e.printStackTrace();
		    }
	}

	private void xoaTrangActions() {
		txtMaSP.setText("");
	    txtTenSP.setText("");
	    txtLoaiSP.setText("");
	    txtGiaSP.setText("");
	    txtSoLuong.setText("");
	    cboxNCC.setSelectedIndex(0);
	    txtMaSP.requestFocus();
	    hienTable();
	}

	private void xoaActions() {
		int row=table.getSelectedRow();
		if(row!=-1) {
			String maSP = (String)table.getModel().getValueAt(row, 0);
			int hoiXacNhan=JOptionPane.showConfirmDialog(this, "Chắc chẵn xóa không?", "Chú ý", JOptionPane.YES_NO_OPTION);
			if(hoiXacNhan==JOptionPane.YES_OPTION) {
				if (nhapHangDao.xoaSanPham(maSP)) {
					JOptionPane.showMessageDialog(this, "Xóa thành công!");
				    hienTable();
				} else {
				    JOptionPane.showMessageDialog(this, "Xóa thất bại!");
				}
			}
		}
		 
	}

	private void themActions() {
		if (!validateData()) 
			return; // Thoát nếu dữ liệu sai
		try {
	        SanPham sp = getSanPhamFromFields();
	        if (nhapHangDao.themSanPham(sp)) {
	            JOptionPane.showMessageDialog(this, "Thêm thành công!");
	            xoaTrangActions();
	            hienTable();
	        } else {
	            JOptionPane.showMessageDialog(this, "Thêm thất bại, mã nhân viên trùng!");
	        }
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(this, "Lỗi dữ liệu!");
	    }
	}
	
	private void timActions() {
		 String maTim = txtTim.getText().trim();
		    SanPham sp = nhapHangDao.timSanPhamTheoMa(maTim);
		    tableModel.setRowCount(0);
		    if (sp != null) {
		        tableModel.addRow(new Object[]{
		            sp.getMaSP(),
		            sp.getTenSP(),
		            sp.getLoaiSP(),
		            sp.getGiaBan(),
		            sp.getSoLuongTon(),
		            sp.getNcc().getTenNCC()
		        });
		    } else {
		        JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm.");
		    }
	}
	
	private SanPham getSanPhamFromFields() {
	    String maSP = txtMaSP.getText().trim();
	    String tenSP = txtTenSP.getText().trim();
	    String loaiSP = txtLoaiSP.getText().trim();
	    double gia = Double.parseDouble(txtGiaSP.getText().trim());
	    int soLuong = Integer.parseInt(txtSoLuong.getText().trim());
	    int indexNCC = cboxNCC.getSelectedIndex();
	    NhaCungCap ncc = dsNCC.get(indexNCC);
	    return new SanPham(maSP, tenSP, loaiSP, gia, soLuong, ncc);
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
	    if (row != -1) {
	        txtMaSP.setText(tableModel.getValueAt(row, 0).toString());
	        txtTenSP.setText(tableModel.getValueAt(row, 1).toString());
	        txtLoaiSP.setText(tableModel.getValueAt(row, 2).toString());
	        txtGiaSP.setText(tableModel.getValueAt(row, 3).toString());
	        txtSoLuong.setText(tableModel.getValueAt(row, 4).toString());

	        String tenNCC = tableModel.getValueAt(row, 5).toString();
	        for (int i = 0; i < cboxNCC.getItemCount(); i++) {
	            if (cboxNCC.getItemAt(i).equalsIgnoreCase(tenNCC)) {
	                cboxNCC.setSelectedIndex(i);
	                break;
	            }
	        }
	    }
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
