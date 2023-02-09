package find_pc.app_controller;

import boundary.*;
import exception.ConnectionDBException;
import exception.GeocodingException;
import find_pc.bean.*;
import find_pc.model.*;
import java.sql.SQLException;
import java.util.List;

public class FindPCController {
    private UserRequest userRequest;
    private GeoResponseBean geoResponseBean;

    public void createRequest(UserChoiceBean bean) {
        this.userRequest = new UserRequest();
        this.userRequest.setConfigChoice(bean.getChoice());
    }

    public void setBudget(UserBudgetBean bean) {
        this.userRequest.setBudgetRange(bean.getRange());
    }

    public UserGeoResponseBean searchPosition(UserGeoRequestBean userGeoData) throws GeocodingException {//require position to API (using adapter pattern)
        GeoRequestBean geoRequestBean = new GeoRequestBean();
        String input = userGeoData.getCity() + " " + userGeoData.getCountry();
        geoRequestBean.setGeoRequest(input);
        GeocodingCityAdapter geocodingAdapter = new GeocodingCityAdapter(new Geoapify());
        UserGeoResponseBean responseToUser = new UserGeoResponseBean();
        this.geoResponseBean = geocodingAdapter.findResult(geoRequestBean);
        String output = this.geoResponseBean.getCity() + " " + this.geoResponseBean.getCountry();
        responseToUser.setFullAddress(output);
        return responseToUser;
    }
    public void setGeoData(UserDistanceBean bean){//geo info for request
        userRequest.setLatRequest(this.geoResponseBean.getLatitude());
        userRequest.setLongRequest(this.geoResponseBean.getLongitude());
        userRequest.setDistance(bean.getDistance());
    }

    public List<Result> searchResults() throws ConnectionDBException, SQLException {
        String choice=this.userRequest.getConfigChoice();

        if (choice.equals("desktop")){
            ResultDesktopDAO desktopDao= new ResultDesktopDAO();
            return desktopDao.fetchResults(this.userRequest);}

        else{
            ResultLaptopDAO laptopDao= new ResultLaptopDAO();
            return laptopDao.fetchResults(this.userRequest);
        }
    }
}