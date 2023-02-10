package post_sale_ad.model;

import post_sale_ad.model.factory_config_info.PcInfo;

public class Post {
    private int postId;

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

    public int getPostId() {
        return postId;
    }
    public void setPostId(int postId) {
        this.postId = postId;
    }
}
