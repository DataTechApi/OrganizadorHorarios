package com.datatech.datatechapi.Entities.models;

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
    public  void teste(){
        System.out.println("testando");
    }

    

}
