module com.datatech.datatechapi {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;
    requires org.jetbrains.annotations;

    requires java.desktop;
    requires mysql.connector.j;

    requires com.github.librepdf.openpdf;


    opens com.datatech.datatechapi to javafx.fxml;
    opens com.datatech.datatechapi.controller to javafx.fxml;
    opens com.datatech.datatechapi.util to javafx.fxml;
    opens com.datatech.datatechapi.entities.models to javafx.base;
    exports com.datatech.datatechapi;
}