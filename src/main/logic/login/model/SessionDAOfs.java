package login.model;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Properties;

//lancia una eccezione se qualcosa va storto, se l'utente non esiste oppure non va l'IO
public class SessionDAOfs {
        public void insertAccount(String fileName, Account account) throws IOException {
            FileInputStream propsInput = new FileInputStream("src/main/logic/resources/config.properties");
            Properties prop = new Properties();
            prop.load(propsInput);
            String property = prop.getProperty("idCounterOnFileSystem");
            int counterID = Integer.parseInt(property);
            counterID++;
            account.setId_user(counterID);
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(account);
            objectOut.close();
            fileOut.close();
            property=Integer.toString(counterID);
            prop.setProperty("idCounterOnFileSystem",property);
            FileOutputStream propsOutput = new FileOutputStream("src/main/logic/resources/config.properties");
            prop.store(propsOutput, null);
            propsOutput.close();
        }
    }
