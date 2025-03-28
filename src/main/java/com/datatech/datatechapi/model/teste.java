package com.datatech.datatechapi.model;

import java.util.Arrays;

public class teste {

    public static void main(String[] args) {
        Restricao r = new Restricao();

        r.setDiaDaSemana(DiaDaSemana.QUARTA);
        r.setHorarioDaAula(HorarioDaAula.TERCEIRAAULA);
        String dia = DiaDaSemana.QUINTA.getDescricao();
        System.out.println("A aula ocorre no dia "+ dia + " na " +
                r.getHorarioDaAula().getDescricao());
    }
}
