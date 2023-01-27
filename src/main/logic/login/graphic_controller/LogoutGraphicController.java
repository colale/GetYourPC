package login.graphic_controller;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class LogoutGraphicController {
    @FXML
    private Label advice;
    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnLogout;
    @FXML
    private Label labelEmail;

    @FXML
    private Label labelName;
    @FXML
    void btnLogoutClick(MouseEvent event) {
    }
    @FXML
    private Label labelSurname;

    @FXML
    private ImageView imgHome;

    @FXML
    private ImageView imgLogin;
    @FXML
    void imgHomeClick(MouseEvent event) {
    }
    @FXML
    void imgMouseEntered(MouseEvent event) {
        ImageView i = (ImageView) event.getSource();
        i.setCursor(Cursor.HAND);
    }

    @FXML
    void imgMouseExited(MouseEvent event) {
        ImageView i = (ImageView) event.getSource();
        i.setCursor(Cursor.DEFAULT);
    }

    @FXML
    void btnQuestionMarkClick(MouseEvent event) {
        advice.setText("For information, read the project documentation");
    }
    @FXML
    void btnMouseEntered(MouseEvent event) {
        Button button = (Button) event.getSource();
        button.setOpacity(0.5);
    }

    @FXML
    void btnMouseExited(MouseEvent event) {
        Button button = (Button) event.getSource();
        button.setOpacity(1);
    }
}
