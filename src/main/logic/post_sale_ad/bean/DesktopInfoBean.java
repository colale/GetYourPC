package post_sale_ad.bean;

import exception.SyntaxBeanException;
import java.io.Serializable;

public class DesktopInfoBean extends PCInfoBean implements Serializable {
    private String cpu;
    private String motherboard;
    private String gpu;
    private String ram;
    private String memory;
   private String power;
    private String heatSink;
    private String pcCase;
    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu)throws SyntaxBeanException {
        syntaxCheck(cpu);
        this.cpu = cpu;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(String motherboard)throws SyntaxBeanException {
        syntaxCheck(motherboard);
        this.motherboard = motherboard;
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

    public void setMemory(String memory)throws SyntaxBeanException {
        syntaxCheck(memory);
        this.memory = memory;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power)throws SyntaxBeanException {
        syntaxCheck(power);
        this.power = power;
    }

    public String getHeatSink() {
        return heatSink;
    }

    public void setHeatSink(String heatSink) throws SyntaxBeanException{
        syntaxCheck(heatSink);
        this.heatSink = heatSink;
    }

    public String getPcCase() {
        return pcCase;
    }

    public void setPcCase(String pcCase)throws SyntaxBeanException {
        syntaxCheck(pcCase);
        this.pcCase = pcCase;
    }

    private void syntaxCheck(String s) throws SyntaxBeanException {
        if((s.length()==0)||(s.length()>50)){
            throw new SyntaxBeanException("Syntax Error in PC configuration field");
        }
}}
