package com.datatech.datatechapi.dao;

import com.datatech.datatechapi.entities.models.Professor;
import com.datatech.datatechapi.util.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDao {

    public List<Professor> buscarTodos() {
        List<Professor> professores = new ArrayList<>();

        try {
            ResultSet rs = null;
            String sql = "select * from professor";
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Professor professor = new Professor();

                professor.setId(rs.getInt("id"));
                professor.setNome(rs.getString("nome"));
                professor.setEmail(rs.getString("email"));
                professor.setSenha(rs.getString("senha"));
                professor.setCoordenador(rs.getBoolean("ehCoordenador"));

                professores.add(professor);
            }

        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
        return professores;
    }
    public Professor buscaPorEmail(String email) {
        Professor professor = null;
        try {
            String sql = "SELECT * FROM professor WHERE email=?";

            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setString(1,email);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                professor = new Professor();
                professor.setId(rs.getInt("id"));
                professor.setNome(rs.getString("nome"));
                professor.setEmail(rs.getString("email"));
                professor.setSenha(rs.getString("senha"));
                professor.setCoordenador(rs.getBoolean("ehCoordenador"));
            }

        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }

        return professor;
    }

}
