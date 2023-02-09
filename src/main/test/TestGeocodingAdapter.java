import boundary.GeoRequestBean;
import boundary.GeoResponseBean;
import boundary.Geoapify;
import boundary.GeocodingAdapter;
import exception.GeocodingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGeocodingAdapter {
    @Test
    public void testFindResultNullInputThrowsException() {
        GeoRequestBean request = new GeoRequestBean();
        request.setGeoRequest("");
        Geoapify geoapify = new Geoapify();
        GeocodingAdapter geocodingAdapter = new GeocodingAdapter(geoapify);
        try {
            GeoResponseBean response = geocodingAdapter.findResult(request);
            assert (false);
        } catch (GeocodingException geoEx) {
        }
        assert (true);
    }

    @Test
    public void testFindResultNumericInputThrowsException() {
        GeoRequestBean request = new GeoRequestBean();
        request.setGeoRequest("12");
        Geoapify geoapify = new Geoapify();
        GeocodingAdapter geocodingAdapter = new GeocodingAdapter(geoapify);
        try {
            GeoResponseBean response = geocodingAdapter.findResult(request);
            assert (false);
        } catch (GeocodingException geoEx) {
        }
        assert (true);
    }

    @Test
    public void testFindResultZeroInputThrowsException() {
        GeoRequestBean request = new GeoRequestBean();
        request.setGeoRequest("0");
        Geoapify geoapify = new Geoapify();
        GeocodingAdapter geocodingAdapter = new GeocodingAdapter(geoapify);
        try {
            GeoResponseBean response = geocodingAdapter.findResult(request);
            assert (false);
        } catch (GeocodingException geoEx) {
        }
        assert (true);
    }

    @Test
    public void testFindResultNegativeInputThrowsException() {
        GeoRequestBean request = new GeoRequestBean();
        request.setGeoRequest("-5");
        Geoapify geoapify = new Geoapify();
        GeocodingAdapter geocodingAdapter = new GeocodingAdapter(geoapify);
        try {
            GeoResponseBean response = geocodingAdapter.findResult(request);
            assert (false);
        } catch (GeocodingException geoEx) {
        }
        assert (true);
    }

    @Test
    public void testFindResultWrongInputThrowsException() {
        GeoRequestBean request = new GeoRequestBean();
        request.setGeoRequest("Rome Italy");
        Geoapify geoapify = new Geoapify();
        GeocodingAdapter geocodingAdapter = new GeocodingAdapter(geoapify);
        try {
            GeoResponseBean response = geocodingAdapter.findResult(request);
            assert (false);
        } catch (GeocodingException geoEx) {
            assert (true);
        }
    }

    @Test
    public void testFindResultIncompleteInputThrowsException() {
        GeoRequestBean request = new GeoRequestBean();
        request.setGeoRequest("Via del polit");
        Geoapify geoapify = new Geoapify();
        GeocodingAdapter geocodingAdapter = new GeocodingAdapter(geoapify);
        try {
            GeoResponseBean response = geocodingAdapter.findResult(request);
            assert (false);
        } catch (GeocodingException geoEx) {
            assert (true);
        }
    }

    @Test
    public void testFindResultCityCorrectInput() {
        GeoRequestBean request = new GeoRequestBean();
        request.setGeoRequest("Via del Politecnico 1");
        Geoapify geoapify = new Geoapify();
        GeocodingAdapter geocodingAdapter = new GeocodingAdapter(geoapify);
        try {
            GeoResponseBean response = geocodingAdapter.findResult(request);
            assertEquals("Rome", response.getCity());
        } catch (GeocodingException geoEx) {
            assert (false);
        }
    }

    @Test
    public void testFindResultRoadCorrectInput() {
        GeoRequestBean request = new GeoRequestBean();
        request.setGeoRequest("Via del Politecnico 1");
        Geoapify geoapify = new Geoapify();
        GeocodingAdapter geocodingAdapter = new GeocodingAdapter(geoapify);
        try {
            GeoResponseBean response = geocodingAdapter.findResult(request);
            assertEquals("Via del Politecnico", response.getStreet());
        } catch (GeocodingException geoEx) {
            assert (false);
        }
    }

    @Test
    public void testFindResultCAPCorrectInput() {
        GeoRequestBean request = new GeoRequestBean();
        request.setGeoRequest("Piazza Barberini Rome Italy");
        Geoapify geoapify = new Geoapify();
        GeocodingAdapter geocodingAdapter = new GeocodingAdapter(geoapify);
        try {
            GeoResponseBean response = geocodingAdapter.findResult(request);
            assertEquals("00187", response.getCap());
        } catch (GeocodingException geoEx) {
            assert (false);
        }
    }
}
