package post_sale_ad.view.cli;

import exception.SyntaxBeanException;
import post_sale_ad.app_controller.PostSaleAdController;
import post_sale_ad.bean.LaptopInfoBean;
import post_sale_ad.bean.PriceBean;

import java.util.Scanner;

public class CLIInsertInfoLaptop {
    PostSaleAdController controller;
    public CLIInsertInfoLaptop(PostSaleAdController controller){
        this.controller=controller;
    }
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        LaptopInfoBean bean = new LaptopInfoBean();
        PriceBean priceBean = new PriceBean();
        try {
            System.out.println("Insert brand");
            bean.setBrand(scanner.nextLine());
            System.out.println("Insert model");
            bean.setModel(scanner.nextLine());
            System.out.println("Insert screen size");
            bean.setScreenSize(Double.parseDouble(scanner.nextLine()));
            System.out.println("Insert CPU");
            bean.setCpu(scanner.nextLine());
            System.out.println("Insert GPU");
            bean.setGpu(scanner.nextLine());
            System.out.println("Insert RAM");
            bean.setRam(scanner.nextLine());
            System.out.println("Insert HDD/SSD");
            bean.setMemory(scanner.nextLine());
            System.out.println("Insert price in euros");
            priceBean.setPrice(scanner.nextLine());
            priceInsertion(scanner, priceBean);
        } catch (SyntaxBeanException ex) {
            System.out.println("Error filling in the fields, please try again");
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