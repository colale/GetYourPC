package login.model;
import login.bean.CredentialsInputBean;
import java.io.*;
import java.util.List;
import java.util.Properties;
public class SessionDAOfs {
    static final String ACCOUNTSPATH="src/main/logic/resources/accountOnFS.dat";

    public Account fetchUser(CredentialsInputBean credentialsInputBean) throws IOException, ClassNotFoundException {
        FileInputStream fileInput = new FileInputStream(ACCOUNTSPATH);
        ObjectInputStream inputStream = new ObjectInputStream(fileInput);
        List<Account>accounts = (List<Account>) inputStream.readObject();
        inputStream.close();
        fileInput.close();
        for (Account account : accounts) {
            if (account.getEmail().equals(credentialsInputBean.getEmail()) && account.getPassword().equals(credentialsInputBean.getPassword())) {
                return account;}}
            throw new IOException();
        }
        public void insertAccount(Account account) throws IOException, ClassNotFoundException {
                    FileInputStream fis = new FileInputStream(ACCOUNTSPATH);
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
                    FileOutputStream fos = new FileOutputStream(ACCOUNTSPATH);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    accounts.add(account);
                    oos.writeObject(accounts);
                    oos.close();
                    fos.close();
                }
            }