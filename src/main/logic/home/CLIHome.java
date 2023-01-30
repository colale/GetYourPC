package home;
import login.app_controller.LoginController;
import login.view.CLILogin;
import login.view.CLILogout;

import java.util.Scanner;

public class CLIHome {
    public void execute() {
        System.out.println("Welcome to Get Your PC!\n1)Search PC\n2)Post sale ad\n3)Personal area\n4)Reviewer area\n5)Login/Logout\n6)Help\n7)Quit");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Insert number:");
            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("It's a string. Retry");
                continue;}
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    System.out.println("xxx");//implementa search pc
                    break;
                case 2:
                    System.out.println("yyy"); //implementa post sale ad
                    break;
                case 3, 4:
                    System.out.println("This option is not available now");
                    break;
                case 5:
                    LoginController c = new LoginController();
                    if (c.checkIsAuthenticated())
                    {(new CLILogout()).execute();}
                        else {(new CLILogin()).execute();}
                    break;
                case 6:
                    System.out.println("For information, read the project documentation");
                    break;
                case 7:
                    Home.quit();
                    break;
                default:
                    System.out.println("Invalid number.Retry");
                    scanner.nextLine();
            }
        }
    }}