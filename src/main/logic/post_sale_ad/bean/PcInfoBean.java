package post_sale_ad.bean;

import java.io.Serializable;

public class PcInfoBean implements Serializable {
    private String choice;
    public void setChoice(String s){
        this.choice=s;
    }
    public String getChoice(){
        return this.choice;
    }
}
