package post_sale_ad.boundary;
import exception.GeocodingException;
import post_sale_ad.bean.GeoRequestBean;
import post_sale_ad.bean.GeoResponseBean;

public interface Geocoding {
public GeoResponseBean getResult(GeoRequestBean request)throws GeocodingException;
}
