module it.getyourpc.getyourpc {
    requires javafx.controls;
    requires javafx.fxml;
    opens home to javafx.fxml;
    exports home;
    exports fIndPC.appController;
    opens fIndPC.appController to javafx.fxml;
}