IF NOT EXISTS ( SELECT 1 FROM taiKhoan WHERE tenDangNhap = ? OR maNhanVien = ?)
BEGIN
    INSERT INTO nhanVien (maNhanVien, hoTen, chucVu, luong, soDienThoai, diaChi, trangThai, pathHinhAnh)
    VALUES (?, ?, ?, ?, ?, ?, ?, ?);
    INSERT INTO taiKhoan (tenDangNhap, matKhau, maNhanVien)
    VALUES (?, ?, ?);
END
