package post_sale_ad.view;

import home.CLIHome;
import javafx.fxml.FXMLLoader;
import post_sale_ad.app_controller.PostSaleAdController;
import post_sale_ad.bean.ConfigChoiceBean;

import java.util.Scanner;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class CLISelectConfig {
    public void execute() {
        System.out.println("Select configuration to post\n1)Desktop\n2)Laptop\n3)Home");
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
                    ConfigChoiceBean choiceBean = new ConfigChoiceBean();
                    String tempChoice = (num==1)?"desktop":"laptop";
                    choiceBean.setChoice(tempChoice);
                    PostSaleAdController appController = new PostSaleAdController();
                    appController.createPost(choiceBean);
                    if(num==1){
                        CLIInsertInfoDesktop cli = new CLIInsertInfoDesktop();
                        cli.setAppController(appController);
                        cli.execute();}
                    else{ CLIInsertInfoLaptop cli = new CLIInsertInfoLaptop();
                        cli.setAppController(appController);
                        cli.execute();}
                    break;
                case 3:
                    validInput = TRUE;
                    (new CLIHome()).execute();
                    break;
                default:
                    System.out.println("Invalid number.Retry");
                    scanner.nextLine();
            }
        }
    }
}
