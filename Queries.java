import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.Time;
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

    public static void annualRevenuesFromServices(Connection conn) throws SQLException, IOException {
        Statement stmt = conn.createStatement();

        String query = "SELECT L.Type, SUM(L.Amount) FROM Ledger AS L GROUP BY L.Type";
        PreparedStatement p = conn.prepareStatement(query);

        p.clearParameters();

        ResultSet r = p.executeQuery();

        System.out.println("    Service Type         Total Revenues");
        System.out.println("--------------------------------------------------\n");

        while (r.next()) {
            String name = r.getString(1);
            Float amount = r.getFloat(2);
            System.out.print(name);
            System.out.println("      " + amount);
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

    // Scenerio 3 Query
    public static void getEmployeeSchedule(Connection conn, String id) throws SQLException, IOException {

        Statement stmt = conn.createStatement();

        String query = "SELECT E.id, ES.StartTime, ES.EndTime FROM Employee AS E, EmployeeSchedule AS ES WHERE E.id = ES.Employee_id AND ES.Employee_id = "
                + id;
        PreparedStatement p = conn.prepareStatement(query);

        p.clearParameters();

        ResultSet r = p.executeQuery();

        System.out.println("EmployeeID: " + id);
        System.out.println("-----------------------------------------------------------------------------");

        while (r.next()) {
            Date dtm_date = r.getDate(2);
            Time dtm_start = r.getTime(2);
            Time dtm_end = r.getTime(3);

            System.out.println("Date        Start Time                         End Time");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println(dtm_date + "  " + dtm_start + "                           " + dtm_end);

        }

        // Close the statement
        stmt.close();
    }

    /************************************************
     * -----------------DELETE ------------------------
     ***************************************/

    public static void deleteEquipment(Connection conn, int id) throws SQLException, IOException {

        Statement stmt = conn.createStatement();

        String query = "delete from Equipment " +
                "where id =" + id;

        stmt.executeUpdate(query);

        System.out.println("Record is deleted from the Equipment table successfully....");
    }

    public static void showEquipmentList(Connection conn) throws SQLException, IOException {
        Statement stmt = conn.createStatement();

        String query = "SELECT id, Brand FROM Equipment;";

        PreparedStatement p = conn.prepareStatement(query);

        p.clearParameters();

        ResultSet r = p.executeQuery();

        System.out.println("All Available Equipment");
        System.out.println("-----------------------------------------------------------------------------");

        while (r.next()) {
            int id = r.getInt(1);
            String brand = r.getString(2);

            System.out.println(id + "    " + brand);
        }

        stmt.close();
    }

    public static void deleteService(Connection conn, int id) throws SQLException, IOException {

        Statement stmt = conn.createStatement();

        String query = "delete from Service " +
                "where id =" + id;

        stmt.executeUpdate(query);

        System.out.println("Record is deleted from the Services table successfully....");
    }

    public static void showServiceList(Connection conn) throws SQLException, IOException {
        Statement stmt = conn.createStatement();

        String query = "SELECT id, Name FROM Service;";

        PreparedStatement p = conn.prepareStatement(query);

        p.clearParameters();

        ResultSet r = p.executeQuery();

        System.out.println("All Available Services");
        System.out.println("-----------------------------------------------------------------------------");

        while (r.next()) {
            int id = r.getInt(1);
            String name = r.getString(2);

            System.out.println(id + "    " + name);
        }

        stmt.close();
    }

    public static void deleteCustomer(Connection conn, int id) throws SQLException, IOException {

        Statement stmt = conn.createStatement();

        String query = "delete from Customer " +
                "where id =" + id;

        stmt.executeUpdate(query);

        System.out.println("Record is deleted from the Customer table successfully....");
    }

    public static void deleteEmployee(Connection conn, int id) throws SQLException, IOException {

        Statement stmt = conn.createStatement();

        String query = "delete from Employee " +
                "where id =" + id;

        stmt.executeUpdate(query);

        System.out.println("Record is deleted from the Employee table successfully....");
    }

    public static void showCustomerList(Connection conn) throws SQLException, IOException {
        Statement stmt = conn.createStatement();

        String query = "SELECT id, Name FROM Customer;";

        PreparedStatement p = conn.prepareStatement(query);

        p.clearParameters();

        ResultSet r = p.executeQuery();

        System.out.println("All Available Customers");
        System.out.println("-----------------------------------------------------------------------------");

        while (r.next()) {
            int id = r.getInt(1);
            String name = r.getString(2);

            System.out.println(id + "    " + name);
        }

        stmt.close();
    }

    public static void showEmployeeList(Connection conn) throws SQLException, IOException {
        Statement stmt = conn.createStatement();

        String query = "SELECT id, Name FROM Employee;";

        PreparedStatement p = conn.prepareStatement(query);

        p.clearParameters();

        ResultSet r = p.executeQuery();

        System.out.println("All Available Employee");
        System.out.println("-----------------------------------------------------------------------------");

        while (r.next()) {
            int id = r.getInt(1);
            String name = r.getString(2);

            System.out.println(id + "    " + name);
        }

        stmt.close();
    }

}
