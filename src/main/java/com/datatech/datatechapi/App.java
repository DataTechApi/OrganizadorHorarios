package com.datatech.datatechapi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/login.fxml"));
        Parent login = fxmlLoader.load();
        scene = new Scene(login);
        String caimnhoCss = getClass().getResource("styles.css").toExternalForm();
        stage.setTitle("DataTech API");
        stage.initStyle(StageStyle.UTILITY);
        scene.getStylesheets().add(caimnhoCss);

        stage.setScene(scene);
        stage.show();
    }
   
    public static void main(String[] args) {
        launch();
    }
}