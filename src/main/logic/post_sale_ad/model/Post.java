package post_sale_ad.model;

import post_sale_ad.model.factory_config_info.PcInfo;

public class Post {
    private int post_id;

    private GeneralPostInfo generalPostInfo;

    private PcInfo pcInfo;

    public GeneralPostInfo getGeneralPostInfo() {
        return generalPostInfo;
    }

    public void setGeneralPostInfo(GeneralPostInfo generalPostInfo) {
        this.generalPostInfo = generalPostInfo;
    }

    public PcInfo getPcInfo() {
        return pcInfo;
    }

    public void setPcInfo(PcInfo pcInfo) {
        this.pcInfo = pcInfo;
    }

    public int getPost_id() {
        return post_id;
    }
    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }
}
