package find_pc.view.gui.graphic_controller;

import exception.ConnectionDBException;
import exception.GeocodingException;
import exception.SyntaxBeanException;
import find_pc.app_controller.FindPCController;
import find_pc.bean.UserDistanceBean;
import find_pc.bean.UserGeoRequestBean;
import find_pc.bean.UserGeoResponseBean;
import find_pc.model.Result;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RequirePositionGrController {
    private FindPCController controller;
    private UserGeoRequestBean userGeoRequestBean;
    private find_pc.bean.UserGeoResponseBean userGeoResponseBean;
    private UserDistanceBean userDistanceBean;
    @FXML
    private Label labelIsItCorrect;
    @FXML
    private Label advice;

    @FXML
    private Button btnConfirm;

    @FXML
    private TextField fieldDistance;

    @FXML
    private TextField fieldCity;

    @FXML
    private TextField fieldCountry;

    @FXML
    private TextField fieldSearch;

    @FXML
    void btnSearchClick(MouseEvent event) {
                this.userGeoRequestBean = new UserGeoRequestBean();
                this.userDistanceBean = new UserDistanceBean();
            try {
                userDistanceBean.setDistance(fieldDistance.getText());
                userGeoRequestBean.setCountry(fieldCountry.getText());
                userGeoRequestBean.setCity(fieldCity.getText());
                UserGeoResponseBean response = controller.searchPosition(userGeoRequestBean);
                this.userGeoResponseBean = response;
                labelIsItCorrect.setVisible(true);
                btnConfirm.setVisible(true);
                labelIsItCorrect.setDisable(false);
                btnConfirm.setDisable(false);
                this.userGeoResponseBean = response;
                fieldSearch.setText(this.userGeoResponseBean.getFullAddress());
            } catch (SyntaxBeanException syntaxException) {
                advice.setText("Invalid data, try again");
                this.fieldCountry.setText("");
                this.fieldDistance.setText("");
                this.fieldCity.setText("");
                labelIsItCorrect.setVisible(false);
                btnConfirm.setVisible(false);
                labelIsItCorrect.setDisable(true);
                btnConfirm.setDisable(true);

            } catch (GeocodingException geoEx) {
                advice.setText("Position not found, try again");
                this.fieldCountry.setText("");
                this.fieldDistance.setText("");
                this.fieldCity.setText("");
                this.fieldSearch.setText("");
                labelIsItCorrect.setDisable(true);
                btnConfirm.setDisable(true);
                labelIsItCorrect.setVisible(false);
                btnConfirm.setVisible(false);
            }
        }

    @FXML
    void btnConfirmClick(MouseEvent event) {
        try {
            controller.setGeoData(userDistanceBean);
            List<Result> results=controller.searchResults();
            FXMLLoader root = new FXMLLoader(getClass().getResource("/find_pc/view/gui/ResultsList.fxml"));
            Scene scene = new Scene(root.load(), 1280, 720);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            ResultsListGrController grController = root.getController();
            grController.setController(this.controller);
            grController.setResults(results);
            stage.show();
        }
        catch (IOException ioEx) {advice.setText("");
            System.err.println(ioEx.getMessage());}
        catch (ConnectionDBException dbEx){System.err.println(dbEx.getMessage());
        advice.setText("System error, please try agin later");}
        catch(SQLException sqlEx){System.err.println(sqlEx.getMessage());
            advice.setText("System error, please try agin later");}
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
    public void setController(FindPCController controller)
    {this.controller=controller;}
}
