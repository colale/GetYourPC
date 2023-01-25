package find_pc.app_controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class A {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("W");
    }
}