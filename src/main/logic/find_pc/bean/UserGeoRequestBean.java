package find_pc.bean;

import exception.SyntaxBeanException;

import java.io.Serializable;

public class UserGeoRequestBean implements Serializable {

    private String country;
    private String city;
    private String address;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) throws SyntaxBeanException {
        syntaxCheck(country);
    this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws SyntaxBeanException {
        syntaxCheck(country);
        this.city = city;
    }

    private void syntaxCheck(String s) throws SyntaxBeanException {
        if (s.length() ==0 || s.length() > 50) {
            throw new SyntaxBeanException();
        }
    }
}