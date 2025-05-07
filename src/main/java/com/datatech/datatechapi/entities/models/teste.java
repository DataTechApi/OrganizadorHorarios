package com.datatech.datatechapi.entities.models;


import com.datatech.datatechapi.dao.DisciplinaDao;
import com.datatech.datatechapi.dao.GradeDao;
import com.datatech.datatechapi.dao.RestricaoDao;

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
        DisciplinaDao dd = new DisciplinaDao();
        Curso curso = new Curso();
        curso= dd.buscarCursoPorNome("Banco de Dados II");

        for (Disciplina disciplina : dd.buscarTodosPorCurso(curso.getId())) {
            System.out.println(disciplina);
        }


        System.out.println(curso);



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



    }
}
