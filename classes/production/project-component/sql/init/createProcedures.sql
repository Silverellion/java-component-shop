IF NOT EXISTS (SELECT * FROM sys.objects WHERE type = 'P' AND name = 'sp_TimSanPhamByMa')
BEGIN
    EXEC('
        CREATE PROCEDURE sp_TimSanPhamByMa
            @maSP VARCHAR(10)
        AS
        BEGIN
            SET NOCOUNT ON;
            SELECT maSP, tenSP, loaiSP, giaBan, soLuongTon, maNCC
            FROM SanPham
            WHERE maSP = @maSP;
        END
    ')
END
