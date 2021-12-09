
//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomersAndService {

    public static void connectToDB(String username, String password) throws IOException {
        Connection conn = null;
        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect to the database
            String url = "jdbc:mysql://localhost:3306/CleanNGo?serverTimezone=UTC&useSSL=TRUE";

            conn = DriverManager.getConnection(url, username, password);

            boolean customerDone = false;
            do {
                CustomersAndService.customerServiceMenu();
                System.out.print("Type in your option: ");
                System.out.flush();
                String customer_ch = Input.readLine();
                System.out.println();

                switch (customer_ch.charAt(0)) {

                    case '1':
                        AnalyzeBusiness.connectToDB(username, password);
                        break;
                    case '2':
                        ServicesSection.connectToDB(username, password);
                        break;
                    case '3':
                        CustomersSection.connectToDB(username, password);
                        break; // end of customer submenu 3
                    case '4':
                        System.out.println("4. Go back to main menu");
                        customerDone = true;
                        break;
                    default:
                        System.out.println(" Not a valid option ");
                }
            } while (!customerDone);

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

    public static void customerServiceMenu() {
        CleanAndGo.topMenu();
        CleanAndGo.titlePadding(25);
        System.out.println("Welcome To Clean-And-Go Shop");
        CleanAndGo.titlePadding(27);
        System.out.println("2. Customers & Services");
        CleanAndGo.bottomMenu();
        CleanAndGo.titlePadding(20);
        System.out.println("1. Analyze the progress of the business");
        CleanAndGo.titlePadding(33);
        System.out.println("2. Services");
        CleanAndGo.titlePadding(33);
        System.out.println("3. Customers");
        CleanAndGo.titlePadding(28);
        System.out.println("4. Go back to main menu");
    }

}
