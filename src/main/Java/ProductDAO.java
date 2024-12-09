public interface ProductDAO {
    boolean addProduct(Product product);
    Product getProductById(int id);
    Product[] getAllProducts();
    boolean deleteProduct(int id);
    boolean updateProduct(Product product);
}
