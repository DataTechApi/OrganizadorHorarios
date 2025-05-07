package com.datatech.datatechapi.controller;

import com.datatech.datatechapi.dao.GradeDao;
import com.datatech.datatechapi.entities.Enums.DiaDaSemana;
import com.datatech.datatechapi.entities.Enums.HorarioDaAula;
import com.datatech.datatechapi.entities.models.Curso;
import com.datatech.datatechapi.entities.models.Disciplina;
import com.datatech.datatechapi.dao.CursoDao;
import com.datatech.datatechapi.dao.DisciplinaDao;

import com.datatech.datatechapi.entities.models.Grade;
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
    List<Disciplina> disciplinas = disciplinaDao.buscarTodosPorCurso();


    CursoDao cursoDao = new CursoDao();
    List<Curso> cursos = cursoDao.buscarTodos();

    GradeDao gradeDao = new GradeDao();
    List<Grade> grades = new ArrayList<>();

   ;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        visualizarCursos(cbx_curso);
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

    @FXML
    void salvarGrade(ActionEvent event) {
        if (cbx_curso.getValue() == null) {
            Notifications.create()
                    .darkStyle()
                    .position(Pos.CENTER)
                    .text("O campo CURSO deve ser preenchido!!!")
                    .title("Necessário atençaõ")
                    .showWarning();
        }else{
            receberDados(cbx_sexta_pri);
            receberDados(cbx_sexta_seg);
            receberDados(cbx_sexta_ter);
            receberDados(cbx_sexta_quar);
            receberDados(cbx_sexta_qui);
        }
    }

    void visualizarDisciplinas(ComboBox cbx) {
        for (Disciplina d : disciplinas) {
            cbx.getItems().add(d.getNome());
        }
    }

    void visualizarCursos(ComboBox cbx) {
        for (Curso c : cursos) {
            cbx.getItems().add(c.getNome());
        }
    }

    void receberDados(ComboBox cbx) {
        String curso = nomeCurso(cbx_curso);
        for (int i = 1; i < gdp_grade.getRowCount(); i++) {
            for(int j = 1; j < gdp_grade.getColumnCount(); j++)
            if(GridPane.getColumnIndex(cbx) == j && GridPane.getRowIndex(cbx) == i){
                Grade grade = new Grade();
                grade.setCursoNome(curso);
                grade.setDisciplinanome(cbx.getValue().toString());
                grade.setDia(DiaDaSemana.SEXTA_FEIRA);
                grade.setHorario(HorarioDaAula.PRIMEIRA_AULA);
                grades.add(grade);
            }
        }
       gradeDao.cadastrarGrade(grades);
        for(Grade g : grades){
            System.out.println(g);
        }
    }
     String  nomeCurso(@org.jetbrains.annotations.NotNull ComboBox cbx){
        String curso = (java.lang.String) cbx.getValue();
        return curso;
    }
    boolean verificarCurso(ComboBox cbx){
        if (cbx.getValue() == null){
            return true;
        }else{
            return false;
        }
    }

}
