public interface UserDAO {
    boolean addUser(User user);
    User getUserByUsername(String username);
    User[] getAllUsers();
    boolean deleteUser(String username);
}
