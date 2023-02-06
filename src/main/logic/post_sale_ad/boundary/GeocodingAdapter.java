package post_sale_ad.boundary;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import exception.GeocodingException;
import post_sale_ad.bean.GeoRequestBean;
import post_sale_ad.bean.GeoResponseBean;

import java.io.IOException;
import java.net.http.HttpResponse;

public class GeocodingAdapter implements Geocoding {
    Geoapify api;
    public GeocodingAdapter(Geoapify api) {
        this.api = api;
    }

    @Override
    public GeoResponseBean findResult(GeoRequestBean request) throws GeocodingException{
        GeoResponseBean responseBean=new GeoResponseBean();
        try {
            HttpResponse<String> response = this.api.findResult(request);
            JSONObject json = new JSONObject(response.body());
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
            responseBean.setCity(city);
            responseBean.setCountry(country);
            responseBean.setLatitude(lat);
            responseBean.setLongitude(lon);
            responseBean.setHouseNumber(houseNumber);
            responseBean.setStreet(street);
            responseBean.setCap(cap);
            return responseBean;}
        catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
            throw new GeocodingException();}
        catch (IOException ioEx){
            System.err.println(ioEx.getMessage());
            throw new GeocodingException();}
        catch(JSONException jEx){
            throw new GeocodingException();}
        }
    }
