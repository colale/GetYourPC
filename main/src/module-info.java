module it.getyourpc.getyourpc {
    requires javafx.controls;
    requires javafx.fxml;
    opens logic.main to javafx.fxml;
    exports logic.main;
}