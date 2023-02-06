module it.getyourpc.getyourpc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.mail;
    requires java.sql;
    requires java.desktop;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;

    opens home to javafx.fxml;
    exports home;
    exports login.view.gui.graphic_controller;

    opens login.view.gui.graphic_controller to javafx.fxml;
    exports login.model;
    opens login.model to javafx.fxml;
    exports find_pc.view.gui.graphic_controller;
    opens find_pc.view.gui.graphic_controller to javafx.fxml;
    opens post_sale_ad.view.gui to javafx.fxml;
    exports post_sale_ad.view.gui;
}