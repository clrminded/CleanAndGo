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
                welcomeMenu();
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
                        break; // end of main menu option 3
                    case '4':
                        // main menu option 4 updates menu
                        Updates.connectToDB(username, password);
                        break;
                    case '5':
                        // main menu option 5 quit program
                        quitMenu();
                        done = true;
                        break;
                    default:
                        // repeats if non valid option is chosen
                        System.out.println(" Not a valid option ");
                } // end of main menu switch

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

    public static void welcomeMenu() {
        topMenu();
        titlePadding(25);
        System.out.println("Welcome To Clean-And-Go Shop");
        bottomMenu();
        titlePadding(27);
        System.out.println("1. Equipment & Supplies");
        titlePadding(27);
        System.out.println("2. Customers & Services");
        titlePadding(32);
        System.out.println("3. Employees");
        titlePadding(33);
        System.out.println("4. Updates");
        titlePadding(34);
        System.out.println("5. Quit");
    }

    public static void quitMenu() {
        topMenu();
        titlePadding(20);
        System.out.println("Thank You For Visiting Clean-And-Go Shop");
        titlePadding(21);
        System.out.println("Have A Wonderful Day, See You Next Time");
        bottomMenu();
    }

    public static void topMenu() {
        for (int i = 0; i < 77; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < 32; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < 11; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void titlePadding(int spaces) { // 25 spaces // for main
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
    }

    public static void bottomMenu() {
        for (int i = 0; i < 32; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < 11; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < 77; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

}
