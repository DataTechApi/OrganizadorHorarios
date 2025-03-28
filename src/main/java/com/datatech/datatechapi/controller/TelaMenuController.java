package com.datatech.datatechapi.controller;

import com.datatech.datatechapi.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    }

    @FXML
    void cadastrarRestricoes(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("restricoes.fxml"));
        Parent restricoes = fxmlLoader.load();
        Scene scene = new Scene(restricoes);
       // String caimnhoCss = getClass().getResource("styles.css").toExternalForm();
        Stage stage = new Stage();
        stage.setTitle("DataTech API - Cadastrar Restrições");
        stage.initStyle(StageStyle.UTILITY);
        //scene.getStylesheets().add(caimnhoCss);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void criarGrade(ActionEvent event) {

    }

    @FXML
    void realizarLogout(ActionEvent event) {

    }

    @FXML
    void visualizarGrade(ActionEvent event) {

    }


}
