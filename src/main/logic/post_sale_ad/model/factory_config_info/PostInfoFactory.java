package post_sale_ad.model.factory_config_info;

import exception.FactoryException;
import post_sale_ad.bean.PCInfoBean;

public class PostInfoFactory {
    public ConfigInfo create (PCInfoBean choice) throws FactoryException {
        GeneralPostInfo generalPostInfo = new GeneralPostInfo();
        switch (choice.getChoice()){
            case "desktop": return new DesktopInfo(generalPostInfo);
            case "laptop": return new LaptopInfo(generalPostInfo);
            default:throw new FactoryException("The creation of the chosen configuration could not be completed");
        }
    }
}
