package login.app_controller;

import login.bean.UserDataBean;
import login.model.Session;

public class LoginController {
    public boolean checkAuthentication(){
        if (Session.getInstance().getRole().equals("")) {return false;}
        else {return true;}
    }
    public boolean authenticate(UserDataBean b){return true;}//AUTENTICAZIONE DA FARE
public void logout(){
    Session.getInstance().setStatus("");
    Session.getInstance().setEmail("");
    Session.getInstance().setName("");
    Session.getInstance().setRole("");
    Session.getInstance().setSurname("");
}
}