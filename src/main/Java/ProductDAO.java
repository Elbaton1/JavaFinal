public interface ProductDAO {
    boolean addProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(int productId);
    Product getProductById(int productId);
    Product[] getAllProducts();
}
