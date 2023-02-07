package find_pc.app_controller;
import boundary.*;
import exception.ConnectionDBException;
import exception.GeocodingException;
import find_pc.bean.*;
import find_pc.model.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class FindPCController {
    UserRequest userRequest;
    GeoResponseBean geoResponseBean;

    public void createRequest(UserChoiceBean bean) {
        this.userRequest = new UserRequest();
        this.userRequest.setConfigChoice(bean.getChoice());
    }

    public void setBudget(UserBudgetBean bean) {
        this.userRequest.setBudgetRange(bean.getRange());
    }

    public UserGeoResponseBean searchPosition(UserGeoRequestBean userGeoData) throws GeocodingException {
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
    public void setGeoData(UserDistanceBean bean){
        userRequest.setLatRequest(this.geoResponseBean.getLatitude());
        userRequest.setLongRequest(this.geoResponseBean.getLongitude());
        userRequest.setDistance(bean.getDistance());
    }

public ArrayList<Result> searchResults() throws ConnectionDBException, SQLException {
        ArrayList<Result> list = new ArrayList<>();
        String choice=this.userRequest.getConfigChoice();

        switch (choice){

            case "desktop":
                ResultDesktopDAO desktopDao= new ResultDesktopDAO();
                return desktopDao.fetchResults(this.userRequest);

            case "laptop":
                ResultLaptopDAO laptopDao= new ResultLaptopDAO();
                return laptopDao.fetchResults(this.userRequest);
        }
    throw new ConnectionDBException("Error in PC selection");
    }
    }