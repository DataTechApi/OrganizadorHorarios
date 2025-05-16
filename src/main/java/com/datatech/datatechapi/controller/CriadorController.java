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
    private ComboBox cbx_segunda_qui;

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
            limparCampos();
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
            cbx.setValue(" ");
        }
    }

    void receberDados(ComboBox cbx) {
        String curso = nomeCurso(cbx_curso);
        Grade grade = new Grade();
        for (int i = 1; i < gdp_grade.getRowCount(); i++) {
            for (int j = 1; j < gdp_grade.getColumnCount(); j++) {
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
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Necessário atençaõ");
                alert.setHeaderText("Grade");
                alert.setContentText("Esse curso já possui uma grade cadastrada!!! \n" +
                        "Acesse á Visualização de Grades para ver a sua grade.");
                alert.showAndWait();
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/visualizargrade.fxml"));
                Parent visualizar = fxmlLoader.load();
                Scene scene = new Scene(visualizar);
                Stage stage = new Stage();
                stage.setTitle("DataTech API - Visualizar Grade    " + " Usuário Logado: " + LoginController.USUARIOLOGADO.toUpperCase());
                stage.initStyle(StageStyle.UTILITY);
                stage.setScene(scene);
                stage.show();

            } else {
                visualizarDisciplinas();
            }

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

    void limparCampos(ComboBox cbx) {
        cbx.setValue(" ");
    }

    void limparCampos() {
        limparCampos(cbx_segunda_pri);
        limparCampos(cbx_segunda_seg);
        limparCampos(cbx_segunda_ter);
        limparCampos(cbx_segunda_quar);
        limparCampos(cbx_segunda_qui);
        limparCampos(cbx_terca_pri);
        limparCampos(cbx_terca_seg);
        limparCampos(cbx_terca_ter);
        limparCampos(cbx_terca_quar);
        limparCampos(cbx_terca_qui);
        limparCampos(cbx_quarta_pri);
        limparCampos(cbx_quarta_seg);
        limparCampos(cbx_quarta_ter);
        limparCampos(cbx_quarta_quar);
        limparCampos(cbx_quarta_qui);
        limparCampos(cbx_quinta_pri);
        limparCampos(cbx_quinta_seg);
        limparCampos(cbx_quinta_ter);
        limparCampos(cbx_quinta_quar);
        limparCampos(cbx_quinta_qui);
        limparCampos(cbx_sexta_pri);
        limparCampos(cbx_sexta_seg);
        limparCampos(cbx_sexta_ter);
        limparCampos(cbx_sexta_quar);
        limparCampos(cbx_sexta_qui);
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

    Restricao r = new Restricao();
    List<Restricao> restricoes = new ArrayList<>();
    RestricaoDao restricaoDao = new RestricaoDao();
    DisciplinaDao d = new DisciplinaDao();
    Disciplina disciplina = new Disciplina();

    @FXML
    void verificarSegundaPri(ActionEvent event) {
       verificarRestricoesProfessor(cbx_segunda_pri, DiaDaSemana.SEGUNDA_FEIRA, HorarioDaAula.PRIMEIRA_AULA);
    }
    @FXML
    void verificarSegundaSeg(ActionEvent event) {
        verificarRestricoesProfessor(cbx_segunda_seg, DiaDaSemana.SEGUNDA_FEIRA, HorarioDaAula.SEGUNDA_AULA);
    }
    @FXML
    void verificarSegundaTer(ActionEvent event) {
        verificarRestricoesProfessor(cbx_segunda_ter, DiaDaSemana.SEGUNDA_FEIRA, HorarioDaAula.TERCEIRA_AULA);
    }
    @FXML
    void verificarSegundaQuar(ActionEvent event) {
        verificarRestricoesProfessor(cbx_segunda_quar, DiaDaSemana.SEGUNDA_FEIRA, HorarioDaAula.QUARTA_AULA);
    }
    @FXML
    void verificarSegundaQui(ActionEvent event) {
        verificarRestricoesProfessor(cbx_segunda_qui, DiaDaSemana.SEGUNDA_FEIRA, HorarioDaAula.QUINTA_AULA);
    }
    @FXML
    void verificarTercaPri(ActionEvent event) {
        verificarRestricoesProfessor(cbx_terca_pri, DiaDaSemana.TERCA_FEIRA, HorarioDaAula.PRIMEIRA_AULA);
    }
    @FXML
    void verificarTercaSeg(ActionEvent event) {
        verificarRestricoesProfessor(cbx_terca_seg, DiaDaSemana.TERCA_FEIRA, HorarioDaAula.SEGUNDA_AULA);
    }
    @FXML
    void verificarTercaTer(ActionEvent event) {
        verificarRestricoesProfessor(cbx_terca_ter, DiaDaSemana.TERCA_FEIRA, HorarioDaAula.TERCEIRA_AULA);
    }
    @FXML
    void verificarTercaQuar(ActionEvent event) {
        verificarRestricoesProfessor(cbx_terca_quar, DiaDaSemana.TERCA_FEIRA, HorarioDaAula.QUARTA_AULA);
    }
    @FXML
    void verificarTercaQui(ActionEvent event) {
        verificarRestricoesProfessor(cbx_terca_qui, DiaDaSemana.TERCA_FEIRA, HorarioDaAula.QUINTA_AULA);
    }
    @FXML
    void verificarQuartaPri(ActionEvent event) {
        verificarRestricoesProfessor(cbx_quarta_pri, DiaDaSemana.QUARTA_FEIRA, HorarioDaAula.PRIMEIRA_AULA);
    }
    @FXML
    void verificarQuartaSeg(ActionEvent event) {
        verificarRestricoesProfessor(cbx_quarta_seg, DiaDaSemana.QUARTA_FEIRA, HorarioDaAula.SEGUNDA_AULA);
    }
    @FXML
    void verificarQuartaTer(ActionEvent event) {
        verificarRestricoesProfessor(cbx_quarta_ter, DiaDaSemana.QUARTA_FEIRA, HorarioDaAula.TERCEIRA_AULA);
    }
    @FXML
    void verificarQuartaQuar(ActionEvent event) {
        verificarRestricoesProfessor(cbx_quarta_quar, DiaDaSemana.QUARTA_FEIRA, HorarioDaAula.QUARTA_AULA);
    }
    @FXML
    void verificarQuartaQui(ActionEvent event) {
        verificarRestricoesProfessor(cbx_quarta_qui, DiaDaSemana.QUARTA_FEIRA, HorarioDaAula.QUINTA_AULA);
    }
    @FXML
    void verificarQuintaPri(ActionEvent event) {
        verificarRestricoesProfessor(cbx_quinta_pri, DiaDaSemana.QUINTA_FEIRA, HorarioDaAula.PRIMEIRA_AULA);
    }
    @FXML
    void verificarQuintaSeg(ActionEvent event) {
        verificarRestricoesProfessor(cbx_quinta_seg, DiaDaSemana.QUINTA_FEIRA, HorarioDaAula.SEGUNDA_AULA);
    }
    @FXML
    void verificarQuintaTer(ActionEvent event) {
        verificarRestricoesProfessor(cbx_quinta_ter, DiaDaSemana.QUINTA_FEIRA, HorarioDaAula.TERCEIRA_AULA);
    }
    @FXML
    void verificarQuintaQuar(ActionEvent event) {
        verificarRestricoesProfessor(cbx_quinta_quar, DiaDaSemana.QUINTA_FEIRA, HorarioDaAula.QUARTA_AULA);
    }
    @FXML
    void verificarQuintaQui(ActionEvent event) {
        verificarRestricoesProfessor(cbx_quinta_qui, DiaDaSemana.QUINTA_FEIRA, HorarioDaAula.QUINTA_AULA);
    }
    @FXML
    void verificarSextaPri(ActionEvent event) {
        verificarRestricoesProfessor(cbx_sexta_pri, DiaDaSemana.SEXTA_FEIRA, HorarioDaAula.PRIMEIRA_AULA);
    }
    @FXML
    void verificarSextaSeg(ActionEvent event) {
        verificarRestricoesProfessor(cbx_sexta_seg, DiaDaSemana.SEXTA_FEIRA, HorarioDaAula.SEGUNDA_AULA);
    }
    @FXML
    void verificarSextaTer(ActionEvent event) {
        verificarRestricoesProfessor(cbx_sexta_ter, DiaDaSemana.SEXTA_FEIRA, HorarioDaAula.TERCEIRA_AULA);
    }
    @FXML
    void verificarSextaQuar(ActionEvent event) {
        verificarRestricoesProfessor(cbx_sexta_quar, DiaDaSemana.SEXTA_FEIRA, HorarioDaAula.QUARTA_AULA);
    }
    @FXML
    void verificarSextaQui(ActionEvent event) {
        verificarRestricoesProfessor(cbx_sexta_qui, DiaDaSemana.SEXTA_FEIRA, HorarioDaAula.QUINTA_AULA);
    }

    void verificarRestricoesProfessor(ComboBox cbx, DiaDaSemana dia, HorarioDaAula aula){
        String nomeDisciplina = String.valueOf(cbx.getSelectionModel().getSelectedItem());
        disciplina = d.buscarDisciplinaPorNome(nomeDisciplina);
        restricoes = restricaoDao.buscarRestricao(disciplina.getProfessor().getEmail());
        for (var item : restricoes) {
            if (disciplina.getProfessor().getEmail().equals(item.getProfessorEmail()) &&
                    item.getDiaDaSemana() == dia &&
                    item.getHorarioDaAula() == aula) {
                emitirAlerta();
                cbx.getSelectionModel().selectNext();
                    }
        }

    }
    void emitirAlerta() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Conflito de Horário");
        alert.setContentText("Professor possui restriçao de horário!!!");
        alert.showAndWait();
    }

}

