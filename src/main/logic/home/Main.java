package home;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.model.Session;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class Main extends Application {
    private Random random = new Random();
    private static final String TRUE = "true";
    private static final String FALSE = "false";

    @Override
    public void start(Stage stage) throws IOException {//"/login/view/Login.fxml" oppure "Home.fxml"
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/login/view/Logout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280,720);
        stage.setTitle("GetYourPC");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
        public void chooseConfiguration() throws IOException {
        FileInputStream propsInput = new FileInputStream("src/main/logic/resources/config.properties");
        Properties prop = new Properties();
        prop.load(propsInput);
        this.randomConfigGenerate(prop); //If you don't want random generation of configuration, comment this line and set it manually
        String cliUI = prop.getProperty("cliUI");
        if (cliUI.equals(FALSE)){
            propsInput.close();
            launch();}
        else{
            propsInput.close();
            CLIHomeController c=new CLIHomeController();
            c.execute();}
        }

public void randomConfigGenerate(Properties prop) throws IOException {
        FileOutputStream propsOutput = new FileOutputStream("src/main/logic/resources/config.properties");
        String value;
        value=(random.nextInt(2)==1)?TRUE:FALSE;
        prop.setProperty("cliUI",value);
        value=(random.nextInt(2)==1)?TRUE:FALSE;
        prop.setProperty("daoOnFileSystem",value);
        prop.store(propsOutput, null);
        propsOutput.close();
}

    public static void main(String[] args) throws IOException {
        Main program = new Main();
        Session session=Session.getInstance();
        program.chooseConfiguration();
    }
}