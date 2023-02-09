package find_pc.bean;

import exception.SyntaxBeanException;

import java.io.Serializable;

public class UserDistanceBean implements Serializable {
    private String distance;
    public String getDistance() {
        return distance;
    }
    public void setDistance(String distance) throws SyntaxBeanException {
        syntaxCheck(distance);
        this.distance = distance;
    }

    private void syntaxCheck(String s) throws SyntaxBeanException {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            throw new SyntaxBeanException("Syntax error in distance entered");
        }
    }
}
