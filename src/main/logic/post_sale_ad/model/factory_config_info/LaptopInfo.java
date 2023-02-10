package post_sale_ad.model.factory_config_info;
import post_sale_ad.bean.LaptopInfoBean;
import post_sale_ad.bean.PcInfoBean;

public class LaptopInfo implements PcInfo{
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
        setBrand(inputBean.getBrand());
        setCpu(inputBean.getCpu());
        setModel(inputBean.getModel());
        setScreenSize(Double.parseDouble(inputBean.getScreenSize()));
        setGpu(inputBean.getGpu());
        setRam(inputBean.getRam());
        setMemory(inputBean.getMemory());
    }
    public LaptopInfo(String type){
        this.pcType=type;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setMemory(String memory) {
        this.memory = memory;
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
    }
