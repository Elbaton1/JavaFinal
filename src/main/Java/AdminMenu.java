import java.util.Scanner;

public class AdminMenu {
    private AdminService adminService;

    // Constructor that accepts both AdminService and ProductService
    public AdminMenu(AdminService adminService, ProductService productService) {
        this.adminService = adminService;
        this.productService = productService;
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n======================");
            System.out.println(" Admin Menu");
            System.out.println("======================");
            System.out.println("1. View Users ");
            System.out.println("2. Delete User ");
            System.out.println("3. View Products ");
            System.out.println("4. Logout ");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    adminService.viewUsers();
                    break;
                case 2:
                    System.out.print("Enter username to delete: ");
                    String username = sc.nextLine();
                    adminService.deleteUser(username);
                    break;
                case 3:
                    adminService.viewAllProducts();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }

    private void displayAllProducts() {
        Product[] products = productService.getAllProducts();
        if (products.length == 0) {
            System.out.println("No products available.");
        } else {
            System.out.println("Listing all products:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
}
