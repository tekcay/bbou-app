module com.tekcay.bbouapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tekcay.bbouapp to javafx.fxml;
    exports com.tekcay.bbouapp;
}