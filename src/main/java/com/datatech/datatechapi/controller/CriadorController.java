package com.datatech.datatechapi.controller;


import com.datatech.datatechapi.App;
import com.datatech.datatechapi.dao.GradeDao;
import com.datatech.datatechapi.dao.RestricaoDao;
import com.datatech.datatechapi.entities.Enums.DiaDaSemana;
import com.datatech.datatechapi.entities.Enums.HorarioDaAula;
import com.datatech.datatechapi.entities.models.Curso;
import com.datatech.datatechapi.entities.models.Disciplina;
import com.datatech.datatechapi.dao.CursoDao;
import com.datatech.datatechapi.dao.DisciplinaDao;

import com.datatech.datatechapi.entities.models.Grade;
import com.datatech.datatechapi.entities.models.Restricao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.net.URL;
import java.nio.file.AccessDeniedException;
import java.util.*;
import java.util.List;

import static com.datatech.datatechapi.util.Alertas.*;
import static com.datatech.datatechapi.util.Detalhes.mostrarDataHora;


public class CriadorController implements Initializable {

    @FXML
    private Button btn_salvar;

    @FXML
    private Button btn_editar;

    @FXML
    private Button btn_voltar;

    @FXML
    private ComboBox<Curso> cbx_curso;

    @FXML
    private ComboBox<Disciplina> cbx_quarta_pri;

    @FXML
    private ComboBox<Disciplina> cbx_quarta_quar;

    @FXML
    private ComboBox<Disciplina> cbx_quarta_qui;

    @FXML
    private ComboBox<Disciplina> cbx_quarta_seg;

    @FXML
    private ComboBox<Disciplina> cbx_quarta_ter;

    @FXML
    private ComboBox<Disciplina> cbx_quinta_pri;

    @FXML
    private ComboBox<Disciplina> cbx_quinta_quar;

    @FXML
    private ComboBox<Disciplina> cbx_quinta_qui;

    @FXML
    private ComboBox<Disciplina> cbx_quinta_seg;

    @FXML
    private ComboBox<Disciplina> cbx_quinta_ter;

    @FXML
    private ComboBox<Disciplina> cbx_segunda_pri;

    @FXML
    private ComboBox<Disciplina> cbx_segunda_quar;

    @FXML
    private ComboBox<Disciplina> cbx_segunda_qui;

    @FXML
    private ComboBox<Disciplina> cbx_segunda_seg;

    @FXML
    private ComboBox<Disciplina> cbx_segunda_ter;

    @FXML
    private ComboBox<Disciplina> cbx_sexta_pri;

    @FXML
    private ComboBox<Disciplina> cbx_sexta_quar;

    @FXML
    private ComboBox<Disciplina> cbx_sexta_qui;

    @FXML
    private ComboBox<Disciplina> cbx_sexta_seg;

    @FXML
    private ComboBox<Disciplina> cbx_sexta_ter;

    @FXML
    private ComboBox<Disciplina> cbx_terca_pri;

    @FXML
    private ComboBox<Disciplina> cbx_terca_quar;

    @FXML
    private ComboBox<Disciplina> cbx_terca_qui;

    @FXML
    private ComboBox<Disciplina> cbx_terca_seg;

    @FXML
    private ComboBox<Disciplina> cbx_terca_ter;

    @FXML
    private Label lb_primeiraaula;

    @FXML
    private Label lb_quarta;

    @FXML
    private Label lbl_rodape;

    @FXML
    private Label lb_quartaaula;

    @FXML
    private Label lb_quinta;

    @FXML
    private Label lb_quintaaula;

    @FXML
    private Label lb_segunda;

    @FXML
    private Label lb_segundaaula;

    @FXML
    private Label lb_sexta;

    @FXML
    private Label lb_terca;

    @FXML
    private Label lb_terceiraaula;

    @FXML
    private GridPane gdp_grade;


    DisciplinaDao disciplinaDao = new DisciplinaDao();
    Disciplina disciplina = new Disciplina();
    RestricaoDao restricaoDao = new RestricaoDao();
    CursoDao cursoDao = new CursoDao();
    GradeDao gradeDao = new GradeDao();
    List<Grade> grades = new ArrayList<>();
    List<Restricao> restricoes = new ArrayList<>();

