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
import java.nio.channels.FileChannel;

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
    void btnConfirmClick(MouseEvent event){
        PhotoBean bean=new PhotoBean();
        bean.setImgPath1("img1");
        bean.setImgPath1("img2");
        bean.setImgPath1("img3");
        PhotoBean bean = new PhotoBean();
        if(controller.checkPhotos(bean){
            controller.setPhotos(bean);
        }
            else{
                try{
                advice.setText("Error inserting photo, please try again");
                Image i= new Image(new FileInputStream("src/main/logic/resources/White_full.png"));
                image1.setImage(i);
                image2.setImage(i);
                image3.setImage(i);
            }
                catch(IOException ex){System.err.println(ex.getCause()); Home.quit();}
        }}
    @FXML
    private void onDragOver1(DragEvent event) {
        if (event.getGestureSource() != image1 && event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }
    @FXML
    private void onDragDropped1(DragEvent event) {
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasFiles()) {
            success = true;
            File file = db.getFiles().get(0);
            try {
                Image image = new Image(new FileInputStream(file));
                image1.setImage(image);
                // Salva l'immagine trascinata
                File savedFile = new File("img1.png");
                try (FileOutputStream outputStream = new FileOutputStream(savedFile);
                     FileChannel inChannel = new FileInputStream(file).getChannel();
                     FileChannel outChannel = outputStream.getChannel()) {
                    inChannel.transferTo(0, inChannel.size(), outChannel);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        event.setDropCompleted(success);
        event.consume();
    }
    @FXML
    private void onDragOver2(DragEvent event) {
        if (event.getGestureSource() != image2 && event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }
    @FXML
    private void onDragDropped2(DragEvent event) {
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasFiles()) {
            success = true;
            File file = db.getFiles().get(0);
            try {
                Image image = new Image(new FileInputStream(file));
                image2.setImage(image);

                // Salva l'immagine trascinata
                File savedFile = new File("img2.png");
                try (FileOutputStream outputStream = new FileOutputStream(savedFile);
                     FileChannel inChannel = new FileInputStream(file).getChannel();
                     FileChannel outChannel = outputStream.getChannel()) {
                    inChannel.transferTo(0, inChannel.size(), outChannel);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        event.setDropCompleted(success);
        event.consume();
    }    @FXML
    private void onDragOver3(DragEvent event) {
        if (event.getGestureSource() != image3 && event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }
    @FXML
    private void onDragDropped3(DragEvent event) {
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasFiles()) {
            success = true;
            File file = db.getFiles().get(0);
            try {
                Image image = new Image(new FileInputStream(file));
                image3.setImage(image);

                // Salva l'immagine trascinata
                File savedFile = new File("img3.png");
                try (FileOutputStream outputStream = new FileOutputStream(savedFile);
                     FileChannel inChannel = new FileInputStream(file).getChannel();
                     FileChannel outChannel = outputStream.getChannel()) {
                    inChannel.transferTo(0, inChannel.size(), outChannel);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        event.setDropCompleted(success);
        event.consume();
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
