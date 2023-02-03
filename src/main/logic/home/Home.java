package home;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.security.SecureRandom;
import static java.lang.System.exit;

public class Home extends Application {
    private SecureRandom random = new SecureRandom();
    private static final String TRUE = "true";
    private static final String FALSE = "false";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280,720);
        stage.setTitle("GetYourPC");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setOnCloseRequest(new GraphicCloseHandler());
        stage.show();}



        public void chooseConfiguration() throws IOException {
        FileInputStream propsInput = new FileInputStream("src/main/logic/resources/config.properties");
        Properties prop = new Properties();
        prop.load(propsInput);
        this.randomConfigGenerate(prop); //If you don't want random generation of configuration, comment this line and set it manually
        String cliUI = prop.getProperty("cliUI");
        if (cliUI.equals(FALSE)||!cliUI.equals(FALSE)){//!!!!!!!!!!!!!!!!
            propsInput.close();
            launch();}
        else{
            propsInput.close();
            CLIHome c=new CLIHome();
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
    public static void quit(){
        System.out.println("aa");//chiudere le connessioni
        exit(0);
    }

    public static void main(String[] args) throws IOException {
        //*Insert code here if you want insert new user, for information read file README
            Home program = new Home();
            program.chooseConfiguration();
    }
}