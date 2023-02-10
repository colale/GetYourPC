package post_sale_ad.view.gui;

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
import post_sale_ad.app_controller.PostSaleAdController;
import post_sale_ad.bean.PcInfoBean;
import java.io.IOException;

public class SelectConfigGrController {
    private PostSaleAdController controller;
    @FXML
    private Label advice;
    @FXML
    void btnDesktopClick(MouseEvent event) throws IOException {
        PcInfoBean choice=new PcInfoBean();
        choice.setChoice("desktop");
        this.controller.createPost(choice);
        FXMLLoader root = new FXMLLoader(getClass().getResource("/post_sale_ad/view/gui/InsertInfoDesktop.fxml"));
        Scene scene = new Scene(root.load(), 1280, 720);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        InsertInfoDesktopGrController nextController = root.getController();
        nextController.setAppController(this.controller);
        stage.show();

    }
    public void setController(PostSaleAdController controller)
    {this.controller=controller;}

    @FXML
    void btnLaptopClick(MouseEvent event) throws IOException {
        PcInfoBean choice=new PcInfoBean();
        choice.setChoice("laptop");
        this.controller.createPost(choice);
        FXMLLoader root = new FXMLLoader(getClass().getResource("/post_sale_ad/view/gui/InsertInfoLaptop.fxml"));
        Scene scene = new Scene(root.load(), 1280, 720);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        InsertInfoLaptopGrController nextController = root.getController();
        nextController.setAppController(this.controller);
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
