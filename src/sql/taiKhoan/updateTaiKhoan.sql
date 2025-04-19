UPDATE nhanVien
SET maNhanVien = ?, hoTen = ?, chucVu = ?, luong = ?, soDienThoai = ?, diaChi = ?, trangThai = ?, pathHinhAnh = ?
WHERE maNhanVien = ?;

UPDATE taiKhoan
SET tenDangNhap = ?, matKhau = ?. maNhanVien = ?
WHERE maNhanVien = ?;
