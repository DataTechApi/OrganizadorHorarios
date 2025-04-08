package com.datatech.datatechapi.Entities.models;

import com.datatech.datatechapi.Entities.Enums.DiaDaSemana;
import com.datatech.datatechapi.Entities.Enums.HorarioDaAula;

public class teste {

    public static void main(String[] args) {

<<<<<<< HEAD
=======
        r.setDiaDaSemana(DiaDaSemana.QUARTA);
        r.setHorarioDaAula(HorarioDaAula.TERCEIRAAULA);
        String dia = DiaDaSemana.QUINTA.getDescricao();
        System.out.println("A aula ocorre no dia "+ dia + " na " +
                r.getHorarioDaAula().getDescricao());

        for(var item : DiaDaSemana.values()){
            System.out.println(item.getDescricao());
        }
>>>>>>> 8ed2f8de0b7021d96f84d52e77d98de4e5c8b590
    }
}
