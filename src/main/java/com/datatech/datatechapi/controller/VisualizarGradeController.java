package com.datatech.datatechapi.controller;

import com.datatech.datatechapi.dao.GradeDao;
import com.datatech.datatechapi.entities.Enums.DiaDaSemana;
import com.datatech.datatechapi.entities.models.Curso;
import com.datatech.datatechapi.dao.CursoDao;
import com.datatech.datatechapi.entities.models.Grade;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
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

    @FXML
    private Label lbl_seg_pri_disc;

    @FXML
    private Label lbl_seg_pri_prof;

    CursoDao cursoDao = new CursoDao();
    List<Curso> cursos = cursoDao.buscarTodos();

    GradeDao gradeDao = new GradeDao();
    Grade grade = new Grade();



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        visualizarCursos(cbx_curso);

    }
    void visualizarCursos(ComboBox cbx){
        for (Curso c : cursos){
            cbx.getItems().add(c.getNome());
        }

    }
    @FXML
    void receberDados(){
        String nome = nomeCurso(cbx_curso);
        List<Grade> lista= new ArrayList<>();
        lista = gradeDao.buscarPorCurso(nome);

        for(Grade g : lista){
            System.out.println(g);
            lbl_seg_pri_disc.setText(g.getDisciplinanome());
            
        }
    }
    String nomeCurso(ComboBox cbx) {
        String curso = (String) cbx.getValue();
        return curso;
    }
}
