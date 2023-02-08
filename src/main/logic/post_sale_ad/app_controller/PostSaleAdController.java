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
import post_sale_ad.model.factory_config_dao.ConfigInfoDAO;
import post_sale_ad.model.factory_config_dao.PostInfoDAOFactory;
import post_sale_ad.model.factory_config_info.ConfigInfo;
import post_sale_ad.model.factory_config_info.PostInfoFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostSaleAdController {
    ConfigInfo configInfo;
    ConfigInfoDAO configInfoDAO;
    GeoResponseBean geoResponseBean;
    LoginController loginController;

    public boolean checkAuthentication() {
        this.loginController=new LoginController();
        return (this.loginController.checkIsAuthenticated());
    }

    public void createPost(PCInfoBean pcInfoBean) {
        PostInfoDAOFactory postInfoFactoryDAO = new PostInfoDAOFactory();
        PostInfoFactory postInfoFactory = new PostInfoFactory();
        try {
            this.configInfo = postInfoFactory.create(pcInfoBean);
            this.configInfoDAO = postInfoFactoryDAO.createDAO(pcInfoBean);
            this.setSellerId();
        } catch (FactoryException ex) {
            System.err.println(ex.getMessage());
            Home.quit();
        }
    }
public void setSellerId(){
        int id =this.loginController.getUserId();
        configInfo.getGeneralPostInfo().setSellerId(id);
}

    public boolean checkPrice(PriceBean bean) {
        try {
            String price = bean.getPrice();
            double parsedPrice = Double.parseDouble(price);
            return parsedPrice > 0 && parsedPrice < 1000000;
        } catch (NumberFormatException e) {
            return false;
        }
        catch (NullPointerException ex){return false;}
    }

    public void setPrice(PriceBean bean) {
        int price = Integer.parseInt(bean.getPrice());
        configInfo.getGeneralPostInfo().setPrice(price);
    }

    public void setConfigInfo(PCInfoBean bean) {
        this.configInfo.setInfo(bean);
    }

    public boolean checkPhotos(PhotoBean bean) {
        ArrayList<String> imagesPath = new ArrayList<String>();
        imagesPath.add(bean.getImgPath1());
        imagesPath.add(bean.getImgPath2());
        imagesPath.add(bean.getImgPath3());
        for (String s : imagesPath) {
            try {
                // Carica l'immagine dal percorso specificato
                BufferedImage image = ImageIO.read(new File(s));

                // Verifica che l'immagine esista e che la sua dimensione non superi la capacità del long blob
                if (image == null || (long) (image.getHeight() * image.getWidth() * 3) > Integer.MAX_VALUE) {
                    return false;
                }
            } catch (IOException e) {
                return false;
            }

        }
        return true;
    }

    public void setPhotos(PhotoBean bean) {
        configInfo.getGeneralPostInfo().setImg1(bean.getImgPath1());
        configInfo.getGeneralPostInfo().setImg2(bean.getImgPath2());
        configInfo.getGeneralPostInfo().setImg3(bean.getImgPath3());
    }

    public UserGeoResponseBean searchPosition(UserGeoRequestBean userGeoData) throws GeocodingException {
        GeoRequestBean geoRequestBean = new GeoRequestBean();
        String input = userGeoData.getAddress() + " " + userGeoData.getCity() + " " + userGeoData.getCountry();
        geoRequestBean.setGeoRequest(input);
        GeocodingAdapter geocodingAdapter = new GeocodingAdapter(new Geoapify());
        UserGeoResponseBean responseToUser = new UserGeoResponseBean();
        this.geoResponseBean = geocodingAdapter.findResult(geoRequestBean);
        String output = this.geoResponseBean.getStreet() + " " + this.geoResponseBean.getHouseNumber() + " " + this.geoResponseBean.getCap() + " " + this.geoResponseBean.getCity() + " " + this.geoResponseBean.getCountry();
        responseToUser.setFullAddress(output);
        return responseToUser;
    }

    public void publishPost() throws SQLException, FileNotFoundException, ConnectionDBException {
        String fullAddress = this.geoResponseBean.getStreet() + " " + this.geoResponseBean.getHouseNumber() + " " + this.geoResponseBean.getCap() + " " + this.geoResponseBean.getCity() + " " + this.geoResponseBean.getCountry();
        configInfo.getGeneralPostInfo().setFullAddress(fullAddress);
        configInfo.getGeneralPostInfo().setLatitude(this.geoResponseBean.getLatitude());
        configInfo.getGeneralPostInfo().setLongitude(this.geoResponseBean.getLongitude());
        this.storePost();
    }

    public void storePost() throws SQLException, FileNotFoundException, ConnectionDBException {
        configInfoDAO.storePost(configInfo);
    }
}