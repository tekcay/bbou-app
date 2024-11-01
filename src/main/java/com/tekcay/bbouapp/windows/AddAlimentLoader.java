package com.tekcay.bbouapp.windows;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tekcay.bbouapp.SimpleAliment;
import com.tekcay.bbouapp.SimpleAlimentUtils;
import com.tekcay.bbouapp.Utils;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddAlimentLoader {

    @FXML
    private Label nameLabel = new Label("Nom :");
    @FXML
    private Label kcalLabel = new Label("kcal :");
    @FXML
    private Label proteinesLabel = new Label("Protéines (g) :");
    @FXML
    private Label glucidesLabel = new Label("Glucides (g) :");
    @FXML
    private Label lipidesLabel = new Label("Lipides (g) :");


    @FXML
    private TextField nameField = new TextField();
    @FXML
    private TextField kcalField = new TextField();
    @FXML
    private TextField proteinesField = new TextField();
    @FXML
    private TextField glucidesField = new TextField();
    @FXML
    private TextField lipidesField = new TextField();

    @FXML
    private Button addButton = new Button("Ajouter");

    @FXML
    protected void onAddButtonClick() throws IOException {
        SimpleAliment simpleAliment = SimpleAlimentUtils.build(0, nameField, glucidesField, proteinesField, lipidesField, kcalField);
        Utils.serialize(simpleAliment);

        String json = simpleAliment.serialize();
        System.out.println(json);
    }

    @FXML
    private GridPane pane = init();

    private GridPane init() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(kcalLabel, 0, 1);
        grid.add(kcalField, 1, 1);
        grid.add(proteinesLabel, 0, 2);
        grid.add(proteinesField, 1, 2);
        grid.add(glucidesLabel, 0, 3);
        grid.add(glucidesField, 1, 3);
        grid.add(lipidesLabel, 0, 4);
        grid.add(lipidesField, 1, 4);

        grid.add(addButton, 1, 3);
        return grid;
    }
}