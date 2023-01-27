package login.graphic_controller;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
public class LogoutGraphicController {//implementa dati input
    @FXML
    private Label advice;
    @FXML
    private Button btnLogout;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelName;
    @FXML
    private Label labelSurname;
    @FXML
    private ImageView imgHome;
    @FXML
    private ImageView imgLogin;
    @FXML
    void imgHomeClick(MouseEvent event) {
        //implementa ritorno alla home
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
    void btnLogoutClick(MouseEvent event) {
        //implementa logout
    }
    @FXML
    void btnMouseExited(MouseEvent event) {
        Button button = (Button) event.getSource();
        button.setOpacity(1);
    }
}
