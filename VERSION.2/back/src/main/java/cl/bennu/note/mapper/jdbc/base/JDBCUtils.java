package cl.bennu.note.mapper.jdbc.base;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtils {

    public Connection open() {
        try {
            String pass = System.getenv("DB_PASS");
            String dbName = System.getenv("DB_NAME");

            String url = "jdbc:postgresql://localhost:5432/"+dbName;
            return DriverManager.getConnection(url, "postgres", pass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void close(Connection connection) {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
