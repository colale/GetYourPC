package post_sale_ad.view;

import home.CLIHome;
import home.Home;
import post_sale_ad.app_controller.PostSaleAdController;
import post_sale_ad.bean.PCInfoBean;
import post_sale_ad.bean.PositionBean;

import java.util.Scanner;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class CLISelectConfig {
    PostSaleAdController controller;
    public void execute() {
        System.out.println("Select configuration to post\n1)Desktop\n2)Laptop\n3)Home\n4)Quit");
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
                        CLIInsertInfoDesktop cli = new CLIInsertInfoDesktop();
                        cli.setAppController(this.controller);
                        cli.execute();}
                    else{ CLIInsertInfoLaptop cli = new CLIInsertInfoLaptop();
                        cli.setAppController(this.controller);
                        cli.execute();}
                    break;
                case 3:
                    validInput = TRUE;
                    (new CLIHome()).execute();
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
    }
    public void setController(PostSaleAdController controller)
    {this.controller=controller;}
}
