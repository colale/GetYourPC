package post_sale_ad.view.cli;

import home.CLIHome;
import home.Home;
import post_sale_ad.app_controller.PostSaleAdController;
import post_sale_ad.bean.PCInfoBean;
import java.util.Scanner;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class CLISelectConfig {
    PostSaleAdController controller;

    public CLISelectConfig(PostSaleAdController controller){
        this.controller=controller;
    }

    public void execute() {
        System.out.println("Select configuration to post\n1)Desktop\n2)Laptop\n3)Home\n4)Help\n5)Quit");
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
                    PCInfoBean choiceBean = new PCInfoBean();
                    String tempChoice = (num==1)?"desktop":"laptop";
                    choiceBean.setChoice(tempChoice);
                    this.controller.createPost(choiceBean);
                    if(num==1){
                        CLIInsertInfoDesktop cli = new CLIInsertInfoDesktop(controller);
                        cli.execute();}
                    else{ CLIInsertInfoLaptop cli = new CLIInsertInfoLaptop(controller);
                        cli.execute();}
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
