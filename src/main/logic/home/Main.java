package home;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280,720);
        stage.setTitle("GetYourPC");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) throws IOException {
        FileInputStream propsInput = new FileInputStream("src/main/logic/resources/config.properties");
        Properties prop = new Properties();
        prop.load(propsInput);
        String CLI_UI = prop.getProperty("CLI_UI");
        String USER_DAO_ON_FILESYSTEM=prop.getProperty("USER_DAO_ON_FILESYSTEM");
        if (CLI_UI.equals("false")){
            propsInput.close();
            launch();}
        else{
            propsInput.close();
            CLIHomeController c=new CLIHomeController();}
        }
}