package com.datatech.datatechapi.dao;

import com.datatech.datatechapi.entities.Enums.DiaDaSemana;
import com.datatech.datatechapi.entities.Enums.HorarioDaAula;
import com.datatech.datatechapi.entities.models.Restricao;
import com.datatech.datatechapi.util.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RestricaoDao {
    public List<Restricao> buscarRestricao(String email){
        List<Restricao> restricoes = new ArrayList<>();

        try {
            ResultSet rs = null;
            String sql = "select * from restricao where professoremail=?";
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();

            while (rs.next()) {
                Restricao restricao = new Restricao();

                restricao.setId(rs.getInt("id"));
                restricao.setDiaDaSemana(DiaDaSemana.valueOf(rs.getString("dia")));
                restricao.setHorarioDaAula(HorarioDaAula.valueOf(rs.getString("aula")));
                restricao.setProfessorEmail(rs.getString("professoremail"));


                restricoes.add(restricao);
            }

        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
        return restricoes;
    }
    public void cadastrarRestricao(Restricao restricao) {
        try {
            String sql = "INSERT INTO restricao(dia,aula,professoremail) VALUES(?,?,?)";
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setString(1,restricao.getDiaDaSemana().toString());
            ps.setString(2, restricao.getHorarioDaAula().toString());
            ps.setString(3, restricao.getProfessorEmail());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro " + e.getMessage());
        }
    }
    public void removerRestricao(Restricao restricao) {
        try {
            String sql = "DELETE FROM restricao WHERE id=?";
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1,restricao.getId());
            ps.execute();
        } catch (Exception e) { }
    }
}
