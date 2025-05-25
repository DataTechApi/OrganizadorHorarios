package com.datatech.datatechapi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    //private static final String URL = "jdbc:mysql://localhost:3306/datatechapi";
    private static final String URL = "jdbc:mysql://datatechapi.mysql.database.azure.com:3306/datatechapi";

    private static String USER = "sr";
    private static final String PASSWORD = "Admin@123";

    public static Connection obterConexao() throws SQLException{
        String driverName = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driverName);
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            throw new SQLException("Erro ao conectar " + e.getMessage());
        }
    }

}
