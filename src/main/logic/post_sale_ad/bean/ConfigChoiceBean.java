package post_sale_ad.bean;

import java.io.Serializable;

public class ConfigChoiceBean implements Serializable {
    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    private String choice;

}
