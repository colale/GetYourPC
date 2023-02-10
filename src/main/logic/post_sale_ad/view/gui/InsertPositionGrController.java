package post_sale_ad.view.gui;

import exception.ConnectionDBException;
import exception.GeocodingException;
import exception.SyntaxBeanException;
import javafx.application.Platform;
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
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

public class InsertPositionGrController {
    public static final String MESSAGE = "System error, please try again later";
    UserGeoResponseBean userGeoResponseBean;
    PostSaleAdController controller;
    @FXML
    private Label advice;
    @FXML
    ImageView imgHome;
    @FXML
    private Button btnCheckPosition;

    @FXML
    private Button btnConfirm;
    @FXML
    private TextField fieldAddress;

    @FXML
    private TextField fieldCity;

    @FXML
    private TextField fieldCountry;

    @FXML
    private TextField fieldSearch;
    @FXML
    private Label labelIsItCorrect;

    @FXML
    void btnCheckClick(MouseEvent event) {
        UserGeoRequestBean bean = new UserGeoRequestBean();
        try {
            bean.setCountry(this.fieldCountry.getText());
            bean.setAddress(this.fieldAddress.getText());
            bean.setCity(this.fieldCity.getText());
            UserGeoResponseBean response = controller.searchPosition(bean);
            labelIsItCorrect.setVisible(true);
            btnConfirm.setVisible(true);
            labelIsItCorrect.setDisable(false);
            btnConfirm.setDisable(false);
            this.userGeoResponseBean = response;
            fieldSearch.setText(this.userGeoResponseBean.getFullAddress());
        } catch (SyntaxBeanException syntaxException) {
            advice.setText("Invalid data, try again");
            this.fieldCountry.setText("");
            this.fieldAddress.setText("");
            this.fieldCity.setText("");
            labelIsItCorrect.setVisible(false);
            btnConfirm.setVisible(false);
            labelIsItCorrect.setDisable(true);
            btnConfirm.setDisable(true);

        } catch (GeocodingException geoEx) {
            advice.setText("Position not found, try again");
            this.fieldCountry.setText("");
            this.fieldAddress.setText("");
            this.fieldCity.setText("");
            this.fieldSearch.setText("");
            labelIsItCorrect.setDisable(true);
            btnConfirm.setDisable(true);
            labelIsItCorrect.setVisible(false);
            btnConfirm.setVisible(false);
        }
    }

    @FXML
    void btnConfirmClick(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            controller.setPosition();
            btnConfirm.setDisable(true);
            btnCheckPosition.setDisable(true);
            this.finalizeUseCase(stage);
        } catch (IOException ioEx) {advice.setText(MESSAGE);
            System.err.println(ioEx.getMessage());}
        catch(SQLException sqlEx){System.err.println(sqlEx.getMessage());
        advice.setText(MESSAGE);}
        catch(ConnectionDBException connEx){advice.setText(MESSAGE);
            System.err.println(connEx.getMessage());}}

        @FXML
        void imgHomeClick (MouseEvent event) throws IOException {
            FXMLLoader root = new FXMLLoader(getClass().getResource("/home/Home.fxml"));
            Scene scene = new Scene(root.load(), 1280, 720);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }

        @FXML
        void imgMouseEntered (MouseEvent event){
            ImageView i = (ImageView) event.getSource();
            i.setCursor(Cursor.HAND);
        }

        @FXML
        void imgMouseExited (MouseEvent event){
            ImageView i = (ImageView) event.getSource();
            i.setCursor(Cursor.DEFAULT);
        }

        @FXML
        void btnQuestionMarkClick (MouseEvent event){
            advice.setText("For information, read the project documentation");
        }

        @FXML
        void btnMouseEntered (MouseEvent event){
            Button button = (Button) event.getSource();
            button.setOpacity(0.5);
        }

        @FXML
        void btnMouseExited (MouseEvent event){
            Button button = (Button) event.getSource();
            if (!(button.isDisable())) {
                button.setOpacity(1);
            }
        }
        public void setController (PostSaleAdController controller){
            this.controller = controller;
        }

        public void finalizeUseCase(Stage stage){
            advice.setText("Your post has been published! You will return to Home in 5 seconds...");
            imgHome.setDisable(true);
            btnConfirm.setDisable(true);
            btnCheckPosition.setDisable(true);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            FXMLLoader root = new FXMLLoader(getClass().getResource("/home/Home.fxml"));
                            try {
                                Scene scene = new Scene(root.load(), 1280, 720);
                                stage.setScene(scene);
                                stage.show();
                            } catch (IOException e) {
                                System.err.println(e.getMessage());
                            }

                        }
                    });
                }
            }, 5000);
        }
}


