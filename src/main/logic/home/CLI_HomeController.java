package home;
import java.util.Scanner;
public class CLI_HomeController {
    public CLI_HomeController(){
        System.out.println("Welcome to Get Your PC!\n1)Search PC\n2)Post sale ad\n3)Personal area\n4)Reviewer area\n5)Login\n6)Help");
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Insert number:");
            if(!scanner.hasNextInt()){
                System.out.println("It's a string. Retry");
                scanner.nextLine();
                continue;}
            int num = scanner.nextInt();
            switch (num) {
            case 1:
                scanner.close();
                System.out.println("Hai inserito 1");
                break;
            case 2:
                scanner.close();
                System.out.println("Hai inserito 2");
                break;
            case 3:
                scanner.close();
                System.out.println("Hai inserito 3");
                break;
            case 4:
                scanner.close();
                System.out.println("Hai inserito 4");
                break;
            case 5:
                scanner.close();
                System.out.println("Hai inserito 5");
                break;
            case 6:
                scanner.close();
                System.out.println("Hai inserito 6");
                break;
            default:
                System.out.println("Invalid number. Retry");
                scanner.nextLine();
                continue;
        }
        break;
    }
        System.out.println("ok");
}}


