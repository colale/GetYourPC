package post_sale_ad.model.factory_config_info_dao;

import exception.FactoryException;

public class PostFactoryDAO {
    public PcInfoDAO createDAO (String choice) throws FactoryException {
        switch (choice){
            case "desktop": return new DesktopDAO();
            case "laptop": return new LaptopDAO();
            default:throw new FactoryException("The creation of the chosen configuration could not be completed");
        }
    }
}
