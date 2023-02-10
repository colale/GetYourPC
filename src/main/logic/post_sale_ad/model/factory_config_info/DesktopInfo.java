package post_sale_ad.model.factory_config_info;
import post_sale_ad.bean.DesktopInfoBean;
import post_sale_ad.bean.PcInfoBean;

public class DesktopInfo implements PcInfo {
   private String cpu;
   private String motherboard;
   private String gpu;
   private String ram;
   private String memory;
   private String power;
   private String heatSink;
   private String pcCase;
   private String pcType;

   @Override
   public void setInfo(PcInfoBean bean){
      DesktopInfoBean inputBean=(DesktopInfoBean) bean;
      setCpu(inputBean.getCpu());
      setGpu(gpu=inputBean.getGpu());
      setRam(inputBean.getRam());
      setMotherboard(inputBean.getMotherboard());
      setMemory(inputBean.getMemory());
      setPower(inputBean.getPower());
      setHeatSink(heatSink=inputBean.getHeatSink());
      setPcCase(inputBean.getPcCase());
   }

   @Override
   public String getPcType(){
      return this.pcType;}
   public DesktopInfo(String type){
      this.pcType=type;
   }

   public String getCpu() {
      return cpu;
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

   public void setCpu(String cpu) {
      this.cpu = cpu;
   }

}
