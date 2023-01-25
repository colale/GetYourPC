package home;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class HomeController {

    @FXML
    private ImageView home_img;
    @FXML
    private Label advice;
    @FXML
    private Button questionMark;
    @FXML
    private ImageView login_img;
    @FXML
    void img_MouseEntered(MouseEvent event) {
        ImageView i = (ImageView) event.getSource();
        i.setCursor(Cursor.HAND);

    }

    @FXML
    void img_MouseExited(MouseEvent event) {
        ImageView i = (ImageView) event.getSource();
        i.setCursor(Cursor.DEFAULT);

    }
    @FXML
    void questionMark_click(MouseEvent event) {
       advice.setText("For information, read the project documentation");
    }
    @FXML
    private Button personalArea_btn;

    @FXML
    private Button postSaleAd_btn;

    @FXML
    private Button reviewerArea_btn;

    @FXML
    private Button searchPC_btn;

    @FXML
    void button_MouseEntered(MouseEvent event) {
            Button button = (Button) event.getSource();
            button.setOpacity(0.5);
    }

    @FXML
    void button_MouseExited(MouseEvent event) {
        Button button = (Button) event.getSource();
        button.setOpacity(1);
    }
    @FXML
    void homeClick(MouseEvent event) {
        advice.setText("This is Home");
    }

    @FXML
    void login_click(MouseEvent event) {

    }

    @FXML
    void personalArea_click(MouseEvent event) {
        advice.setText("This option is not yet available");
    }

    @FXML
    void postSaleAd_click(MouseEvent event) {

    }

    @FXML
    void reviewerArea_click(MouseEvent event) {
        advice.setText("This option is not yet available");
    }

    @FXML
    void searchPC_click(MouseEvent event) {

    }

}
