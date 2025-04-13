IF NOT EXISTS (SELECT 1 FROM nhanVien WHERE maNhanVien = ?)
BEGIN
    INSERT INTO nhanVien (maNhanVien, hoTen, chucVu, luong, soDienThoai, diaChi)
    VALUES (?, ?, ?, ?, ?, ?);
END
