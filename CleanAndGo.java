import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            // String user;
            // String pass;
            // user = readEntry("userid : ");
            // pass = readEntry("password: ");
            conn = DriverManager.getConnection(url, username, password);

            boolean done = false;
            do {
                // main first screen
                welcomeMenu();
                System.out.print("Type in your option: ");
                System.out.flush();
                String ch = readLine();
                System.out.println();

                switch (ch.charAt(0)) {
                    /*
                     * ------------------------------ EQUIPMENT & SUPPLIES
                     * ----------------------------
                     */
                    case '1':
                        // main menu option 1 equipment & supplie menu
                        boolean equipmentDone = false;
                        do {
                            equipmentSupplyMenu();
                            System.out.print("Type in your option: ");
                            System.out.flush();
                            String equip_ch = readLine();
                            System.out.println();

                            switch (equip_ch.charAt(0)) {
                                case '1':
                                    System.out.println("1. Analyze the progress of the business.");
                                    break;
                                case '2':
                                    System.out.println("2. Equipment");
                                    break;
                                case '3':
                                    System.out.println("3. Supplies");
                                    break;
                                case '4':
                                    System.out.println("4. Go back to main menu");
                                    equipmentDone = true;
                                    break;
                                default:
                                    // repeats if non valid option is chosen
                                    System.out.println(" Not a valid option ");
                            }
                        } while (!equipmentDone);

                        break; // end of main menu option 1

                    case '2':
                        CustomersAndService.connectToDB(username, password);
                    case '3':
                        // main menu option 3 employee menu
                        boolean employeeDone = false;
                        do {
                            employeeMenu();
                            System.out.print("Type in your option: ");
                            System.out.flush();
                            String employee_ch = readLine();
                            System.out.println();

                            switch (employee_ch.charAt(0)) {
                                case '1':
                                    titlePadding(27);
                                    System.out.println("1. Get Working Schedule");
                                    break;
                                case '2':
                                    titlePadding(27);
                                    System.out.println("2. Go back to main menu");
                                    employeeDone = true;
                                    break;
                                default:
                                    // repeats if non valid option is chosen
                                    System.out.println(" Not a valid option ");
                            }
                        } while (!employeeDone);

                        break; // end of main menu option 3
                    case '4':
                        // main menu option 4 updates menu
                        boolean updatesDone = false;
                        do {
                            updatesMenu();
                            System.out.print("Type in your option: ");
                            System.out.flush();
                            String updates_ch = readLine();
                            System.out.println();

                            switch (updates_ch.charAt(0)) {
                                case '1':
                                    System.out.println("1. Insert new information");
                                    break;
                                case '2':
                                    System.out.println("2. Delete some information");
                                    break;
                                case '3':
                                    System.out.println("3. Update current information");
                                    break;
                                case '4':
                                    System.out.println("4. Go back to main menu");
                                    updatesDone = true;
                                    break;
                                default:
                                    // repeats if non valid option is chosen
                                    System.out.println(" Not a valid option ");
                            }
                        } while (!updatesDone);
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

    public static void equipmentSupplyMenu() {
        topMenu();
        titlePadding(25);
        System.out.println("Welcome To Clean-And-Go Shop");
        titlePadding(27);
        System.out.println("1. Equipment & Supplies");
        bottomMenu();
        titlePadding(20);
        System.out.println("1. Analyze the progress of the business.");
        titlePadding(33);
        System.out.println("2. Equipment");
        titlePadding(33);
        System.out.println("3. Supplies");
        titlePadding(28);
        System.out.println("4. Go back to main menu");
    }

    public static void employeeMenu() {
        topMenu();
        titlePadding(25);
        System.out.println("Welcome To Clean-And-Go Shop");
        titlePadding(31);
        System.out.println("3. Employees");
        bottomMenu();
        titlePadding(28);
        System.out.println("1. Get Working Schedule");
        titlePadding(28);
        System.out.println("2. Go back to main menu");
    }

    public static void updatesMenu() {
        topMenu();
        titlePadding(25);
        System.out.println("Welcome To Clean-And-Go Shop");
        titlePadding(32);
        System.out.println("4. Updates");
        bottomMenu();
        titlePadding(31);
        System.out.println("1. Insert new information");
        titlePadding(28);
        System.out.println("2. Delete some information");
        titlePadding(28);
        System.out.println("3. Update current information");
        titlePadding(28);
        System.out.println("4. Go back to main menu");
    }

    public static void updates1Submenu() {
        topMenu();
        titlePadding(25);
        System.out.println("Updates");
        titlePadding(32);
        System.out.println("1. Insert New Information");
        bottomMenu();
        titlePadding(31);
        System.out.println("A. Add new equipment");
        titlePadding(28);
        System.out.println("B. Add new service");
        titlePadding(28);
        System.out.println("C. Add new customer information");
        titlePadding(28);
        System.out.println("D. Add new employee information");
        titlePadding(28);
        System.out.println("E. Go back to Updates menu");
    }

    public static void updates2Submenu() {
        topMenu();
        titlePadding(25);
        System.out.println("Updates");
        titlePadding(32);
        System.out.println("2. Delete some information");
        bottomMenu();
        titlePadding(31);
        System.out.println("A. Delete specific eqipment");
        titlePadding(28);
        System.out.println("B. Delete specific service");
        titlePadding(28);
        System.out.println("C. Delete specific customer information");
        titlePadding(28);
        System.out.println("D. Delete specific employee information");
        titlePadding(28);
        System.out.println("E. Go back to Updates menu");
    }

    public static void updates3Submenu() {
        topMenu();
        titlePadding(25);
        System.out.println("Updates");
        titlePadding(32);
        System.out.println("3. Update Current Information");
        bottomMenu();
        titlePadding(31);
        System.out.println("A. Update specific eqipment");
        titlePadding(28);
        System.out.println("B. Update specific service");
        titlePadding(28);
        System.out.println("C. Update specific customer information");
        titlePadding(28);
        System.out.println("D. Update specific employee information");
        titlePadding(28);
        System.out.println("E. Go back to Updates menu");
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

    public static String readEntry(String prompt) {
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

    public static String readLine() {
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
