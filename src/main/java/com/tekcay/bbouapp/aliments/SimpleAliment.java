package com.tekcay.bbouapp.aliments;

import com.tekcay.bbouapp.Utils;
import javafx.scene.control.TextField;

public record SimpleAliment(int id, String localizedName, int glucides, int proteines, int lipides, int kcal) {

    public static SimpleAliment build(int id, TextField nameField, TextField glucideField, TextField proteineField, TextField lipideField, TextField kcalField) {

        int glucides = Utils.getNumericValue(glucideField);
        int proteines = Utils.getNumericValue(proteineField);
        int lipides = Utils.getNumericValue(lipideField);
        int kcal = Utils.getNumericValue(kcalField);

        if (kcal == 0) kcal = setKcal(glucides, proteines, lipides);

        return new SimpleAliment(id, nameField.getText(), glucides, proteines, lipides, kcal);
    }

    public static int setKcal(int glucides, int proteines, int lipides) {
        return (glucides + proteines) * 4 + lipides * 9;
    }
}
