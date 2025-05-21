package com.datatech.datatechapi.controller;

import com.datatech.datatechapi.App;
import com.datatech.datatechapi.dao.CursoDao;
import com.datatech.datatechapi.dao.GradeDao;
import com.datatech.datatechapi.entities.models.Curso;
import com.datatech.datatechapi.entities.models.Grade;
import com.datatech.datatechapi.util.Conexao;


import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.alignment.HorizontalAlignment;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class VisualizarGradeController implements Initializable {

    @FXML
    private ComboBox<?> cbx_curso;

    @FXML
    private Button btn_visualizarpdf;

    @FXML
    private Button btn_voltar;

    @FXML
    private GridPane gdp_visualizar;

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
    private Label lbl_qua_pri;

    @FXML
    private Label lbl_qua_qua;

    @FXML
    private Label lbl_qua_qui;

    @FXML
    private Label lbl_qua_seg;

    @FXML
    private Label lbl_qua_ter;

    @FXML
    private Label lbl_qui_pri;

    @FXML
    private Label lbl_qui_qua;

    @FXML
    private Label lbl_qui_qui;

    @FXML
    private Label lbl_qui_seg;

    @FXML
    private Label lbl_qui_ter;

    @FXML
    private Label lbl_seg_pri;

    @FXML
    private Label lbl_seg_qua;

    @FXML
    private Label lbl_seg_qui;

    @FXML
    private Label lbl_seg_seg;

    @FXML
    private Label lbl_seg_ter;

    @FXML
    private Label lbl_sex_pri;

    @FXML
    private Label lbl_sex_qua;

    @FXML
    private Label lbl_sex_qui;

    @FXML
    private Label lbl_sex_seg;

    @FXML
    private Label lbl_sex_ter;

    @FXML
    private Label lbl_ter_pri;

    @FXML
    private Label lbl_ter_qua;

    @FXML
    private Label lbl_ter_qui;

    @FXML
    private Label lbl_ter_seg;

    @FXML
    private Label lbl_ter_ter;


    GradeDao gradeDao = new GradeDao();
    ObservableList<Curso> cursos;
    CursoDao cursoDao = new CursoDao();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        visualizarCursos(cbx_curso);
    }

    @FXML
    void visualizarGrade(ActionEvent event) {
        if (event.getSource() == cbx_curso) {
            String nomeCurso = String.valueOf(cbx_curso.getSelectionModel().getSelectedItem());
            visualizarGrade();
        }
    }

    @FXML
    void visualizarPdf(ActionEvent event) throws IOException {

        Document documento = new Document();

        PdfWriter.getInstance(documento, new FileOutputStream("grade.pdf"));

        documento.open();
        documento.setPageSize(PageSize.A4);
        documento.setMargins(0,0,3,3);


        Table table = new Table(6);
        table.setWidths(new float[]{12,25, 25, 25,25,25});
        table.setWidth(100);

        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD,9);
        
        table.setHorizontalAlignment(HorizontalAlignment.CENTER);
        Paragraph p = new Paragraph(String.valueOf(cbx_curso.getValue()));
        p.setAlignment("center");
        documento.add(p);

        table.addCell(new Cell(lb_segunda.getText()),0,1);
        table.addCell(new Cell(lb_terca.getText()),0,2);
        table.addCell(new Cell( lb_quarta.getText()),0,3);
        table.addCell(new Cell( lb_quinta.getText()),0,4);
        table.addCell(new Cell(lb_sexta.getText()),0,5);


        table.addCell(new Cell("1ª Aula"),1,0);
        table.addCell(new Cell("2ª Aula"),2,0);
        table.addCell(new Cell("3ª Aula"),3,0);
        table.addCell(new Cell("4ª Aula"),4,0);
        table.addCell(new Cell("5ª Aula"),5,0);
        table.setBackgroundColor(ColorUIResource.getHSBColor(255,200,50));


        List<Grade> grades = new ArrayList<>();
        grades = gradeDao.buscarPorCurso(nomeCurso(cbx_curso));
        for(var item : grades){
            if(item.getDisciplinanome().equals("AULA VAGA"))
                table.addCell(new Cell(item.getDisciplinanome()),item.getLinha(),item.getColuna());
            else
                table.addCell(new Cell(item.getDisciplinanome() + "\n" + item.getProfessorNome()),item.getLinha(),item.getColuna());


        }


        documento.add(table);

        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File("grade.pdf"));

        documento.close();


    }

    @FXML
    void voltarMenu(ActionEvent event) throws IOException {
        App.setRoot("views/telamenu.fxml");
    }

    void visualizarCursos(ComboBox cbx) {
        cursos = FXCollections.observableList(cursoDao.buscarTodos());
        for (Curso c : cursos) {
            cbx.getItems().add(c.getNome());
            cbx.setValue(" ");
        }
    }

    void receberDados(Label lbl) {
        String nome = nomeCurso(cbx_curso);
        List<Grade> grades = new ArrayList<>();
        grades = gradeDao.buscarPorCurso(nome);
        lbl.setText(" ");
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i).getLinha() == GridPane.getRowIndex(lbl) &&
                    grades.get(i).getColuna() == GridPane.getColumnIndex(lbl)) {
                if (grades.get(i).getDisciplinanome().equals("AULA VAGA"))
                    lbl.setText(grades.get(i).getDisciplinanome());
                else
                    lbl.setText(grades.get(i).getDisciplinanome() + "\n" + grades.get(i).getProfessorNome());
            }
        }
    }

    String nomeCurso(ComboBox cbx) {
        String curso = (String) cbx.getValue();
        return curso;
    }

    void visualizarGrade() {
        receberDados(lbl_ter_pri);
        receberDados(lbl_ter_qua);
        receberDados(lbl_ter_qui);
        receberDados(lbl_ter_seg);
        receberDados(lbl_ter_ter);
        receberDados(lbl_sex_pri);
        receberDados(lbl_sex_seg);
        receberDados(lbl_sex_ter);
        receberDados(lbl_sex_qua);
        receberDados(lbl_sex_qui);
        receberDados(lbl_seg_pri);
        receberDados(lbl_seg_qua);
        receberDados(lbl_seg_qui);
        receberDados(lbl_seg_seg);
        receberDados(lbl_seg_ter);
        receberDados(lbl_qui_pri);
        receberDados(lbl_qui_qua);
        receberDados(lbl_qui_qui);
        receberDados(lbl_qui_seg);
        receberDados(lbl_qui_ter);
        receberDados(lbl_qua_pri);
        receberDados(lbl_qua_qua);
        receberDados(lbl_qua_qui);
        receberDados(lbl_qua_seg);
        receberDados(lbl_qua_ter);
    }
}
