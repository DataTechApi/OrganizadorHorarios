module com.datatech.datatechapi {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.datatech.datatechapi to javafx.fxml;
    opens com.datatech.datatechapi.controller to javafx.fxml;
    exports com.datatech.datatechapi;
}