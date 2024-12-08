
import java.util.Scanner;

public class UserMenu {
    private UserService userService;

    public UserMenu() {
        this.userService = new UserServiceImpl(new UserDAOImpl());
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- User Menu ---");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Back");
        System.out.print("Choose: ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch(choice) {
            case 1:
                System.out.print("Enter username: ");
                String u = sc.nextLine();
                System.out.print("Enter password: ");
                String p = sc.nextLine();
                System.out.print("Enter email: ");
                String e = sc.nextLine();
                System.out.print("Enter role (buyer/seller/admin): ");
                String r = sc.nextLine();
                if(userService.registerUser(u, p, e, r)) {
                    System.out.println("Registered successfully!");
                } else {
                    System.out.println("Registration failed. User may already exist.");
                }
                break;
            case 2:
                System.out.print("Enter username: ");
                String lu = sc.nextLine();
                System.out.print("Enter password: ");
                String lp = sc.nextLine();
                User logged = userService.loginUser(lu, lp);
                if(logged != null) {
                    System.out.println("Login successful! Hello, " + logged.getUsername());
                } else {
                    System.out.println("Login failed.");
                }
                break;
            default:
                System.out.println("Returning to main menu...");
        }
        // Do not close sc if returning to main menu
    }
}
