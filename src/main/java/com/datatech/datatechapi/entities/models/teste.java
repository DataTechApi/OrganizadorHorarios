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
        GradeDao gradeDao  = new GradeDao();
        List<Grade> grades = new ArrayList<>();

        grades = gradeDao.buscarPorCurso("Banco de Dados I");
        int i , j;
        String materia = "";
        for( i = 0; i < grades.size(); i++){
            for( j = 0; j < grades.size(); j++){
                if (grades.get(i ).getLinha()== 5 && grades.get(i).getColuna() == 2)
                   materia = grades.get(i).getDisciplinanome();
            }
        }
        System.out.println(materia);






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
