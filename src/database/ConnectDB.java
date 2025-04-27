package database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class ConnectDB {
    private static Connection conn = null;
    public static void initialize(String url, String user, String password) throws IOException, SQLException {
        conn = DriverManager.getConnection(url, user, password);
        executeSQLFile(conn, "createDatabase.sql");
        executeSQLFile(conn, "useDatabase.sql");
        executeSQLFile(conn, "createTables.sql");
        executeSQLFile(conn, "createProcedures.sql");
    }

    public static Connection getConn() {
        return conn;
    }

    public static void generateTempData() throws SQLException, IOException {
        if(conn == null)
            return;
        executeSQLFile(conn, "insertData.sql");
    }

    private static void executeSQLFile(Connection conn, String filename) throws IOException, SQLException {
        String sql = Files.readString(Paths.get("src/sql/init/" + filename));
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        stmt.close();
    }
}
