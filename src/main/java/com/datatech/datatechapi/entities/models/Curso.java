package com.datatech.datatechapi.entities.models;

public class Curso {
    private int id;
    private String nome;
    private String siglaCurso;
    
    public String getSiglaCurso() {
        return siglaCurso;
    }
    public void setSiglaCurso(String siglaCurso) {
        this.siglaCurso = siglaCurso;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }



    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", siglaCurso='" + siglaCurso + '\'' +
                '}';
    }
}
