package find_pc.bean;

import java.io.Serializable;

public class UserGeoResponseBean implements Serializable {
    private String fullAddress;
    public String getFullAddress() {
        return fullAddress;
    }
    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }
}
