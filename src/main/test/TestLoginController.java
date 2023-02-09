import exception.SyntaxBeanException;
import login.app_controller.LoginController;
import login.bean.CredentialsInputBean;
import login.model.Session;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class TestLoginController {
    @Test
    public void testCheckIsAuthenticated(){
        LoginController loginController=new LoginController();
        Session session=Session.getInstance();
        session.setEmail("mario.rossi@gmail.com");
        assert(loginController.checkIsAuthenticated());
    }
    @Test
    public void testAuthenticate() throws SyntaxBeanException, IOException {
        LoginController loginController=new LoginController();
        CredentialsInputBean credentialsInputBean =new CredentialsInputBean();
        credentialsInputBean.setEmail("mario.rossi@gmail.com");
        credentialsInputBean.setPassword("password1");
        assert(loginController.authenticate(credentialsInputBean));
    }
    @Test
    public void testAuthenticateWrongPassword() throws SyntaxBeanException, IOException {
        CredentialsInputBean credentialsInputBean =new CredentialsInputBean();
        LoginController loginController=new LoginController();
        credentialsInputBean.setEmail("mario.rossi@gmail.com");
        credentialsInputBean.setPassword("wrongPassword");
        assertEquals(false,loginController.authenticate(credentialsInputBean));
    }
    @Test
    public void testLogoutFromByUserLoggedIn(){
        LoginController loginController=new LoginController();
        Session session=Session.getInstance();
        session.setEmail("mario.rossi@gmail.com");
        session.setName("Mario");
        session.setSurname("Rossi");
        session.setRole("user");
        loginController.logout();
        String s=session.getName()+session.getSurname()+session.getEmail()+session.getRole();
        assert(s.equals("")); }
    @Test
    public void testLogoutFromByUserNotLoggedIn(){
        LoginController loginController=new LoginController();
        Session session=Session.getInstance();
        session.setEmail("");
        session.setName("");
        session.setSurname("");
        session.setRole("");
        loginController.logout();
        String s=session.getName()+session.getSurname()+session.getEmail()+session.getRole();
        assert(s.equals("")); }
}
