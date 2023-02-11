package boundary;
import exception.GeocodingException;

public interface Geocoding {
    GeoResponseBean findPosition(GeoRequestBean request)throws GeocodingException;
}
