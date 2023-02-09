module it.getyourpc.getyourpc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.mail;
    requires java.sql;
    requires java.desktop;
    requires java.net.http;
    requires org.json;
    opens home to javafx.fxml;
    exports home;
    exports login.bean;
    exports boundary;
    exports exception;
    exports login.app_controller;
    exports login.view.gui.graphic_controller;
    exports post_sale_ad.bean;
    opens login.view.gui.graphic_controller to javafx.fxml;
    exports login.model;
    opens login.model to javafx.fxml;
    opens post_sale_ad.view.gui to javafx.fxml;
    exports post_sale_ad.view.gui;
    exports find_pc.view.gui.graphic_controller to javafx.fxml;
    opens find_pc.view.gui.graphic_controller to javafx.fxml;
}