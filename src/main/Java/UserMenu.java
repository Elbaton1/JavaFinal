import java.util.Scanner;

public class UserMenu {
    private UserService userService;

    public UserMenu(UserService userService) {
        this.userService = userService;
    }

    public User showMenu() {
        Scanner sc = new Scanner(System.in);
        User loggedInUser = null;
        int choice;
        do {
            System.out.println("\n======================");
            System.out.println(" User Menu");
            System.out.println("======================");
            System.out.println("1. Register ");
            System.out.println("2. Login ");
            System.out.println("3. Back to Main ");
            System.out.print("Choose: ");
            choice = sc.nextInt();
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
                    String r = sc.nextLine().toLowerCase();

                    if(userService.registerUser(u, p, e, r)) {
                        System.out.println(" Registered successfully!");
                    } else {
                        System.out.println(" Registration failed. User may already exist.");
                    }
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String lu = sc.nextLine();
                    System.out.print("Enter password: ");
                    String lp = sc.nextLine();
                    loggedInUser = userService.loginUser(lu, lp);
                    if(loggedInUser != null) {
                        System.out.println(" Login successful! Hello, " + loggedInUser.getUsername());
                        return loggedInUser;
                    } else {
                        System.out.println(" Login failed. Invalid credentials.");
                    }
                    break;
                case 3:
                    System.out.println(" Returning to main menu...");
                    return null;
                default:
                    System.out.println(" Invalid choice! Try again.");
            }
        } while (loggedInUser == null);

        return loggedInUser;
    }
}
