package login.model;
import login.bean.CredentialsInput;
import java.io.*;
import java.util.List;
import java.util.Properties;
public class SessionDAOfs {

    public Account fetchUser(CredentialsInput credentialsInput) throws IOException, ClassNotFoundException {
        FileInputStream fileInput = new FileInputStream("src/main/logic/resources/accountOnFS.dat");
        ObjectInputStream inputStream = new ObjectInputStream(fileInput);
        List<Account>accounts = (List<Account>) inputStream.readObject(); //questo non lo esegue
        inputStream.close();
        fileInput.close();
        for (Account account : accounts) {
            if (account.getEmail().equals(credentialsInput.getEmail()) && account.getPassword().equals(credentialsInput.getPassword())) {
                System.out.println("aaa");
                return account;}}
            throw new IOException();
        }
        public void insertAccount(List <Account> accounts) throws IOException, ClassNotFoundException {
            FileOutputStream fos = new FileOutputStream("src/main/logic/resources/accountOnFS.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(accounts);
            oos.close();
            fos.close();
        }
    }
