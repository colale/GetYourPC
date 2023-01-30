package login.app_controller;
import login.bean.CredentialsInput;
import login.bean.UserDataBean;
import login.model.Session;
import login.model.SessionDAOdb;
import java.sql.SQLException;

public class LoginController {
    public boolean checkIsAuthenticated(){
        return !((Session.getInstance().getEmail()).equals(""));

    }
    public boolean authenticate(CredentialsInput credentials){//db oppure fs
        try{SessionDAOdb s = new SessionDAOdb();
        UserDataBean userData = new UserDataBean();
        userData=s.login(credentials);
        try{
        Session.getInstance().setName(userData.getName());
        Session.getInstance().setSurname(userData.getSurname());
        Session.getInstance().setEmail(userData.getEmail());
        Session.getInstance().setRole(userData.getRole());}
        catch(Exception ex){return false;}
        return true;}
        catch(SQLException exSQL){return false;}//catch(IOException exIO){return false;}
    }
public void logout(){
    Session.getInstance().setEmail("");
    Session.getInstance().setName("");
    Session.getInstance().setRole("");
    Session.getInstance().setSurname("");
}
public UserDataBean getUser(){
    UserDataBean b = new UserDataBean();
    b.setName(Session.getInstance().getName());
    b.setSurname(Session.getInstance().getSurname());
    b.setEmail(Session.getInstance().getEmail());
    return b;
}
}