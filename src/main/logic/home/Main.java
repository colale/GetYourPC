package home;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class Main extends Application {
    private Random random = new Random();
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
        Main program = new Main();
        program.ChooseConfiguration();
    }
        public void ChooseConfiguration() throws IOException {
        FileInputStream propsInput = new FileInputStream("src/main/logic/resources/config.properties");
        Properties prop = new Properties();
        prop.load(propsInput);
        this.RandomConfigGenerate(prop); //If you don't want random generation of configuration, comment this line and set it manually
        String CLI_UI = prop.getProperty("CLI_UI");
        String USER_DAO_ON_FILESYSTEM=prop.getProperty("USER_DAO_ON_FILESYSTEM");
        if (CLI_UI.equals("false")){
            propsInput.close();
            launch();}
        else{
            propsInput.close();
            CLIHomeController c=new CLIHomeController();
            c.execute();}
        }

public void RandomConfigGenerate(Properties prop) throws IOException {
        FileOutputStream propsOutput = new FileOutputStream("src/main/logic/resources/config.properties");
        String value;
        value=(random.nextInt(2)==1)?"true":"false";
        prop.setProperty("CLI_UI",value);
        value=(random.nextInt(2)==1)?"true":"false";
        prop.setProperty("USER_DAO_ON_FILESYSTEM",value);
        prop.store(propsOutput, null);
        propsOutput.close();
}
}