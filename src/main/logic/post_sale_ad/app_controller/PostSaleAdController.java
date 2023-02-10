package post_sale_ad.app_controller;

import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import boundary.GeoRequestBean;
import boundary.GeoResponseBean;
import exception.ConnectionDBException;
import exception.FactoryException;
import exception.GeocodingException;
import home.Home;
import login.app_controller.LoginController;
import post_sale_ad.bean.*;
import boundary.Geoapify;
import boundary.GeocodingAdapter;
import post_sale_ad.model.factory_config_dao.PostDAO;
import post_sale_ad.model.factory_config_dao.PostFactoryDAO;
import post_sale_ad.model.factory_config_info.Post;
import post_sale_ad.model.factory_config_info.PostFactory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostSaleAdController {
    private Post post;
    private GeoResponseBean geoResponseBean;
    public boolean checkAuthentication() {
        LoginController loginController=new LoginController();
        return (loginController.checkIsAuthenticated());
    }

    public void createPost(PcInfoBean pcInfoBean) {
        PostFactory postFactory = new PostFactory();
        try {//factory method
            this.post = postFactory.create(pcInfoBean);
            this.setSellerId();}
        catch (FactoryException ex) {//Abnormal case in which an unrecognized string is passed to the factory
            System.err.println(ex.getMessage());
            Home.quit();}
    }
    public void setSellerId(){
        LoginController loginController=new LoginController();
        int id =loginController.getUserId();
        post.getGeneralPostInfo().setSellerId(id);
    }

    public boolean checkPrice(PriceBean bean) {
        try {
            String price = bean.getPrice();
            double parsedPrice = Double.parseDouble(price);
            return parsedPrice > 0 && parsedPrice < 1000000; //Assume that the price is less than 1000000
        } catch (NumberFormatException e) {
            return false;
        }
        catch (NullPointerException ex){return false;}
    }

    public void setPrice(PriceBean bean) {
        int price = Integer.parseInt(bean.getPrice());
        post.getGeneralPostInfo().setPrice(price);
    }

    public void setConfigInfo(PcInfoBean bean) {
        this.post.setInfo(bean);
    }//sets the information related to the specific pc configuration

    public boolean checkPhotos(PhotoBean bean) {
        ArrayList<String> imagesPath = new ArrayList<String>();
        imagesPath.add(bean.getImgPath1());
        imagesPath.add(bean.getImgPath2());
        imagesPath.add(bean.getImgPath3());
        for (String s : imagesPath) {
            try {
                BufferedImage image = ImageIO.read(new File(s));
                // Verify that the image exists and that its size does not exceed the capacity of the long blob
                if (image == null || (long) (image.getHeight() * image.getWidth() * 3) > Integer.MAX_VALUE) {
                    return false;}}
            catch (IOException e) {
                return false;}
        }
        return true;
    }

    public void setPhotos(PhotoBean bean) {
        post.getGeneralPostInfo().setImg1(bean.getImgPath1());
        post.getGeneralPostInfo().setImg2(bean.getImgPath2());
        post.getGeneralPostInfo().setImg3(bean.getImgPath3());
    }

    public UserGeoResponseBean searchPosition(UserGeoRequestBean userGeoData) throws GeocodingException {
        GeoRequestBean geoRequestBean = new GeoRequestBean();
        String input = userGeoData.getAddress() + " " + userGeoData.getCity() + " " + userGeoData.getCountry();//prepare bean for adapter
        geoRequestBean.setGeoRequest(input);
        GeocodingAdapter geocodingAdapter = new GeocodingAdapter(new Geoapify());
        UserGeoResponseBean responseToUser = new UserGeoResponseBean();
        this.geoResponseBean = geocodingAdapter.findResult(geoRequestBean);
        String output = this.geoResponseBean.getStreet() + " " + this.geoResponseBean.getHouseNumber() + " " + this.geoResponseBean.getCap() + " " + this.geoResponseBean.getCity() + " " + this.geoResponseBean.getCountry();
        responseToUser.setFullAddress(output);
        return responseToUser;
    }

    public void setPosition() throws SQLException, FileNotFoundException, ConnectionDBException {
        String fullAddress = this.geoResponseBean.getStreet() + " " + this.geoResponseBean.getHouseNumber() + " " + this.geoResponseBean.getCap() + " " + this.geoResponseBean.getCity() + " " + this.geoResponseBean.getCountry();
        post.getGeneralPostInfo().setFullAddress(fullAddress);
        post.getGeneralPostInfo().setLatitude(this.geoResponseBean.getLatitude());
        post.getGeneralPostInfo().setLongitude(this.geoResponseBean.getLongitude());
        this.storePost();
    }

    public void storePost() throws SQLException, FileNotFoundException, ConnectionDBException {
        try{//In persistence
        PostFactoryDAO postInfoFactoryDAO = new PostFactoryDAO();
        PostDAO postDAO = postInfoFactoryDAO.createDAO(this.post.getPcType());
        postDAO.storePost(post);}
        catch (FactoryException ex){//Abnormal error in Factory
            System.err.println("ex.getMessage()");
            Home.quit();
        }}
}