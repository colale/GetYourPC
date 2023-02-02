package find_pc.graphic_controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ResultView {

    public HBox copyHBox() {
        this.labelPrice.setText("123123");
        return this.hbox;
    }

    @FXML
    private Button btnDetails;

    @FXML
    private HBox hbox;

    @FXML
    private ImageView imgMain;

    @FXML
    private Label labelFirstFIeld;

    @FXML
    private Label labelFullName;

    @FXML
    private Label labelPrice;

    @FXML
    private Label labelSecondField;

    @FXML
    private Label labelThirdField;

    @FXML
    void btnDetailsClick(MouseEvent event) throws IOException {
        FXMLLoader root = new FXMLLoader(getClass().getResource("/find_pc/view/RequireBudget.fxml"));
        Scene scene = new Scene(root.load(), 1280, 720);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        RequireBudgetGrController r = root.getController();
        stage.show();
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
