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
│   ├── models/ <- add your logic classes here
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
sidebar background color: rgb(45, 45, 45);<br>
main background color: rgb (30, 30, 30);<br>

Reminder:

1. loaiTK needs to be removed
2. accountStatus needs to be added like in trangThai: A(Active)/I(Inactive) <- we check for a single char for this in MSSQL
3. in PnlCaiDat, changing the system theme/UI/Appearance (Dark/Light mode) seems to be out of scope for now,
   so, we will only focus on letting the employee changing the username/password/dia chi/SDT/Dia chi.

Instruction:
- After cloning the project, remember to put  the mssql-jdbc_auth-12.10.0.x64.dll into C:\Users\<YourUser>\.jdks\openjdk-24\bin