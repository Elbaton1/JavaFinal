public class Main {
    public static void main(String[] args) {
        ProductMenu menu = new ProductMenu();

        // Test adding a product
        System.out.println("--- Testing Add Product ---");
        menu.addProduct();

        // Test updating a product
        System.out.println("--- Testing Update Product ---");
        menu.updateProduct();

        // Test deleting a product
        System.out.println("--- Testing Delete Product ---");
        menu.deleteProduct();

        // Test viewing a product by ID
        System.out.println("--- Testing View Product by ID ---");
        menu.viewProductById();

        // Test displaying all products
        System.out.println("--- Testing Display All Products ---");
        menu.productService.displayAllProducts();
    }
}