    String[] dias = {"SEGUNDA_FEIRA", "TERCA_FEIRA", "QUARTA_FEIRA", "QUINTA_FEIRA", "SEXTA_FEIRA"};
    String[] aulas = {"PRIMEIRA_AULA", "SEGUNDA_AULA", "TERCEIRA_AULA", "QUARTA_AULA", "QUINTA_AULA"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        visualizarCursos(cbx_curso);
        lbl_rodape.setText(mostrarDataHora());
    }

    @FXML
    void salvarGrade(ActionEvent event) throws IOException {
        if (cbx_curso.getSelectionModel().isEmpty()) {
           emitirAlertaCampoCurso();
        } else {
            receberDados();
            emitirAlertaGradeSalva();
            App.setRoot("views/criadorgrade.fxml");
        }
    }

    @FXML
    void voltarMenu(ActionEvent event) throws IOException {
        App.setRoot("views/telamenu.fxml");

    }
    void visualizarDisciplinas(ComboBox cbx) {
        Curso c = new Curso();
        ObservableList<Disciplina> disciplinas;
        c = disciplinaDao.buscarCursoPorNome(nomeCurso(cbx_curso));
        disciplinas = FXCollections.observableList(disciplinaDao.buscarTodosPorCurso(c.getId()));
        cbx.getItems().clear();
        for (Disciplina d : disciplinas) {
            cbx.getItems().add(d.getNome());
        }

        cbx.getItems().add(0, "AULA VAGA");
    }

    void visualizarCursos(ComboBox cbx) {
        ObservableList<Curso> cursos;
        cursos = FXCollections.observableList(cursoDao.buscarTodos());
        for (Curso c : cursos) {
            cbx.getItems().add(c.getNome());
            cbx.setValue("");
        }
    }

    void receberDados(ComboBox cbx) {
        String curso = nomeCurso(cbx_curso);
        Grade grade = new Grade();
        DisciplinaDao disciplinadao = new DisciplinaDao();
        Disciplina disciplina = null;
        int i = 0;
        int j = 0;
        for (i = 1; i < gdp_grade.getRowCount(); i++) {
            for (j = 1; j < gdp_grade.getColumnCount(); j++) {
                if (GridPane.getColumnIndex(cbx) == j && GridPane.getRowIndex(cbx) == i) {
                    if (cbx.getValue() == null || cbx.getValue().equals("AULA VAGA")) {
                        grade.setCursoNome(curso);
                        grade.setDisciplinanome("AULA VAGA");
                        grade.setHorario(HorarioDaAula.valueOf(aulas[i - 1]));
                        grade.setDia(DiaDaSemana.valueOf(dias[j - 1]));
                        grade.setLinha(i);
                        grade.setColuna(j);
                    } else {
                        grade.setCursoNome(curso);
                        grade.setDisciplinanome(cbx.getValue().toString());
                        String disc = cbx.getValue().toString();
                        disciplina = disciplinadao.buscarDisciplinaPorNome(disc);
                        String nome = disciplina.getProfessor().getNome();
                        grade.setHorario(HorarioDaAula.valueOf(aulas[i - 1]));
                        grade.setDia(DiaDaSemana.valueOf(dias[j - 1]));
                        grade.setLinha(i);
                        grade.setColuna(j);
                        grade.setProfessorNome(nome);
                    }
                }
            }
        }
        grades.add(grade);
    }


    String nomeCurso(ComboBox cbx) {
        String curso = (String) cbx.getValue();
        return curso;
    }

    @FXML
    void preencherDisciplinas(ActionEvent event) throws IOException {
        if (event.getSource() == cbx_curso) {
            String nomeCurso = String.valueOf(cbx_curso.getSelectionModel().getSelectedItem());
            if (testarGrade(nomeCurso)) {
                emitirAlertaGradeCriada();
            } else {
                visualizarDisciplinas();
            }
        }
    }

