package com.datatech.datatechapi.dao;

import com.datatech.datatechapi.entities.Enums.DiaDaSemana;
import com.datatech.datatechapi.entities.Enums.HorarioDaAula;
import com.datatech.datatechapi.entities.models.Grade;
import com.datatech.datatechapi.entities.models.Restricao;
import com.datatech.datatechapi.util.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDao {

    public List<Grade> buscarTodos() {
        List<Grade> grades = new ArrayList<>();

        try {
            ResultSet rs = null;
            String sql = "select * from grade";
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Grade grade = new Grade();
                grade.setLinha(rs.getInt("linha"));
                grade.setColuna(rs.getInt("coluna"));
                grade.setCursoNome(rs.getString("cursonome"));
                grade.setDia(DiaDaSemana.valueOf(rs.getString("dia")));
                grade.setHorario(HorarioDaAula.valueOf(rs.getString("horario")));
                grade.setDisciplinanome(String.valueOf(rs.getString("disciplinanome")));
                grade.setProfessorNome(String.valueOf(rs.getString("professornome")));

                grades.add(grade);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return grades;
    }
    public List<Grade> buscarPorCurso(String cursoNome) {
        List<Grade> grades = new ArrayList<>();
        try{
            ResultSet rs = null;
            String sql = "select * from grade where cursonome = ?";
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setString(1, cursoNome);
            rs = ps.executeQuery();

            while (rs.next()) {
                Grade grade = new Grade();
                grade.setCursoNome(rs.getString("cursonome"));
                grade.setDia(DiaDaSemana.valueOf(rs.getString("dia")));
                grade.setHorario(HorarioDaAula.valueOf(rs.getString("horario")));
                grade.setDisciplinanome(String.valueOf(rs.getString("disciplinanome")));
                grade.setProfessorNome(String.valueOf(rs.getString("professornome")));
                grade.setLinha(rs.getInt("linha"));
                grade.setColuna(rs.getInt("coluna"));

                grades.add(grade);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return grades;
    }
    public List<Grade> buscarPorProfessor(String professornome) {
        List<Grade> grades = new ArrayList<>();
        try{
            ResultSet rs = null;
            String sql = "select * from grade where professornome = ?";
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setString(1, professornome);
            rs = ps.executeQuery();

            while (rs.next()) {
                Grade grade = new Grade();
                //grade.setCursoNome(rs.getString("cursonome"));
                grade.setDia(DiaDaSemana.valueOf(rs.getString("dia")));
                grade.setHorario(HorarioDaAula.valueOf(rs.getString("horario")));
                //grade.setDisciplinanome(String.valueOf(rs.getString("disciplinanome")));
                grade.setProfessorNome(String.valueOf(rs.getString("professornome")));
                grade.setLinha(rs.getInt("linha"));
                grade.setColuna(rs.getInt("coluna"));

                grades.add(grade);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return grades;
    }
    public void cadastrarGrade(List<Grade> grades) {
        for (Grade grade : grades) {
            try {

                String sql = "INSERT INTO grade(cursonome,dia,horario,disciplinanome,linha,coluna,professornome) VALUES(?,?,?,?,?,?,?)";
                PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
                ps.setString(1, grade.getCursoNome());
                ps.setString(2, grade.getDia().toString());
                ps.setString(3, grade.getHorario().toString());
                ps.setString(4, grade.getDisciplinanome());
                ps.setInt(5, grade.getLinha());
                ps.setInt(6, grade.getColuna());
                ps.setString(7, grade.getProfessorNome());
                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erro " + e.getMessage());
            }

        }
    }
}
