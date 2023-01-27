package login.view;

import java.util.Scanner;

public class CLILogout {
    public void execute(){
        System.out.println("You are logged in as ... \n 1)Logout\n2)Home");//implementa dati input
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
                    System.out.println("xxx");//implementa logout
                    break;
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
