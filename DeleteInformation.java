
//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DeleteInformation {
    public static void connectToDB(String username, String password) throws IOException {
        Connection conn = null;
        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect to the database
            String url = "jdbc:mysql://localhost:3306/CleanNGo?serverTimezone=UTC&useSSL=TRUE";

            conn = DriverManager.getConnection(url, username, password);

            boolean updatesDone = false;
            do {
                UI.updates2Submenu();
                System.out.print("Type in your option: ");
                System.out.flush();
                String updates_ch = Input.readLine();
                System.out.println();

                switch (updates_ch.charAt(0)) {
                    case 'A':
                    case 'a':
                        System.out.println("A. Delete specific eqipment");
                        break;
                    case 'B':
                    case 'b':
                        System.out.println("B. Delete specific service");
                        Queries.deleteService(conn, 1);
                        break;
                    case 'C':
                    case 'c':
                        System.out.println("C. Delete specific customer information");
                        break;
                    case 'D':
                    case 'd':
                        System.out.println("D. Delete specific employee information");
                        break;
                    case 'E':
                    case 'e':
                        System.out.println("4. Go back to updates menu");
                        updatesDone = true;
                        break;
                    default:
                        // repeats if non valid option is chosen
                        System.out.println(" Not a valid option ");
                }
            } while (!updatesDone);

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
