package com.datatech.datatechapi.Entities.models;

public class Professor {

    private String nome;
    private String email;
    private String senha;
    private boolean isCoordenador = false;

    public String getNome() {
        return nome;
    }

    public boolean isCoordenador() {
        return isCoordenador;
    }

    public void setCoordenador(boolean coordenador) {
        isCoordenador = coordenador;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
