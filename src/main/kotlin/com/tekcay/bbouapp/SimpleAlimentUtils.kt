package com.tekcay.bbouapp;

import javafx.scene.control.TextField

object SimpleAlimentUtils {

    @JvmStatic
    fun build(id: Int, nameField: TextField, glucideField: TextField, proteineField: TextField, lipideField: TextField, kcalField: TextField): SimpleAliment {

        val glucides: Int = Utils.getNumericValue(glucideField);
        val proteines: Int = Utils.getNumericValue(proteineField);
        val lipides: Int = Utils.getNumericValue(lipideField);
        var kcal: Int = Utils.getNumericValue(kcalField);

        if (kcal == 0) kcal = setKcal(glucides, proteines, lipides);

        return SimpleAliment(id, nameField.text, glucides, proteines, lipides, kcal)
    }

    @JvmStatic
    fun setKcal(glucides: Int, proteines: Int, lipides: Int): Int {
        return (glucides + proteines) * 4 + lipides * 9;
    }
}
