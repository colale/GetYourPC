package post_sale_ad.model.factory_config_info;

import post_sale_ad.bean.PcInfoBean;

public interface PcInfo{
    void setInfo(PcInfoBean bean);
    String getPcType();
}