import java.util.Scanner;

public class SellerMenu {
    private ProductService productService;

    public SellerMenu(ProductService productService) {
        this.productService = productService;
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n======================");
            System.out.println("🛒 Seller Menu");
            System.out.println("======================");
            System.out.println("1. Add Product ");
            System.out.println("2. Update Product ");
            System.out.println("3. Delete Product ");
            System.out.println("4. View All Products ");
            System.out.println("5. Logout ");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    addProduct(sc);
                    break;
                case 2:
                    updateProduct(sc);
                    break;
                case 3:
                    deleteProduct(sc);
                    break;
                case 4:
                    productService.displayAllProducts();
                    break;
                case 5:
                    System.out.println(" Logging out...");
                    break;
                default:
                    System.out.println(" Invalid choice!");
            }
        } while(choice != 5);
    }

    private void addProduct(Scanner sc) {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Product Price: ");
        double price = sc.nextDouble();
        System.out.print("Enter Product Quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Enter Seller ID: ");
        int sellerId = sc.nextInt();

        Product product = new Product(id, name, price, quantity, sellerId);
        productService.addProduct(product);
    }

    private void updateProduct(Scanner sc) {
        System.out.print("Enter Product ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Updated Product Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Updated Product Price: ");
        double price = sc.nextDouble();
        System.out.print("Enter Updated Product Quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Enter Updated Seller ID: ");
        int sellerId = sc.nextInt();

        Product updatedProduct = new Product(id, name, price, quantity, sellerId);
        productService.updateProduct(id, updatedProduct);
    }

    private void deleteProduct(Scanner sc) {
        System.out.print("Enter Product ID to Delete: ");
        int id = sc.nextInt();
        productService.deleteProduct(id);
    }
}
