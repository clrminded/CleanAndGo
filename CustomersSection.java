
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
                        System.out.println(
                                "Maybe provide a list of all available service available....?");
                        System.out.println("Prompt for the name of a service");
                        System.out.println("Return a list of customers that USED this service");
                        break;
                    case 'B':
                    case 'b':
                        System.out.println("Customer number.");
                        System.out.println("prompt for a year");
                        System.out.println(
                                "Return the total number of customers per month during the year");
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
