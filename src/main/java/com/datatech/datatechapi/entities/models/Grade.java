package com.datatech.datatechapi.entities.models;

import com.datatech.datatechapi.entities.Enums.DiaDaSemana;
import com.datatech.datatechapi.entities.Enums.HorarioDaAula;

public class Grade {
    private String cursoNome;
    private String disciplinanome;
    private String professorNome;
    private DiaDaSemana dia;
    private HorarioDaAula horario;
    private Integer linha;
    private Integer coluna;

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
    public String getCursoNome() {
        return cursoNome;
    }

    public void setCursoNome(String cursoNome) {
        this.cursoNome = cursoNome;
    }

    public String getDisciplinanome() {
        return disciplinanome;
    }

    public void setDisciplinanome(String disciplinanome) {
        this.disciplinanome = disciplinanome;
    }

    public String getProfessorNome() {
        return professorNome;
    }

    public void setProfessorNome(String professorNome) {
        this.professorNome = professorNome;
    }

    public DiaDaSemana getDia() {
        return dia;
    }

    public void setDia(DiaDaSemana dia) {
        this.dia = dia;
    }

    public HorarioDaAula getHorario() {
        return horario;
    }

    public void setHorario(HorarioDaAula horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "cursoNome='" + cursoNome + '\'' +
                ", disciplinanome='" + disciplinanome + '\'' +
                ", professorNome='" + professorNome + '\'' +
                ", dia=" + dia +
                ", horario=" + horario +
                '}';
    }
}
