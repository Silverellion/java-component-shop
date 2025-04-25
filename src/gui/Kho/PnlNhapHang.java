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
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import entity.NhaCungCap;
import entity.QuanLyKho;
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
	private QuanLyKho dssp=new QuanLyKho();
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
		
	}
	
	public void hienTable() {
		for(int i=0;i<dssp.tong();i++) {
			SanPham sp=dssp.getSanPham(i);
			String[] dataRow= {sp.getMaSP(), sp.getTenSP(), sp.getLoaiSP(), sp.getGiaBan() + "",
				sp.getSoLuongTon() + "", sp.getNcc().getTenNCC()};
			tableModel.addRow(dataRow);
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
	
	private void suaActions() {
		int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần sửa.");
            return;
        }

        try {
            String maSP = txtMaSP.getText();
            String tenSP = txtTenSP.getText();
            String loai = txtLoaiSP.getText();
            int soluong = Integer.parseInt(txtSoLuong.getText());
            double gia = Double.parseDouble(txtGiaSP.getText());

            SanPham sp = new SanPham(maSP, tenSP, loai, gia, soluong, null);
            
            if (dssp.suaSanPham(sp)) {
                tableModel.setValueAt(sp.getTenSP(), row, 1);
                tableModel.setValueAt(sp.getLoaiSP(), row, 2);
                tableModel.setValueAt(sp.getGiaBan() + "", row, 3);
                tableModel.setValueAt(sp.getSoLuongTon() + "", row, 4);
                tableModel.setValueAt(sp.getNcc().getTenNCC(), row, 5);
                JOptionPane.showMessageDialog(null, "Sửa thông tin sản phẩm thành công.");
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm để sửa.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi nhập liệu.");
        }
		
	}

	private void xoaTrangActions() {
		txtMaSP.setText("");
		txtTenSP.setText("");
		txtLoaiSP.setText("");
		txtGiaSP.setText("");
		txtSoLuong.setText("");
		txtMaSP.requestFocus();
		
	}

	private void xoaActions() {
		int row=table.getSelectedRow();
		if(row!=-1) {
			String maSP=(String)table.getModel().getValueAt(row, 0);
			int hoiXacNhan=JOptionPane.showConfirmDialog(this, "Chắc chẵn xóa không?", "Chú ý", JOptionPane.YES_NO_OPTION);
			if(hoiXacNhan==JOptionPane.YES_OPTION) {
				if(dssp.xoaSanPham(maSP)) {
					tableModel.removeRow(row);
					xoaTrangActions();
				}
			}
		}
		
	}

	private void themActions() {
		try {
			SanPham sp=null;
			String maSP=txtMaSP.getText();
			String tenSP=txtTenSP.getText();
			String loai=txtLoaiSP.getText();
			int soLuong=Integer.parseInt(txtSoLuong.getText());
			double giaBan=Double.parseDouble(txtGiaSP.getText());
			String ncc=cboxNCC.getSelectedItem().toString();
			sp=new SanPham(maSP, tenSP, loai, giaBan, soLuong, null);
			if(dssp.themSanPham(sp)) {
				String[] row= {sp.getMaSP(), sp.getTenSP(), sp.getLoaiSP(), sp.getGiaBan() + "",
					sp.getSoLuongTon() + "", sp.getNcc().getTenNCC()};
				tableModel.addRow(row);
				xoaTrangActions();
			}else {
				JOptionPane.showMessageDialog(null, "Trùng mã sản phẩm!");
				txtMaSP.selectAll();
				txtMaSP.requestFocus();
			}
			
		}catch(Exception ex1) {
			JOptionPane.showMessageDialog(null, "Lỗi nhập liệu!");
			return;
		}
		
	}
	
	private void timActions() {
		String maSP=txtTim.getText().trim();
		if(maSP.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phẩm cần tìm!");
			return;
		}
		boolean found=false;
		for(int i=0;i<dssp.tong();i++) {
			SanPham sp=dssp.getSanPham(i);
			if(String.valueOf(sp.getMaSP()).equals(maSP)) {
				table.setRowSelectionInterval(i, i);
				txtMaSP.setText(String.valueOf(sp.getMaSP()));
				txtTenSP.setText(sp.getTenSP());
				txtLoaiSP.setText(sp.getLoaiSP());
				txtGiaSP.setText(String.valueOf(sp.getGiaBan()));
				txtSoLuong.setText(String.valueOf(sp.getSoLuongTon()));
				found=true;
				break;
			}
		}
		if(!found) {
			JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên với mã: " + maSP);
			
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row=table.getSelectedRow();
		txtMaSP.setText(table.getValueAt(row, 0).toString());
		txtTenSP.setText(table.getValueAt(row, 1).toString());
		txtLoaiSP.setText(table.getValueAt(row, 2).toString());
		txtGiaSP.setText(table.getValueAt(row, 3).toString());
		txtSoLuong.setText(table.getValueAt(row, 4).toString());
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
