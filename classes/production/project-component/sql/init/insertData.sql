--NhaCungCap

IF NOT EXISTS (SELECT * FROM NhaCungCap WHERE maNCC = 'NCC001')
BEGIN
    INSERT INTO NhaCungCap (maNCC, tenNCC, soDienThoai, email, diaChi)
    VALUES (N'NCC001', N'Tech Co.', N'0123456889', N'ncc001@example.com', N'Hà Nội');
END

IF NOT EXISTS (SELECT * FROM NhaCungCap WHERE maNCC = 'NCC002')
BEGIN
    INSERT INTO NhaCungCap (maNCC, tenNCC, soDienThoai, email, diaChi)
    VALUES (N'NCC002', N'Tech Plus', N'0123456890', N'ncc002@example.com', N'Hồ Chí Minh');
END

IF NOT EXISTS (SELECT * FROM NhaCungCap WHERE maNCC = 'NCC003')
BEGIN
    INSERT INTO NhaCungCap (maNCC, tenNCC, soDienThoai, email, diaChi)
    VALUES (N'NCC003', N'Tech Innovations', N'0123456891', N'ncc003@example.com', N'Đà Nẵng');
END

IF NOT EXISTS (SELECT * FROM NhaCungCap WHERE maNCC = 'NCC004')
BEGIN
    INSERT INTO NhaCungCap (maNCC, tenNCC, soDienThoai, email, diaChi)
    VALUES (N'NCC004', N'V-Tech', N'0123456892', N'ncc004@example.com', N'Bình Dương');
END

IF NOT EXISTS (SELECT * FROM NhaCungCap WHERE maNCC = 'NCC005')
BEGIN
    INSERT INTO NhaCungCap (maNCC, tenNCC, soDienThoai, email, diaChi)
    VALUES (N'NCC005', N'Vertech', N'0123456893', N'ncc005@example.com', N'Vũng Tàu');
END

IF NOT EXISTS (SELECT * FROM NhaCungCap WHERE maNCC = 'NCC006')
BEGIN
    INSERT INTO NhaCungCap (maNCC, tenNCC, soDienThoai, email, diaChi)
    VALUES (N'NCC006', N'FutureTech', N'0123456894', N'ncc006@example.com', N'Quảng Ninh');
END

IF NOT EXISTS (SELECT * FROM NhaCungCap WHERE maNCC = 'NCC007')
BEGIN
    INSERT INTO NhaCungCap (maNCC, tenNCC, soDienThoai, email, diaChi)
    VALUES (N'NCC007', N'NextTech', N'0123456895', N'ncc007@example.com', N'Khánh Hòa');
END

IF NOT EXISTS (SELECT * FROM NhaCungCap WHERE maNCC = 'NCC008')
BEGIN
    INSERT INTO NhaCungCap (maNCC, tenNCC, soDienThoai, email, diaChi)
    VALUES (N'NCC008', N'ProTech', N'0123456896', N'ncc008@example.com', N'Tây Ninh');
END

IF NOT EXISTS (SELECT * FROM NhaCungCap WHERE maNCC = 'NCC009')
BEGIN
    INSERT INTO NhaCungCap (maNCC, tenNCC, soDienThoai, email, diaChi)
    VALUES (N'NCC009', N'GalaxyTech', N'0123456897', N'ncc009@example.com', N'Long An');
END

IF NOT EXISTS (SELECT * FROM NhaCungCap WHERE maNCC = 'NCC010')
BEGIN
    INSERT INTO NhaCungCap (maNCC, tenNCC, soDienThoai, email, diaChi)
    VALUES (N'NCC010', N'MegaTech', N'0123456898', N'ncc010@example.com', N'Hải Phòng');
END

--SanPham
IF NOT EXISTS (SELECT * FROM SanPham WHERE maSP = 'SP001')
BEGIN
    INSERT INTO SanPham (maSP, tenSP, loaiSP, giaBan, soLuongTon, maNCC)
    VALUES (N'SP001', N'Tivi LED', N'Điện tử', 5000000, 10, N'NCC001');
END

IF NOT EXISTS (SELECT * FROM SanPham WHERE maSP = 'SP002')
BEGIN
    INSERT INTO SanPham (maSP, tenSP, loaiSP, giaBan, soLuongTon, maNCC)
    VALUES (N'SP002', N'Điện thoại', N'Điện tử', 2000000, 15, N'NCC002');
END

IF NOT EXISTS (SELECT * FROM SanPham WHERE maSP = 'SP003')
BEGIN
    INSERT INTO SanPham (maSP, tenSP, loaiSP, giaBan, soLuongTon, maNCC)
    VALUES (N'SP003', N'Máy tính bảng', N'Điện tử', 3000000, 20, N'NCC003');
END

IF NOT EXISTS (SELECT * FROM SanPham WHERE maSP = 'SP004')
BEGIN
    INSERT INTO SanPham (maSP, tenSP, loaiSP, giaBan, soLuongTon, maNCC)
    VALUES (N'SP004', N'Laptop', N'Điện tử', 15000000, 8, N'NCC004');
END

IF NOT EXISTS (SELECT * FROM SanPham WHERE maSP = 'SP005')
BEGIN
    INSERT INTO SanPham (maSP, tenSP, loaiSP, giaBan, soLuongTon, maNCC)
    VALUES (N'SP005', N'Tai nghe Bluetooth', N'Điện tử', 500000, 30, N'NCC005');
END

IF NOT EXISTS (SELECT * FROM SanPham WHERE maSP = 'SP006')
BEGIN
    INSERT INTO SanPham (maSP, tenSP, loaiSP, giaBan, soLuongTon, maNCC)
    VALUES (N'SP006', N'Loa Bluetooth', N'Điện tử', 700000, 25, N'NCC006');
END

IF NOT EXISTS (SELECT * FROM SanPham WHERE maSP = 'SP007')
BEGIN
    INSERT INTO SanPham (maSP, tenSP, loaiSP, giaBan, soLuongTon, maNCC)
    VALUES (N'SP007', N'Máy ảnh', N'Điện tử', 8000000, 5, N'NCC007');
END

IF NOT EXISTS (SELECT * FROM SanPham WHERE maSP = 'SP008')
BEGIN
    INSERT INTO SanPham (maSP, tenSP, loaiSP, giaBan, soLuongTon, maNCC)
    VALUES (N'SP008', N'Smartwatch', N'Điện tử', 2500000, 18, N'NCC008');
END

IF NOT EXISTS (SELECT * FROM SanPham WHERE maSP = 'SP009')
BEGIN
    INSERT INTO SanPham (maSP, tenSP, loaiSP, giaBan, soLuongTon, maNCC)
    VALUES (N'SP009', N'Quạt điều hòa', N'Điện tử', 3000000, 10, N'NCC009');
END

IF NOT EXISTS (SELECT * FROM SanPham WHERE maSP = 'SP010')
BEGIN
    INSERT INTO SanPham (maSP, tenSP, loaiSP, giaBan, soLuongTon, maNCC)
    VALUES (N'SP010', N'Bàn phím cơ', N'Phụ kiện', 1000000, 12, N'NCC010');
END
