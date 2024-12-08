
import java.util.Scanner;

public class AdminMenu {
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Admin Menu ---");
        System.out.println("1. View Users (Not Implemented)");
        System.out.println("2. Delete User (Not Implemented)");
        System.out.println("3. View Products (Not Implemented)");
        System.out.println("4. Back");
        System.out.print("Choose: ");
        int choice = sc.nextInt();
        System.out.println("Placeholder admin functionality not implemented yet.");
    }
}
