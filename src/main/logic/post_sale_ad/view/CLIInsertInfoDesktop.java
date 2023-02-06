package post_sale_ad.view;

import exception.SyntaxBeanException;
import post_sale_ad.app_controller.PostSaleAdController;
import post_sale_ad.bean.DesktopInfoBean;
import post_sale_ad.bean.PriceBean;
import post_sale_ad.graphic_controller.SelectConfigGrController;

import java.util.Scanner;

public class CLIInsertInfoDesktop {
    PostSaleAdController controller;
public CLIInsertInfoDesktop(PostSaleAdController controller){
    this.controller=controller;
}
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        DesktopInfoBean bean = new DesktopInfoBean();
        PriceBean priceBean = new PriceBean();
        try {
            System.out.println("Insert CPU");
            bean.setCpu(scanner.nextLine());
            System.out.println("Insert motherboard");
            bean.setMotherboard(scanner.nextLine());
            System.out.println("Insert GPU");
            bean.setGpu(scanner.nextLine());
            System.out.println("Insert RAM");
            bean.setRam(scanner.nextLine());
            System.out.println("Insert SSD/HDD");
            bean.setMemory(scanner.nextLine());
            System.out.println("Insert Power supply");
            bean.setPower(scanner.nextLine());
            System.out.println("Insert CPU heat sink and fans");
            bean.setHeatSink(scanner.nextLine());
            System.out.println("Insert case");
            bean.setPcCase(scanner.nextLine());
            System.out.println("Insert price in euros");
            priceBean.setPrice(scanner.nextLine());
            priceInsertion(scanner, priceBean);
        } catch (SyntaxBeanException ex) {
            System.out.println("Error filling in the fields, please try again");
            scanner.nextLine();
            this.execute();
        }
        controller.setConfigInfo(bean);
        (new CLIInsertPhotos(controller)).execute();
    }


    public void priceInsertion(Scanner scanner, PriceBean priceBean) {
        while (!controller.checkPrice(priceBean)) {
            System.out.println("Error filling in the field 'price', please insert price again");
            try {
                scanner.nextLine();
                priceBean.setPrice(scanner.nextLine());
            } catch (SyntaxBeanException ex) {
                System.out.println("try again");
                this.priceInsertion(scanner, priceBean);
            }
        }
        controller.setPrice(priceBean);
    }
}