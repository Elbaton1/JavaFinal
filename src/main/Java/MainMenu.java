import java.util.Scanner;

public class MainMenu {
    private static User currentUser = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserDAO userDAO = new UserDAOImpl();
        UserService userService = new UserServiceImpl(userDAO);
        ProductService productService = new ProductService();
        AdminService adminService = new AdminServiceImpl(userService, productService);

        int choice;
        do {
            if (currentUser == null) {
                // Not logged in
                System.out.println("\n======================");
                System.out.println("🏪 Welcome to the E-Commerce Platform");
                System.out.println("======================");
                System.out.println("1. User Menu (Register/Login)");
                System.out.println("2. Exit 🚪");
                System.out.print("Choose an option: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch(choice) {
                    case 1:
                        UserMenu userMenu = new UserMenu(userService);
                        currentUser = userMenu.showMenu();
                        // If user logs in successfully, currentUser will not be null
                        break;
                    case 2:
                        System.out.println("👋 Exiting... Goodbye!");
                        break;
                    default:
                        System.out.println("❌ Invalid choice! Please try again.");
                }
            } else {
                // Logged in
                String role = currentUser.getRole();
                if (role.equals("admin")) {
                    AdminMenu adminMenu = new AdminMenu(adminService);
                    adminMenu.showMenu();
                    currentUser = null; // after logout
                } else if (role.equals("buyer")) {
                    BuyerMenu buyerMenu = new BuyerMenu(productService);
                    buyerMenu.showMenu();
                    currentUser = null; // after logout
                } else if (role.equals("seller")) {
                    SellerMenu sellerMenu = new SellerMenu(productService);
                    sellerMenu.showMenu();
                    currentUser = null; // after logout
                } else {
                    System.out.println("❌ Unknown role. Logging out...");
                    currentUser = null;
                }
                choice = (currentUser == null) ? 0 : -1;
            }
        } while (choice != 2);

        sc.close();
        System.out.println("👋 Goodbye!");
    }
}
