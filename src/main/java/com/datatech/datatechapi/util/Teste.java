package com.datatech.datatechapi.util;

import java.sql.SQLException;

public class Teste {
    public static void main(String[] args) throws SQLException {

        Conexao.obterConexao();

        System.out.println(Detalhes.mostrarDataHora());




    }
}
