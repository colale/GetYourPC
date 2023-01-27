package login.graphic_controller;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class LoginGraphicController {
    @FXML
    private Label advice;
    @FXML
    private Button btnConfirm;

    @FXML
    private Button btnLoginWithGMail;
    @FXML
    private Button btnSignUp;

    @FXML
    private TextField fieldEmail;

    @FXML
    private PasswordField fieldPassword;

    @FXML
    private ImageView imgHome;

    @FXML
    private ImageView imgLogin;
    @FXML
    void btnConfirmClick(MouseEvent event) {

    }

    @FXML
    void btnLoginWIthGmail(MouseEvent event) {

    }
    @FXML
    void btnSignUpClick(MouseEvent event) {
            advice.setText("This option is not available now");
    }

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
