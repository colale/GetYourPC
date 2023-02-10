package post_sale_ad.model.factory_config_info;

import exception.FactoryException;
import post_sale_ad.bean.PcInfoBean;

public class PostFactory {
    public Post create (PcInfoBean bean) throws FactoryException {
        switch (bean.getChoice()){
            case "desktop": return new Desktop(bean.getChoice());
            case "laptop": return new Laptop(bean.getChoice());
            default:throw new FactoryException("The creation of the chosen configuration could not be completed");
        }
    }
}
