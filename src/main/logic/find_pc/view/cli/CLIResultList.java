package find_pc.view.cli;

import find_pc.app_controller.FindPCController;
import find_pc.model.Result;
import find_pc.model.ResultDesktop;
import find_pc.model.ResultLaptop;
import post_sale_ad.model.factory_config_info.DesktopInfo;

import java.util.ArrayList;

public class CLIResultList {
    public CLIResultList(FindPCController controller, ArrayList<Result> results) {
        this.controller = controller;
        this.results=results;
    }
    FindPCController controller;
    ArrayList<Result> results;
    public void execute() {
        ArrayList<Integer> postNumber = new ArrayList<>();
        int i = 0;
        try {
            if (this.results.get(0) instanceof ResultDesktop) {
                String sellerName;
                String sellerSurname;
                String cpu;
                String gpu;
                String ram;
                String price;
                System.out.println("Desktop results:");
                for (Result result : this.results) {
                    ++i;
                    postNumber.add(i);
                    sellerName = ((ResultDesktop) result).getSellerName();
                    sellerSurname = ((ResultDesktop) result).getSellerSurname();
                    cpu = ((ResultDesktop) result).getCpu();
                    gpu = ((ResultDesktop) result).getGpu();
                    ram = ((ResultDesktop) result).getRam();
                    double tempPrice = ((ResultDesktop) result).getPrice();
                    price = Double.toString(tempPrice);
                    System.out.println("\n" + i + "\n" + sellerName + " " + sellerSurname + " " + cpu + " " + gpu + " " + ram + " " + price);
                    postNumber.add(i);
                    System.out.println();
                }
            } else {
                String sellerName;
                String sellerSurname;
                String brand;
                String model;
                String cpu;
                String price;
                System.out.println("Laptop results:");
                for (Result result : this.results) {
                    ++i;
                    postNumber.add(i);
                    sellerName = ((ResultLaptop) result).getSellerName();
                    sellerSurname = ((ResultLaptop) result).getSellerSurname();
                    cpu = ((ResultLaptop) result).getCpu();
                    brand = ((ResultLaptop) result).getBrand();
                    model = ((ResultLaptop) result).getModel();
                    double tempPrice = ((ResultLaptop) result).getPrice();
                    price = Double.toString(tempPrice);
                    System.out.println("\n" + i + "\n" + sellerName + " " + sellerSurname + " " + brand + " " + model + " " + cpu + " " + price);
                }
            }

            System.out.println("Insert number");

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("There are no results");
            (new CLIRequireConfig(this.controller)).execute();}
    }
}