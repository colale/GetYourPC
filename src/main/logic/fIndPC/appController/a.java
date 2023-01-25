package fIndPC.appController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class a {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("W");
    }
}