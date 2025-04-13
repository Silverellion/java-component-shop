package database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class JDBC {
    private static Connection connection = null;
    public static void initialize(String url, String user, String password) throws IOException, SQLException {
        connection = DriverManager.getConnection(url, user, password);
        executeSQLFile(connection, "createDatabase.sql");
        executeSQLFile(connection, "useDatabase.sql");
        executeSQLFile(connection, "createTableNhanvien.sql");
        executeSQLFile(connection, "createTableTaiKhoan.sql");
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            connection = null;
        }
    }

    private static void executeSQLFile(Connection conn, String filename) throws IOException, SQLException {
        String sql = Files.readString(Paths.get("src/database/sql/initialize/" + filename));
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        stmt.close();
    }
}
