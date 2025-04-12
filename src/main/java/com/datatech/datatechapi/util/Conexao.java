package com.datatech.datatechapi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/datatechapi";

    private static String USER = "datatech";
    private static final String PASSWORD = "admin123";

    public static Connection obterConexao() throws SQLException{
        String driverName = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driverName);
            System.out.println("Conectado");
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            throw new SQLException("Erro ao conectar " + e.getMessage());
        }
    }

}
