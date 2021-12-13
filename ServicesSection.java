
//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServicesSection {

    public static void connectToDB(String username, String password) throws IOException {
        Connection conn = null;
        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect to the database
            String url = "jdbc:mysql://localhost:3306/CleanNGo?serverTimezone=UTC&useSSL=TRUE";

            conn = DriverManager.getConnection(url, username, password);

            boolean customer2SubDone = false;
            do {
                UI.csSubmenu2();
                System.out.print("Type in your option: ");
                System.out.flush();
                String customer2Sub_ch = Input.readLine();
                System.out.println();

                switch (customer2Sub_ch.charAt(0)) {
                    case 'A':
                    case 'a':
                        System.out.println("Requested Services");
                        Queries.mostRequestedServiceType(conn);
                        break;
                    case 'B':
                    case 'b':
                        System.out.println("Service transactions");
                        Queries.perMonthServiceTransactions(conn);
                        break;
                    case 'C':
                    case 'c':
                        System.out.println("Annual revenues from services");
                        Queries.annualRevenuesFromServices(conn);
                        break;
                    case 'D':
                    case 'd':
                        System.out.println("Go back to customers & services menu");
                        customer2SubDone = true;
                        break;

                    default:
                        System.out.println("Not a valid option, try again");

                }

            } while (!customer2SubDone);

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
