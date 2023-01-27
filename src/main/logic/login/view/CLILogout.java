package login.view;

import home.CLIHome;
import login.app_controller.LoginController;

import java.util.Scanner;

public class CLILogout {
    LoginController c = new LoginController();
    public void execute(){
        System.out.println("You are logged in as ... \n1)Logout\n2)Home");//implementa dati input
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
                    c.logout();
                    System.out.println("Logout completed\n");
                    new CLIHome().execute();
                case 2:
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid number.Retry");
                    scanner.nextLine();
            }
        }
        scanner.close();
    }
}
