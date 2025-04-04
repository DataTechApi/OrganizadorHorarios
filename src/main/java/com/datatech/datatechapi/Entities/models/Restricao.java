package com.datatech.datatechapi.Entities.models;

import com.datatech.datatechapi.Entities.Enums.DiaDaSemana;
import com.datatech.datatechapi.Entities.Enums.HorarioDaAula;

public class Restricao {

    private DiaDaSemana diaDaSemana;
    private HorarioDaAula horarioDaAula;

    public DiaDaSemana getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public HorarioDaAula getHorarioDaAula() {
        return horarioDaAula;
    }

    public void setHorarioDaAula(HorarioDaAula horarioDaAula) {
        this.horarioDaAula = horarioDaAula;
    }
}
