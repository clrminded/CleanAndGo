
//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomersSection {

    public static void connectToDB(String username, String password) throws IOException {
        Connection conn = null;
        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect to the database
            String url = "jdbc:mysql://localhost:3306/CleanNGo?serverTimezone=UTC&useSSL=TRUE";

            conn = DriverManager.getConnection(url, username, password);

            boolean customer3SubDone = false;
            do {
                UI.csSubmenu3();
                System.out.print("Type in your option: ");
                System.out.flush();
                String customer3Sub_ch = Input.readLine();
                System.out.println();

                switch (customer3Sub_ch.charAt(0)) {
                    case 'A':
                    case 'a':
                        System.out.println("Customer list for a service.");
                        System.out.println("Choose a Service:");
                        Queries.showServiceList(conn);
                        System.out.flush();
                        int serviceName = Integer.parseInt(Input.readLine());
                        Queries.servicesCustomerList(conn, serviceName);
                        break;
                    case 'B':
                    case 'b':
                        System.out.println("Customer Number:");
                        System.out.println("Enter in a year:");
                        System.out.flush();
                        int year = Integer.parseInt(Input.readLine());
                        Queries.numberOfCustomerPerYear(conn, year);
                        break;
                    case 'C':
                    case 'c':
                        System.out.println("Go back to customers & services menu");
                        customer3SubDone = true;
                        break;
                    default:
                        System.out.println("Not a valid option, try again");

                }

            } while (!customer3SubDone);

        } catch (ClassNotFoundException e) {
            System.out.println("Could not load the driver");
        } catch (SQLException ex) {
            System.out.println(ex);
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

}
