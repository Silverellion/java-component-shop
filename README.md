folder structure:

```
project-component/
├── lib/
│   └── mssql-jdbc-12.10.0.jre11.jar
├── src/
│   ├── database/
│   │   └── JDBC.java
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
│   │   └── SwingHelper.java
├── .classpath
├── .gitignore
├── .project
├── project-component.iml
└── README.md
```

UI Font: 'Segoe UI'<br>
sidebar background color: rgb(45, 45, 45);<br>
main background color: rgb (30, 30, 30);<br>
jdbc:sqlserver://<HOST>:<PORT>;encrypt=true;trustServerCertificate=true;>

Reminder:

1. loaiTK needs to be removed
2. accountStatus needs to be added like in trangThai: A(Active)/I(Inactive) <- we check for a single char for this in MSSQL
3. in PnlCaiDat, changing the system theme/UI/Appearance (Dark/Light mode) seems to be out of scope for now,
   so, we will only focus on letting the employee changing the username/password/dia chi/SDT/Dia chi.