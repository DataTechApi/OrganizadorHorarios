package com.datatech.datatechapi.controller;

import com.datatech.datatechapi.App;
import com.datatech.datatechapi.Entities.models.Professor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Button bt_logar;

    @FXML
    private PasswordField pwd_senha;

    @FXML
    private TextField tf_email;



    Professor professor = new Professor();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void logar(ActionEvent event) throws IOException {
        professor.setNome("DATATECH");
        professor.setEmail("teste@gmail.com");
        professor.setSenha("123456");
        if (!tf_email.getText().equals(professor.getEmail()) &&
                !pwd_senha.getText().equals(professor.getSenha())) {
            Notifications.create()
                    .title("Login DataTech API")
                    .position(Pos.TOP_CENTER)
                    .text("Usuário ou senha inválidos!!!")
                    .darkStyle()
                    .showError();
        } else {
            Notifications.create()
                    .title("Login DataTech API")
                    .position(Pos.TOP_CENTER)
                    .text(professor.getNome() + " seu login foi realizado com sucesso!!!")
                    .darkStyle()
                    .showInformation();
            navegarMenu();
        }
    }
    void navegarMenu() throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/telamenu.fxml"));
        Parent menu = fxmlLoader.load();
        Scene scene = new Scene(menu);
        Stage stage = new Stage();
        stage.setTitle("DataTech API - Menu DATAGRADE");
        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);
        stage.show();

    }



}
