public interface UserService {
    boolean registerUser(String username, String password, String email, String role);
    User loginUser(String username, String password);
    User[] getAllUsers();
    boolean deleteUser(String username);
}
