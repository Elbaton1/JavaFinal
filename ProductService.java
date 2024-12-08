import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products = new ArrayList<>(); // Mock in-memory storage

    // Add a new product
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added successfully: " + product);
    }

    // Update an existing product
    public void updateProduct(int id, Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, updatedProduct);
                System.out.println("Product updated successfully: " + updatedProduct);
                return;
            }
        }
        System.out.println("Product not found with ID: " + id);
    }

    // Delete a product by ID
    public void deleteProduct(int id) {
        boolean removed = products.removeIf(product -> product.getId() == id);
        if (removed) {
            System.out.println("Product deleted successfully with ID: " + id);
        } else {
            System.out.println("Product not found with ID: " + id);
        }
    }

    // Get a product by ID
    public Product getProductById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Get a list of all products
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}
