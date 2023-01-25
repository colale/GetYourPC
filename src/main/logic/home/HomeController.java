package home;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class HomeController {

    @FXML
    private Label advice;

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
    private ImageView imgHome;

    @FXML
    private ImageView imgLogin;

    @FXML
    void btnPersonalAreaClick(MouseEvent event) {
        advice.setText("This option is not yet available");
    }

    @FXML
    void btnPostSaleAdClick(MouseEvent event) {

    }

    @FXML
    void btnReviewerAreaClick(MouseEvent event) {
        advice.setText("This option is not yet available");
    }

    @FXML
    void btnSearchPCClick(MouseEvent event) {

    }

    @FXML
    void buttonMouseEntered(MouseEvent event) {
        Button button = (Button) event.getSource();
        button.setOpacity(0.5);
    }

    @FXML
    void buttonMouseExited(MouseEvent event) {
        Button button = (Button) event.getSource();
        button.setOpacity(1);
    }

    @FXML
    void imgHomeClick(MouseEvent event) {
        advice.setText("This is Home");
    }

    @FXML
    void imgLoginClick(MouseEvent event) {

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
    void questionMark_click(MouseEvent event) {
        advice.setText("For information, read the project documentation");
    }

}
