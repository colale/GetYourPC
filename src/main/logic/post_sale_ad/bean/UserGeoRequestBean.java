package post_sale_ad.bean;

import exception.SyntaxBeanException;

public class UserGeoRequestBean {

    private String country;
    private String city;
    private String address;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) throws SyntaxBeanException {
        syntaxCheckPassword(country);
    this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws SyntaxBeanException {
        syntaxCheckPassword(country);
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws SyntaxBeanException {
        syntaxCheckPassword(country);
        this.address = address;
    }

    private void syntaxCheckPassword(String s) throws SyntaxBeanException {
        if (s.length() < 8 || s.length() > 15) {
            throw new SyntaxBeanException();
        }
    }
}