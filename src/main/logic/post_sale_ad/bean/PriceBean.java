package post_sale_ad.bean;

import exception.SyntaxBeanException;

import java.io.Serializable;

public class PriceBean implements Serializable {
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) throws SyntaxBeanException {
        syntaxCheck(price);
        this.price = price;
    }

    private String price;

    private void syntaxCheck(String s) throws SyntaxBeanException {
        if (s.length() ==0 || s.length() > 10) {
            throw new SyntaxBeanException("Syntax error in price");
        }
    }
}