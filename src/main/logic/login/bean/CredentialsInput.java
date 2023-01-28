package login.bean;
        import exception.SyntaxBeanException;

        import javax.mail.internet.AddressException;
        import javax.mail.internet.InternetAddress;
        import java.io.Serializable;

public class CredentialsInput implements Serializable {
    String email;
    String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws SyntaxBeanException {
        try {
            syntaxCheckEmail(email);
            this.email = email;
        } catch (AddressException e) {
            throw new SyntaxBeanException();
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
            throw new SyntaxBeanException();}
    }
}