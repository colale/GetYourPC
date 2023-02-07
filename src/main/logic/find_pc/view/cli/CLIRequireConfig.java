package find_pc.view.cli;

import find_pc.app_controller.FindPCController;
import find_pc.bean.UserChoiceBean;
import home.CLIHome;
import home.Home;
import java.util.Scanner;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class CLIRequireConfig {
    public CLIRequireConfig(FindPCController controller){
        this.controller=controller;
    }
    FindPCController controller;
    public void execute() {
        System.out.println("Select configuration to search\n1)Desktop\n2)Laptop\n3)Home\n4)Help\n5)Quit");
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
                case 1, 2://Warning: modify implementation if configuration added
                    validInput = TRUE;
                    UserChoiceBean bean = new UserChoiceBean();
                    String tempChoice = (num==1)?"desktop":"laptop";
                    bean.setChoice(tempChoice);
                    this.controller.createRequest(bean);
                    (new CLIRequireBudget(this.controller)).execute();
                    break;
                case 3:
                    validInput = TRUE;
                    (new CLIHome()).execute();
                    break;
                case 4:
                    validInput=FALSE;
                    System.out.println("For information, read the project documentation");
                    break;

                case 5:
                    validInput=TRUE;
                    Home.quit();
                    break;
                default:
                    System.out.println("Invalid number.Retry");
                    scanner.nextLine();
            }
        }
    }
}
