IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'taiKhoan')
BEGIN
    CREATE TABLE taiKhoan (
        tenDangNhap NVARCHAR(50) PRIMARY KEY,
        matKhau NVARCHAR(100),
        maNhanVien NVARCHAR(8),
        CONSTRAINT FK_nhanVien FOREIGN KEY (maNhanVien) REFERENCES nhanVien(maNhanVien)
    );
END