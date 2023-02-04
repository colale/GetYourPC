package post_sale_ad.model.factory_config_info;

import post_sale_ad.bean.DesktopInfoBean;
import post_sale_ad.bean.PCInfoBean;

public class DesktopInfo implements ConfigInfo{
   String cpu;
   String motherboard;
   String gpu;
   String ram;
   String memory;
   String power;
   String heatSink;
   String pcCase;
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
}
