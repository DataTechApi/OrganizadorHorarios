package com.datatech.datatechapi.controller;

import com.datatech.datatechapi.Entities.models.Curso;
import com.datatech.datatechapi.Entities.models.Disciplina;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;

import java.net.URL;
import java.util.ResourceBundle;

public class CriadorController implements Initializable {

    @FXML
    private Button bt_salvar;

    @FXML
    private ComboBox<Curso> cbx_curso;

    @FXML
    private ComboBox<Disciplina> cbx_quarta_pri;

    @FXML
    private ComboBox<?> cbx_quarta_quar;

    @FXML
    private ComboBox<?> cbx_quarta_qui;

    @FXML
    private ComboBox<?> cbx_quarta_seg;

    @FXML
    private ComboBox<?> cbx_quarta_ter;

    @FXML
    private ComboBox<?> cbx_quinta_pri;

    @FXML
    private ComboBox<?> cbx_quinta_quar;

    @FXML
    private ComboBox<?> cbx_quinta_qui;

    @FXML
    private ComboBox<?> cbx_quinta_seg;

    @FXML
    private ComboBox<?> cbx_quinta_ter;

    @FXML
    private ComboBox<?> cbx_segunda_pri;

    @FXML
    private ComboBox<?> cbx_segunda_quar;

    @FXML
    private ComboBox<?> cbx_segunda_qui;

    @FXML
    private ComboBox<?> cbx_segunda_seg;

    @FXML
    private ComboBox<?> cbx_segunda_ter;

    @FXML
    private ComboBox<?> cbx_sexta_pri;

    @FXML
    private ComboBox<?> cbx_sexta_quar;

    @FXML
    private ComboBox<?> cbx_sexta_qui;

    @FXML
    private ComboBox<?> cbx_sexta_seg;

    @FXML
    private ComboBox<?> cbx_sexta_ter;

    @FXML
    private ComboBox<?> cbx_terca_pri;

    @FXML
    private ComboBox<?> cbx_terca_quar;

    @FXML
    private ComboBox<?> cbx_terca_qui;

    @FXML
    private ComboBox<?> cbx_terca_seg;

    @FXML
    private ComboBox<?> cbx_terca_ter;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
