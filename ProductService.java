public class ProductService {
    private Product[] products = new Product[10]; // Fixed initial size
    private int count = 0; // Tracks the number of products

    // Add a product
    public void addProduct(Product product) {
        if (count == products.length) {
            // Resize the array if full
            Product[] newProducts = new Product[products.length * 2];
            System.arraycopy(products, 0, newProducts, 0, products.length);
            products = newProducts;
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
                // Shift elements to the left
                System.arraycopy(products, i + 1, products, i, count - i - 1);
                products[--count] = null;
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
        return null;
    }

    // Get all products
    public Product[] getAllProducts() {
        Product[] result = new Product[count];
        System.arraycopy(products, 0, result, 0, count);
        return result;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
}