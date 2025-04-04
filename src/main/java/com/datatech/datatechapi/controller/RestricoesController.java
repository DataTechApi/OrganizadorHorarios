package com.datatech.datatechapi.controller;

import com.datatech.datatechapi.App;
import com.datatech.datatechapi.Entities.models.Professor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

public class RestricoesController implements Initializable {

    @FXML
    private Button btn_excluir;

    @FXML
    private Button btn_salvar;

    @FXML
    private ComboBox<?> cbx_diadasemana;

    @FXML
    private ComboBox<?> cbx_horariodaaula;

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
    }

    @FXML
    void excluirResticao(ActionEvent event) {

    }

    @FXML
    void salvarRestricao(ActionEvent event) {

    }
    void visualizarNomeProfessor(){
        Professor professor = new Professor();
        professor.setNome("DATATECH");
        lbl_professor.setText(professor.getNome());



    }
}
