package com.datatech.datatechapi.controller;

import com.datatech.datatechapi.App;
import com.datatech.datatechapi.Entities.Enums.DiaDaSemana;
import com.datatech.datatechapi.Entities.Enums.HorarioDaAula;
import com.datatech.datatechapi.Entities.models.Professor;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.StageStyle;

import java.net.URL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class RestricoesController implements Initializable{

    @FXML
    private Button btn_salvar;

    @FXML
    private ComboBox<DiaDaSemana> cbx_diadasemana;

    @FXML
    private ComboBox<HorarioDaAula> cbx_horariodaaula;

    @FXML
    private Label lbl_professor;

    @FXML
    private TableColumn<?, ?> tbc_diadasemana;

    @FXML
    private TableColumn<?, ?> tbc_horariodaaula;

    @FXML
    private TableView<?> tbv_restricoes;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        visualizarNomeProfessor();
        //cbx_diadasemana.getItems().setAll(DiaDaSemana.values());
        visualizarDiaSemana(cbx_diadasemana);
        visualizarHorarios(cbx_horariodaaula);
        //cbx_horariodaaula.getItems().setAll(HorarioDaAula.values());

    }

    @FXML
    void excluirResticao(ActionEvent event) {

    }

    @FXML
    void salvarRestricao(ActionEvent event) {

    }

    void visualizarNomeProfessor() {
        Professor professor = new Professor();
        lbl_professor.setText(LoginController.USUARIOLOGADO);
    }
    void visualizarDiaSemana(ComboBox cbx){
        for(DiaDaSemana dia : DiaDaSemana.values()){
            cbx.getItems().add(dia.getDescricao());
        }
    }
    void visualizarHorarios(ComboBox cbx){
        for(HorarioDaAula horario : HorarioDaAula.values()){
            cbx.getItems().add(horario.getDescricao());
        }
    }



}
