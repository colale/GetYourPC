package login.app_controller;
import login.bean.UserDataBean;
import login.model.Session;
import Exception.SyntaxBeanException;

public class LoginController {
    public boolean checkIsAuthenticated(){
        if (Session.getInstance().getEmail().equals("")) {return false;}
        else {return true;}}
    public boolean authenticate(UserDataBean b){return true;}//AUTENTICAZIONE DA FARE
public void logout(){
    Session.getInstance().setStatus("");
    Session.getInstance().setEmail("");
    Session.getInstance().setName("");
    Session.getInstance().setRole("");
    Session.getInstance().setSurname("");
}
public UserDataBean getUser() throws SyntaxBeanException{
    UserDataBean b = new UserDataBean();
    b.setName(Session.getInstance().getName());
    b.setSurname(Session.getInstance().getSurname());
    b.setEmail(Session.getInstance().getEmail());
    return b;
}
}