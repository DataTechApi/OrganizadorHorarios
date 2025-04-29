package com.datatech.datatechapi.entities.models;

public class Professor {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private boolean ehCoordenador = false;

    public String getNome() {
        return nome;
    }

    public boolean ehCoordenador() {
        return ehCoordenador;
    }

    public void setCoordenador(boolean coordenador) {
        ehCoordenador = coordenador;
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEhCoordenador() {
        return ehCoordenador;
    }

    public void setEhCoordenador(boolean ehCoordenador) {
        this.ehCoordenador = ehCoordenador;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", ehCoordenador=" + ehCoordenador +
                '}';
    }
}
