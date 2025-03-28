package com.datatech.datatechapi.model;

public enum HorarioDaAula {
    PRIMEIRAAULA("18:45-19:35"),
    SEGUNDAAULA("19:35-20:25"),
    TERCEIRAAULA("20:25-21:15"),
    QUARTAAULA("21:25-22:15"),
    QUINTAAULA("22:15-23:05");

    private String descricao;

    HorarioDaAula(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
