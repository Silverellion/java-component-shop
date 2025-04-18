folder structure:

```
project-component/
├── lib/
│   ├── mssql-jdbc-12.10.0.jre11.jar
│   └── mssql-jdbc_auth-12.10.0.x64.dll
├── src/
│   ├── database/
│   │   ├── JDBC.java
│   │   └── sql/ <- put your SQLs here!
│   │       ├── initialize/ <- put your SQLs that create tables if it doesn't exit yet here!
│   │       │   ├── createDatabase.sql
│   │       │   ├── createTableNhanvien.sql
│   │       │   ├── createTableTaiKhoan.sql
│   │       │   └── useDatabase.sql
│   │       ├── taiKhoan/
│   │       │   └── insertTaiKhoan.sql
│   │       ├── .../
│   ├── gui/
│   ├── main/
│   │   └── App.java <- to run the program 
│   ├── entity/ <- add your logic classes here
│   │   ├── DanhSachTaiKhoan.java
│   │   ├── NhanVien.java
│   │   └── TaiKhoan.java
│   ├── resources/
│   │   └── icons/
│   │       ├── icon8-login-50.png
│   │       ├── icon8-logout-50.png
│   │       └── ...
│   ├── utils/
│   │   ├── FontHelper.java
│   │   └── SwingHelper.java <- class to automatically call the theme of the app's JButtons and JLabels
├── .classpath
├── .gitignore
├── .project
├── project-component.iml
└── README.md
```

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