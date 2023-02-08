package find_pc.view.gui.graphic_controller;

import find_pc.app_controller.FindPCController;
import find_pc.model.Result;
import find_pc.model.ResultDesktop;
import find_pc.model.ResultLaptop;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

public class ResultDesktopGrController {
    List<Result> resultsList;
    FindPCController controller;
    private Result result;

    @FXML
    private Label advice;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnPersonalArea;

    @FXML
    private Button btnPostSaleAd;

    @FXML
    private Button btnQuestionMark;

    @FXML
    private Button btnReport;

    @FXML
    private Button btnReviewerArea;

    @FXML
    private Button btnSearchPC;

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView imgHome;

    @FXML
    private Label labelAddress;

    @FXML
    private Label labelCase;

    @FXML
    private Label labelCpu;

    @FXML
    private Label labelCpuHeat;

    @FXML
    private Label labelEmail;

    @FXML
    private Label labelFullName;

    @FXML
    private Label labelGpu;

    @FXML
    private Label labelMemory;

    @FXML
    private Label labelMoba;

    @FXML
    private Label labelPower;

    @FXML
    private Label labelPrice;

    @FXML
    private Label labelRam;

    @FXML
    void btnBackClick(MouseEvent event) throws IOException {
        FXMLLoader root = new FXMLLoader(getClass().getResource("/find_pc/view/gui/ResultsList.fxml"));
        Scene scene = new Scene(root.load(), 1280, 720);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        ResultsListGrController grController = root.getController();
        grController.setController(this.controller);
        grController.setResults(this.resultsList);
        stage.show();
    }

    @FXML
    void btnReportClick(MouseEvent event) {
        advice.setText("This option is not available now");
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

    public void setList(List<Result> list) {
        this.resultsList = list;
    }

    public void setController(FindPCController controller) {
        this.controller = controller;
    }

    public void setInfo(Result result) {
        this.result = result;
            labelMoba.setText(((ResultDesktop) result).getMotherboard());
            labelCpuHeat.setText(((ResultDesktop) result).getHeatSink());
            labelCpu.setText(((ResultDesktop) result).getCpu());
            String fullName = ((ResultDesktop) result).getSellerName() + ((ResultDesktop) result).getSellerSurname();
            labelFullName.setText(fullName);
            String price = Double.toString(((ResultDesktop) result).getPrice());
            labelPrice.setText(price+" €");
            labelEmail.setText(((ResultDesktop) result).getSellerEmail());
            labelGpu.setText(((ResultDesktop) result).getGpu());
            labelAddress.setText(((ResultDesktop) result).getFullAddress());
            labelPower.setText(((ResultDesktop) result).getPower());
            labelMemory.setText(((ResultDesktop) result).getMemory());
            labelCase.setText(((ResultDesktop) result).getPcCase());
            labelRam.setText(((ResultDesktop) result).getRam());
            Image image = new Image(new ByteArrayInputStream(((ResultDesktop) result).getImg1()));
            img1.setImage(image);
            image = new Image(new ByteArrayInputStream(((ResultDesktop) result).getImg2()));
            img2.setImage(image);
            image = new Image(new ByteArrayInputStream(((ResultDesktop) result).getImg3()));
            img3.setImage(image);
    }
}
