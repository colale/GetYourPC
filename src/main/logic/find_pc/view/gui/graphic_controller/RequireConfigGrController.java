package find_pc.view.gui.graphic_controller;

import find_pc.app_controller.FindPCController;
import find_pc.bean.UserChoiceBean;
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
import java.io.IOException;

public class RequireConfigGrController {
    private FindPCController controller;
    public void setController(FindPCController controller)
    {this.controller=controller;}
    @FXML
    private Label advice;@FXML
    void btnDesktopClick(MouseEvent event) throws IOException {
        UserChoiceBean bean = new UserChoiceBean();
        bean.setChoice("desktop");
        this.controller.createRequest(bean);
        FXMLLoader root = new FXMLLoader(getClass().getResource("/find_pc/view/gui/RequireBudget.fxml"));
        Scene scene = new Scene(root.load(), 1280, 720);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        RequireBudgetGrController grController = root.getController();
        grController.setController(this.controller);
        stage.show();
    }

    @FXML
    void btnLaptopClick(MouseEvent event) throws IOException {
        UserChoiceBean bean = new UserChoiceBean();
        bean.setChoice("laptop");
        this.controller.createRequest(bean);
        FXMLLoader root = new FXMLLoader(getClass().getResource("/find_pc/view/gui/RequireBudget.fxml"));
        Scene scene = new Scene(root.load(), 1280, 720);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        RequireBudgetGrController grController = root.getController();
        grController.setController(this.controller);
        stage.show();
    }
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
    void btnMouseExited(MouseEvent event) {
        Button button = (Button) event.getSource();
        if (!(button.isDisable())) {
            button.setOpacity(1);
        }
    }
}
