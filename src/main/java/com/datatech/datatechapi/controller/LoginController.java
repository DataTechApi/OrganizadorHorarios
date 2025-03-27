package com.datatech.datatechapi.controller;

import com.datatech.datatechapi.App;
import com.datatech.datatechapi.model.Professor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController  implements Initializable {
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
        professor.setNome("Jackson");
        professor.setEmail("teste@gmail.com");
        professor.setSenha("123456");
        if (tf_email.getText().equals(professor.getEmail()) &&
        pwd_senha.getText().equals(professor.getSenha())){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Login");
            alert.setHeaderText("Login realizado com sucesso!!!");
            alert.setContentText("Seja bem-vindo " + professor.getNome());
            alert.show();

            App.setRoot("restricoes");
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Login");
            alert.setHeaderText("Login não realizado!!!");
            alert.setContentText("Os dados estão incorretos!!!");
            alert.show();
        }



    }
}
