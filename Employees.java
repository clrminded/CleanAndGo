import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Employees {
    public static void connectToDB(String username, String password) throws IOException {
        Connection conn = null;
        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect to the database
            String url = "jdbc:mysql://localhost:3306/CleanNGo?serverTimezone=UTC&useSSL=TRUE";

            conn = DriverManager.getConnection(url, username, password);

            // main menu option 3 employee menu
            boolean employeeDone = false;
            do {
                UI.employeeMain();
                System.out.print("Type in your option: ");
                System.out.flush();
                String employee_ch = Input.readLine();
                System.out.println();

                switch (employee_ch.charAt(0)) {
                    case '1':
                        System.out.println("Please enter your employeeID: ");
                        System.out.flush();
                        String employeeID_ch = Input.readLine();
                        Queries.getEmployeeSchedule(conn, employeeID_ch);
                        break;
                    case '2':
                        UI.titlePadding(27);
                        System.out.println("2. Go back to main menu");
                        employeeDone = true;
                        break;
                    default:
                        // repeats if non valid option is chosen
                        System.out.println(" Not a valid option ");
                }
            } while (!employeeDone);

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
