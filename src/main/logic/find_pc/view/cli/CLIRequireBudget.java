package find_pc.view.cli;

import find_pc.app_controller.FindPCController;
import find_pc.bean.UserBudgetBean;
import home.CLIHome;
import home.Home;
import java.util.Scanner;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class CLIRequireBudget{
    public CLIRequireBudget(FindPCController controller){
        this.controller=controller;
    }
    FindPCController controller;
    public void execute() {
        System.out.println("Select budget range:\n1)0-400€\n2)400-600€\n3)600-1000€\n4)>10000-400€\n5)Home\n6)Help\n7)Quit");
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
                case 1, 2,3,4://Warning: modify implementation if configuration added, budget is coded in numbers
                    validInput = TRUE;
                    UserBudgetBean bean = new UserBudgetBean();
                    bean.setRange(num);
                    this.controller.setBudget(bean);
                    (new CLIRequirePosition(this.controller)).execute();
                    break;

                case 5://user requires Home
                    validInput = TRUE;
                    new CLIHome().execute();
                    break;

                case 6://user requires help
                    validInput=FALSE;
                    System.out.println("For information, read the project documentation");
                    break;

                case 7:
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
