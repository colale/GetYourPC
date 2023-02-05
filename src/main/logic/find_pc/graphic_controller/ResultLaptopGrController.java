package find_pc.graphic_controller;

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

public class ResultLaptopGrController {

    @FXML
    private Label advice;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnPersonalArea;

    @FXML
    private Button btnPostSaleAd;

    @FXML
    private Button btnQuestionMark;

    @FXML
    private Button btnReport;

    @FXML
    private Button btnReviewerArea;

    @FXML
    private Button btnSearchPC;

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView imgHome;

    @FXML
    private Label labelAddress;

    @FXML
    private Label labelBrand;

    @FXML
    private Label labelCpu;

    @FXML
    private Label labelEmail;

    @FXML
    private Label labelFullName;
    @FXML
    private Label labelMemory;
    @FXML
    private Label labelGpu;

    @FXML
    private Label labelModel;

    @FXML
    private Label labelPrice;

    @FXML
    private Label labelRam;

    @FXML
    private Label labelScreenSize;

    @FXML
    void btnBackClick(MouseEvent event) {

    }

    @FXML
    void btnReportClick(MouseEvent event) {

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
