package boundary;
import exception.GeocodingException;

public interface Geocoding {
public GeoResponseBean findResult(GeoRequestBean request)throws GeocodingException;
}
