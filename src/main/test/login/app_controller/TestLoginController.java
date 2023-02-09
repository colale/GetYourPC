package login.app_controller;

import exception.SyntaxBeanException;
import login.bean.CredentialsInputBean;
import login.model.Session;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class TestLoginController {
    @Test
    public void TestCheckIsAuthenticatedCaseTrue(){
        LoginController loginController=new LoginController();
        Session session=Session.getInstance();
        session.setEmail("mario.rossi@gmail.com");
        assert(loginController.checkIsAuthenticated());
    }
    @Test
    public void TestCheckIsAuthenticatedCaseFalse(){
        LoginController loginController=new LoginController();
        Session session=Session.getInstance();
        session.setEmail("");
        assert(loginController.checkIsAuthenticated());
    }
    @Test
    public void TestAuthenticateCaseTrue() throws SyntaxBeanException, IOException {
        LoginController loginController=new LoginController();
        CredentialsInputBean credentialsInputBean =new CredentialsInputBean();
        credentialsInputBean.setEmail("mario.rossi@gmail.com)");
        credentialsInputBean.setPassword("password1");
        assert(loginController.authenticate(credentialsInputBean));
    }
    @Test
    public void TestAuthenticateCaseFalse() throws SyntaxBeanException, IOException {
        LoginController loginController=new LoginController();
        CredentialsInputBean credentialsInputBean =new CredentialsInputBean();
        loginController=new LoginController();
        credentialsInputBean.setEmail("mario.rossi@gmail.com)");
        credentialsInputBean.setPassword("wrongPassword");//nel assumiamo che una mail possa avere una e una sola password
        assert(!loginController.authenticate(credentialsInputBean));
    }
    @Test
    public void TestLogout(){
        LoginController loginController=new LoginController();
        Session session=Session.getInstance();
        session.setEmail("mario.rossi@gmail.com");
        session.setName("Mario");
        session.setRole("user");
        session.setSurname("Rossi");
        loginController.logout();
        boolean prop1=(session.getEmail()).equals(session.getRole());
        boolean prop2=(session.getName()).equals(session.getSurname());
        assert(prop1&&prop2);
    }

}