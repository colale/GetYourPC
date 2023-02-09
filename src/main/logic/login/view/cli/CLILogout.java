package login.view.cli;
import home.CLIHome;
import home.Home;
import login.app_controller.LoginController;
import login.bean.UserDataBean;
import java.util.Scanner;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class CLILogout {
    public void execute() {
        this.initialize();//show user data
        LoginController controller = new LoginController();
        Scanner scanner = new Scanner(System.in);
        boolean validInput = FALSE;
        while (!validInput) {
            System.out.println("Insert number:");
            if (!scanner.hasNextInt()) {
                System.out.println("It's a string. Retry");
                scanner.nextLine();
                continue;
            }
            int num = scanner.nextInt();
            switch (num) {
                case 1://user confirms logout
                    validInput = TRUE;
                    validInput = true;
                    controller.logout();
                    System.out.println("Logout completed\n");
                    new CLIHome().execute();
                    break;
                case 2://user requires Home
                    validInput = TRUE;
                    validInput = true;
                    new CLIHome().execute();
                    break;
                case 3://user requires Help
                    validInput = FALSE;
                    System.out.println("For information, read the project documentation");
                    break;

                case 4://quit
                    validInput = TRUE;
                    Home.quit();
                    break;
                default:
                    System.out.println("Invalid number.Retry");
                    scanner.nextLine();
            }
        }
        scanner.close();
    }

    public void initialize() {
        LoginController controller = new LoginController();
        UserDataBean userDataBean = new UserDataBean();
        userDataBean.setName(controller.getUserDataBean().getName());
        userDataBean.setSurname(controller.getUserDataBean().getSurname());
        userDataBean.setEmail(controller.getUserDataBean().getEmail());
        String name = userDataBean.getName();
        String surname = userDataBean.getSurname();
        String email = userDataBean.getEmail();
        System.out.println("Name: " + name + " Surname: " + surname + " Email: " + email + "\n\n1)Logout\n2)Home\n3)Help\n4)Quit");
    }
}