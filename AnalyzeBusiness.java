
//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AnalyzeBusiness {

    public static void connectToDB(String username, String password) throws IOException {
        Connection conn = null;
        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect to the database
            String url = "jdbc:mysql://localhost:3306/CleanNGo?serverTimezone=UTC&useSSL=TRUE";

            conn = DriverManager.getConnection(url, username, password);

            boolean customer1SubDone = false;
            do {
                UI.csSubmenu1();
                System.out.print("Type in your option: ");
                System.out.flush();
                String customer1Sub_ch = Input.readLine();
                System.out.println();

                switch (customer1Sub_ch.charAt(0)) {
                    case 'A':
                    case 'a':
                        System.out.println("Total number of new customers");
                        Queries.getCurrentYearNewCustomerCount(conn);
                        break;
                    case 'B':
                    case 'b':
                        System.out.println("Total number of service transactions");
                        Queries.getCurrentMonthServiceTransactions(conn);
                        break;
                    case 'C':
                    case 'c':
                        System.out.println("Go back to customers & services menu");
                        customer1SubDone = true;
                        break;
                    default:
                        System.out.println("Not a valid option, try again");

                }

            } while (!customer1SubDone);

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
