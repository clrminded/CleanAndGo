
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
                customerService2Submenu();
                System.out.print("Type in your option: ");
                System.out.flush();
                String customer2Sub_ch = Input.readLine();
                System.out.println();

                switch (customer2Sub_ch.charAt(0)) {
                    case 'A':
                    case 'a':
                        System.out.println("Requested Services");
                        System.out.println(
                                "This should report the most requested TYPE of service");
                        break;
                    case 'B':
                    case 'b':
                        System.out.println("Service transactions");
                        System.out.println(
                                "This should report the total number of service transactions");
                        System.out.println("per month in the last 6 months.");
                        break;
                    case 'C':
                    case 'c':
                        System.out.println("Annual revenues from services");
                        System.out.println(
                                "This should calculate the annual revenures from services");
                        System.out
                                .println("provided to customers. AND grouped by service TYPE");
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

    public static void customerService2Submenu() {
        CleanAndGo.topMenu();
        CleanAndGo.titlePadding(27);
        System.out.println("Customers & Services");
        CleanAndGo.titlePadding(30);
        System.out.println("2. Services");
        CleanAndGo.bottomMenu();
        CleanAndGo.titlePadding(27);
        System.out.println("A. Requested Services.");
        CleanAndGo.titlePadding(27);
        System.out.println("B. Service transactions.");
        CleanAndGo.titlePadding(23);
        System.out.println("C. Annual revenues from services");
        CleanAndGo.titlePadding(21);
        System.out.println("D. Go back to customers & services menu");

    }
}
