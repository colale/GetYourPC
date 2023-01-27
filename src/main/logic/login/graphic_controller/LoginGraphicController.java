package login.graphic_controller;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import login.app_controller.LoginController;
import login.bean.UserDataBean;

public class LoginGraphicController {
    UserDataBean b = new UserDataBean();
    LoginController c = new LoginController();
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
    void btnConfirmClick(MouseEvent event){//TRY... CATCH
        boolean passed;
        b.setEmail(fieldEmail.getText());
        b.setPassword(fieldPassword.getText());//fine del try
        passed=(c.authenticate(b))?true:false;
        //catch imposta su false il passed
        if (!passed){
            btnConfirm.setVisible(false);
            btnConfirm.setDisable(true);
            btnSignUp.setVisible(false);
            btnSignUp.setDisable(true);
            btnLoginWithGMail.setVisible(false);
            btnLoginWithGMail.setDisable(true);
            advice.setText("You are logged in now, return to the Home");}
        else {
            fieldPassword.setText("");
            fieldEmail.setText("");
            advice.setText("Login failed, try again");}
        }
    @FXML
    void btnLoginWithGmail(MouseEvent event) {
        advice.setText("This option is not available now");
    }
    @FXML
    void btnSignUpClick(MouseEvent event) {
            advice.setText("This option is not available now");
    }

    @FXML
    void imgHomeClick(MouseEvent event) throws IOException {
        FXMLLoader root = new FXMLLoader(getClass().getResource("/home/Home.fxml"));
        Scene scene = new Scene(root.load(), 1280, 720);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();}
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
