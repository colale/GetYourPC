package post_sale_ad.boundary;

import exception.GeocodingException;
import post_sale_ad.bean.GeoRequestBean;
import post_sale_ad.bean.GeoResponseBean;
import java.net.http.HttpResponse;
import post_sale_ad.boundary.conversion_classes.Root;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GeocodingAdapter implements Geocoding {
    Geoapify api;
    public GeocodingAdapter(Geoapify api) {
        this.api = api;
    }

    @Override
    public GeoResponseBean findResult(GeoRequestBean request) throws GeocodingException{
        try {
            HttpResponse<String> response = this.api.findResult(request);
            ObjectMapper om = new ObjectMapper();
            String JSONstring=response.body();
            Root root = om.readValue(JSONstring, Root.class);
            double lat = (double) (root.features.get(0).geometry.coordinates.get(0));
            double lon = (double) (root.features.get(0).geometry.coordinates.get(1));
            String street = (String) (root.features.get(0).properties.street);
            String houseNumber = (String) (root.features.get(0).properties.housenumber);
            String cap = (String) (root.features.get(0).properties.postcode);
            String city = (String) (root.features.get(0).properties.city);
            String country = (String) (root.features.get(0).properties.country);
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
