package home;
import login.app_controller.LoginController;
import login.view.CLILogin;
import login.view.CLILogout;

import java.util.Scanner;

public class CLIHome {
    public void execute(){
        System.out.println("Welcome to Get Your PC!\n1)Search PC\n2)Post sale ad\n3)Personal area\n4)Reviewer area\n5)Login\n6)Help\n7)Quit");
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        while(!validInput){
            System.out.println("Insert number:");
            if(!scanner.hasNextInt()){
                System.out.println("It's a string. Retry");
                scanner.nextLine();
                continue;}
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    validInput = true;
                    System.out.println("xxx");//implementa search pc
                    break;
                case 2:
                    validInput = true;
                    System.out.println("xxx"); //implementa post sale ad
                    break;
                case 3, 4:
                    validInput = false;
                    System.out.println("This option is not available now");
                    break;
                case 5:
                    validInput = true;
                    LoginController c = new LoginController();
                    if (c.checkAuthentication()) {
                        (new CLILogout()).execute();}
                    else {(new CLILogin()).execute();}
                case 6:
                    validInput = false;
                    System.out.println("For information, read the project documentation");
                    break;
                case 7:
                    validInput = false;
                    Main.quit();
                    break;
                default:
                    System.out.println("Invalid number.Retry");
                    scanner.nextLine();
            }
        }
        scanner.close();
    }
}
