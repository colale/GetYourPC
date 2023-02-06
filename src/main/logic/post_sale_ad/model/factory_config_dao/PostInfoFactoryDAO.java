package post_sale_ad.model.factory_config_dao;

import exception.FactoryException;
import post_sale_ad.bean.PCInfoBean;

public class PostInfoFactoryDAO {
    public ConfigInfoDAO createDAO (PCInfoBean choice) throws FactoryException {
        switch (choice.getChoice()){
            case "desktop": return new DesktopInfoDAO();
            case "laptop": return new LaptopInfoDAO();
            default:throw new FactoryException("The creation of the chosen configuration could not be completed");
        }
    }
}
