module org.example.academyfx_mvc {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires jdk.jdi;

    opens org.example.academyfx_mvc to javafx.fxml;
    exports org.example.academyfx_mvc;
    exports org.example.academyfx_mvc.Controller;
    opens org.example.academyfx_mvc.Controller to javafx.fxml;
}