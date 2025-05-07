package com.datatech.datatechapi.dao;

import com.datatech.datatechapi.entities.models.Curso;
import com.datatech.datatechapi.util.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CursoDao {

    public List<Curso> buscarTodos(){
        List<Curso> cursos = new ArrayList<>();

        try {
            ResultSet rs = null;
            String sql = "select * from curso ";
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);


            rs = ps.executeQuery();

            while (rs.next()) {
                Curso curso = new Curso();
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setSiglaCurso((rs.getString("siglacurso")));
                cursos.add(curso);
            }
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
        return cursos;
    }



}
