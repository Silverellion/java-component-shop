package database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class JDBC {
    public static void connect(String url, String user, String password) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            executeSQLFile(conn, "create_database.sql");
            executeSQLFile(conn, "use_database.sql");
            executeSQLFile(conn, "create_table_nhanvien.sql");
            executeSQLFile(conn, "create_table_taikhoan.sql");
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void executeSQLFile(Connection conn, String filename) throws IOException, SQLException {
        String sql = Files.readString(Paths.get("src/database/sql/" + filename));
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        stmt.close();
    }
}
