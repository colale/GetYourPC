package post_sale_ad.bean;

import java.io.Serializable;

public class UserGeoResponseBean implements Serializable {
    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    private String fullAddress;
}
