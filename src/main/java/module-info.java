module com.tekcay.bbouapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires com.google.gson;

    opens com.tekcay.bbouapp to javafx.fxml, com.google.gson;
    exports com.tekcay.bbouapp;
}