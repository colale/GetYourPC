package post_sale_ad.model.factory_config_info;

import post_sale_ad.bean.PCInfoBean;

public interface ConfigInfo {
    default void setInfo(PCInfoBean bean) {
    }
}