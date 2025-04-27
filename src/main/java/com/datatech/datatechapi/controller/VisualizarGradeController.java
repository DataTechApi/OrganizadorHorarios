package com.datatech.datatechapi.controller;

import com.datatech.datatechapi.Entities.models.Curso;
import com.datatech.datatechapi.dao.CursoDao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class VisualizarGradeController implements Initializable {

    @FXML
    private ComboBox<Curso> cbx_curso;

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

    CursoDao cursoDao = new CursoDao();
    List<Curso> cursos = cursoDao.buscarTodos();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        visualizarCursos(cbx_curso);
    }
    void visualizarCursos(ComboBox cbx){
        for (Curso c : cursos){
            cbx.getItems().add(c.getNome().toUpperCase());
        }
    }
}
