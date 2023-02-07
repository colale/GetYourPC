package post_sale_ad.model.factory_config_info;

import post_sale_ad.bean.LaptopInfoBean;
import post_sale_ad.bean.PCInfoBean;

public class LaptopInfo implements ConfigInfo{
    public GeneralPostInfo getGeneralPostInfo() {
        return generalPostInfo;
    }

    private GeneralPostInfo generalPostInfo;
    private String brand;
    private String model;
    private String screenSize;
    private String cpu;
    private String gpu;
    private String ram;
    private String memory;
    @Override
    public void setInfo(PCInfoBean bean) {
        LaptopInfoBean inputBean=(LaptopInfoBean)bean;
        this.brand=inputBean.getBrand();
        this.cpu=inputBean.getCpu();
        this.model=inputBean.getModel();
        this.screenSize=inputBean.getScreenSize();
        this.gpu=inputBean.getGpu();
        this.ram=inputBean.getRam();
        this.memory=inputBean.getMemory();
    }
    public LaptopInfo (GeneralPostInfo generalPostInfo){
        this.generalPostInfo=generalPostInfo;
    }
}
