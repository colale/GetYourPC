package post_sale_ad.app_controller;

import exception.FactoryException;
import home.Home;
import login.app_controller.LoginController;
import post_sale_ad.bean.PCInfoBean;
import post_sale_ad.model.GeneralPostInfo;
import post_sale_ad.model.factory_config_dao.PostInfoFactoryDAO;
import post_sale_ad.model.factory_config_info.ConfigInfo;
import post_sale_ad.model.factory_config_info.PostInfoFactory;

import static java.lang.Boolean.TRUE;

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
        GeneralPostInfo generalPostInfo = new GeneralPostInfo();
        try {
            configInfo = this.postInfoFactory.create(PCInfoBean);
        } catch (FactoryException ex) {
            System.err.println(ex.getMessage());
            Home.quit();
        }
    }

    public boolean checkPcValues(PCInfoBean bean) {



        return TRUE;
    }

}
