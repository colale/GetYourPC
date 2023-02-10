package test_login;

import exception.SyntaxBeanException;
import login.app_controller.LoginController;
import login.bean.CredentialsInputBean;
import login.model.Session;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLoginController {
    private static final String EMAIL = "mario.rossi@gmail.com";
//Assume that "mario.rossi@gmail.com" with password "password1" is a valid account
    @Test
    public void testCheckIsAuthenticated() {
        LoginController loginController = new LoginController();
        Session session = Session.getInstance();
        session.setEmail(EMAIL);
        assert (loginController.checkIsAuthenticated());
    }

    @Test
    public void testAuthenticate() throws SyntaxBeanException{
        LoginController loginController = new LoginController();
        CredentialsInputBean credentialsInputBean = new CredentialsInputBean();
        credentialsInputBean.setEmail(EMAIL);
        credentialsInputBean.setPassword("password1");
        assert (loginController.authenticate(credentialsInputBean));
    }

    @Test
    public void testAuthenticateWrongPassword() throws SyntaxBeanException{
        CredentialsInputBean credentialsInputBean = new CredentialsInputBean();
        LoginController loginController = new LoginController();
        credentialsInputBean.setEmail(EMAIL);
        credentialsInputBean.setPassword("wrongPassword");
        assertEquals(false, loginController.authenticate(credentialsInputBean));
    }
    //Assume that "mario.rossi@gmail.com" with password "wrongPassword" is non-existent account
    @Test
    public void testLogoutFromByUserLoggedIn() {
        LoginController loginController = new LoginController();
        Session session = Session.getInstance();
        session.setEmail(EMAIL);
        session.setName("Mario");
        session.setSurname("Rossi");
        session.setRole("user");
        loginController.logout();
        String s = session.getName() + session.getSurname() + session.getEmail() + session.getRole();
        assert (s.equals(""));
    }
}
