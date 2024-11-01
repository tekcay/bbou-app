package com.tekcay.bbouapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddAliment {

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
        serialize(simpleAliment);

        String json = simpleAliment.serialize();
        System.out.println(json);
    }

    protected List<SimpleAliment> deserialize() {
        Gson gson = new GsonBuilder().create();

        try (Reader reader = new BufferedReader(new FileReader("data/aliments.json"))) {
            SimpleAliment[] aliments = gson.fromJson(reader, SimpleAliment[].class);
            return Arrays.stream(aliments).toList();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    protected void serialize(SimpleAliment simpleAliment) throws IOException {
        List<SimpleAliment> storedAliments = new ArrayList<>(deserialize());
        storedAliments.add(simpleAliment);
        SimpleAliment[] aliments = storedAliments.toArray(SimpleAliment[]::new);

        Gson gson = new GsonBuilder().create();

        try (Writer writer = new FileWriter("data/aliments.json")) {
            gson.toJson(aliments, writer);
        }
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