IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'NhanVien')
BEGIN
    CREATE TABLE NhanVien (
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

IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'TaiKhoan')
BEGIN
    CREATE TABLE TaiKhoan (
        tenDangNhap NVARCHAR(50) PRIMARY KEY,
        matKhau NVARCHAR(100),
        maNhanVien NVARCHAR(8),
        CONSTRAINT FK_nhanVien FOREIGN KEY (maNhanVien) REFERENCES nhanVien(maNhanVien)
    );
END

IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'KhachHang')
BEGIN
    CREATE TABLE KhachHang (
        maKH NVARCHAR(20) PRIMARY KEY,
        tenKH NVARCHAR(100),
        soDienThoai NVARCHAR(20),
        email NVARCHAR(100),
        diaChi NVARCHAR(255)
    );
END

IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'NhaCungCap')
BEGIN
    CREATE TABLE NhaCungCap (
        maNCC NVARCHAR(20) PRIMARY KEY,
        tenNCC NVARCHAR(100),
        soDienThoai NVARCHAR(20),
        email NVARCHAR(100),
        diaChi NVARCHAR(255)
    );
END

IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SanPham')
BEGIN
    CREATE TABLE SanPham (
        maSP NVARCHAR(20) PRIMARY KEY,
        tenSP NVARCHAR(100),
        loaiSP NVARCHAR(50),
        giaBan FLOAT,
        soLuongTon INT,
        maNCC NVARCHAR(20),
        FOREIGN KEY (maNCC) REFERENCES NhaCungCap(maNCC)
    );
END

IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'HoaDon')
BEGIN
    CREATE TABLE HoaDon (
        maHD NVARCHAR(20) PRIMARY KEY,
        ngayLapHD DATE,
        tongTien FLOAT,
        maKH NVARCHAR(20),
        maNhanVien NVARCHAR(8),
        FOREIGN KEY (maKH) REFERENCES KhachHang(maKH),
        FOREIGN KEY (maNhanVien) REFERENCES NhanVien(maNhanVien)
    );
END

IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'ChiTietHoaDon')
BEGIN
    CREATE TABLE ChiTietHoaDon (
        maHD NVARCHAR(20),
        maSP NVARCHAR(20),
        soLuong INT,
        thanhTien FLOAT,
        PRIMARY KEY (maHD, maSP),
        FOREIGN KEY (maHD) REFERENCES HoaDon(maHD),
        FOREIGN KEY (maSP) REFERENCES SanPham(maSP)
    );
END

IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'NhanVien')
BEGIN
    CREATE TABLE NhanVien (
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

IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'TaiKhoan')
BEGIN
    CREATE TABLE TaiKhoan (
        tenDangNhap NVARCHAR(50) PRIMARY KEY,
        matKhau NVARCHAR(100),
        maNhanVien NVARCHAR(8),
        CONSTRAINT FK_nhanVien FOREIGN KEY (maNhanVien) REFERENCES NhanVien(maNhanVien)
    );
END
