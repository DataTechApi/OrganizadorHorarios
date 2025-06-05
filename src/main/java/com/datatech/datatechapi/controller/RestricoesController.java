package com.datatech.datatechapi.controller;

import com.datatech.datatechapi.App;
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
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.datatech.datatechapi.util.Alertas.*;
import static com.datatech.datatechapi.util.Detalhes.mostrarDataHora;

public class RestricoesController implements Initializable {

    @FXML
    private Button btn_salvar;

    @FXML
    private Button btn_voltar;

    @FXML
    private Label lbl_rodape;

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
        cbx_diadasemana.getItems().addAll(DiaDaSemana.values());
        cbx_horariodaaula.getItems().addAll(HorarioDaAula.values());
        preencherTabela();
        lbl_rodape.setText(mostrarDataHora());
    }

    @FXML
    void excluirResticao(ActionEvent event) {
        Restricao restTv = (Restricao) tbv_restricoes.getSelectionModel().getSelectedItem();
        if (restTv == null)
            emitirAlertaSelecao();
        else{
            restricaoDao.removerRestricao(restricoesObservable.get(tbv_restricoes.getSelectionModel().getSelectedIndex()));
            emitirAlertaRestricaoExcluids();
        }

        preencherTabela();
    }

    @FXML
    void salvarRestricao(ActionEvent event) {

        if (cbx_horariodaaula.getSelectionModel().isEmpty() || cbx_diadasemana.getSelectionModel().isEmpty()) {
            emitirAlertaRestricaoCamposVazios();
        } else if (verificarRestricoes()) {
            emitirAlertaRetricoesJaExiste();
        } else {
            Restricao restricao = new Restricao();
            restricao.setDiaDaSemana(cbx_diadasemana.getValue());
            restricao.setHorarioDaAula(cbx_horariodaaula.getValue());
            restricao.setProfessorEmail(LoginController.EMAIL);
            restricaoDao.cadastrarRestricao(restricao);
            preencherTabela();
            limparCampos();
            emitirAlertaRestricaoSalva();
        }
    }

    boolean verificarRestricoes() {
        restricoes = restricaoDao.buscarRestricao(LoginController.EMAIL);
        for (Restricao r : restricoes) {
            if (cbx_diadasemana.getValue().equals(r.getDiaDaSemana()) &&
                    cbx_horariodaaula.getValue().equals(r.getHorarioDaAula()))
                return true;
        }
        return false;
    }

    void visualizarNomeProfessor() {
        Professor professor = new Professor();
        lbl_professor.setText(LoginController.USUARIOLOGADO);
    }

    void preencherTabela() {
        tbc_diadasemana.setCellValueFactory(new PropertyValueFactory<>("diaDaSemana"));
        tbc_horariodaaula.setCellValueFactory(new PropertyValueFactory<>("horarioDaAula"));

        restricoes = restricaoDao.buscarRestricao(LoginController.EMAIL);
        restricoesObservable = FXCollections.observableArrayList(restricoes);

        tbv_restricoes.setItems(restricoesObservable);
    }

    void limparCampos() {
        cbx_diadasemana.getSelectionModel().clearSelection();
        cbx_horariodaaula.getSelectionModel().clearSelection();
    }

    @FXML
    void voltarMenu(ActionEvent event) throws IOException {
        App.setRoot("views/telamenu.fxml");

    }


}
