package com.datatech.datatechapi.Entities.models;


import com.datatech.datatechapi.dao.DisciplinaDao;
import com.datatech.datatechapi.dao.ProfessorDao;

import java.util.ArrayList;
import java.util.Collections;
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
        List<Disciplina> teste = new ArrayList<>();

        teste = dd.buscarTodosNome();
        for(var disc : teste){
            System.out.println(disc.getNome());
        }


    }
}
