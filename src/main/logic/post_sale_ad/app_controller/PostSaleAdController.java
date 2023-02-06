package post_sale_ad.app_controller;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import exception.FactoryException;
import home.Home;
import login.app_controller.LoginController;
import post_sale_ad.bean.PCInfoBean;
import post_sale_ad.bean.PhotoBean;
import post_sale_ad.bean.PriceBean;
import post_sale_ad.model.GeneralPostInfo;
import post_sale_ad.model.factory_config_dao.PostInfoFactoryDAO;
import post_sale_ad.model.factory_config_info.ConfigInfo;
import post_sale_ad.model.factory_config_info.PostInfoFactory;

import java.util.ArrayList;

public class PostSaleAdController {
    GeneralPostInfo generalPostInfo;//è una classe mode che contiene le informazioni generali del post
    ConfigInfo configInfo; //è una classe mode che contiene le informazioni specifiche del computer
    PostInfoFactory postInfoFactory;
    PostInfoFactoryDAO postInfoFactoryDAO;

    public PostSaleAdController() {//il costruttore istanzia le factory e inizializza il suo stato
        this.postInfoFactory = new PostInfoFactory();
        this.postInfoFactoryDAO = new PostInfoFactoryDAO();
    }

    public boolean checkAuthentication() {
        return (new LoginController()).checkIsAuthenticated();
    }

    public void createPost(PCInfoBean PCInfoBean) {
        this.generalPostInfo = new GeneralPostInfo();
        try {
            configInfo = this.postInfoFactory.create(PCInfoBean);
        } catch (FactoryException ex) {
            System.err.println(ex.getMessage());
            Home.quit();
        }
    }

    public boolean checkPrice(PriceBean bean) {
        try {
            String price = bean.getPrice();
            double parsedPrice = Double.parseDouble(price);
            return parsedPrice > 0 && parsedPrice < 1000000;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void setPrice(PriceBean bean) {
        int price = Integer.valueOf(bean.getPrice());
        this.generalPostInfo.setPrice(price);

    }

    public void setConfigInfo(PCInfoBean bean) {
        this.configInfo.setInfo(bean);
    }

    public boolean checkPhotos(PhotoBean bean) {
        ArrayList<String> imagesPath=new ArrayList<String>();
        imagesPath.add(bean.getImgPath1());
        imagesPath.add(bean.getImgPath2());
        imagesPath.add(bean.getImgPath3());
        for(String s:imagesPath){
            try {
            // Carica l'immagine dal percorso specificato
                System.out.println(s);
            BufferedImage image = ImageIO.read(new File(s));

            // Verifica che l'immagine esista e che la sua dimensione non superi la capacità del long blob
            if (image == null || (long) (image.getHeight() * image.getWidth() * 3) > Integer.MAX_VALUE) {return false;
            }
        } catch (Exception e) {
                return false;
        }

        }
        return true;
    }

    public void setPhotos(PhotoBean bean) {
        generalPostInfo.setImg1(bean.getImgPath1());
        generalPostInfo.setImg1(bean.getImgPath2());
        generalPostInfo.setImg1(bean.getImgPath3());
    }



}