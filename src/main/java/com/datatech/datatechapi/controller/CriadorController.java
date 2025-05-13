package com.datatech.datatechapi.controller;

import com.datatech.datatechapi.dao.GradeDao;
import com.datatech.datatechapi.entities.Enums.DiaDaSemana;
import com.datatech.datatechapi.entities.Enums.HorarioDaAula;
import com.datatech.datatechapi.entities.models.Curso;
import com.datatech.datatechapi.entities.models.Disciplina;
import com.datatech.datatechapi.dao.CursoDao;
import com.datatech.datatechapi.dao.DisciplinaDao;

import com.datatech.datatechapi.entities.models.Grade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.controlsfx.control.Notifications;
import org.jetbrains.annotations.NotNull;


import java.net.URL;
import java.util.*;
import java.util.List;

public class CriadorController implements Initializable {

    @FXML
    private Button bt_salvar;

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


    CursoDao cursoDao = new CursoDao();
    ObservableList<Curso> cursos;

    GradeDao gradeDao = new GradeDao();
    List<Grade> grades = new ArrayList<>();
    String[] dias = {"SEGUNDA_FEIRA", "TERCA_FEIRA", "QUARTA_FEIRA", "QUINTA_FEIRA", "SEXTA_FEIRA"};
    String[] aulas = {"PRIMEIRA_AULA", "SEGUNDA_AULA", "TERCEIRA_AULA", "QUARTA_AULA", "QUINTA_AULA"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        visualizarCursos(cbx_curso);
    }

    @FXML
    void salvarGrade(ActionEvent event) {
        if (cbx_curso.getValue() == null) {
            Notifications.create()
                    .darkStyle()
                    .position(Pos.CENTER)
                    .text("O campo CURSO deve ser preenchido!!!")
                    .title("Necessário atençaõ")
                    .showWarning();
        } else {
            receberDados();
        }
    }
    void visualizarDisciplinas(ComboBox cbx) {
        Curso c = new Curso();
        List<Disciplina> disciplinas = new ArrayList<>();
        c = disciplinaDao.buscarCursoPorNome(nomeCurso(cbx_curso));
        disciplinas = disciplinaDao.buscarTodosPorCurso(c.getId());
        cbx.getItems().clear();
        for (Disciplina d : disciplinas) {
            cbx.getItems().add(d.getNome());
        }
    }
    void visualizarCursos(ComboBox cbx) {
        cursos = FXCollections.observableList(cursoDao.buscarTodos());
        for (Curso c : cursos) {
            cbx.getItems().add(c.getNome());
            cbx.setValue(c.getNome());
        }
    }
    void receberDados(ComboBox cbx) {
        String curso = nomeCurso(cbx_curso);
        Grade grade = new Grade();
        for (int i = 1; i < gdp_grade.getRowCount(); i++) {
            for (int j = 1; j < gdp_grade.getColumnCount(); j++)
                if (GridPane.getColumnIndex(cbx) == j && GridPane.getRowIndex(cbx) == i) {
                    if (cbx.getValue() == null) {
                        grade.setCursoNome(curso);
                        grade.setDisciplinanome("AULA VAGA");
                        grade.setHorario(HorarioDaAula.valueOf(aulas[i - 1]));
                        grade.setDia(DiaDaSemana.valueOf(dias[j - 1]));
                        grade.setLinha(i);
                        grade.setColuna(j);
                    } else {
                        DisciplinaDao disciplinadao = new DisciplinaDao();
                        Disciplina disciplina = new Disciplina();
                        grade.setCursoNome(curso);
                        grade.setDisciplinanome(cbx.getValue().toString());
                        disciplina = disciplinadao.buscarDisciplinaPorNome(cbx.getValue().toString());
                        String nome = disciplina.getProfessor().getNome();
                        grade.setHorario(HorarioDaAula.valueOf(aulas[i - 1]));
                        grade.setDia(DiaDaSemana.valueOf(dias[j - 1]));
                        grade.setLinha(i);
                        grade.setColuna(j);
                        grade.setProfessorNome(nome);
                    }
                }
        }
        grades.add(grade);
    }
    String nomeCurso(ComboBox cbx) {
        String curso = (String) cbx.getValue();
        return curso;
    }
    void visualizarGrade(ComboBox cbx){
        String nome = nomeCurso(cbx_curso);
        List<Grade> grades = new ArrayList<>();
        grades = gradeDao.buscarPorCurso(nome);
        //cbx.setText(" ");
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i).getLinha() == GridPane.getRowIndex(cbx) &&
                    grades.get(i).getColuna() == GridPane.getColumnIndex(cbx))
                    cbx.getItems().add(grades.get(i).getDisciplinanome());
        }
    }
    @FXML
    void preencherDisciplinas(ActionEvent event) {
        if (event.getSource() == cbx_curso) {
            String nomeCurso = String.valueOf(cbx_curso.getSelectionModel().getSelectedItem());
            visualizarDisciplinas();
        }
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
}

