package com.datatech.datatechapi.entities.models;


import com.datatech.datatechapi.dao.DisciplinaDao;
import com.datatech.datatechapi.dao.GradeDao;
import com.datatech.datatechapi.dao.RestricaoDao;
import com.datatech.datatechapi.entities.Enums.DiaDaSemana;
import com.datatech.datatechapi.entities.Enums.HorarioDaAula;

import java.util.ArrayList;
import java.util.List;

public class teste {

    public static void main(String[] args) {
//        ProfessorDao p = new ProfessorDao();
//        List<Professor> teste = new ArrayList<>();
//
//        teste = Collections.singletonList(p.buscaPorEmail("adrian@fatec"));
//
//        for (var item : teste){
//            System.out.println(item);
//        }

        //     RestricaoDao r = new RestricaoDao();
//        Restricao restricao = new Restricao();
//        restricao.setDiaDaSemana(DiaDaSemana.SEGUNDA_FEIRA);
//        restricao.setHorarioDaAula(HorarioDaAula.SEGUNDA_AULA);
//        restricao.setProfessorEmail("adriana@fatec");
//        r.cadastrarRestricao(restricao);
//        r.buscarRestricao("adriana@fatec");
//
//       List<Restricao> t = new ArrayList<>();
//       t=r.buscarRestricao("adriana@fatec");
//       for (var i: t){
//           System.out.println(i);
//       }
//        GradeDao g = new GradeDao();
//        List<Grade> t = g.buscarPorCurso("Banco de Dados II");
//
//        for(var i : t){
//            System.out.println(i);
//        }
        Restricao r = new Restricao();
        List<Restricao> restricoes = new ArrayList<>();
        RestricaoDao restricaoDao = new RestricaoDao();
        DisciplinaDao d = new DisciplinaDao();
        Disciplina disciplina = new Disciplina();
        disciplina = d.buscarDisciplinaPorNome("Algoritmos");
        restricoes = restricaoDao.buscarRestricao("sabha@fatec");
        System.out.println(disciplina);
        String nome = disciplina.getProfessor().getNome();
        System.out.println(nome);
        for (var item : restricoes) {
            System.out.println(item);
        }
        for (var item : restricoes) {
            if (disciplina.getProfessor().getEmail().equals(item.getProfessorEmail())&& item.getDiaDaSemana() == DiaDaSemana.SEGUNDA_FEIRA && item.getHorarioDaAula() == HorarioDaAula.SEGUNDA_AULA) {
                System.out.println("entrou");
            }else System.out.println("falhou");
        }


    }
}
