package com.datatech.datatechapi.entities.models;

import com.datatech.datatechapi.entities.Enums.DiaDaSemana;
import com.datatech.datatechapi.entities.Enums.HorarioDaAula;

public class Restricao {

    private int id;
    private DiaDaSemana diaDaSemana;
    private HorarioDaAula horarioDaAula;
    private Professor professor;
    private String professorEmail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfessorEmail() {
        return professorEmail;
    }

    public void setProfessorEmail(String professorEmail) {
        this.professorEmail = professorEmail;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public void setHorarioDaAula(HorarioDaAula horarioDaAula) {
        this.horarioDaAula = horarioDaAula;
    }

    public DiaDaSemana getDiaDaSemana() {
        return diaDaSemana;
    }



    public HorarioDaAula getHorarioDaAula() {
        return horarioDaAula;
    }

    @Override
    public String toString() {
        return "Restricao{" +
                "id=" + id +
                ", diaDaSemana=" + diaDaSemana +
                ", horarioDaAula=" + horarioDaAula +
                ", professor=" + professor +
                ", professorEmail='" + professorEmail + '\'' +
                '}';
    }
}
