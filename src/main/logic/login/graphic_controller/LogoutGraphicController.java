package login.graphic_controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import login.app_controller.LoginController;
import login.bean.UserDataBean;
import exception.SyntaxBeanException;
import java.io.IOException;

public class LogoutGraphicController {//implementa dati input
    private LoginController c = new LoginController();
    @FXML
    private Label advice;
    @FXML
    private Label label;
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
    public void init(){
        UserDataBean bean = c.getUser();
        labelName.setText(bean.getName());
        labelSurname.setText(bean.getSurname());
        labelEmail.setText(bean.getEmail());}

    @FXML
    void imgHomeClick(MouseEvent event) throws IOException {
        FXMLLoader root = new FXMLLoader(getClass().getResource("/home/Home.fxml"));
        Scene scene = new Scene(root.load(), 1280, 720);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
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
        c.logout();
        btnLogout.setVisible(false);
        btnLogout.setDisable(true);
        label.setText("Logout completed");
        labelName.setText("");
        labelSurname.setText("");
        labelEmail.setText("");
        advice.setText("Return to the Home");}
    @FXML
    void btnMouseExited(MouseEvent event) {
        Button button = (Button) event.getSource();
        button.setOpacity(1);
    }
}
