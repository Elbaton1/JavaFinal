
import org.mindrot.jbcrypt.BCrypt;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean registerUser(String username, String password, String email, String role) {
        if(userDAO.getUserByUsername(username) != null) {
            return false; // user already exists
        }
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        User user = new User(0, username, hashed, email, role);
        return userDAO.addUser(user);
    }

    @Override
    public User loginUser(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        if(user != null && BCrypt.checkpw(password, user.getPassword())) {
            return user;
        }
        return null;
    }
}
