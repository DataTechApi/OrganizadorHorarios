package com.datatech.datatechapi.controller;

import com.datatech.datatechapi.Entities.models.Curso;
import com.datatech.datatechapi.Entities.models.Disciplina;
import com.datatech.datatechapi.dao.CursoDao;
import com.datatech.datatechapi.dao.DisciplinaDao;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

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
    private ComboBox<Disciplina>cbx_quarta_seg;

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
    private Label lb_quarta;

    @FXML
    private Label lb_quinta;

    @FXML
    private Label lb_segunda;

    @FXML
    private Label lb_sexta;

    @FXML
    private Label lb_terca;


    DisciplinaDao disciplinaDao = new DisciplinaDao();
    List<Disciplina> disciplinas=disciplinaDao.buscarTodosNome();

    CursoDao cursoDao = new CursoDao();
    List<Curso> cursos = cursoDao.buscarTodos();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
        visualizarCursos(cbx_curso);
    }

    void visualizarDisciplinas(ComboBox cbx){
        for (Disciplina d : disciplinas){
            cbx.getItems().add(d.getNome().toUpperCase());
        }
    }
    void visualizarCursos(ComboBox cbx){
        for (Curso c : cursos){
            cbx.getItems().add(c.getNome().toUpperCase());
        }
    }


}
