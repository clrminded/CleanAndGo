
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

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/CleanNGo?serverTimezone=UTC&useSSL=TRUE";

            conn = DriverManager.getConnection(url, username, password);

            boolean equipmentDone = false;
            do {
                UI.equipmentSupplyMain();
                System.out.print("Type in your option: ");
                System.out.flush();
                String equip_ch = Input.readLine();
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
                        System.out.println(" Not a valid option ");
                }
            } while (!equipmentDone);

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
