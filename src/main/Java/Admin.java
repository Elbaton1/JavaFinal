
public class Admin extends User {
    public Admin() {}
    public Admin(int id, String username, String password, String email) {
        super(id, username, password, email, "admin");
    }
}