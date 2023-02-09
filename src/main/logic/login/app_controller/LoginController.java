package login.app_controller;

import exception.ConnectionDBException;
import login.bean.CredentialsInputBean;
import login.bean.UserDataBean;
import login.model.Account;
import login.model.Session;
import login.model.SessionDAOdb;
import login.model.SessionDAOfs;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class LoginController {
    private Account userData;

    public boolean checkIsAuthenticated() {
        return !((Session.getInstance().getEmail()).equals(""));
    }

    public boolean authenticate(CredentialsInputBean credentials) throws IOException {
        FileInputStream propsInput = new FileInputStream("src/main/logic/resources/config.properties");
        Properties prop = new Properties();
        prop.load(propsInput);
        String property = prop.getProperty("daoOnFileSystem");
        boolean persistenceOnFS = (property.equals("true"));
        propsInput.close();
        boolean success;
        if(persistenceOnFS){success=this.usingFS(credentials);}
        else{success=this.usingDB(credentials);}
        if (success){return this.updateSession();}
        return false;
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
        return bean;
    }

    public int getUserId(){
        return Session.getInstance().getId();
    }

    public boolean updateSession() {
        try {
            Session.getInstance().setName(userData.getName());
            Session.getInstance().setSurname(userData.getSurname());
            Session.getInstance().setEmail(userData.getEmail());
            Session.getInstance().setRole(userData.getRole());
            Session.getInstance().setId(userData.getUserID());
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean usingDB(CredentialsInputBean credentials){
        try {
            SessionDAOdb s = new SessionDAOdb();
            this.userData = s.fetchUser(credentials); //fetch user data from database
            return true;}
        catch (SQLException exSQL) {
            return false;}
        catch (ConnectionDBException ex){//it is launched in case of failed connection to the DB
                String error=ex.getMessage();
                System.err.println(error);
                return false;}
    }

    public boolean usingFS(CredentialsInputBean credentials){
        SessionDAOfs s = new SessionDAOfs();
        try{
            this.userData=s.fetchUser(credentials);//fetch user data from FileSystem
            return true;}
        catch(Exception ex){
            return false;}
        }
    }

