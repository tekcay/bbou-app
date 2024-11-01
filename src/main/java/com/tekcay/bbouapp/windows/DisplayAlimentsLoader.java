package com.tekcay.bbouapp.windows;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tekcay.bbouapp.SimpleAliment;
import com.tekcay.bbouapp.SimpleAlimentUtils;
import com.tekcay.bbouapp.Utils;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisplayAlimentsLoader {

    @FXML
    private final String title = "Aliments ajoutés"

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
    private TableView<SimpleAliment> tableView = new TableView<>();

    @FXML
    private Button addButton = new Button("Ajouter");

    @FXML
    private GridPane pane = new GridPane();

    @Override
    public void load() {

    }

    public void tableInit() {
        TableColumn<SimpleAliment, String> nameColumn = new TableColumn<>("Nom");
        TableColumn<SimpleAliment, Integer> proteinesColumn = new TableColumn<>("Protéines (g)");
        TableColumn<SimpleAliment, Integer> glucidesColumn = new TableColumn<>("Glucides (g)");
        TableColumn<SimpleAliment, Integer> lipidesColumn = new TableColumn<>("Lipides (g)");
        TableColumn<SimpleAliment, Integer> caloriesColumn = new TableColumn<>("Calories (kcal)");

        tableView.getColumns().add(nameColumn);
        tableView.getColumns().add(proteinesColumn);
        tableView.getColumns().add(glucidesColumn);
        tableView.getColumns().add(lipidesColumn);
        tableView.getColumns().add(caloriesColumn);

        fillTable();
    }

    private void addColumnsLabel() {

    }

    public void fillTable() {
        List<SimpleAliment> aliments = Utils.deserialize();
        ObservableList<SimpleAliment> aliments1 = FXCollections.observableList(aliments);
        tableView.setItems(aliments1);
    }

    private void init() {













        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(nameLabel, 0, 0);
        pane.add(nameField, 1, 0);
        pane.add(kcalLabel, 0, 1);
        pane.add(kcalField, 1, 1);

        pane.add(addButton, 1, 3);
    }
}