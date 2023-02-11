package login.app_controller;

import exception.ConnectionDBException;
import login.bean.CredentialsInputBean;
import login.bean.UserDataBean;
import login.model.Account;
import login.model.Session;
import login.model.AccountDAOdb;
import login.model.AccountDAOfs;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class LoginController {

    public boolean checkIsAuthenticated() {
        return !((Session.getInstance().getEmail()).equals(""));
    }

    public boolean authenticate(CredentialsInputBean credentials){
        try {
        Account account;
        FileInputStream propsInput = new FileInputStream("src/main/logic/resources/config.properties");
        Properties prop = new Properties();
        prop.load(propsInput);
        String property = prop.getProperty("daoOnFileSystem");
        boolean persistenceOnFS = (property.equals("true"));
        propsInput.close();
            if (persistenceOnFS){account = usingFS(credentials);}
            else {account = usingDB(credentials);}
            return this.updateSession(account);}
        catch (ConnectionDBException ex) {//it is launched in case of failed connection to the DB
            System.err.println(ex.getMessage());
            return false;}
        catch (SQLException ex) {//it is launched in case of db query fail
            return false;}
        catch (ClassNotFoundException e) {//it is launched in case of fs query fail
            System.err.println(e.getMessage());
            return false;}
        catch (IOException ioException) {//it is launched in case of fs query fail
            return false;}
    }
    public void logout() {
        Session.getInstance().setEmail("");
        Session.getInstance().setName("");
        Session.getInstance().setRole("");
        Session.getInstance().setSurname("");
    }

    public UserDataBean getUserDataBean() {//fetch authenticated user data from Session to show when logout is requested
        UserDataBean bean = new UserDataBean();
        bean.setName(Session.getInstance().getName());
        bean.setSurname(Session.getInstance().getSurname());
        bean.setEmail(Session.getInstance().getEmail());
        bean.setRole(Session.getInstance().getRole());
        return bean;
    }
    public int getUserId(){
        return Session.getInstance().getId();
    }
    public boolean updateSession(Account account) {
        try{
            Session.getInstance().setName(account.getName());
            Session.getInstance().setSurname(account.getSurname());
            Session.getInstance().setEmail(account.getEmail());
            Session.getInstance().setRole(account.getRole());
            Session.getInstance().setId(account.getUserID());}
        catch (Exception ex){return false;}
        return true;
    }

    Account usingDB(CredentialsInputBean credentials) throws ConnectionDBException, SQLException { //fetch user data from database
            AccountDAOdb s = new AccountDAOdb();
            return s.fetchUser(credentials);
}

    Account usingFS(CredentialsInputBean credentials) throws IOException, ClassNotFoundException {
        AccountDAOfs s = new AccountDAOfs();
            return s.fetchUser(credentials);//fetch user data from FileSystem
        }
    }

