public class Buyer extends User {

    

    // Default Constructor
    public Buyer() {
        super();
    }

    // Constructor with all fields
    public Buyer(int id, String username, String password, String email, String role) {
        super(id, username, password, email, role);
    }

    // Constructor without id 
    public Buyer(String username, String password, String email, String role) {
        super(username, password, email, role);
    }

    

    // toString Method
    @Override
    public String toString() {
        return "Buyer {" +
               "id=" + getId() +
               ", username='" + getUsername() + '\'' +
               ", email='" + getEmail() + '\'' +
               ", role='" + getRole() + '\'' +
               '}';
    }
}
