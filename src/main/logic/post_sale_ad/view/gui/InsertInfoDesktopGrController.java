package post_sale_ad.view.gui;

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
import post_sale_ad.bean.PriceBean;

import java.io.IOException;

public class InsertInfoDesktopGrController {
    private PostSaleAdController controller;

    public void setAppController(PostSaleAdController appController) {
        this.controller = appController;
    }
    @FXML
    private Label advice;
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
    void btnConfirmClick(MouseEvent event) throws IOException {
        DesktopInfoBean bean = new DesktopInfoBean();
        PriceBean priceBean = new PriceBean();
        try {
            bean.setPcCase(fieldCase.getText());
            bean.setGpu(fieldGpu.getText());
            bean.setCpu(fieldCpu.getText());
            bean.setMemory(fieldStorage.getText());
            bean.setMotherboard(fieldMoba.getText());
            bean.setHeatSink(fieldHeat.getText());
            bean.setPower(fieldPower.getText());
            bean.setRam(fieldRam.getText());
            priceBean.setPrice(fieldPrice.getText());}
        catch (SyntaxBeanException ex) {
            advice.setText("Error filling in the fields, please try again");
            fieldCase.setText("");
            fieldGpu.setText("");
            fieldCpu.setText("");
            fieldRam.setText("");
            fieldStorage.setText("");
            fieldMoba.setText("");
            fieldHeat.setText("");
            fieldPower.setText("");
            fieldPrice.setText("");
        }
        if (controller.checkPrice(priceBean)) {
            controller.setPrice(priceBean);
            controller.setConfigInfo(bean);
            FXMLLoader root = new FXMLLoader(getClass().getResource("/post_sale_ad/view/gui/InsertPhotos.fxml"));
            Scene scene = new Scene(root.load(), 1280, 720);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            InsertPhotosGrController nextGraphicController = root.getController();
            nextGraphicController.setController(controller);
            stage.show();
        } else {advice.setText("Error filling in the field 'price', please insert price again");
            fieldPrice.setText("");}
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
