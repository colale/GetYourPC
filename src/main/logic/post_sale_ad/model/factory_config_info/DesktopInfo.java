package post_sale_ad.model.factory_config_info;

import post_sale_ad.bean.DesktopInfoBean;
import post_sale_ad.bean.PCInfoBean;

public class DesktopInfo implements ConfigInfo{
   private GeneralPostInfo generalPostInfo;
   public GeneralPostInfo getGeneralPostInfo() {
      return generalPostInfo;
   }

   private String cpu;
   private String motherboard;
   private String gpu;
   private String ram;
   private String memory;
   private String power;
   private String heatSink;
   private String pcCase;
   @Override
   public void setInfo(PCInfoBean bean){
      DesktopInfoBean inputBean=(DesktopInfoBean) bean;
      this.cpu=inputBean.getCpu();
      this.gpu=inputBean.getGpu();
      this.ram=inputBean.getRam();
      this.motherboard=inputBean.getMotherboard();
      this.memory=inputBean.getMemory();
      this.power=inputBean.getPower();
      this.heatSink=inputBean.getHeatSink();
      this.pcCase=inputBean.getPcCase();
   }
   public DesktopInfo(GeneralPostInfo generalPostInfo){
      this.generalPostInfo=generalPostInfo;
   }
}
