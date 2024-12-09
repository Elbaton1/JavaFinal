public class AdminServiceImpl implements AdminService {
    private UserService userService;
    private ProductService productService;

    public AdminServiceImpl(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void viewUsers() {
        User[] users = userService.getAllUsers();
        if (users == null || users.length == 0) {
            System.out.println("❌ No users found.");
        } else {
            System.out.println("\n👥 List of Users:");
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    @Override
    public void deleteUser(String username) {
        boolean success = userService.deleteUser(username);
        if (success) {
            System.out.println("✅ User " + username + " deleted successfully.");
        } else {
            System.out.println("❌ User " + username + " not found.");
        }
    }

    @Override
    public void viewAllProducts() {
        productService.getAllProducts();
    }
}

