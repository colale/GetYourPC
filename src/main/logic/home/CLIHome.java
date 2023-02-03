package home;
import find_pc.view.CLIRequireConfig;
import login.app_controller.LoginController;
import login.view.CLILogin;
import login.view.CLILogout;
import post_sale_ad.view.CLISelectConfig;
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
                    (new CLIRequireConfig()).execute();
                    break;

                case 2:
                    validInput=TRUE;
                    (new CLISelectConfig()).execute();
                    break;

                case 3, 4:
                    validInput=TRUE;
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
                    validInput=true;
                    System.out.println("For information, read the project documentation");
                    break;

                case 7:
                    validInput=true;
                    Home.quit();
                    break;

                default:
                    System.out.println("Invalid number.Retry");
                    scanner.nextLine();
            }
        }
    }}