    boolean testarGrade(String nome) {
        List<Grade> grades = new ArrayList<>();
        grades = gradeDao.buscarPorCurso(nome);
        if (grades.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    boolean verificarRestricoesProfessor(ComboBox cbx, DiaDaSemana dia, HorarioDaAula aula) {
        String nomeDisciplina = String.valueOf(cbx.getSelectionModel().getSelectedItem());
        if (!nomeDisciplina.equals("AULA VAGA")){
            disciplina = disciplinaDao.buscarDisciplinaPorNome(nomeDisciplina);
            restricoes = restricaoDao.buscarRestricao(disciplina.getProfessor().getEmail());
            for (var item : restricoes) {
                if (disciplina.getProfessor().getEmail().equals(item.getProfessorEmail()) &&
                        item.getDiaDaSemana() == dia &&
                        item.getHorarioDaAula() == aula) {
                    cbx.getSelectionModel().selectNext();
                    return true;
                }
            }
        }
        return false;
    }

    boolean verificarAlocacaoProfessor(ComboBox cbx, DiaDaSemana dia, HorarioDaAula aula) {
        String nomeCurso = nomeCurso(cbx_curso);
        String nomeDisciplina = String.valueOf(cbx.getSelectionModel().getSelectedItem());
        if (!nomeDisciplina.equals("AULA VAGA")) {
            disciplina = disciplinaDao.buscarDisciplinaPorNome(nomeDisciplina);
            List<Grade> horarios = new ArrayList<>();
            horarios = gradeDao.buscarPorProfessor(disciplina.getProfessor().getNome(), nomeCurso);
            for (var item : horarios) {
                if (item.getDia() == dia && item.getHorario() == aula) {
                    cbx.getSelectionModel().selectNext();
                    return true;
                }
            }
        }
        return false;
    }



    @FXML
    void verificarSegundaPri(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_segunda_pri, DiaDaSemana.SEGUNDA_FEIRA, HorarioDaAula.PRIMEIRA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_segunda_pri, DiaDaSemana.SEGUNDA_FEIRA, HorarioDaAula.PRIMEIRA_AULA))
            emitirAlertaAlocacao();
    }

