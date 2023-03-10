package home;
import exception.ConnectionDBException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.model.DBConnection;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
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
        String cliUI = prop.getProperty("cliUI");//fetch UI property
        if (cliUI.equals(FALSE)){
            propsInput.close();
            launch();}//start in GUI mode
        else{
            propsInput.close();
            CLIHome c=new CLIHome();
            c.execute();}//start in CLI mode
        }

public void randomConfigGenerate(Properties prop) throws IOException {//generate random configuration
    FileOutputStream propsOutput = new FileOutputStream("src/main/logic/resources/config.properties");
        String randomBoolean;
        randomBoolean=(random.nextInt(2)==1)?TRUE:FALSE;//value is 0 or 1
        prop.setProperty("cliUI",randomBoolean); //setting UI
        randomBoolean=(random.nextInt(2)==1)?TRUE:FALSE;//value is 0 or 1
        prop.setProperty("daoOnFileSystem",randomBoolean);//setting user persistence
        prop.store(propsOutput, null);
        propsOutput.close();
}
    public static void quit(){
        try {
            DBConnection.getInstance().getConnection().close();

        }
        catch (SQLException | ConnectionDBException e){exit(0);}
        exit(0);}

    public static void main(String[] args) throws IOException{
            Home program = new Home();
            program.chooseConfiguration();//choose user interface and account persistence
    }
}