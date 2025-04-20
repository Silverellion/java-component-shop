SELECT tk.tenDangNhap, tk.matKhau,
       nv.maNhanVien, nv.hoTen, nv.chucVu, nv.luong, nv.soDienThoai, nv.diaChi, nv.pathHinhAnh, nv.trangThai
FROM taiKhoan tk, nhanVien nv
WHERE tk.maNhanVien = nv.maNhanVien
AND tk.tenDangNhap = ? AND tk.matKhau = ?