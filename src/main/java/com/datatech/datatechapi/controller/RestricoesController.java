package com.datatech.datatechapi.controller;

import com.datatech.datatechapi.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private ComboBox<?> cbx_professor;

    @FXML
    private TableColumn<?, ?> tbc_diadasemana;

    @FXML
    private TableColumn<?, ?> tbc_horariodaaula;

    @FXML
    private TableView<?> tbv_restricoes;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void excluirResticao(ActionEvent event) {

    }

    @FXML
    void salvarRestricao(ActionEvent event) {

    }


}
