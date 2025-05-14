package com.datatech.datatechapi.dao;

import com.datatech.datatechapi.entities.models.Curso;
import com.datatech.datatechapi.entities.models.Disciplina;
import com.datatech.datatechapi.entities.models.Professor;
import com.datatech.datatechapi.util.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public List<Disciplina> buscarTodosPorCurso(int id) {
        List<Disciplina> disciplinasNome = new ArrayList<>();

        try {
            ResultSet rs = null;
            String sql = "select * from disciplina where cursoid= ?";
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Disciplina disciplina = new Disciplina();


                //disciplina.setId(rs.getInt("id"));
                disciplina.setNome(rs.getString("nome"));

                // disciplina.setCursoId((rs.getInt("cursoid")));
                // disciplina.setProfessorId(rs.getInt("professorid"));
                disciplinasNome.add(disciplina);
            }

        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
        return disciplinasNome;
    }

    public Curso buscarCursoPorNome(String nome) {

        Curso curso = null;
        try {
            ResultSet rs = null;
            String sql = "SELECT * FROM curso WHERE nome=?";
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setString(1, nome);

            rs = ps.executeQuery();
            while (rs.next()) {
                curso = new Curso();
                curso.setNome(rs.getString("nome"));
                curso.setId(rs.getInt("id"));

            }

        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
        return curso;
    }

    public Disciplina buscarDisciplinaPorNome(String nomeDisciplina) {
        Disciplina disciplina = null;
        Professor professor = null;
        try {
            ResultSet rs = null;
            String sql = "SELECT *, p.nome, p.email FROM disciplina as d " +
                    "join professor as p on p.id = d.professorid WHERE d.nome=?";
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setString(1, nomeDisciplina);
            rs = ps.executeQuery();
            while (rs.next()) {
                disciplina = new Disciplina();
                professor = new Professor();
                //professor.setId(rs.getInt("professorid"));
                professor.setNome(rs.getString("p.nome"));
                disciplina.setNome(rs.getString("nome"));
                professor.setEmail(rs.getString("p.email"));
                disciplina.setProfessor(professor);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return disciplina;
    }
}
