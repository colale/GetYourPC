package login.app_controller;
import login.bean.CredentialsInput;
import login.bean.UserDataBean;
import login.model.Session;
import exception.SyntaxBeanException;

public class LoginController {
    public boolean checkIsAuthenticated(){
        return !Session.getInstance().getEmail().equals("");
    }
    public boolean authenticate(CredentialsInput b){return true;}//AUTENTICAZIONE DA FARE
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