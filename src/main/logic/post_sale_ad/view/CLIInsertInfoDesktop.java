package post_sale_ad.view;

import post_sale_ad.app_controller.PostSaleAdController;

public class CLIInsertInfoDesktop {
    PostSaleAdController controller;
    public void setAppController(PostSaleAdController controller){
        this.controller=controller;
    }
    public void execute(){
        System.out.println("Insert CPU");
    }

}