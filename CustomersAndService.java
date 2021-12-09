
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
            // String user;
            // String pass;
            // user = readEntry("userid : ");
            // pass = readEntry("password: ");
            conn = DriverManager.getConnection(url, username, password);
            // main menu option 2 customer & services menu
            boolean customerDone = false;
            do {
                CustomersAndService.customerServiceMenu();
                System.out.print("Type in your option: ");
                System.out.flush();
                String customer_ch = Input.readLine();
                System.out.println();

                switch (customer_ch.charAt(0)) {

                    case '1':
                        boolean customer1SubDone = false;
                        do {
                            CustomersAndService.customerService1Submenu();
                            System.out.print("Type in your option: ");
                            System.out.flush();
                            String customer1Sub_ch = Input.readLine();
                            System.out.println();

                            switch (customer1Sub_ch.charAt(0)) {
                                case 'A':
                                case 'a':
                                    System.out.println("Total number of new customers");
                                    Queries.selectAllCustomerNames(conn);
                                    break;
                                case 'B':
                                case 'b':
                                    System.out.println("Total number of service transactions");
                                    Queries.selectAllSupplierNames(conn);
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

                        break;
                    case '2':
                        System.out.println("2. Services");
                        boolean customer2SubDone = false;
                        do {
                            CustomersAndService.customerService2Submenu();
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
                        break;
                    case '3':
                        boolean customer3SubDone = false;
                        do {
                            CustomersAndService.customerService3Submenu();
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
                        break; // end of customer submenu 3
                    case '4':
                        System.out.println("4. Go back to main menu");
                        customerDone = true;
                        break;
                    default:
                        // repeats if non valid option is chosen
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

    public static void customerService1Submenu() {
        CleanAndGo.topMenu();
        CleanAndGo.titlePadding(27);
        System.out.println("Customers & Services");
        CleanAndGo.titlePadding(20);
        System.out.println("1. Analyze the progress of the business");
        CleanAndGo.bottomMenu();
        CleanAndGo.titlePadding(22);
        System.out.println("A. Total number of new customers.");
        CleanAndGo.titlePadding(20);
        System.out.println("B. Total number of service transactions.");
        CleanAndGo.titlePadding(21);
        System.out.println("C. Go back to customers & services menu");

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

    public static void customerService3Submenu() {
        CleanAndGo.topMenu();
        CleanAndGo.titlePadding(27);
        System.out.println("Customers & Services");
        CleanAndGo.titlePadding(20);
        System.out.println("3. Customers");
        CleanAndGo.bottomMenu();
        CleanAndGo.titlePadding(22);
        System.out.println("A. Customer list for a service.");
        CleanAndGo.titlePadding(20);
        System.out.println("B. Customer number.");
        CleanAndGo.titlePadding(21);
        System.out.println("C. Go back to customers & services menu");

    }
}
