import java.util.Scanner;

public class BuyerMenu {
    private ProductService productService;

    public BuyerMenu(ProductService productService) {
        this.productService = productService;
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n======================");
            System.out.println(" Buyer Menu");
            System.out.println("======================");
            System.out.println("1. View All Products ");
            System.out.println("2. View Product By ID ");
            System.out.println("3. Logout ");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    productService.displayAllProducts();
                    break;
                case 2:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    Product p = productService.getProductById(id);
                    if (p != null) {
                        System.out.println(" Product Details: " + p);
                    }
                    break;
                case 3:
                    System.out.println(" Logging out...");
                    break;
                default:
                    System.out.println(" Invalid choice! Try again.");
            }
        } while (choice != 3);
    }
}
