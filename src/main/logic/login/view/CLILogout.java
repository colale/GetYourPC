package login.view;

import home.CLIHome;
import login.app_controller.LoginController;
import login.bean.UserDataBean;
import exception.SyntaxBeanException;
import java.util.Scanner;

public class CLILogout {
    private String name;
    private String surname;
    private String email;

    LoginController c = new LoginController();

    public void execute() throws SyntaxBeanException {
        this.init();
        System.out.println("Name:" + this.name + "Surname:" + this.surname + "Email:" + this.email + "\n\n1)Logout\n2)Home");
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
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
                    validInput = true;
                    c.logout();
                    System.out.println("Logout completed\n");
                    new CLIHome().execute();
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

    void init() throws SyntaxBeanException {
        UserDataBean bean = c.getUser();
        this.name=bean.getName();
        this.surname=bean.getSurname();
        this.email=bean.getEmail();
    }

}