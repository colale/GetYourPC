package post_sale_ad.model.factory_config_info;

import exception.FactoryException;
import post_sale_ad.bean.PcInfoBean;

public class PcInfoFactory {
    public PcInfo create (PcInfoBean bean) throws FactoryException {
        switch (bean.getChoice()){
            case "desktop": return new DesktopInfo(bean.getChoice());
            case "laptop": return new LaptopInfo(bean.getChoice());
            default:throw new FactoryException("The creation of the chosen configuration could not be completed");
        }
    }
}
