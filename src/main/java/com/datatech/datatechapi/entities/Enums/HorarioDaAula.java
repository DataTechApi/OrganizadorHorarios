package com.datatech.datatechapi.entities.Enums;

public enum HorarioDaAula {
    PRIMEIRA_AULA("18:45-19:35"),
    SEGUNDA_AULA("19:35-20:25"),
    TERCEIRA_AULA("20:25-21:15"),
    QUARTA_AULA("21:25-22:15"),
    QUINTA_AULA("22:15-23:05");

    private String descricao;


    HorarioDaAula(String descricao) {

        this.descricao = descricao;

    }

    public String getDescricao() {

        return descricao;
    }


}
