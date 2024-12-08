
public class Buyer extends User {
    public Buyer() {}
    public Buyer(int id, String username, String password, String email) {
        super(id, username, password, email, "buyer");
    }
}
