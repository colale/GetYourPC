package post_sale_ad.view.gui;

import home.Home;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;
import post_sale_ad.app_controller.PostSaleAdController;
import post_sale_ad.bean.PhotoBean;
import java.io.*;

public class InsertPhotosGrController {
    PhotoBean bean;
    PostSaleAdController controller;
    public void setController(PostSaleAdController controller){
        this.controller=controller;}

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
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private ImageView imgHome;

    @FXML
    void btnConfirmClick(MouseEvent event) throws IOException {
        try{
        if(controller.checkPhotos(this.bean)){
        controller.setPhotos(bean);
            FXMLLoader root = new FXMLLoader(getClass().getResource("/post_sale_ad/view/gui/InsertPosition.fxml"));
            Scene scene = new Scene(root.load(), 1280, 720);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            InsertPositionGrController nextGraphicController = root.getController();
            nextGraphicController.setController(controller);
            stage.show();}
            else{
                advice.setText("Error inserting photo, please try again");
                Image i= new Image(new FileInputStream("src/main/logic/resources/White_full.png"));
                bean.setImgPath1("");
                image1.setImage(i);
            bean.setImgPath2("");
                image2.setImage(i);
            bean.setImgPath3("");
                image3.setImage(i);
            }}
        catch(Exception ex){advice.setText("Error inserting photo, please try again");}}
    @FXML
    private void onDragOver1(DragEvent event) {
        if (event.getGestureSource() != image1 && event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }
    @FXML
    private void onDragDropped1(DragEvent event) throws FileNotFoundException {
        if (bean==null) {this.bean=new PhotoBean();}
        Dragboard db = event.getDragboard();
        if (db.hasFiles()) {
            File file = db.getFiles().get(0);
            Image image = new Image(new FileInputStream(file));
            image1.setImage(image);
            this.bean.setImgPath1(file.getAbsolutePath());
        }
        else{
        advice.setText("Error inserting photo 1, please try again");    }}
    @FXML
    private void onDragOver2(DragEvent event) {
        if (event.getGestureSource() != image2 && event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }
    @FXML
    private void onDragDropped2(DragEvent event) throws FileNotFoundException {
        if (bean==null) {this.bean=new PhotoBean();}
        Dragboard db = event.getDragboard();
        if (db.hasFiles()) {
            File file = db.getFiles().get(0);
            Image image = new Image(new FileInputStream(file));
            image2.setImage(image);
            this.bean.setImgPath2(file.getAbsolutePath());
        }else{
        advice.setText("Error inserting photo 2, please try again");    }}
    @FXML
    private void onDragOver3(DragEvent event) {
        if (event.getGestureSource() != image3 && event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }
    @FXML
    private void onDragDropped3(DragEvent event) throws FileNotFoundException {
        if (bean==null) {this.bean=new PhotoBean();}
        Dragboard db = event.getDragboard();
        if (db.hasFiles()) {
            File file = db.getFiles().get(0);
            Image image = new Image(new FileInputStream(file));
            image3.setImage(image);
            this.bean.setImgPath3(file.getAbsolutePath());
        }else{
        advice.setText("Error inserting photo 3, please try again");
    }}
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
