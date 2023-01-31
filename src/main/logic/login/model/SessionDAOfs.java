package login.model;
import login.bean.CredentialsInput;
import java.io.*;
import java.util.List;
import java.util.Properties;
public class SessionDAOfs {
    static final String sessionOnFsPath="src/main/logic/resources/accountOnFS.dat";

    public Account fetchUser(CredentialsInput credentialsInput) throws IOException, ClassNotFoundException {
        FileInputStream fileInput = new FileInputStream(sessionOnFsPath);
        ObjectInputStream inputStream = new ObjectInputStream(fileInput);
        List<Account>accounts = (List<Account>) inputStream.readObject();
        inputStream.close();
        fileInput.close();
        for (Account account : accounts) {
            if (account.getEmail().equals(credentialsInput.getEmail()) && account.getPassword().equals(credentialsInput.getPassword())) {
                return account;}}
            throw new IOException();
        }
        public void insertAccount(Account account) throws IOException, ClassNotFoundException {
                    FileInputStream fis = new FileInputStream(sessionOnFsPath);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    List<Account> accounts = (List<Account>) ois.readObject();
                    ois.close();
                    fis.close();
                    FileInputStream propsInput = new FileInputStream("src/main/logic/resources/config.properties");
                    Properties prop = new Properties();
                    prop.load(propsInput);
                    String property = prop.getProperty("idCounterOnFileSystem");
                    int counterID = Integer.parseInt(property);
                    counterID++;
                    account.setUserID(counterID);
                    property=Integer.toString(counterID);
                    prop.setProperty("idCounterOnFileSystem",property);
                    FileOutputStream propsOutput = new FileOutputStream("src/main/logic/resources/config.properties");
                    prop.store(propsOutput, null);
                    propsOutput.close();
                    FileOutputStream fos = new FileOutputStream(sessionOnFsPath);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    accounts.add(account);
                    oos.writeObject(accounts);
                    oos.close();
                    fos.close();
                }
            }