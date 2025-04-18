IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'nhanVien')
BEGIN
    CREATE TABLE nhanVien (
        maNhanVien NVARCHAR(8) PRIMARY KEY,
        hoTen NVARCHAR(100),
        chucVu NVARCHAR(100),
        luong INT,
        soDienThoai NVARCHAR(15),
        diaChi NVARCHAR(200),
        pathHinhAnh NVARCHAR(255),
        trangThai NVARCHAR(20) CHECK (trangThai IN ('HoatDong', 'KhongConHoatDong'))
    );
END