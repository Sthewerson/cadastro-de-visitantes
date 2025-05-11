package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    public static Connection getConnection() throws java.sql.SQLException {
        String url = String url = "jdbc:mysql://localhost:3307/visitantes_db";
        String user = "visitante";
        String password = "visitante123";
        return DriverManager.getConnection(url, user, password);
    }
}
