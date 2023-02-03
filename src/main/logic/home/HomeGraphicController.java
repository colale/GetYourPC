package home;

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
import login.graphic_controller.LogoutGraphicController;
import java.io.IOException;
public class HomeGraphicController {
    @FXML
    private Label advice;

    @FXML
    void btnPersonalAreaClick() {
        advice.setText("This option is not available now");
    }

    @FXML
    void btnPostSaleAdClick(MouseEvent event) throws IOException {
        String path;
        LoginController loginController = new LoginController();
        path = loginController.checkIsAuthenticated() ?"/post_sale_ad/view/SelectConfig.fxml":"/login/view/Login.fxml";
        FXMLLoader root = new FXMLLoader(getClass().getResource(path));
        Scene scene = new Scene(root.load(), 1280, 720);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnReviewerAreaClick() {
        advice.setText("This option is not available now");
    }

    @FXML
    void btnSearchPCClick(MouseEvent event) throws IOException {
        FXMLLoader root = new FXMLLoader(getClass().getResource("/find_pc/view/RequireConfig.fxml"));
        Scene scene = new Scene(root.load(), 1280, 720);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void imgHomeClick() {
        advice.setText("This is Home");
    }

    @FXML
    void imgLoginClick(MouseEvent event) throws IOException {
        String path;
        LoginController loginController=new LoginController();
        path = loginController.checkIsAuthenticated() ?"/login/view/Logout.fxml":"/login/view/Login.fxml";
        FXMLLoader root = new FXMLLoader(getClass().getResource(path));
        Scene scene = new Scene(root.load(), 1280, 720);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            if (loginController.checkIsAuthenticated()) {
                LogoutGraphicController gController = root.getController();
                gController.init();}
                stage.setScene(scene);
                stage.show();
    }

    @FXML
    void imgMouseEntered(MouseEvent event) {
        ImageView i = (ImageView) event.getSource();
        i.setCursor(Cursor.HAND);
    }
    @FXML
    void btnQuestionMarkClick() {
        advice.setText("For information, read the project documentation");
    }
    @FXML
    void imgMouseExited(MouseEvent event) {
        ImageView i = (ImageView) event.getSource();
        i.setCursor(Cursor.DEFAULT);
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
