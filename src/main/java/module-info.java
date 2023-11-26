module com.example.lavanderiawinchi {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.lavanderiawinchi to javafx.fxml;
    exports com.example.lavanderiawinchi;
    exports com.example.lavanderiawinchi.controllers;
    opens com.example.lavanderiawinchi.controllers to javafx.fxml;
}