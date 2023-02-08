package login.app_controller;

import exception.SyntaxBeanException;
import login.bean.CredentialsInput;
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
        CredentialsInput credentialsInput=new CredentialsInput();
        credentialsInput.setEmail("mario.rossi@gmail.com)");
        credentialsInput.setPassword("password1");
        assert(loginController.authenticate(credentialsInput));
    }
    @Test
    public void TestAuthenticateCaseFalse() throws SyntaxBeanException, IOException {
        LoginController loginController=new LoginController();
        CredentialsInput credentialsInput=new CredentialsInput();
        loginController=new LoginController();
        credentialsInput.setEmail("mario.rossi@gmail.com)");
        credentialsInput.setPassword("wrongPassword");//nel assumiamo che una mail possa avere una e una sola password
        assert(!loginController.authenticate(credentialsInput));
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