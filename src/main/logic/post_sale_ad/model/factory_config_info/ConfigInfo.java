package post_sale_ad.model.factory_config_info;

import post_sale_ad.bean.PCInfoBean;

public interface ConfigInfo {
    public void setInfo(PCInfoBean bean);
    public GeneralPostInfo getGeneralPostInfo();

}