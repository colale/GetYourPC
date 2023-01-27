package login.bean;
import Exception.SyntaxBeanException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.io.Serializable;

public class UserDataBean implements Serializable {
    String name;
    String surname;
    String email;
    String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws SyntaxBeanException {
        try {
            syntaxCheckEmail(email);
            this.email = email;
        } catch (AddressException e) {
            SyntaxBeanException exception = new SyntaxBeanException();
            throw exception;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws SyntaxBeanException {
        syntaxCheckPassword(password);
        this.password = password;
    }

    private void syntaxCheckEmail(String email) throws AddressException {
        InternetAddress emailAddr = new InternetAddress(email);
        emailAddr.validate();
    }

    private void syntaxCheckPassword(String s) throws SyntaxBeanException {
        if (s.length() < 8 || s.length() > 15) {
            SyntaxBeanException e = new SyntaxBeanException();
            throw e;}
    }
}