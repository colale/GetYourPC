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
import post_sale_ad.bean.LaptopInfoBean;
import post_sale_ad.bean.PriceBean;

import java.io.IOException;

public class InsertInfoLaptopGrController {
    PostSaleAdController controller;

    public void setAppController(PostSaleAdController appController) {
        this.controller = appController;
    }
    @FXML
    private TextField fieldBrand;

    @FXML
    private TextField fieldCpu;

    @FXML
    private TextField fieldDisplay;

    @FXML
    private TextField fieldGpu;

    @FXML
    private TextField fieldModel;

    @FXML
    private TextField fieldPrice;

    @FXML
    private TextField fieldRam;
    @FXML
    private Label advice;
    @FXML
    private TextField fieldMemory;
    @FXML
    void btnConfirmClick(MouseEvent event) throws IOException {
        LaptopInfoBean bean = new LaptopInfoBean();
        PriceBean priceBean = new PriceBean();
        try {
            bean.setGpu(fieldGpu.getText());
            bean.setCpu(fieldCpu.getText());
            bean.setMemory(fieldMemory.getText());
            bean.setBrand(fieldBrand.getText());
            bean.setModel(fieldModel.getText());
            bean.setScreenSize(Double.parseDouble(fieldDisplay.getText()));
            bean.setRam(fieldRam.getText());
            priceBean.setPrice(fieldPrice.getText());}
        catch (SyntaxBeanException ex) {
            advice.setText("Error filling in the fields, please try again");
            fieldGpu.setText("");
            fieldCpu.setText("");
            fieldMemory.setText("");
            fieldBrand.setText("");
            fieldModel.setText("");
            fieldDisplay.setText("");
            fieldRam.setText("");
            fieldPrice.setText("");}
        if (controller.checkPrice(priceBean)) {
            controller.setPrice(priceBean);
            controller.setConfigInfo(bean);
            FXMLLoader root = new FXMLLoader(getClass().getResource("/post_sale_ad/view/gui/InsertPhotos.fxml"));
            Scene scene = new Scene(root.load(), 1280, 720);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            InsertPositionGrController nextGraphicController = root.getController();
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