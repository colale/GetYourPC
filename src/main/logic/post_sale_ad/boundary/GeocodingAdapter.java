package post_sale_ad.boundary;
import org.json.JSONArray;
import org.json.JSONObject;
import exception.GeocodingException;
import post_sale_ad.bean.GeoRequestBean;
import post_sale_ad.bean.GeoResponseBean;
import java.net.http.HttpResponse;

public class GeocodingAdapter implements Geocoding {
    Geoapify api;
    public GeocodingAdapter(Geoapify api) {
        this.api = api;
    }

    @Override
    public GeoResponseBean findResult(GeoRequestBean request) throws GeocodingException{
        try {
            HttpResponse<String> response = this.api.findResult(request);
            String JSONstring=response.body();
            JSONObject json = new JSONObject(JSONstring);
            JSONObject feature = json.getJSONArray("features").getJSONObject(0);
            JSONObject properties = feature.getJSONObject("properties");
            JSONObject geometry = feature.getJSONObject("geometry");
            String street = properties.getString("street");
            String houseNumber = properties.optString("housenumber");
            String cap = properties.getString("postcode");
            String city = properties.getString("city");
            String country = properties.getString("country");
            JSONArray coordinates = geometry.getJSONArray("coordinates");
            double lat = coordinates.getDouble(0);
            double lon = coordinates.getDouble(1);
            GeoResponseBean responseBean=new GeoResponseBean();
            responseBean.setCity(city);
            responseBean.setCountry(country);
            responseBean.setLatitude(lat);
            responseBean.setLongitude(lon);
            responseBean.setHouseNumber(houseNumber);
            responseBean.setStreet(street);
            responseBean.setCap(cap);
            return responseBean;}
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new GeocodingException();
        }
    }
}
