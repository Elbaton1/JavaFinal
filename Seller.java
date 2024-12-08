public class Seller extends User {

    

    // Default Constructor
    public Seller() {
        super();
    }

    // Constructor with all fields
    public Seller(int id, String username, String password, String email, String role) {
        super(id, username, password, email, role);
    }

    // Constructor without id 
    public Seller(String username, String password, String email, String role) {
        super(username, password, email, role);
    }

    

    // toString Method
    @Override
    public String toString() {
        return "Seller {" +
               "id=" + getId() +
               ", username='" + getUsername() + '\'' +
               ", email='" + getEmail() + '\'' +
               ", role='" + getRole() + '\'' +
               '}';
    }
}
