import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class CleanAndGo {

    public static void main(String[] args) {
        connectToDB("student", "password");
    }

    public static void connectToDB(String username, String password) {
        Connection conn = null;
        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect to the database
            String url = "jdbc:mysql://localhost:3306/CleanNGo?serverTimezone=UTC&useSSL=TRUE";

            conn = DriverManager.getConnection(url, username, password);

            boolean done = false;
            do {
                // main first screen
                UI.mainMenu();
                System.out.print("Type in your option: ");
                System.out.flush();
                String ch = Input.readLine();
                System.out.println();

                switch (ch.charAt(0)) {

                    case '1':
                        EquipmentAndSupplies.connectToDB(username, password);
                        break;
                    case '2':
                        CustomersAndService.connectToDB(username, password);
                        break;
                    case '3':
                        Employees.connectToDB(username, password);
                        break;
                    case '4':
                        String admin[] = validateAdmin();
                        Updates.connectToDB(admin[0], admin[1]);
                        break;
                    case '5':
                        UI.exitMain();
                        done = true;
                        break;
                    default:
                        System.out.println(" Not a valid option ");
                }
            } while (!done);

        } catch (ClassNotFoundException e) {
            System.out.println("Could not load the driver");
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static String[] validateAdmin() {
        String[] adminCreds = new String[] { "admin", "nimda" };
        String[] creds = new String[2];
        System.out.print("Enter admin username: ");
        System.out.flush();
        String adminUsername = Input.readLine();
        System.out.print("Enter admin password: ");
        System.out.flush();
        String adminPass = Input.readLine();
        if (adminUsername.equals("admin") && adminPass.equals("nimda")) {
            return adminCreds;
        }
        return creds;
    }

}
