package post_sale_ad.bean;

import java.io.Serializable;

public class DesktopInfoBean extends PCInfoBean implements Serializable {
    String cpu;
    String motherboard;
    String gpu;
    String ram;
    String memory;
    String power;
    String heatSink;
    String pcCase;
    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getHeatSink() {
        return heatSink;
    }

    public void setHeatSink(String heatSink) {
        this.heatSink = heatSink;
    }

    public String getPcCase() {
        return pcCase;
    }

    public void setPcCase(String pcCase) {
        this.pcCase = pcCase;
    }
}
