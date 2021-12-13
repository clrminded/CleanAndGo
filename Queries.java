import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Queries {

    private static String getFirstOfMonth() {
        LocalDate today = LocalDate.now();
        return "'" + today.getYear() + "-" + today.getMonthValue() + "-01'";
    }

    private static String getFirstOfYear() {
        return getFirstOfYear(LocalDate.now().getYear());
    }

    private static String getFirstOfYear(int year) {
        return "'" + year + "-01-01'";
    }

    private static String getLastOfYear() {
        return getLastOfYear(LocalDate.now().getYear());
    }

    private static String getLastOfYear(int year) {
        return "'" + year + "-12-31'";
    }

    private static String getCurrentDate() {
        LocalDate today = LocalDate.now();
        return "'" + today.getYear() + "-" + today.getMonthValue() + "-" + today.getDayOfMonth() + "'";
    }

    private static String getSixMonthAgoStart() {
        LocalDate sixMonthsAgo = LocalDate.now().minusMonths(6);
        return "'" + sixMonthsAgo.getYear() + "-" + sixMonthsAgo.getMonthValue() + "-01'";
    }

    private static String getSixMonthAgoEnd() {
        LocalDate endOfMonth = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1).minusDays(1);
        return "'" + endOfMonth.getYear() + "-" + endOfMonth.getMonthValue() + "-" + endOfMonth.getDayOfMonth() + "'";
    }

    private static String getCurrentWeekStart() {
        LocalDate weekStart = LocalDate.now().minusDays(LocalDate.now().getDayOfWeek().getValue() - 1);
        return "'" + weekStart.getYear() + "-" + weekStart.getMonthValue() + "-" + weekStart.getDayOfMonth() + "'";
    }

    private static String getCurrentWeekEnd() {
        LocalDate weekEnd = LocalDate.now().minusDays(LocalDate.now().getDayOfWeek().getValue() - 7);
        return "'" + weekEnd.getYear() + "-" + weekEnd.getMonthValue() + "-" + weekEnd.getDayOfMonth() + "'";
    }

    /*
     * -------------- SPECIAL QUERIES ------------------------
     * -------------- SCENERIO 2 -----------------------------
     */
    public static void annualRevenuesFromServices(Connection conn) throws SQLException, IOException {
        Statement stmt = conn.createStatement();

        String query = "SELECT S.Name, SUM(L.Amount)  AS Total FROM Ledger AS L, Invoice AS I, Service AS S WHERE L.id = I.Ledger_id AND I.Service_id = S.id AND L.Type = 'Service' GROUP BY S.Name";
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

    public static void getCurrentYearNewCustomerCount(Connection conn) throws SQLException, IOException {
        Statement stmt = conn.createStatement();

        String query = "SELECT COUNT(*) FROM Customer WHERE Added >= " + getFirstOfYear() +
                " AND Added <= " + getLastOfYear() + ";";
        PreparedStatement p = conn.prepareStatement(query);

        p.clearParameters();

        ResultSet r = p.executeQuery();

        System.out.println(" Count of new customers of this current year");
        System.out.println("--------------------------------------------------\n");
        // valueOf("2021-01-01")
        // valueOf("2021-12-31")

        while (r.next()) {
            int count = r.getInt(1);

            System.out.println(count);
        }

        // Close the statement
        stmt.close();
    }

    public static void getCurrentMonthServiceTransactions(Connection conn) throws SQLException, IOException {
        Statement stmt = conn.createStatement();

        String query = "SELECT COUNT(L.Type) FROM Ledger AS L WHERE L.Type = 'Service' AND L.Date >= "
                + getFirstOfMonth() + " AND L.Date <= " + getCurrentDate() + ";";

        PreparedStatement p = conn.prepareStatement(query);

        p.clearParameters();

        ResultSet r = p.executeQuery();

        System.out.println(" Count of service transactions of the current month");
        System.out.println("--------------------------------------------------\n");

        while (r.next()) {
            int count = r.getInt(1);

            System.out.println(count);
        }

        // Close the statement
        stmt.close();
    }

    public static void mostRequestedServiceType(Connection conn) throws SQLException, IOException {
        Statement stmt = conn.createStatement();

        String query = "SELECT S.Name, COUNT(*) AS Total FROM Invoice AS I, Service AS S WHERE I.Service_id = S.id GROUP BY Service_id ORDER BY Total DESC LIMIT 1;";
        PreparedStatement p = conn.prepareStatement(query);

        p.clearParameters();

        ResultSet r = p.executeQuery();

        System.out.println("Most request service type: ");
        System.out.println("Name           Count");
        System.out.println("-----------------------------------------------------------------------------");

        while (r.next()) {
            String name = r.getString(1);
            int count = r.getInt(2);
            System.out.println(name + "        " + count);
        }

        // Close the statement
        stmt.close();
    }

    public static void perMonthServiceTransactions(Connection conn) throws SQLException, IOException {

        Statement stmt = conn.createStatement();

        String query = "SELECT COUNT(*) AS Total, MONTH(L.Date) AS Month FROM Ledger AS L WHERE L.Date <= "
                + getSixMonthAgoEnd() + " AND L.Date >= " + getSixMonthAgoStart() +
                " AND L.Type = 'Service' GROUP BY MONTH(L.Date);";

        PreparedStatement p = conn.prepareStatement(query);

        p.clearParameters();

        ResultSet r = p.executeQuery();

        System.out.println("Number of service transactions in the last completed 6 months: ");
        System.out.println("Dates from " + getSixMonthAgoStart() + " to " + getSixMonthAgoEnd());
        System.out.println("Count            Month");
        System.out.println("-----------------------------------------------------------------------------");

        while (r.next()) {
            int count = r.getInt(1);
            int month = r.getInt(2);
            System.out.println(count + "        " + month);
        }

        // Close the statement
        stmt.close();
    }

    /************************************************
     * ----------------- EMPLOYEE SCHEDULE ------------------------
     * -------------- SCENERIO 3 ---------------------
     *****************************************************/
    public static void getEmployeeSchedule(Connection conn, String id) throws SQLException, IOException {

        Statement stmt = conn.createStatement();

        String query = "SELECT E.id, ES.StartTime, ES.EndTime FROM Employee AS E, EmployeeSchedule AS ES WHERE E.id = ES.Employee_id AND ES.Employee_id = "
                + id + " AND ES.StartTime >= " + getCurrentWeekStart() + " AND ES.EndTime <= "
                + getCurrentWeekEnd();
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

    public static void servicesCustomerList(Connection conn, int id) throws SQLException, IOException {

        Statement stmt = conn.createStatement();

        String query = "SELECT C.id, C.Name FROM Customer AS C, Invoice AS I WHERE I.Customer_id = C.id AND I.Service_id = "
                + id + " GROUP BY C.id;";

        PreparedStatement p = conn.prepareStatement(query);

        p.clearParameters();

        ResultSet r = p.executeQuery();

        System.out.println("Customer Names that have used service");
        System.out.println("-----------------------------------------------------------------------------");

        while (r.next()) {
            String name = r.getString(2);

            System.out.println(name);
        }

        // Close the statement
        stmt.close();

    }

    public static void numberOfCustomerPerYear(Connection conn, int year) throws SQLException, IOException {
        Statement stmt = conn.createStatement();

        String query = "SELECT COUNT(*) AS Total, MONTH(C.Added) AS Month FROM Customer AS C WHERE C.Added >= "
                + getFirstOfYear(year)
                + " AND C.Added <= " + getLastOfYear(year) + " GROUP BY MONTH(C.Added);";

        PreparedStatement p = conn.prepareStatement(query);

        p.clearParameters();

        ResultSet r = p.executeQuery();

        System.out.println("Number of Customers for the year of " + year);
        System.out.println("Count           Month");
        System.out.println("-----------------------------------------------------------------------------");

        while (r.next()) {
            int count = r.getInt(1);
            int month = r.getInt(2);

            System.out.println(count + "        " + month);
        }

        // Close the statement
        stmt.close();
    }

    /************************************************
     * -----------------DELETE ------------------------
     * -------------- SCENERIO 1 ---------------------
     *********************************************/

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

    public static void deleteEmployee(Connection conn, int id) throws SQLException, IOException {

        Statement stmt = conn.createStatement();

        String query = "delete from Employee " +
                "where id =" + id;

        stmt.executeUpdate(query);

        System.out.println("Record is deleted from the Employee table successfully....");
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
