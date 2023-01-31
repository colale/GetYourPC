package login.app_controller;
import login.bean.CredentialsInput;
import login.bean.UserDataBean;
import login.model.Session;
import login.model.SessionDAOdb;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class LoginController {
    UserDataBean userData;

    public boolean checkIsAuthenticated() {
        return !((Session.getInstance().getEmail()).equals(""));

    }

    public boolean authenticate(CredentialsInput credentials) throws IOException {//db oppure fs

        FileInputStream propsInput = new FileInputStream("src/main/logic/resources/config.properties");
        Properties prop = new Properties();
        prop.load(propsInput);
        String property = prop.getProperty("daoOnFileSystem");
        boolean persistanceOnFS = (property.equals("true"));
        propsInput.close();
        boolean success;
        if(persistanceOnFS){success=this.usingFS(credentials);}
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

    public UserDataBean getUser() {
        UserDataBean b = new UserDataBean();
        b.setName(Session.getInstance().getName());
        b.setSurname(Session.getInstance().getSurname());
        b.setEmail(Session.getInstance().getEmail());
        return b;
    }


    public boolean updateSession() {
        try {
            Session.getInstance().setName(userData.getName());
            Session.getInstance().setSurname(userData.getSurname());
            Session.getInstance().setEmail(userData.getEmail());
            Session.getInstance().setRole(userData.getRole());
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

            public boolean usingDB(CredentialsInput credentials){
            try {
        SessionDAOdb s = new SessionDAOdb(); //tenta la connessione al db
        userData = s.login(credentials); //prova a richiedere i dati
                return true;
    } catch (SQLException exSQL) {
        return false;
    }}
    public boolean usingFS(CredentialsInput credentials){return false;}
}
