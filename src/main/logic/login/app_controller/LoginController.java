package login.app_controller;

import login.model.Session;

public class LoginController {
    public boolean checkAuthentication(){
        if (Session.getInstance().getRole().equals("")) {return false;}
        else {return true;}
    }
}