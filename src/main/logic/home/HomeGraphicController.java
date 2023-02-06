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
import login.view.gui.graphic_controller.LogoutGraphicController;
import post_sale_ad.app_controller.PostSaleAdController;
import post_sale_ad.view.gui.SelectConfigGrController;
import java.io.IOException;

public class HomeGraphicController {

    public static final String MESSAGE = "This option is not available now";
    @FXML
    private Label advice;

    @FXML
    void btnPersonalAreaClick() {
        advice.setText(MESSAGE);
    }

    @FXML
    void btnPostSaleAdClick(MouseEvent event) throws IOException {
        String path;
        PostSaleAdController controller = new PostSaleAdController();
        path = controller.checkAuthentication() ? "/post_sale_ad/view/gui/SelectConfig.fxml" : "/login/view/gui/Login.fxml";
        FXMLLoader root = new FXMLLoader(getClass().getResource(path));
        Scene scene = new Scene(root.load(), 1280, 720);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        if (root.getController() instanceof SelectConfigGrController){
            SelectConfigGrController nextGraphicController=root.getController();
            nextGraphicController.setController(controller);
        }
        stage.show();
    }

    @FXML
    void btnReviewerAreaClick() {
        advice.setText(MESSAGE);
    }

    @FXML
    void btnSearchPCClick(MouseEvent event){
        advice.setText(MESSAGE);
    }


    @FXML
    void imgHomeClick() {
        advice.setText("This is Home");
    }

    @FXML
    void imgLoginClick(MouseEvent event) throws IOException {
        String path;
        LoginController loginController=new LoginController();
        path = loginController.checkIsAuthenticated() ? "/login/view/gui/Logout.fxml" : "/login/view/gui/Login.fxml";
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
