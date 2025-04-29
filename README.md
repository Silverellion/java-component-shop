Instruction:
-
- After cloning the project, remember to put the `mssql-jdbc_auth-12.10.0.x64.dll` into `C:\Users\<YourUser>\.jdks\openjdk-24\bin`

How the program should works:
-
1. The program begins with the WindowLogin_GUI
2. The user logins successfully
3. WindowLogin then fetches `TaiKhoan` which contains `NhanVien` by calling danhSachTaiKhoan which calls DAO login: 
```Java
public void login() {
    TaiKhoan loggedInAccount = danhSachTaiKhoan.login(username, password);
    if(loggedInAccount != null) {
        this.dispose();
        new WindowMain_GUI(loggedInAccount);
    }
}
```
4. `WindowMain_GUI` is loaded in with loggedInAccount, which then is pased to `PnlTrangChu`.

If you don't have an account in the database for logging in:
-


INSIDE
```java
public class App {
	private static final String url = "jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;integratedSecurity=true";
	private static final String user = "sa";
	private static final String password = "sapassword";
	public static void main(String[] args) {
		try {
			ConnectDB.initialize(url, user, password);
			new WindowLogin_GUI();
//			new WindowMain_GUI(new TaiKhoan("testAccount", "12345678",
//					new NhanVien(
//							"AD000001", "Test",
//							"Test", 90000,
//							"012345678910", "asd",
//							"")));
		} catch (SQLException | IOException e) {
			throw new RuntimeException(e);
		}
	}
}
```
UNCOMMENT 
```java
new WindowMain_GUI(new TaiKhoan("testAccount", "12345678",
    new NhanVien(
        "AD000001", "Test",
        "Test", 90000,
        "012345678910", "asd",
        "")));
```
THEN COMMENT
```java
    new WindowLogin_GUI();
```
