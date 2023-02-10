package boundary;
import exception.GeocodingException;

public interface Geocoding {
    GeoResponseBean findResult(GeoRequestBean request)throws GeocodingException;
}
