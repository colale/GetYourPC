package find_pc.view.cli;

import find_pc.app_controller.FindPCController;
import find_pc.model.Result;
import find_pc.model.ResultDesktop;
import find_pc.model.ResultLaptop;
import home.CLIHome;
import home.Home;
import java.util.List;
import java.util.Scanner;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class CLIPostView {
    public CLIPostView(FindPCController controller, List<Result> results, int index) {
        this.controller = controller;
        this.results=results;
        this.index=index;
    }
    private FindPCController controller;
    private List<Result> results;
    private int index;
    public void execute() {
        try {
            --this.index;
            Result result =this.results.get(this.index);
            if (this.results.get(index) instanceof ResultDesktop) {
                String sellerName;
                String sellerSurname;
                String email;
                String cpu;
                String gpu;
                String ram;
                String price;
                String memory;
                String pcCase;
                String power;
                String motherboard;
                String heatSink;
                sellerName = ((ResultDesktop) result).getSellerName();
                pcCase=((ResultDesktop) result).getPcCase();
                sellerSurname = ((ResultDesktop) result).getSellerSurname();
                cpu = ((ResultDesktop) result).getCpu();
                gpu = ((ResultDesktop) result).getGpu();
                ram = ((ResultDesktop) result).getRam();
                email = ((ResultDesktop) result).getSellerEmail();
                memory = ((ResultDesktop) result).getMemory();
                double tempPrice = ((ResultDesktop) result).getPrice();
                price = Double.toString(tempPrice);
                motherboard = ((ResultDesktop) result).getMemory();
                heatSink = ((ResultDesktop) result).getHeatSink();
                power = ((ResultDesktop) result).getPower();
                System.out.println("Name: " + sellerName + "\nSurname: " + sellerSurname + "\nEmail: " + email + "\nCPU: " + cpu + "\nMotherboard: "+ motherboard + "\nGPU: " +gpu + "\nRAM: " + ram + "\nSSD/HDD: " +memory + "\nPower: " +power + "\nHeat Sink and Fans: " +heatSink + "\nCase: " +pcCase + "\nPrice:  " +price + "€\n");}

            else{
                String sellerName;
                String sellerSurname;
                String email;
                String cpu;
                String gpu;
                String ram;
                String price;
                String memory;
                String brand;
                String model;
                String screenSize;

                sellerName = ((ResultLaptop) result).getSellerName();
                sellerSurname = ((ResultLaptop) result).getSellerSurname();
                email = ((ResultLaptop) result).getSellerEmail();
                cpu = ((ResultLaptop) result).getCpu();
                gpu = ((ResultLaptop) result).getGpu();
                ram = ((ResultLaptop) result).getRam();
                brand = ((ResultLaptop) result).getBrand();
                model = ((ResultLaptop) result).getModel();
                double tempScreenSize= ((ResultLaptop) result).getScreenSize();
                screenSize=Double.toString(tempScreenSize);
                memory= ((ResultLaptop) result).getMemory();
                double tempPrice = ((ResultLaptop) result).getPrice();
                price = Double.toString(tempPrice);
                System.out.println("\nName: " + sellerName + "\nSurname: " + sellerSurname + "\nEmail: " + email + "\nBrand: " + brand + "\nModel: "+ model + "\nScreen Size: " + screenSize + "\nCPU: " + cpu + "\nGPU: " + gpu + "\nRAM: " + ram + "\nSSD/HDD: " + memory + "\nPrice: " +price + "€");}

            requireAction();

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Number not valid, please retry");
            (new CLIResultList(this.controller,this.results)).execute();}
    }

public void requireAction(){
    System.out.println("1)Home\n2)Report as inappropriate\n3)Back\n4)Help\n5)Quit");
    Scanner scanner = new Scanner(System.in);
    boolean validInput=FALSE;
    while (!validInput) {
        System.out.println("Insert number:");
        if (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("It's a string. Retry");
            continue;}
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                validInput=TRUE;
                (new CLIHome()).execute();
                break;
            case 2:
                validInput=FALSE;
                System.out.println("This option is not available now");
                    break;

            case 3:
                validInput=TRUE;
                (new CLIResultList(this.controller,this.results )).execute();
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
                System.out.println("Invalid number.Retry\n");
                scanner.nextLine();
        }
    }
}
}