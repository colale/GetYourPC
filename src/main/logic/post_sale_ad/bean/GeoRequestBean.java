package post_sale_ad.bean;

import java.io.Serializable;

public class GeoRequestBean implements Serializable {
    private String  geoRequest;
    public String getGeoRequest() {
        return geoRequest;
    }
    public void setGeoRequest(String geoRequest) {
        this.geoRequest = geoRequest;
    }
}
