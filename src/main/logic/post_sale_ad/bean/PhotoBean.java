package post_sale_ad.bean;

import java.io.Serializable;

public class PhotoBean implements Serializable {

String imgPath1;
String imgPath2;
String getImgPath3;

    public String getImgPath1() {
        return imgPath1;
    }

    public void setImgPath1(String imgPath1) {
        this.imgPath1 = imgPath1;
    }

    public String getImgPath2() {
        return imgPath2;
    }

    public void setImgPath2(String imgPath2) {
        this.imgPath2 = imgPath2;
    }

    public String getGetImgPath3() {
        return getImgPath3;
    }

    public void setGetImgPath3(String getImgPath3) {
        this.getImgPath3 = getImgPath3;
    }
}
