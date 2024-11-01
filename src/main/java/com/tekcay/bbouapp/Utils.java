package com.tekcay.bbouapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    public static int getNumericValue(TextField field) {
        String text = field.getText();
        return text.length() == 0 ? 0 : Integer.parseInt(field.getText());
    }

    public static List<SimpleAliment> deserialize() {
        Gson gson = new GsonBuilder().create();

        try (Reader reader = new BufferedReader(new FileReader("data/aliments.json"))) {
            SimpleAliment[] aliments = gson.fromJson(reader, SimpleAliment[].class);
            return Arrays.stream(aliments).toList();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static void serialize(SimpleAliment simpleAliment) throws IOException {
        List<SimpleAliment> storedAliments = new ArrayList<>(deserialize());
        storedAliments.add(simpleAliment);
        SimpleAliment[] aliments = storedAliments.toArray(SimpleAliment[]::new);

        Gson gson = new GsonBuilder().create();

        try (Writer writer = new FileWriter("data/aliments.json")) {
            gson.toJson(aliments, writer);
        }
    }
}


