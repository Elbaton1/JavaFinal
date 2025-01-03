public class ProductService {
    private ProductDAO productDAO;

    // Constructor to initialize the DAO
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    // Add a new product
    public boolean addProduct(String name, double price, int quantity, int sellerId) {
        if (name == null || name.isEmpty() || price <= 0 || quantity < 0) {
            System.out.println("Invalid product details.");
            return false; // Validation failed
        }
        Product product = new Product(0, name, price, quantity, sellerId); // ID is auto-generated by the DB
        return productDAO.addProduct(product);
    }

    // Retrieve a product by ID
    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }

    // Retrieve all products
    public Product[] getAllProducts() {
        return productDAO.getAllProducts();
    }

    // Update an existing product
    public boolean updateProduct(int id, String name, double price, int quantity, int sellerId) {
        Product existingProduct = productDAO.getProductById(id);
        if (existingProduct == null) {
            System.out.println("Product not found.");
            return false; // Product not found
        }
        if (existingProduct.getSellerId() != sellerId) {
            System.out.println("You can only update your own products!");
            return false; // Ownership validation failed
        }
        Product updatedProduct = new Product(id, name, price, quantity, sellerId);
        return productDAO.updateProduct(updatedProduct);
    }

    // Delete a product by ID
    public boolean deleteProduct(int id, int sellerId) {
        Product existingProduct = productDAO.getProductById(id);
        if (existingProduct == null) {
            System.out.println("Product not found.");
            return false; // Product not found
        }
        if (existingProduct.getSellerId() != sellerId) {
            System.out.println("You can only delete your own products!");
            return false; // Ownership validation failed
        }
        return productDAO.deleteProduct(id);
    }
}