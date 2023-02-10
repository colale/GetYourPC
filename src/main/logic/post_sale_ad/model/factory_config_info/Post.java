package post_sale_ad.model.factory_config_info;

import post_sale_ad.bean.PcInfoBean;

public interface Post {
    public void setInfo(PcInfoBean bean);
    public GeneralPostInfo getGeneralPostInfo();
    String getPcType();
}