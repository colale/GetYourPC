package find_pc.graphic_controller;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.control.ScrollPane;
        import javafx.scene.image.ImageView;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.layout.*;
        import javafx.stage.Stage;
        import java.io.IOException;

public class ResultsListGrController {

    public void init() throws IOException {
        for (int i = 0; i < 50; i++) {
            FXMLLoader root = new FXMLLoader(getClass().getResource("/find_pc/view/Hbox.fxml"));
            Scene scene = new Scene(root.load(), 1280, 720);
            Stage stage=new Stage();
            stage.setScene(scene);
            Hbox gController = root.getController();
            HBox nuova=gController.copyHBox();
            vbox.getChildren().add(nuova);
        }
    }
    @FXML
    private Label advice;

    @FXML
    private Button btnDetails;
@FXML
Label asd;
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
    private HBox hbox;

    @FXML
    private ImageView imgHome;

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
    private ScrollPane scrollPane;

    @FXML
    private VBox vbox;

    @FXML
    void btnDetailsClick(MouseEvent event) {

    }

    @FXML
    void btnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnQuestionMarkClick(MouseEvent event) {

    }

    @FXML
    void imgHomeClick(MouseEvent event) {

    }

    @FXML
    void imgMouseEntered(MouseEvent event) {

    }

    @FXML
    void imgMouseExited(MouseEvent event) {

    }

    @FXML
    void onmouse(MouseEvent event) {

    }
}
