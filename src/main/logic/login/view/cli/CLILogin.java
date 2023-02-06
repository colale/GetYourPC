package login.view.cli;
import home.CLIHome;
import home.Home;
import login.app_controller.LoginController;
import login.bean.CredentialsInput;
import exception.SyntaxBeanException;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class CLILogin {
    String password;
    String email;
    CredentialsInput credentialsInput = new CredentialsInput();
    LoginController c = new LoginController();
    public void execute() {
        System.out.println("Login:\n\n1)Login with email and password\n2)Login with Gmail\n3)Sign up\n4)Home\n5)Help\n6)Quit)");
        Scanner scanner = new Scanner(System.in);
        boolean validInput=FALSE;
        while (!validInput) {
            System.out.println("Insert number:");
            if(!scanner.hasNextInt()){
                System.out.println("It's a string. Retry");
                scanner.nextLine();
                continue;}
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    validInput=TRUE;
                    requireLogin();
                    break;
                case 2:
                    validInput=FALSE;
                    System.out.println("This option in not available now");
                    break;
                case 3:
                    validInput=FALSE;
                    System.out.println("This option is not available now");
                    break;
                case 4:
                    validInput=TRUE;
                    (new CLIHome()).execute();
                    break;
                case 5:
                    validInput=FALSE;
                    System.out.println("For information, read the project documentation");
                    break;

                case 6:
                    validInput=TRUE;
                    Home.quit();
                    break;
                default:
                    System.out.println("Invalid number.Retry");
                    scanner.nextLine();
            }
        }
        scanner.close();
    }

    public void requireLogin(){
        while(true){
            this.requireData();
        boolean passed;
                    try {
        credentialsInput.setEmail(this.email);
        credentialsInput.setPassword(this.password);
        passed = c.authenticate(credentialsInput);
    }
                    catch(SyntaxBeanException e) {passed=false;}
                    catch(IOException ex){passed=false;}
                    if (passed){
        System.out.println("You are logged in now\n");
        (new CLIHome()).execute();}
                    else {
        System.out.println("Login failed, try again");}}}



    public void requireData(){
    System.out.println("Insert Email");
    Scanner scanner = new Scanner(System.in);
    String input=scanner.nextLine();
    this.email=input;
    System.out.println("Insert Password");
    input=scanner.nextLine();
    this.password=input;}
}

