package post_sale_ad.view.gui;

import exception.GeocodingException;
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
import post_sale_ad.bean.UserGeoRequestBean;
import post_sale_ad.bean.UserGeoResponseBean;

import java.io.IOException;

public class InsertPositionGrController {
    UserGeoResponseBean userGeoResponseBean;
PostSaleAdController controller;
    @FXML
    private Label advice;

    @FXML
    private Button btnCheckPosition;

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
    private TextField fieldAddress;

    @FXML
    private TextField fieldCity;

    @FXML
    private TextField fieldCountry;

    @FXML
    private TextField fieldSearch;

    @FXML
    private ImageView imgHome;

    @FXML
    private Label labelIsItCorrect;

    @FXML
    void btnCheckClick(MouseEvent event) {
        UserGeoRequestBean bean = new UserGeoRequestBean();
        try {
            bean.setCountry(this.fieldCountry.getText());
            bean.setAddress(this.fieldAddress.getText());
            bean.setCity(this.fieldCity.getText());
            UserGeoResponseBean response =controller.searchPosition(bean);
            labelIsItCorrect.setVisible(true);
            btnConfirm.setVisible(true);
            labelIsItCorrect.setDisable(false);
            btnConfirm.setDisable(false);
            this.userGeoResponseBean=response;
            fieldSearch.setText(this.userGeoResponseBean.getFullAddress());
        }
        catch(SyntaxBeanException syntaxException){
                advice.setText("Invalid data, try again");
                this.fieldCountry.setText("");
                this.fieldAddress.setText("");
                this.fieldCity.setText("");
            labelIsItCorrect.setVisible(false);
            btnConfirm.setVisible(false);
            labelIsItCorrect.setDisable(true);
            btnConfirm.setDisable(true);

            }
        catch(GeocodingException geoEx){
            advice.setText("Position not found, try again");
            this.fieldCountry.setText("");
            this.fieldAddress.setText("");
            this.fieldCity.setText("");
            labelIsItCorrect.setDisable(true);
            btnConfirm.setDisable(true);
            labelIsItCorrect.setVisible(false);
            btnConfirm.setVisible(false);
        }
        }
                @FXML
    void btnConfirmClick(MouseEvent event) {
        controller.publishPost();
        advice.setText("Your post has been published! Back to home");
        btnConfirm.isDisable();
        btnCheckPosition.isDisable();
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
    public void setController(PostSaleAdController controller){
        this.controller=controller;
    }
}
