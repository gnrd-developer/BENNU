package cl.bennu.note.mapper.jdbc.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    public Connection open(){
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);            
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
