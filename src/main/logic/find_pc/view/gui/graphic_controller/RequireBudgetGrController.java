package find_pc.view.gui.graphic_controller;

import find_pc.app_controller.FindPCController;
import find_pc.bean.UserBudgetBean;
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

public class RequireBudgetGrController {
FindPCController controller;
    @FXML
    private Label advice;

    @FXML
    private Button btnFirstRange;

    @FXML
    private Button btnFourthRangeClick;

    @FXML
    private Button btnPersonalArea;

    @FXML
    private Button btnPostSaleAd;

    @FXML
    private Button btnQuestionMark;

    @FXML
    private Button btnReviewerArea;

    @FXML
    private Button btnSearchPC;

    @FXML
    private Button btnSecondRange;

    @FXML
    private Button btnThirdRange;

    @FXML
    private ImageView imgHome;

    @FXML
    private ImageView imgLogin;

    @FXML
    void btnFirstRangeClick(MouseEvent event) throws IOException {
        UserBudgetBean bean = new UserBudgetBean();
        bean.setRange(1);
        this.controller.setBudget(bean);
        FXMLLoader root = new FXMLLoader(getClass().getResource("/find_pc/view/gui/RequirePosition.fxml"));
        Scene scene = new Scene(root.load(), 1280, 720);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        RequirePositionGrController grController = root.getController();
        grController.setController(this.controller);
        stage.show();
    }

    @FXML
    void btnFourthRangeClick(MouseEvent event) throws IOException {
        UserBudgetBean bean = new UserBudgetBean();
        bean.setRange(4);
        this.controller.setBudget(bean);
        FXMLLoader root = new FXMLLoader(getClass().getResource("/find_pc/view/gui/RequirePosition.fxml"));
        Scene scene = new Scene(root.load(), 1280, 720);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        RequirePositionGrController grController = root.getController();
        grController.setController(this.controller);
        stage.show();
    }

    @FXML
    void btnSecondRangeClick(MouseEvent event) throws IOException {
        UserBudgetBean bean = new UserBudgetBean();
        bean.setRange(2);
        this.controller.setBudget(bean);
        FXMLLoader root = new FXMLLoader(getClass().getResource("/find_pc/view/gui/RequirePosition.fxml"));
        Scene scene = new Scene(root.load(), 1280, 720);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        RequirePositionGrController grController = root.getController();
        grController.setController(this.controller);
        stage.show();
    }

    @FXML
    void btnThirdRangeClick(MouseEvent event) throws IOException {
        UserBudgetBean bean = new UserBudgetBean();
        bean.setRange(3);
        this.controller.setBudget(bean);
        FXMLLoader root = new FXMLLoader(getClass().getResource("/find_pc/view/gui/RequirePosition.fxml"));
        Scene scene = new Scene(root.load(), 1280, 720);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        RequirePositionGrController grController = root.getController();
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
    public void setController(FindPCController controller)
    {this.controller=controller;}
}
