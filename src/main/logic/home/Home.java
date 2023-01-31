package home;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.security.SecureRandom;
import static java.lang.System.exit;

/*Se si vuole popolare lo strato di persistenza:
import login.model.Account;
import login.model.SessionDAOdb;
import login.model.SessionDAOfs;
*/

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
    public static void quit(){exit(0);}//da migliorare
    public static void main(String[] args) throws IOException, SQLException {
        Home program = new Home();
        program.chooseConfiguration();
    }
}

        /* Questo è il codice utilizzato per popolare il file.dat
        Account a=new Account();
        a.setName("Michele");
        a.setEmail("michele.bianchi@gmail.com");
        a.setPassword("password4");
        a.setRole("user");
        a.setSurname("Bianchi");
        a.setStatus("active");
        SessionDAOfs s = new SessionDAOfs();
        s.insertAccount("src/main/logic/resources/accountOnFS.dat",a);
        */

        /* Questo è il codice utilizzato per popolare il db
        Account a=new Account();
        a.setName("Sara");
        a.setEmail("sara.rossi@gmail.com");
        a.setPassword("password5");
        a.setRole("user");
        a.setSurname("Rossi");
        SessionDAOdb s = new SessionDAOdb();
        s.insertAccount(a);
        */


