package com.tekcay.bbouapp;

import javafx.scene.control.TextField;

public class Utils {

    public static int getNumericValue(TextField field) {
        String text = field.getText();
        return text.length() == 0 ? 0 : Integer.parseInt(field.getText());
    }
}