    @FXML
    void verificarSegundaSeg(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_segunda_seg, DiaDaSemana.SEGUNDA_FEIRA, HorarioDaAula.SEGUNDA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_segunda_seg, DiaDaSemana.SEGUNDA_FEIRA, HorarioDaAula.SEGUNDA_AULA))
            emitirAlertaAlocacao();
    }

    @FXML
    void verificarSegundaTer(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_segunda_ter, DiaDaSemana.SEGUNDA_FEIRA, HorarioDaAula.TERCEIRA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_segunda_ter, DiaDaSemana.SEGUNDA_FEIRA, HorarioDaAula.TERCEIRA_AULA))
            emitirAlertaAlocacao();
    }

    @FXML
    void verificarSegundaQuar(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_segunda_quar, DiaDaSemana.SEGUNDA_FEIRA, HorarioDaAula.QUARTA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_segunda_quar, DiaDaSemana.SEGUNDA_FEIRA, HorarioDaAula.QUARTA_AULA))
            emitirAlertaAlocacao();
    }

    @FXML
    void verificarSegundaQui(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_segunda_qui, DiaDaSemana.SEGUNDA_FEIRA, HorarioDaAula.QUINTA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_segunda_qui, DiaDaSemana.SEGUNDA_FEIRA, HorarioDaAula.QUINTA_AULA))
            emitirAlertaAlocacao();
    }

    @FXML
    void verificarTercaPri(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_terca_pri, DiaDaSemana.TERCA_FEIRA, HorarioDaAula.PRIMEIRA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_terca_pri, DiaDaSemana.TERCA_FEIRA, HorarioDaAula.PRIMEIRA_AULA))
            emitirAlertaAlocacao();
    }

    @FXML
    void verificarTercaSeg(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_terca_seg, DiaDaSemana.TERCA_FEIRA, HorarioDaAula.SEGUNDA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_terca_seg, DiaDaSemana.TERCA_FEIRA, HorarioDaAula.SEGUNDA_AULA))
            emitirAlertaAlocacao();
    }

    @FXML
    void verificarTercaTer(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_terca_ter, DiaDaSemana.TERCA_FEIRA, HorarioDaAula.TERCEIRA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_terca_ter, DiaDaSemana.TERCA_FEIRA, HorarioDaAula.TERCEIRA_AULA))
            emitirAlertaAlocacao();
    }

    @FXML
    void verificarTercaQuar(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_terca_quar, DiaDaSemana.TERCA_FEIRA, HorarioDaAula.QUARTA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_terca_quar, DiaDaSemana.TERCA_FEIRA, HorarioDaAula.QUARTA_AULA))
            emitirAlertaAlocacao();
    }

    @FXML
    void verificarTercaQui(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_terca_qui, DiaDaSemana.TERCA_FEIRA, HorarioDaAula.QUINTA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_terca_qui, DiaDaSemana.TERCA_FEIRA, HorarioDaAula.QUINTA_AULA))
            emitirAlertaAlocacao();
    }

    @FXML
    void verificarQuartaPri(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_quarta_pri, DiaDaSemana.QUARTA_FEIRA, HorarioDaAula.PRIMEIRA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_quarta_pri, DiaDaSemana.QUARTA_FEIRA, HorarioDaAula.PRIMEIRA_AULA))
            emitirAlertaAlocacao();
    }

    @FXML
    void verificarQuartaSeg(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_quarta_seg, DiaDaSemana.QUARTA_FEIRA, HorarioDaAula.SEGUNDA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_quarta_seg, DiaDaSemana.QUARTA_FEIRA, HorarioDaAula.SEGUNDA_AULA))
            emitirAlertaAlocacao();
    }

    @FXML
    void verificarQuartaTer(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_quarta_ter, DiaDaSemana.QUARTA_FEIRA, HorarioDaAula.TERCEIRA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_quarta_ter, DiaDaSemana.QUARTA_FEIRA, HorarioDaAula.TERCEIRA_AULA))
            emitirAlertaAlocacao();
    }

    @FXML
    void verificarQuartaQuar(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_quarta_quar, DiaDaSemana.QUARTA_FEIRA, HorarioDaAula.QUARTA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_quarta_quar, DiaDaSemana.QUARTA_FEIRA, HorarioDaAula.QUARTA_AULA))
            emitirAlertaAlocacao();
    }

    @FXML
    void verificarQuartaQui(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_quarta_qui, DiaDaSemana.QUARTA_FEIRA, HorarioDaAula.QUINTA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_quarta_qui, DiaDaSemana.QUARTA_FEIRA, HorarioDaAula.QUINTA_AULA))
            emitirAlertaAlocacao();
    }

    @FXML
    void verificarQuintaPri(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_quinta_pri, DiaDaSemana.QUINTA_FEIRA, HorarioDaAula.PRIMEIRA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_quinta_pri, DiaDaSemana.QUINTA_FEIRA, HorarioDaAula.PRIMEIRA_AULA))
            emitirAlertaAlocacao();
    }

    @FXML
    void verificarQuintaSeg(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_quinta_seg, DiaDaSemana.QUINTA_FEIRA, HorarioDaAula.SEGUNDA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_quinta_seg, DiaDaSemana.QUINTA_FEIRA, HorarioDaAula.SEGUNDA_AULA))
            emitirAlertaAlocacao();
    }

    @FXML
    void verificarQuintaTer(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_quinta_ter, DiaDaSemana.QUINTA_FEIRA, HorarioDaAula.TERCEIRA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_quinta_ter, DiaDaSemana.QUINTA_FEIRA, HorarioDaAula.TERCEIRA_AULA))
            emitirAlertaAlocacao();
    }

    @FXML
    void verificarQuintaQuar(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_quinta_quar, DiaDaSemana.QUINTA_FEIRA, HorarioDaAula.QUARTA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_quinta_quar, DiaDaSemana.QUINTA_FEIRA, HorarioDaAula.QUARTA_AULA))
            emitirAlertaAlocacao();
    }

    @FXML
    void verificarQuintaQui(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_quinta_qui, DiaDaSemana.QUINTA_FEIRA, HorarioDaAula.QUINTA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_quinta_qui, DiaDaSemana.QUINTA_FEIRA, HorarioDaAula.QUINTA_AULA))
            emitirAlertaAlocacao();
    }

    @FXML
    void verificarSextaPri(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_sexta_pri, DiaDaSemana.SEXTA_FEIRA, HorarioDaAula.PRIMEIRA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_sexta_pri, DiaDaSemana.SEXTA_FEIRA, HorarioDaAula.PRIMEIRA_AULA))
            emitirAlertaAlocacao();
    }

    @FXML
    void verificarSextaSeg(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_sexta_seg, DiaDaSemana.SEXTA_FEIRA, HorarioDaAula.SEGUNDA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_sexta_seg, DiaDaSemana.SEXTA_FEIRA, HorarioDaAula.SEGUNDA_AULA))
            emitirAlertaAlocacao();
    }

    @FXML
    void verificarSextaTer(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_sexta_ter, DiaDaSemana.SEXTA_FEIRA, HorarioDaAula.TERCEIRA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_sexta_ter, DiaDaSemana.SEXTA_FEIRA, HorarioDaAula.TERCEIRA_AULA))
            emitirAlertaAlocacao();
    }

    @FXML
    void verificarSextaQuar(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_sexta_quar, DiaDaSemana.SEXTA_FEIRA, HorarioDaAula.QUARTA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_sexta_quar, DiaDaSemana.SEXTA_FEIRA, HorarioDaAula.QUARTA_AULA))
            emitirAlertaAlocacao();
    }

    @FXML
    void verificarSextaQui(ActionEvent event) {
        if (verificarRestricoesProfessor(cbx_sexta_qui, DiaDaSemana.SEXTA_FEIRA, HorarioDaAula.QUINTA_AULA))
            emitirAlerta();
        else if (verificarAlocacaoProfessor(cbx_sexta_qui, DiaDaSemana.SEXTA_FEIRA, HorarioDaAula.QUINTA_AULA))
            emitirAlertaAlocacao();
    }

    void receberDados() {
        receberDados(cbx_segunda_pri);
        receberDados(cbx_segunda_seg);
        receberDados(cbx_segunda_ter);
        receberDados(cbx_segunda_quar);
        receberDados(cbx_segunda_qui);
        receberDados(cbx_terca_pri);
        receberDados(cbx_terca_seg);
        receberDados(cbx_terca_ter);
        receberDados(cbx_terca_quar);
        receberDados(cbx_terca_qui);
        receberDados(cbx_quarta_pri);
        receberDados(cbx_quarta_seg);
        receberDados(cbx_quarta_ter);
        receberDados(cbx_quarta_quar);
        receberDados(cbx_quarta_qui);
        receberDados(cbx_quinta_pri);
        receberDados(cbx_quinta_seg);
        receberDados(cbx_quinta_ter);
        receberDados(cbx_quinta_quar);
        receberDados(cbx_quinta_qui);
        receberDados(cbx_sexta_pri);
        receberDados(cbx_sexta_seg);
        receberDados(cbx_sexta_ter);
        receberDados(cbx_sexta_quar);
        receberDados(cbx_sexta_qui);
        gradeDao.cadastrarGrade(grades);
    }

    void visualizarDisciplinas() {
        visualizarDisciplinas(cbx_segunda_pri);
        visualizarDisciplinas(cbx_segunda_seg);
        visualizarDisciplinas(cbx_segunda_ter);
        visualizarDisciplinas(cbx_segunda_quar);
        visualizarDisciplinas(cbx_segunda_qui);
        visualizarDisciplinas(cbx_terca_pri);
        visualizarDisciplinas(cbx_terca_seg);
        visualizarDisciplinas(cbx_terca_ter);
        visualizarDisciplinas(cbx_terca_quar);
        visualizarDisciplinas(cbx_terca_qui);
        visualizarDisciplinas(cbx_quarta_pri);
        visualizarDisciplinas(cbx_quarta_seg);
        visualizarDisciplinas(cbx_quarta_ter);
        visualizarDisciplinas(cbx_quarta_qui);
        visualizarDisciplinas(cbx_quarta_quar);
        visualizarDisciplinas(cbx_quinta_pri);
        visualizarDisciplinas(cbx_quinta_seg);
        visualizarDisciplinas(cbx_quinta_ter);
        visualizarDisciplinas(cbx_quinta_quar);
        visualizarDisciplinas(cbx_quinta_qui);
        visualizarDisciplinas(cbx_sexta_pri);
        visualizarDisciplinas(cbx_sexta_seg);
        visualizarDisciplinas(cbx_sexta_ter);
        visualizarDisciplinas(cbx_sexta_quar);
        visualizarDisciplinas(cbx_sexta_qui);
    }
}



