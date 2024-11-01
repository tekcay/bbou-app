package com.tekcay.bbouapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader accueil = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        FXMLLoader ajouterAliment = new FXMLLoader(HelloApplication.class.getResource("add-aliment.fxml"));



        Scene scene = new Scene(ajouterAliment.load(), 640, 500);
        stage.setTitle("Ajouter un aliment");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}