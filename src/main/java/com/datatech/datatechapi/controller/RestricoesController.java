package com.datatech.datatechapi.controller;

import com.datatech.datatechapi.entities.Enums.DiaDaSemana;
import com.datatech.datatechapi.entities.Enums.HorarioDaAula;
import com.datatech.datatechapi.entities.models.Professor;
import com.datatech.datatechapi.entities.models.Restricao;
import com.datatech.datatechapi.dao.RestricaoDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RestricoesController implements Initializable {

    @FXML
    private Button btn_salvar;

    @FXML
    private ComboBox<DiaDaSemana> cbx_diadasemana;

    @FXML
    private ComboBox<HorarioDaAula> cbx_horariodaaula;

    @FXML
    private Label lbl_professor;

    @FXML
    private TableColumn<DiaDaSemana, HorarioDaAula> tbc_diadasemana;

    @FXML
    private TableColumn<DiaDaSemana, HorarioDaAula> tbc_horariodaaula;

    @FXML
    private TableView<Restricao> tbv_restricoes;

    List<Restricao> restricoes = new ArrayList<>();
    RestricaoDao restricaoDao = new RestricaoDao();
    ObservableList<Restricao> restricoesObservable;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        visualizarNomeProfessor();
        visualizarDiaSemana(cbx_diadasemana);
        visualizarHorarios(cbx_horariodaaula);
        preencherTabela();


    }

    @FXML
    void excluirResticao(ActionEvent event) {

    }

    @FXML
    void salvarRestricao(ActionEvent event) {
        preencherTabela();
    }

    void visualizarNomeProfessor() {
        Professor professor = new Professor();
        lbl_professor.setText(LoginController.USUARIOLOGADO);
    }

    void visualizarDiaSemana(ComboBox cbx) {
        for (DiaDaSemana dia : DiaDaSemana.values()) {
            cbx.getItems().add(dia.getDescricao());
        }
    }

    void visualizarHorarios(ComboBox cbx) {
        for (HorarioDaAula horario : HorarioDaAula.values()) {
            cbx.getItems().add(horario.getDescricao());
        }
    }

    void preencherTabela() {
        tbc_diadasemana.setCellValueFactory(new PropertyValueFactory<>("diaDaSemana"));
        tbc_horariodaaula.setCellValueFactory(new PropertyValueFactory<>("horarioDaAula"));

        restricoes = restricaoDao.buscarRestricao(LoginController.EMAIL);
        restricoesObservable= FXCollections.observableArrayList(restricoes);

        tbv_restricoes.setItems(restricoesObservable);
    }


}
