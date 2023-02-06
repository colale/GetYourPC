package post_sale_ad.boundary;

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
    public GeoResponseBean getResult(GeoRequestBean request) throws GeocodingException{
        try {
            HttpResponse<String> response = this.api.findResult(request);
            String JSONstring = response.body();
            ObjectMapper om = new ObjectMapper();
            Root root = om.readValue(JSONstring, Root.class);
            double lat = (double) (root.features.get(0).geometry.coordinates.get(0));
            double lon = (double) (root.features.get(0).geometry.coordinates.get(1));
            String street = (String) (root.features.get(0).properties.street);
            String housenumber = (String) (root.features.get(0).properties.housenumber);
            String cap = (String) (root.features.get(0).properties.postcode);
            String city = (String) (root.features.get(0).properties.city);
            String country = (String) (root.features.get(0).properties.country);
            System.out.println("latitudine: " + lat);
            System.out.println("longitudine: " + lon);
            System.out.println("street: " + street);
            System.out.println("housenumber: " + housenumber);
            System.out.println("cap:" + cap);
            System.out.println("city: " + city);
            System.out.println("country: " + country);
        } catch (Exception ex) {
            throw new GeocodingException();
        }
        GeoResponseBean responseBean=new GeoResponseBean();
        return responseBean;
    }
}
