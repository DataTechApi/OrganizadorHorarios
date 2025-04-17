package com.datatech.datatechapi.dao;

import com.datatech.datatechapi.Entities.models.Disciplina;
import com.datatech.datatechapi.Entities.models.Professor;
import com.datatech.datatechapi.util.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDao {

    public List<Disciplina> buscarTodos() {
        List<Disciplina> disciplinas = new ArrayList<>();

        try {
            ResultSet rs = null;
            String sql = "select * from disciplina";
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Disciplina disciplina = new Disciplina();

                disciplina.setId(rs.getInt("id"));
                disciplina.setNome(rs.getString("nome"));
                disciplina.setCursoId((rs.getInt("cursoid")));
                disciplina.setProfessorId(rs.getInt("professorid"));

                disciplinas.add(disciplina);
            }

        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
        return disciplinas;
    }
    public List<Disciplina> buscarTodosNome() {
        List<Disciplina> disciplinasNome = new ArrayList<>();

        try {
            ResultSet rs = null;
            String sql = "select nome  from disciplina";
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Disciplina disciplina = new Disciplina();

               // disciplina.setId(rs.getInt("id"));
                disciplina.setNome(rs.getString("nome"));
                //disciplina.setCursoId((rs.getInt("cursoid")));
               // disciplina.setProfessorId(rs.getInt("professorid"));

                disciplinasNome.add(disciplina);
            }

        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
        return disciplinasNome;
    }
}
