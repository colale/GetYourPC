package post_sale_ad.view.cli;

import exception.ConnectionDBException;
import exception.GeocodingException;
import exception.SyntaxBeanException;
import home.CLIHome;
import post_sale_ad.app_controller.PostSaleAdController;
import post_sale_ad.bean.UserGeoRequestBean;
import post_sale_ad.bean.UserGeoResponseBean;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class CLIInsertPosition {
    private PostSaleAdController controller;
    private UserGeoRequestBean userGeoRequestBean;
    private UserGeoResponseBean userGeoResponseBean;

    public CLIInsertPosition(PostSaleAdController controller) {
        this.controller = controller;
    }

    public void execute(){
        this.userGeoRequestBean = new UserGeoRequestBean();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Insert Country:");
            userGeoRequestBean.setCountry(scanner.nextLine());
            System.out.println("Insert City:");
            userGeoRequestBean.setCity(scanner.nextLine());
            System.out.println("Insert address:");
            userGeoRequestBean.setAddress(scanner.nextLine());
            UserGeoResponseBean response = controller.searchPosition(userGeoRequestBean);
            this.userGeoResponseBean = response;
            System.out.println("Position: " + response.getFullAddress());
            if (confirmRequest()) {
                controller.setPosition();
                System.out.println("Your post has been published! You will return to Home in 5 seconds...");
                Thread.sleep(5000);
                (new CLIHome()).execute();}
            else {
                this.execute();
            }
        } catch (SyntaxBeanException syntaxException) {
            System.out.println("Invalid data, try again");
            this.execute();
        } catch (GeocodingException geoEx) {
            System.out.println("Position not found, try again");
            this.execute();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
      }catch(IOException ioEx){System.out.println("System error, please try again later");}
        catch (SQLException sqlEx){System.err.println(sqlEx.getMessage());
        this.execute();}
        catch(ConnectionDBException connEx)
        {System.out.println("System error, please try again later");
            this.execute();}
    }

    public boolean confirmRequest() {
        System.out.println("Is it correct? Enter 'y' for yes, or any other key for no:");
        Scanner scanner = new Scanner(System.in);
        return(scanner.nextLine().equals("y"));
    }
}