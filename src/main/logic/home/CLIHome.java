package home;

import find_pc.app_controller.FindPCController;
import find_pc.view.cli.CLIRequireConfig;
import login.app_controller.LoginController;
import login.view.cli.CLILogin;
import login.view.cli.CLILogout;
import post_sale_ad.app_controller.PostSaleAdController;
import post_sale_ad.view.cli.CLISelectConfig;
import java.util.Scanner;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class CLIHome {
    public void execute() {
        System.out.println("Welcome to Get Your PC!\n1)Search PC\n2)Post sale ad\n3)Personal area\n4)Reviewer area\n5)Login/Logout\n6)Help\n7)Quit");
        Scanner scanner = new Scanner(System.in);
        boolean validInput=FALSE;
        while (!validInput) {
            System.out.println("Insert number:");
            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("It's a string. Retry");
                continue;}
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    validInput=TRUE;
                    FindPCController findPCController = new FindPCController();
                        (new CLIRequireConfig(findPCController)).execute();
                    break;
                case 2:
                    validInput=TRUE;
                    PostSaleAdController postSaleAdController = new PostSaleAdController();
                    if(!postSaleAdController.checkAuthentication()) {
                        validInput=FALSE;
                        (new CLILogin()).execute();
                        break;}
                    (new CLISelectConfig(postSaleAdController)).execute();
                    break;

                case 3, 4:
                    validInput=FALSE;
                    System.out.println("This option is not available now");
                    break;

                case 5:
                    validInput=TRUE;
                    LoginController c = new LoginController();
                    if (c.checkIsAuthenticated())
                    {(new CLILogout()).execute();}
                        else {(new CLILogin()).execute();}
                    break;

                case 6:
                    validInput=FALSE;
                    System.out.println("For information, read the project documentation");
                    break;

                case 7:
                    validInput=TRUE;
                    Home.quit();
                    break;

                default:
                    System.out.println("Invalid number.Retry");
                    scanner.nextLine();
            }
        }
    }}