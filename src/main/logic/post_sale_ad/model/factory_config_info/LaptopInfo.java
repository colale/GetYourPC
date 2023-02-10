package post_sale_ad.model.factory_config_info;

import post_sale_ad.bean.LaptopInfoBean;
import post_sale_ad.bean.PcInfoBean;
import post_sale_ad.model.GeneralPostInfo;

public class LaptopInfo implements PcInfo{
    public GeneralPostInfo getGeneralPostInfo() {
        return generalPostInfo;
    }
    private GeneralPostInfo generalPostInfo;
    private String brand;
    private String pcType;
    private String model;
    private double screenSize;
    private String cpu;
    private String gpu;
    private String ram;
    private String memory;

    @Override
    public void setInfo(PcInfoBean bean) {
        LaptopInfoBean inputBean=(LaptopInfoBean)bean;
        this.brand=inputBean.getBrand();
        this.cpu=inputBean.getCpu();
        this.model=inputBean.getModel();
        this.screenSize= Double.parseDouble(inputBean.getScreenSize());
        this.gpu=inputBean.getGpu();
        this.ram=inputBean.getRam();
        this.memory=inputBean.getMemory();
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public String getCpu() {
        return cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public String getRam() {
        return ram;
    }

    public String getMemory() {
        return memory;
    }
    public String getPcType(){
        return this.pcType;}
    public LaptopInfo(String type){
        this.pcType=type;
        this.generalPostInfo=new GeneralPostInfo();
    }
}
