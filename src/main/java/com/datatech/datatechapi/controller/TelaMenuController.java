package com.datatech.datatechapi.controller;

import com.datatech.datatechapi.App;
import com.datatech.datatechapi.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaMenuController implements Initializable {

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private MenuBar barramenu;

    @FXML
    private Menu logout;

    @FXML
    private MenuItem mit_sair;

    @FXML
    private Menu menugrade;

    @FXML
    private Menu menuprofessor;

    @FXML
    private MenuItem mit_criargrade;

    @FXML
    private MenuItem mit_logout;

    @FXML
    private MenuItem mit_restricoes;

    @FXML
    private MenuItem mit_visualizargrade;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        verificarCoordenador();
    }


    @FXML
    void cadastrarRestricoes(ActionEvent event) throws IOException {
        App.setRoot("views/restricoes.fxml");
    }

    @FXML
    public void criarGrade(ActionEvent event) throws IOException {
        App.setRoot("views/criadorgrade.fxml");
    }

    @FXML
    void realizarLogout(ActionEvent event) throws IOException {
        App.setRoot("views/login.fxml");
    }

    @FXML
    void visualizarGrade(ActionEvent event) throws IOException {
        App.setRoot("views/visualizargrade.fxml");
    }
    void verificarCoordenador(){
        if (LoginController.EHCOORDENADOR == true) mit_criargrade.setDisable(false);
        else mit_criargrade.setDisable(true);
    }
    @FXML
    void sairDoSistema(ActionEvent event) {
        System.exit(0);

    }
}
