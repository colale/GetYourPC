module it.getyourpc.getyourpc {
    requires javafx.controls;
    requires javafx.fxml;
    opens home to javafx.fxml;
    exports home;
    exports find_pc.app_controller;
    opens find_pc.app_controller to javafx.fxml;
}