package post_sale_ad.graphic_controller;

import exception.SyntaxBeanException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import post_sale_ad.app_controller.PostSaleAdController;
import post_sale_ad.bean.DesktopInfoBean;
import post_sale_ad.model.factory_config_info.DesktopInfo;

import java.io.IOException;

public class InsertInfoDesktopGrController {
    PostSaleAdController controller;

    public void setAppController(PostSaleAdController appController) {
        this.controller = appController;
    }

    @FXML
    private Label advice;

    @FXML
    private Button btnConfirm;

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
    private TextField fieldCase;

    @FXML
    private TextField fieldCpu;

    @FXML
    private TextField fieldGpu;

    @FXML
    private TextField fieldHeat;

    @FXML
    private TextField fieldMoba;

    @FXML
    private TextField fieldPower;

    @FXML
    private TextField fieldPrice;

    @FXML
    private TextField fieldRam;

    @FXML
    private TextField fieldStorage;

    @FXML
    private ImageView imgHome;

    @FXML
    void btnConfirmClick(MouseEvent event) throws IOException {
        DesktopInfoBean bean = new DesktopInfoBean();
     /*   try {
            bean.setPcCase(fieldCase.getText());
            bean.getGpu()(fieldGpu.getText());






        }//Inserisci qui la copia dai field al bean}
        catch (SyntaxBeanException ex) {
        }*/
        if (controller.checkPcValues(bean)) { //NEWPATH
            FXMLLoader root = new FXMLLoader(getClass().getResource(""));
            Scene scene = new Scene(root.load(), 1280, 720);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            SelectConfigGrController nextGraphicController = root.getController();
            nextGraphicController.setController(controller);
            stage.show();
        } else {
        }//svuotare i field
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
