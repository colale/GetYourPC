package post_sale_ad.view.cli;

import post_sale_ad.app_controller.PostSaleAdController;
import post_sale_ad.bean.PhotoBean;

import java.util.Scanner;

public class CLIInsertPhotos {
    PostSaleAdController controller;
    PhotoBean bean;
    public CLIInsertPhotos(PostSaleAdController controller){
        this.controller=controller;
    }

    public void execute() {
        this.bean = new PhotoBean();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the full path of the first photo of the ad");
        bean.setImgPath1(scanner.nextLine());
        System.out.println("Insert the full path of the second photo of the ad");
        bean.setImgPath2(scanner.nextLine());
        System.out.println("Insert the full path of the third photo of the ad");
        bean.setImgPath3(scanner.nextLine());
        if (controller.checkPhotos(bean)) {
                controller.setPhotos(bean);
                (new CLIInsertPosition(controller)).execute();}
            else {System.out.println("Error, please try again");
                this.again();}
        }

            public void again() {
                bean.setImgPath1("");
                bean.setImgPath2("");
                bean.setImgPath3("");
                this.execute();
            }
        }


