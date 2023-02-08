package find_pc.view.gui.graphic_controller;
        import find_pc.app_controller.FindPCController;
        import find_pc.model.Result;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Cursor;
        import javafx.scene.Node;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.control.ScrollPane;
        import javafx.scene.image.ImageView;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.layout.*;
        import javafx.stage.Stage;
        import java.io.IOException;
        import java.util.List;

public class ResultsListGrController {
    FindPCController controller;

    private List<Result> results;
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

    public void setController(FindPCController controller) {
        this.controller = controller;
    }

    public void setResults(List<Result> results) throws IOException {
        this.results = results;
        for (int i = 0; i < results.size(); i++) {
            FXMLLoader root = new FXMLLoader(getClass().getResource("/find_pc/view/gui/Result.fxml"));
            Scene scene = new Scene(root.load(), 1280, 720);
            Stage stage = new Stage();
            stage.setScene(scene);
            ResultGrController resultController = root.getController();
            resultController.setController(this.controller);
            resultController.setInfo(results.get(i));
            HBox newResult = resultController.copyHBox(i);
            vbox.getChildren().add(newResult);
        }
    }
}
