package com.datatech.datatechapi.controller;

import com.datatech.datatechapi.App;
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
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/restricoes.fxml"));
        Parent restricoes = fxmlLoader.load();
        Scene scene = new Scene(restricoes);
        Stage stage = new Stage();
        stage.setTitle("DataTech API - Cadastrar Restrições   " + " Usuário Logado: "  + LoginController.USUARIOLOGADO.toUpperCase());
        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void criarGrade(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/criadorgrade.fxml"));
        Parent criador = fxmlLoader.load();
        Scene scene = new Scene(criador,800,600);
        Stage stage = new Stage();
        stage.setTitle("DataTech API - Criador Grade   "+ " Usuário Logado: "  + LoginController.USUARIOLOGADO.toUpperCase());
        stage.initStyle(StageStyle.UTILITY);
       // stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void realizarLogout(ActionEvent event) {


    }

    @FXML
    void visualizarGrade(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/visualizargrade.fxml"));
        Parent visualizar = fxmlLoader.load();
        Scene scene = new Scene(visualizar, 800,600);
        Stage stage = new Stage();
        stage.setTitle("DataTech API - Visualizar Grade    "+ " Usuário Logado: "  + LoginController.USUARIOLOGADO.toUpperCase());
        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);
        stage.show();


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
