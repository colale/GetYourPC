package post_sale_ad.model.factory_config_info;

import exception.FactoryException;
import post_sale_ad.bean.ConfigChoiceBean;

public class PostInfoFactory {
    public ConfigInfo create (ConfigChoiceBean choice) throws FactoryException {
        switch (choice.getChoice()){
            case "destkop": return new DesktopInfo();
            case "laptop": return new LaptopInfo();
            default:throw new FactoryException("The creation of the chosen configuration could not be completed");
        }
    }
}
