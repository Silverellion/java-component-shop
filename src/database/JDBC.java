package database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class JDBC {
    public static void connect(String url, String user, String password) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            executeSQLFile(conn, "createDatabase.sql");
            executeSQLFile(conn, "useDatabase.sql");
            executeSQLFile(conn, "createTableNhanvien.sql");
            executeSQLFile(conn, "createTableTaikhoan.sql");
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void executeSQLFile(Connection conn, String filename) throws IOException, SQLException {
        String sql = Files.readString(Paths.get("src/database/sql/initialize/" + filename));
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        stmt.close();
    }
}
