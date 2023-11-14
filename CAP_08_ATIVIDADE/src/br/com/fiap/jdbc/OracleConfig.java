package br.com.fiap.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class OracleConfig {
	
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
               "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
               "RM97637", "241197"
            );
            conn.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC não encontrado.", e);
        }
        return conn;
    }
}
