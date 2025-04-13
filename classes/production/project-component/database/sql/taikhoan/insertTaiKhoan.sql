IF NOT EXISTS (
    SELECT 1 FROM taiKhoan
    WHERE tenDangNhap = ? OR maNhanVien = ?
)
BEGIN
    INSERT INTO taiKhoan (tenDangNhap, matKhau, maNhanVien)
    VALUES (?, ?, ?);
END
