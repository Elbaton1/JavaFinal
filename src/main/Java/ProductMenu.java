import java.util.Scanner;

public class ProductMenu {
    private ProductService productService = new ProductService();
    private Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\n--- Product Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View Product by ID");
            System.out.println("5. View All Products");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    viewProductById();
                    break;
                case 5:
                    productService.displayAllProducts();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
    }

    private void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Product Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Seller ID: ");
        int sellerId = scanner.nextInt();

        Product product = new Product(id, name, price, quantity, sellerId);
        productService.addProduct(product);
    }

    private void updateProduct() {
        System.out.print("Enter Product ID to Update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Updated Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Updated Product Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Updated Product Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Updated Seller ID: ");
        int sellerId = scanner.nextInt();

        Product updatedProduct = new Product(id, name, price, quantity, sellerId);
        productService.updateProduct(id, updatedProduct);
    }

    private void deleteProduct() {
        System.out.print("Enter Product ID to Delete: ");
        int id = scanner.nextInt();
        productService.deleteProduct(id);
    }

    private void viewProductById() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        Product product = productService.getProductById(id);
        if (product != null) {
            System.out.println("Product Details: " + product);
        }
    }
}
