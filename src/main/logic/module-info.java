module it.getyourpc.getyourpc {
    requires javafx.controls;
    requires javafx.fxml;
    opens home to javafx.fxml;
    exports home;
    exports findPC.appController;
    opens findPC.appController to javafx.fxml;
}