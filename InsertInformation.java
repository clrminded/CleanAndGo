
//import java.io.BufferedReader;
import java.io.IOException;
import java.math.*;
//import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertInformation {
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
                UI.updates1Submenu();
                System.out.print("Type in your option: ");
                System.out.flush();
                String updates_ch = Input.readLine();
                System.out.println();

                switch (updates_ch.charAt(0)) {
                    case 'A':
                    case 'a':
                        System.out.println("A. Add new equipment");
                        break;
                    case 'B':
                    case 'b':
                        System.out.println("B. Add new service");
                        Queries.addNewService(conn);
                        break;
                    case 'C':
                    case 'c':
                        System.out.println("C. Add new customer information");
                        break;
                    case 'D':
                    case 'd':
                        System.out.println("D. Add new employee information");
                        break;
                    case 'E':
                    case 'e':
                        System.out.println("E. Go back to updates menu");
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

    public static String selectServiceName() {
        System.out.print("Type in the service name: ");
        System.out.flush();
        String updates_ch = Input.readLine();
        return updates_ch;
    };

    public static String selectServiceDesc() {
        System.out.print("Type in the service description: ");
        System.out.flush();
        String updates_ch = Input.readLine();
        return updates_ch;
    }

    public static Float selectServiceRate() {
        System.out.print("Type in the service rate: ");
        System.out.flush();
        Float updates_ch = Float.parseFloat(Input.readLine());
        BigDecimal value = new BigDecimal(updates_ch).setScale(2, RoundingMode.HALF_UP);
        return value.floatValue();
    }

    public static Double selectServiceDuration() {
        System.out.print("Type in the service duration: ");
        System.out.flush();
        Double updates_ch = Double.parseDouble(Input.readLine());
        return updates_ch;
    }

}
