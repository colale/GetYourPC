package find_pc.view.cli;

import exception.GeocodingException;
import exception.SyntaxBeanException;
import find_pc.app_controller.FindPCController;
import find_pc.bean.UserDistanceBean;
import find_pc.bean.UserGeoRequestBean;
import find_pc.bean.UserGeoResponseBean;
import java.util.Scanner;

public class CLIRequirePosition {
    FindPCController controller;
    UserGeoRequestBean userGeoRequestBean;
    UserGeoResponseBean userGeoResponseBean;
    UserDistanceBean userDistanceBean;

    public CLIRequirePosition(FindPCController controller) {
        this.controller = controller;
    }
    public void execute(){
        this.userGeoRequestBean = new UserGeoRequestBean();
        this.userDistanceBean = new UserDistanceBean();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Insert Country:");
            userGeoRequestBean.setCountry(scanner.nextLine());
            System.out.println("Insert City:");
            userGeoRequestBean.setCity(scanner.nextLine());
            System.out.println("Insert distance in km:");
            userDistanceBean.setDistance(scanner.nextLine());
            UserGeoResponseBean response = controller.searchPosition(userGeoRequestBean);
            this.userGeoResponseBean = response;
            System.out.println("Position: " + response.getFullAddress());
            if (confirmRequest()) {
                controller.setPosition(userDistanceBean);
                (new CLIResultList(this.controller,controller.searchResults())).execute();}
            else {
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
        return(scanner.nextLine().equals("y"));
    }
}