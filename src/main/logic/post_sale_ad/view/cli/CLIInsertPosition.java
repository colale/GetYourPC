package post_sale_ad.view.cli;

import exception.SyntaxBeanException;
import post_sale_ad.app_controller.PostSaleAdController;
import post_sale_ad.bean.PhotoBean;
import post_sale_ad.bean.UserGeoRequestBean;
import post_sale_ad.bean.UserGeoResponseBean;

import java.util.Scanner;

public class CLIInsertPosition {
    PostSaleAdController controller;
    UserGeoRequestBean userGeoRequestBean;

    public CLIInsertPosition(PostSaleAdController controller) {
        this.controller = controller;
    }

    public void execute() {
        try {
            this.userGeoRequestBean = new UserGeoRequestBean();
            userGeoRequestBean.setCountry("");
            userGeoRequestBean.setCity("");
            userGeoRequestBean.setAddress("");
            System.out.println("Insert Country:");
            Scanner scanner = new Scanner(System.in);
            userGeoRequestBean.setCountry(scanner.nextLine());
            System.out.println("Insert City:");
            userGeoRequestBean.setCity(scanner.nextLine());
            System.out.println("Insert address:");
            userGeoRequestBean.setAddress(scanner.nextLine());
        } catch (SyntaxBeanException ex) {
            System.out.println("Error, please try again");
            this.execute();
        }

    }
}


