import java.util.Arrays;

public class ProductService {
    private Product[] products; 
    private int count;         
    // Constructor
    public ProductService() {
        this.products = new Product[10]; // Initial capacity of 10
        this.count = 0;
    }

    // Add a product
    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("Cannot add null product!");
            return;
        }

        // Check if the array is full and resize if necessary
        if (count == products.length) {
            resizeArray();
        }

       
        products[count++] = product;
        System.out.println("Product added successfully: " + product);
    }

    // Update a product by ID
    public void updateProduct(int id, Product updatedProduct) {
        for (int i = 0; i < count; i++) {
            if (products[i].getId() == id) {
                products[i] = updatedProduct;
                System.out.println("Product updated successfully: " + updatedProduct);
                return;
            }
        }
        System.out.println("Product not found with ID: " + id);
    }

    // Delete a product by ID
    public void deleteProduct(int id) {
        for (int i = 0; i < count; i++) {
            if (products[i].getId() == id) {
                // Shift elements to the left to remove the product
                System.arraycopy(products, i + 1, products, i, count - i - 1);
                products[--count] = null; // Clear the last element
                System.out.println("Product deleted successfully with ID: " + id);
                return;
            }
        }
        System.out.println("Product not found with ID: " + id);
    }

    // Get a product by ID
    public Product getProductById(int id) {
        for (int i = 0; i < count; i++) {
            if (products[i].getId() == id) {
                return products[i];
            }
        }
        System.out.println("Product not found with ID: " + id);
        return null;
    }

    // Get all products
    public Product[] getAllProducts() {
        return Arrays.copyOf(products, count); // Return a copy of the active products
    }

    // Resize the internal array
    private void resizeArray() {
        products = Arrays.copyOf(products, products.length * 2);
        System.out.println("Resized the products array to: " + products.length);
    }

    // Display all products
    public void displayAllProducts() {
        if (count == 0) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("Listing all products:");
        for (int i = 0; i < count; i++) {
            System.out.println(products[i]);
        }
    }
}
