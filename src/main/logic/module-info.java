module it.getyourpc.getyourpc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.mail;
    opens home to javafx.fxml;
    exports home;
    exports login.graphic_controller;
    opens login.graphic_controller to javafx.fxml;
    exports login.model;
    opens login.model to javafx.fxml;
}