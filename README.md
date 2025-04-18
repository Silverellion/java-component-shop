UI Font: 'Segoe UI'<br>
Reminder:

1. `loaiTK` needs to be removed
2. At the constructor/initializer of any DanhSach class, `conn = JDBC.getConnection();` should be called.
3. `accountStatus` needs to be implememted om style of `trangThai: (HoatDong/KhongConHoatDong)` <- we check for this in MSSQL
4. `TrangThai` will be added to NhanVien, and automatically pass 'HoatDong' whenever DanhSachTaiKhoan's them() is called.
5. If `TrangThai = KhongConHoatDong`, it's still going to be added into the dynamic array for existence checking, but won't be displayed on the `PnlTaiKhoan`'s `DefaultTableModel`
6. in `PnlCaiDat` we will focus on letting the employee change the username/password/SDT/Dia chi.
7. We need to store the file path to the employee's profile picture and load it.

Instruction:
- After cloning the project, remember to put the `mssql-jdbc_auth-12.10.0.x64.dll` into `C:\Users\<YourUser>\.jdks\openjdk-24\bin`