import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Queries {

    public static void findAllSuppliers(Connection conn) throws SQLException, IOException {
        Statement stmt = conn.createStatement();

        String query = "SELECT s.id, s.Name FROM Supplier AS s";
        PreparedStatement p = conn.prepareStatement(query);

        p.clearParameters();

        ResultSet r = p.executeQuery();

        System.out.println("    Count New Customers");
        System.out.println("--------------------------------------------------\n");

        while (r.next()) {
            int id = r.getInt(1);
            String name = r.getString(2);

            System.out.println(id + " " + name);
        }

        // Close the statement
        stmt.close();
    }

    public static void selectAllCustomerNames(Connection conn) throws SQLException, IOException {
        Statement stmt = conn.createStatement();

        String query = "SELECT C.Name FROM Customer AS C";
        PreparedStatement p = conn.prepareStatement(query);

        p.clearParameters();

        ResultSet r = p.executeQuery();

        System.out.println("    Names of all Customers");
        System.out.println("--------------------------------------------------\n");

        while (r.next()) {
            String name = r.getString(1);

            System.out.println(name);
        }

        // Close the statement
        stmt.close();
    }

    public static void selectAllSupplierNames(Connection conn) throws SQLException, IOException {
        Statement stmt = conn.createStatement();

        String query = "SELECT S.Name FROM Supplier AS S";
        PreparedStatement p = conn.prepareStatement(query);

        p.clearParameters();

        ResultSet r = p.executeQuery();

        System.out.println("    Names of all Suppliers");
        System.out.println("--------------------------------------------------\n");

        while (r.next()) {
            String name = r.getString(1);

            System.out.println(name);
        }

        // Close the statement
        stmt.close();
    }
}
