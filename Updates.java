
//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Updates {

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
                UI.updatesMain();
                System.out.print("Type in your option: ");
                System.out.flush();
                String updates_ch = Input.readLine();
                System.out.println();

                switch (updates_ch.charAt(0)) {
                    case '1':
                        // 1. Insert new information
                        System.out.println("Not implemented at this time");
                        InsertInformation.connectToDB(username, password);
                        break;
                    case '2':
                        // 2. Delete some information
                        DeleteInformation.connectToDB(username, password);
                        break;
                    case '3':
                        // 3. Update current information
                        System.out.println("Not implemented at this time");
                        break;
                    case '4':
                        // 4. Go back to main menu
                        System.out.println("4. Go back to main menu");
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

/*
 * String query = "INSERT INTO Service(Name, Description, Rate, DurationHours) "
 * + "VALUES (" + sName + ", " + desc + ", "
 * + rate + ", " + duration + ");";
 * 
 * String query =
 * "INSERT INTO Equipment(Brand, PurchaseDate, PurchasePrice, Type, LifeSpanMonths, RetiredDate, SupplieCycleLengthMin) "
 * + "VALUES (" + brand + ", " + purchaseDate + ", " + purchasePrice + ", " +
 * equipmentType + ", " + LifeSpanMonths
 * + ", " + RetiredDate + ", " + SupplierID + ", " + CycleLengthMin + ");";
 * 
 * String query = "UPDATE Equipment " + "SET Brand="+brand+", "+
 * "PurchaseDate="+purchaseDate+", "+ "PurchasePrice="+purchasePrice+", "
 * +"Type="+equipmentType+"; "+ "LifeSpanMonths="+LifeSpanMonths+", "+
 * "RetiredDate="+RetiredDate+", "+ "SupplierID="+SupplierID+", "
 * +"CycleLengthMin="+CycleLengthMin+", " + "WHERE id=" + equipmentID+";";
 * 
 */