import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class CleanAndGo {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Step 1: Load the JDBC driver(You have to have the connector Jar file in your
            // project Class path)
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect to the database(Change the URL)
            String url = "jdbc:mysql://localhost:3306/CleanNGo?serverTimezone=UTC&useSSL=TRUE";
            String user;
            String pass;
            user = readEntry("userid : ");
            pass = readEntry("password: ");
            conn = DriverManager.getConnection(url, user, pass);

            boolean done = false;
            do {
                welcomeMenu();
                System.out.print("Type in your option: ");
                System.out.flush();
                String ch = readLine();
                System.out.println();

                switch (ch.charAt(0)) {
                    case 'a':
                        findAllEquipment(conn);
                        break;
                    case 'b':
                        customerServiceMenu();
                        break;
                    case 'c':
                        employeeMenu();
                        break;
                    case 'd':
                        updatesMenu();
                        break;
                    case 'e':
                        quitMenu();
                        done = true;
                        break;
                    default:
                        System.out.println(" Not a valid option ");
                } // switch

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

    private static void findAllEquipment(Connection conn) throws SQLException, IOException {

        /*
         * In this method your SQL Query should return the ssn, Lname, FirstName and
         * Salary for all employees ordered by the highest salary
         */
        equipmentSupplyMenu();
        // STEP1: CREATE VARIABLE OF TYPE STATEMENT

        Statement stmt = conn.createStatement();

        // STEP 2 DEFINE A STRING THAT IS = TO YOUR query SQL Statement

        String query = "select * from Employee";
        PreparedStatement p = conn.prepareStatement(query);
        p.clearParameters();

        // Step 3: Declare a variable with ResultSet type

        ResultSet r = p.executeQuery();

        // Execute your Query and store the return in the declared variable from step 3

        System.out.println("    HIGHEST PAID WORKERS");
        System.out.println("--------------------------------------------------\n");

        // Write a loop to read all the returned rows from the query execution
        while (r.next()) {
            String ssn = r.getString(1);
            String lname = r.getString(2);
            String fname = r.getString(3);
            double salary = r.getDouble(4);
            System.out.println(ssn + " " + lname + " " + fname + " " + salary);
        }

        // Close the statement
        stmt.close();
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

    // Scenerio 1 (Updates)

    public static void equipmentSupplyMenu() {
        topMenu();
        titlePadding(25);
        System.out.println("Welcome To Clean-And-Go Shop");
        titlePadding(27);
        System.out.println("1. Equipment & Supplies");
        bottomMenu();
    }

    // Scenerio 2 (Customers & Services)
    public static void customerServiceMenu() {
        topMenu();
        titlePadding(25);
        System.out.println("Welcome To Clean-And-Go Shop");
        titlePadding(27);
        System.out.println("2. Customers & Services");
        bottomMenu();
    }

    public static void employeeMenu() {
        topMenu();
        titlePadding(25);
        System.out.println("Welcome To Clean-And-Go Shop");
        titlePadding(31);
        System.out.println("3. Employees");
        bottomMenu();
    }

    public static void updatesMenu() {
        topMenu();
        titlePadding(25);
        System.out.println("Welcome To Clean-And-Go Shop");
        titlePadding(32);
        System.out.println("4. Updates");
        bottomMenu();
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

    static String readEntry(String prompt) {
        try {
            StringBuffer buffer = new StringBuffer();
            System.out.print(prompt);
            System.out.flush();
            int c = System.in.read();
            while (c != '\n' && c != -1) {
                buffer.append((char) c);
                c = System.in.read();
            }
            return buffer.toString().trim();
        } catch (IOException e) {
            return "";
        }
    }

    private static String readLine() {
        InputStreamReader isr = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(isr, 1);
        String line = "";

        try {
            line = br.readLine();
        } catch (IOException e) {
            System.out.println("Error in SimpleIO.readLine: " + "IOException was thrown");
            System.exit(1);
        }
        return line;
    }

}
