
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the E-Commerce Platform");
        System.out.println("1. User Menu");
        System.out.println("2. Admin Menu");
        System.out.println("3. Product Menu");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
        int choice = sc.nextInt();
        switch(choice) {
            case 1:
                UserMenu userMenu = new UserMenu();
                userMenu.showMenu();
                break;
            case 2:
                AdminMenu adminMenu = new AdminMenu();
                adminMenu.showMenu();
                break;
            case 3:
                ProductMenu productMenu = new ProductMenu();
                productMenu.displayMenu();
                break;
            default:
                System.out.println("Exiting...");
        }
        sc.close();
    }
}
