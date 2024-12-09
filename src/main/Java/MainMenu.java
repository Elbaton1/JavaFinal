import java.util.Scanner;

public class MainMenu {
    private static User currentUser = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize DAO and Service Layers
        UserDAO userDAO = new UserDAOImpl();
        UserService userService = new UserServiceImpl(userDAO);
        ProductDAO productDAO = new ProductDAOImpl();
        ProductService productService = new ProductService(productDAO); // Updated to use ProductDAO
        AdminService adminService = new AdminServiceImpl(userService, productService);

        int choice;
        do {
            if (currentUser == null) {
                // Not logged in
                System.out.println("\n======================");
                System.out.println(" Welcome to the E-Commerce Platform");
                System.out.println("======================");
                System.out.println("1. User Menu (Register/Login)");
                System.out.println("2. Exit ");
                System.out.print("Choose an option: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        UserMenu userMenu = new UserMenu(userService);
                        currentUser = userMenu.showMenu();
                        // If user logs in successfully, currentUser will not be null
                        break;
                    case 2:
                        System.out.println(" Exiting... Goodbye!");
                        break;
                    default:
                        System.out.println(" Invalid choice! Please try again.");
                }
            } else {
                // Logged in
                String role = currentUser.getRole();
                switch (role) {
                    case "admin":
                        AdminMenu adminMenu = new AdminMenu(adminService);
                        adminMenu.showMenu();
                        currentUser = null; // After logout
                        break;
                    case "buyer":
                        BuyerMenu buyerMenu = new BuyerMenu(productService);
                        buyerMenu.showMenu();
                        currentUser = null; // After logout
                        break;
                    case "seller":
                        // Pass the currentUser into SellerMenu so we can enforce ownership checks
                        SellerMenu sellerMenu = new SellerMenu(productService, currentUser);
                        sellerMenu.showMenu();
                        currentUser = null; // After logout
                        break;
                    default:
                        System.out.println(" Unknown role. Logging out...");
                        currentUser = null;
                        break;
                }

                // Reset choice to allow relogin
                choice = (currentUser == null) ? 0 : -1;
            }
        } while (choice != 2);

        sc.close();
        System.out.println("👋 Goodbye!");
    }
}
