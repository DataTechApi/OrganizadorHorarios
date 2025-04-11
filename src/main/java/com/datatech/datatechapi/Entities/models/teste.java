package com.datatech.datatechapi.Entities.models;



public class teste {

    public static void main(String[] args) {

        Curso c1 = new Curso();
        c1.setId(1);
        c1.setNome("BD");

        Disciplina d1 = new Disciplina();
        d1.setId(1);
        d1.setCurso(c1);


        System.out.println(d1.getCurso().getNome());

    }
}
