public class Seller extends User {
    public Seller() {
        super();
    }

    public Seller(int id, String username, String password, String email) {
        super(id, username, password, email, "seller");
    }
}
