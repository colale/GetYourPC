package login.view.cli;
import home.CLIHome;
import home.Home;
import login.app_controller.LoginController;
import login.bean.UserDataBean;
import java.util.Scanner;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class CLILogout {
    private String name;
    private String surname;
    private String email;

    LoginController c = new LoginController();

    public void execute(){
        this.init();
        System.out.println("Name: " + this.name + " Surname: " + this.surname + " Email: " + this.email + "\n\n1)Logout\n2)Home\n3)Help\n4)Quit");
        Scanner scanner = new Scanner(System.in);
        boolean validInput=FALSE;
        while (!validInput) {
            System.out.println("Insert number:");
            if (!scanner.hasNextInt()) {
                System.out.println("It's a string. Retry");
                scanner.nextLine();
                continue;
            }
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    validInput=TRUE;
                    validInput = true;
                    c.logout();
                    System.out.println("Logout completed\n");
                    new CLIHome().execute();
                    break;
                case 2:
                    validInput=TRUE;
                    validInput = true;
                    new CLIHome().execute();
                    break;
                case 3:
                    validInput=FALSE;
                    System.out.println("For information, read the project documentation");
                    break;

                case 4:
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

    void init(){
        UserDataBean bean = c.getUserDataBean();
        this.name=bean.getName();
        this.surname=bean.getSurname();
        this.email=bean.getEmail();
    }

}