
//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EquipmentAndSupplies {

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
            // main menu option 1 equipment & supplie menu
            boolean equipmentDone = false;
            do {
                equipmentSupplyMenu();
                System.out.print("Type in your option: ");
                System.out.flush();
                String equip_ch = CleanAndGo.readLine();
                System.out.println();

                switch (equip_ch.charAt(0)) {
                    case '1':
                        System.out.println("1. Analyze the progress of the business.");
                        System.out.println("Not implemented at this time");
                        break;
                    case '2':
                        System.out.println("2. Equipment");
                        System.out.println("Not implemented at this time");
                        break;
                    case '3':
                        System.out.println("3. Supplies");
                        System.out.println("Not implemented at this time");
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

        } catch (ClassNotFoundException e) {
            System.out.println("Could not load the driver");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void equipmentSupplyMenu() {
        CleanAndGo.topMenu();
        CleanAndGo.titlePadding(25);
        System.out.println("Welcome To Clean-And-Go Shop");
        CleanAndGo.titlePadding(27);
        System.out.println("1. Equipment & Supplies");
        CleanAndGo.bottomMenu();
        CleanAndGo.titlePadding(20);
        System.out.println("1. Analyze the progress of the business.");
        CleanAndGo.titlePadding(33);
        System.out.println("2. Equipment");
        CleanAndGo.titlePadding(33);
        System.out.println("3. Supplies");
        CleanAndGo.titlePadding(28);
        System.out.println("4. Go back to main menu");
    }

}
