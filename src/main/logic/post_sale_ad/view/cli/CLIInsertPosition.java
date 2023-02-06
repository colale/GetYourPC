package post_sale_ad.view.cli;

import exception.GeocodingException;
import exception.SyntaxBeanException;
import post_sale_ad.app_controller.PostSaleAdController;
import post_sale_ad.bean.UserGeoRequestBean;
import post_sale_ad.bean.UserGeoResponseBean;

import java.util.Scanner;

public class CLIInsertPosition {
    PostSaleAdController controller;
    UserGeoRequestBean userGeoRequestBean;
    UserGeoResponseBean userGeoResponseBean;

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
            UserGeoResponseBean response = controller.searchPosition(userGeoRequestBean);
            this.userGeoResponseBean = response;
            System.out.println("Position: " + response.getFullAddress());
            if (confirmRequest()) {
                controller.publishPost();
                System.out.println("Your post has been published! Back to home");
            } else {
                this.execute();
            }
        } catch (SyntaxBeanException syntaxException) {
            System.out.println("Invalid data, try again");
            this.execute();
        } catch (GeocodingException geoEx) {
            System.out.println("Position not found, try again");
            this.execute();
        }
    }


    public boolean confirmRequest() {
        System.out.println("Is it correct? Enter 'y' for yes, or any other key for no:");
        Scanner scanner = new Scanner(System.in);
        if(scanner.nextLine().equals("y")){return true;}
        else{return false;}
    }
}