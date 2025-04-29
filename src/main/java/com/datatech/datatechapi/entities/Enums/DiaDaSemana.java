package com.datatech.datatechapi.entities.Enums;

public enum DiaDaSemana {
    SEGUNDA_FEIRA("Segunda-feira"),
    TERCA_FEIRA("Terça-feira"),
    QUARTA_FEIRA("Quarta-feira"),
    QUINTA_FEIRA("Quinta-feira"),
    SEXTA_FEIRA("Sexta-feira");

    private String descricao;


    DiaDaSemana(String descricao) {
        this.descricao = descricao;

    }

    public String getDescricao() {

        return descricao;
    }


}
