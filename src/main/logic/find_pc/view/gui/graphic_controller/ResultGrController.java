package find_pc.view.gui.graphic_controller;
import find_pc.app_controller.FindPCController;
import find_pc.model.Result;
import find_pc.model.ResultDesktop;
import find_pc.model.ResultLaptop;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import post_sale_ad.model.factory_config_info.LaptopInfo;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

public class ResultGrController {

    public FindPCController controller;
public Result result;
    public HBox copyHBox(int i) {
        this.labelPrice.setText("" + i);
        return this.hbox;
    }

    @FXML
    private Button btnDetails;

    @FXML
    private HBox hbox;

    @FXML
    private ImageView imgMain;

    @FXML
    private Label labelFirstField;

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
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if(this.result instanceof ResultDesktop) {
            FXMLLoader root = new FXMLLoader(getClass().getResource("/find_pc/view/gui/ResultDesktop.fxml"));
            Scene scene = new Scene(root.load(), 1280, 720);
            stage.setScene(scene);
            ResultDesktopGrController grController = root.getController();
            grController.setController(this.controller);
            grController.setInfo(this.result);
        }
        else {
            FXMLLoader root = new FXMLLoader(getClass().getResource("/find_pc/view/gui/ResultLaptop.fxml"));
            Scene scene = new Scene(root.load(), 1280, 720);
            stage.setScene(scene);
            ResultLaptopGrController grController = root.getController();
            grController.setController(this.controller);
            grController.setInfo(this.result);
        }
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

    public void setInfo(Result result) {
        this.result=result;
        if (result instanceof ResultLaptop) {
            labelFirstField.setText(((ResultLaptop) result).getBrand());
            labelSecondField.setText(((ResultLaptop) result).getModel());
            labelThirdField.setText(((ResultLaptop) result).getCpu());
            String fullname = ((ResultLaptop) result).getSellerName() + ((ResultLaptop) result).getSellerSurname();
            labelFullName.setText(fullname);
            String price = Double.toString(((ResultLaptop) result).getPrice());
            labelPrice.setText(price);
            Image image = new Image(new ByteArrayInputStream(((ResultLaptop) result).getImg1()));
            imgMain.setImage(image);
        } else {
            labelFirstField.setText(((ResultDesktop) result).getCpu());
            labelSecondField.setText(((ResultDesktop) result).getGpu());
            labelThirdField.setText(((ResultDesktop) result).getRam());
            String fullname = ((ResultDesktop) result).getSellerName() + ((ResultDesktop) result).getSellerSurname();
            labelFullName.setText(fullname);
            String price = Double.toString(((ResultDesktop) result).getPrice());
            labelPrice.setText(price);
            Image image = new Image(new ByteArrayInputStream(((ResultDesktop) result).getImg1()));
            imgMain.setImage(image);
        }
    }

    public void setController(FindPCController controller){
        this.controller=controller;
    }
}
