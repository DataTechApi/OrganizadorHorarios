package com.datatech.datatechapi;

import com.datatech.datatechapi.controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {

    public static Scene scene;
    public static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/login.fxml"));
        Parent login = fxmlLoader.load();
        scene = new Scene(login);
        String caminhoCss = getClass().getResource("styles.css").toExternalForm();
        stage.setTitle("DataTech API  -  DataGrade");
        stage.initStyle(StageStyle.UTILITY);
        scene.getStylesheets().add(caminhoCss);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void setRoot(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        scene.setRoot(root);
    }

}