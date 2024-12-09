import java.util.Scanner;

public class AdminMenu {
    private AdminService adminService;

    public AdminMenu(AdminService adminService) {
        this.adminService = adminService;
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n======================");
            System.out.println(" Admin Menu");
            System.out.println("======================");
            System.out.println("1. View Users ");
            System.out.println("2. Delete User ");
            System.out.println("3. View Products ");
            System.out.println("4. Logout ");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch(choice) {
                case 1:
                    adminService.viewUsers();
                    break;
                case 2:
                    System.out.print("Enter username to delete: ");
                    String username = sc.nextLine();
                    adminService.deleteUser(username);
                    break;
                case 3:
                    adminService.viewAllProducts();
                    break;
                case 4:
                    System.out.println(" Logging out...");
                    break;
                default:
                    System.out.println(" Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }
}
