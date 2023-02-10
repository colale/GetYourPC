package find_pc.view.cli;

import find_pc.app_controller.FindPCController;
import find_pc.model.Result;
import find_pc.model.ResultDesktop;
import find_pc.model.ResultLaptop;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CLIResultList {
    public CLIResultList(FindPCController controller, List<Result> results) {
        this.controller = controller;
        this.results = results;
    }
    FindPCController controller;
    List<Result> results;

    public void execute() {
        int i = 1;
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
                    sellerName = ((ResultDesktop) result).getSellerName();
                    sellerSurname = ((ResultDesktop) result).getSellerSurname();
                    cpu = ((ResultDesktop) result).getCpu();
                    gpu = ((ResultDesktop) result).getGpu();
                    ram = ((ResultDesktop) result).getRam();
                    double tempPrice = ((ResultDesktop) result).getPrice();
                    price = Double.toString(tempPrice);
                    System.out.println("Number: " + i + "\nName: " + sellerName + "\nSurname: " + sellerSurname + "\nCPU: " + cpu + "\nGPU " + gpu + "\nRAM " + ram + "\nPrice: " + price+"€"+"\n");
                    i=i+1;
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
                    sellerName = ((ResultLaptop) result).getSellerName();
                    sellerSurname = ((ResultLaptop) result).getSellerSurname();
                    cpu = ((ResultLaptop) result).getCpu();
                    brand = ((ResultLaptop) result).getBrand();
                    model = ((ResultLaptop) result).getModel();
                    double tempPrice = ((ResultLaptop) result).getPrice();
                    price = Double.toString(tempPrice);
                    System.out.println("Number: " + i + "\nName: " + sellerName + "\nSurname: " + sellerSurname + "\nBrand: " + brand + "\nModel: " + model + "\nCPU: " + cpu + "\nPrice: " + price);
                    i=i+1;
                }
            }
            System.out.println("Insert number");
            Scanner scanner = new Scanner(System.in);
            i = scanner.nextInt();
            (new CLIPostView(this.controller, this.results, i)).execute();

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("There are no results");
            (new CLIRequireConfig(this.controller)).execute();
        } catch (InputMismatchException inputEx) {System.out.println("Invalid input");
            this.execute();
        }
    }
}