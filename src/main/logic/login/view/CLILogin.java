package login.view;
import home.CLIHome;
import login.app_controller.LoginController;
import login.bean.UserDataBean;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
public class CLILogin {
    String password;
    String email;
    UserDataBean b = new UserDataBean();
    LoginController c = new LoginController();
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
                    this.requireData();
                    System.out.println(this.email);
                    System.out.println(this.password);
                    b.setEmail(this.email);
                    b.setPassword(this.password);
                    if (c.authenticate(b)){System.out.println("You are logged in now\n");
                    (new CLIHome()).execute();}
                    else {System.out.println("Retry");//SISTEMARE!!!!!!
                    this.requireData();}
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
                    (new CLIHome()).execute();
                default:
                    System.out.println("Invalid number.Retry");
                    scanner.nextLine();
            }
        }
        scanner.close();
    }

public void requireData(){
    System.out.println("Insert Username");
    Scanner scanner = new Scanner(System.in);
    String input=scanner.nextLine();
    this.email=input;
    System.out.println("Insert Password");
    input=scanner.nextLine();
    this.password=input;}
}
