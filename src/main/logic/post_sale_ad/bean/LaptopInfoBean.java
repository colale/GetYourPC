package post_sale_ad.bean;

import exception.SyntaxBeanException;
import java.io.Serializable;

public class LaptopInfoBean extends PcInfoBean implements Serializable {
    private String brand;
    private String model;
    private String screenSize;
    private String cpu;
    private String gpu;
    private String ram;
    private String memory;
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) throws SyntaxBeanException {
        syntaxCheck(brand);
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) throws SyntaxBeanException{
        syntaxCheck(model);
        this.model = model;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) throws SyntaxBeanException {
        syntaxDisplayCheck(screenSize);
        this.screenSize = screenSize;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu)throws SyntaxBeanException {
        syntaxCheck(cpu);
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu)throws SyntaxBeanException {
        syntaxCheck(gpu);
        this.gpu = gpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram)throws SyntaxBeanException {
        syntaxCheck(ram);
        this.ram = ram;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) throws SyntaxBeanException{
        syntaxCheck(memory);
        this.memory = memory;
    }
    private void syntaxCheck(String s) throws SyntaxBeanException {
        if(s.length()==0 || s.length()>50){
            throw new SyntaxBeanException("Syntax error in PC configuration field");
        }
    }
    private void syntaxDisplayCheck(String s) throws SyntaxBeanException {
        try {
            Double num=Double.parseDouble(s);
            if (num>27){throw new SyntaxBeanException("Syntax error in ScreenSize, number too big");}
        } catch (NumberFormatException e) {
            throw new SyntaxBeanException("Syntax error in ScreenSize");
        }
        }
}
