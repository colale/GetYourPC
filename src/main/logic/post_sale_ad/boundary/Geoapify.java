package post_sale_ad.boundary;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;
import post_sale_ad.bean.GeoRequestBean;


public class Geoapify {
    public HttpResponse<String> findResult(GeoRequestBean request) throws IOException, InterruptedException {
        FileInputStream propsInput = new FileInputStream("src/main/logic/resources/config.properties");
        Properties prop = new Properties();
        prop.load(propsInput);
        String apiKey = prop.getProperty("apikey");
        String inputString = request.getGeoRequest();
        inputString=generateCompatibleString(inputString);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api.geoapify.com/v1/geocode/search?text=" + inputString + prop.getProperty("apikey")))
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return response;
    }

    String generateCompatibleString(String inputString){
        int i = 0;
        for (i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == ' ') {
                inputString = inputString.substring(0, i) + "%20" + inputString.substring(i + 1);
            }
        }
    return inputString;
    }
}