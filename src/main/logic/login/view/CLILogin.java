package login.view;
import java.util.Scanner;
public class CLILogin {
    public void execute(){
        System.out.println("Login:\n\n1)Login with email and password\n2)Login with Gmail\n3)Sign up\n4)Home");
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
                    System.out.println("xxx");//implementa login
                    break;
                case 2:
                    validInput = true;
                    System.out.println("This option in not available now");
                    break;
                case 3:
                    validInput = false;
                    System.out.println("This option is not available now");
                    break;
                case 4:
                    validInput = true;
                    System.out.println("xxx");//implementa ritorno alla home
                    break;
                default:
                    System.out.println("Invalid number.Retry");
                    scanner.nextLine();
            }
        }
        scanner.close();
    }
}
