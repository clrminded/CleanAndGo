//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Updates {
    public static void main(String args[]) throws SQLException {

        boolean done = false;
        do {
            updatesMenu();
            System.out.print("Type in your option: ");
            System.out.flush();
            String ch = CleanAndGo.readLine();
            System.out.println();
            switch (ch.charAt(0)){
                case '1':
                    changeEquipment();
                    break;
                case '2':
                    changeServices();
                    break;
                case '3':
                    changeCustomers();
                    break;
                case '4':
                    changeEmployees();
                    break;
                case '5':
                    CleanAndGo.connectToDB("student", "password");
                    done=true;
                    break;
                default:
                    System.out.println("Not a valid option");
            }
        } while (!done);
    }


public static void updatesMenu() {
    // options display for updates menu
    CleanAndGo.topMenu();
    CleanAndGo.titlePadding(25);
    System.out.println("Welcome to Clean-And-Go Shop");
    CleanAndGo.titlePadding(27);
    System.out.println("4. Updates");
    CleanAndGo.bottomMenu();
    CleanAndGo.titlePadding(25);
    System.out.println("1. Change Equipment");
    CleanAndGo.titlePadding(35);
    System.out.println("2. Change Services");
    CleanAndGo.titlePadding(33);
    System.out.println("3. Change Customer Information");
    CleanAndGo.titlePadding(33);
    System.out.println("4. Change Employee Information");
    CleanAndGo.titlePadding(25);
    System.out.println("5. Exit");
}

public static void changeEquipment() throws SQLException{
    // options menu to change equipment table
    boolean done = false;
        do {
            equipmentMenu();
            String user = CleanAndGo.readEntry("Userid: ");
            String password = CleanAndGo.readEntry("Password: ");
            String url = "jdbc:mysql://localhost:3306/CleanNGo?serverTimezone=UTC&useSSL=TRUE";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            System.out.print("Type in your option: ");
            System.out.flush();
            String ch = CleanAndGo.readLine();
            System.out.println();

            switch (ch.charAt(0)){
                case '1':
                    // inserts new equipment
                    System.out.print("Brand name: ");
                    System.out.flush();
                    String brand = CleanAndGo.readLine();
                    System.out.print("Purchase Date YYYY-MM-DD: ");
                    System.out.flush();
                    String purchaseDate = CleanAndGo.readLine();
                    System.out.print("Purchase Price: ");
                    System.out.flush();
                    String purchasePrice = CleanAndGo.readLine();
                    System.out.print("Equipment Type: ");
                    System.out.flush();
                    String equipmentType = CleanAndGo.readLine();
                    System.out.print("Equipment Lifespan (Months): ");
                    System.out.flush();
                    String LifeSpanMonths = CleanAndGo.readLine();
                    System.out.print("Retire Date YYYY-MM-DD: ");
                    System.out.flush();
                    String RetiredDate = CleanAndGo.readLine();
                    System.out.print("Supplier ID: ");
                    System.out.flush();
                    String SupplierID = CleanAndGo.readLine();
                    System.out.print("Cycle Length in Minutes: ");
                    System.out.flush();
                    String CycleLengthMin = CleanAndGo.readLine();


                    String query = "INSERT INTO Equipment(Brand, PurchaseDate, PurchasePrice, Type, LifeSpanMonths, RetiredDate, SupplierID, CycleLengthMin) "
                     + "VALUES (" + brand + ", " + purchaseDate + ", " + purchasePrice + ", " + equipmentType + ", " + LifeSpanMonths + ", "
                     + RetiredDate + ", " + SupplierID + ", " + CycleLengthMin + ");";
                    stmt.executeQuery(query);

                    query = "SELECT id, Brand from Equipment;";
                    ResultSet rset = stmt.executeQuery(query);
                    
                    System.out.println("Addition Complete!");
                    System.out.println("                       Equipment List");
                    System.out.println("-------------------------------------------------------------");
                    while(rset.next()){
                        Integer eID = rset.getInt(1);
                        String brandName = rset.getString(2);
                        System.out.println("Equipment ID: "+eID+ " Brand Name: "+brandName);
                    };
                    break;
                case '2':
                    // deletes equipment given id
                    System.out.print("Enter Equipment ID you wish to delete: ");
                    System.out.flush();
                    String equipmentID = CleanAndGo.readLine();

                    query = "DELETE FROM Equipment WHERE id="+ equipmentID + ";";
                    stmt.executeQuery(query); 
                    System.out.println("Deletion Complete!");
                    break;
                case '3':
                    // updates equipment given id
                    System.out.print("Enter Equipment ID you wish to update: ");
                    System.out.flush();
                    equipmentID = CleanAndGo.readLine();

                    System.out.print("Brand name: ");
                    System.out.flush();
                    brand = CleanAndGo.readLine();
                    System.out.print("Purchase Date YYYY-MM-DD: ");
                    System.out.flush();
                    purchaseDate = CleanAndGo.readLine();
                    System.out.print("Purchase Price: ");
                    System.out.flush();
                    purchasePrice = CleanAndGo.readLine();
                    System.out.print("Equipment Type: ");
                    System.out.flush();
                    equipmentType = CleanAndGo.readLine();
                    System.out.print("Equipment Lifespan (Months): ");
                    System.out.flush();
                    LifeSpanMonths = CleanAndGo.readLine();
                    System.out.print("Retire Date YYYY-MM-DD: ");
                    System.out.flush();
                    RetiredDate = CleanAndGo.readLine();
                    System.out.print("Supplier ID: ");
                    System.out.flush();
                    SupplierID = CleanAndGo.readLine();
                    System.out.print("Cycle Length in Minutes: ");
                    System.out.flush();
                    CycleLengthMin = CleanAndGo.readLine();

                    query = "UPDATE Equipment " + "SET Brand="+brand+", "+ "PurchaseDate="+purchaseDate+", "+ "PurchasePrice="+purchasePrice+", "
                    +"Type="+equipmentType+"; "+ "LifeSpanMonths="+LifeSpanMonths+", "+ "RetiredDate="+RetiredDate+", "+ "SupplierID="+SupplierID+", "
                    +"CycleLengthMin="+CycleLengthMin+", " + "WHERE id=" + equipmentID+";";
                    stmt.executeQuery(query);
                    System.out.println("Update Complete!");
                    break;
                case '4':
                    // exits menu
                    done=true;
                    break;
                default:
                    System.out.println("Not a valid option");
            }
        } while (!done);
}

public static void equipmentMenu(){
    // text menu for changeEquipment
    CleanAndGo.topMenu();
    CleanAndGo.titlePadding(25);
    System.out.println("Welcome to Clean-And-Go Shop");
    CleanAndGo.titlePadding(27);
    System.out.println("1. Change Equipment");
    CleanAndGo.bottomMenu();
    CleanAndGo.titlePadding(25);
    System.out.println("1. Add new Equipment");
    CleanAndGo.titlePadding(35);
    System.out.println("2. Delete Equipment");
    CleanAndGo.titlePadding(33);
    System.out.println("3. Update Equipment");
    CleanAndGo.titlePadding(25);
    System.out.println("4. Exit");
}

public static void changeServices() throws SQLException{
    // options menu to change services
    boolean done = false;
        do {
            servicesMenu();
            String user = CleanAndGo.readEntry("Userid: ");
            String password = CleanAndGo.readEntry("Password: ");
            String url = "jdbc:mysql://localhost:3306/CleanNGo?serverTimezone=UTC&useSSL=TRUE";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            System.out.print("Type in your option: ");
            System.out.flush();
            String ch = CleanAndGo.readLine();
            System.out.println();

            switch (ch.charAt(0)){
                case '1':
                    // inserts new service
                    System.out.println("Service Name: ");
                    System.out.flush();
                    String sName = CleanAndGo.readLine();

                    System.out.println("Service Description: ");
                    System.out.flush();
                    String desc = CleanAndGo.readLine();
                    
                    System.out.println("Service Price Rate per Hour: ");
                    System.out.flush();
                    String rate = CleanAndGo.readLine();

                    System.out.println("Service Duration in Hours:");
                    System.out.flush();
                    String duration = CleanAndGo.readLine();

                    String query = "INSERT INTO Service(Name, Description, Rate, DurationHours) " 
                    + "VALUES ("+sName+", "+desc+", "+rate+", "+duration+");";
                    stmt.executeQuery(query);
                    break;
                case '2':
                    // deletes service given id
                    query = "DELETE FROM Service";
                    stmt.executeQuery(query);
                    break;
                case '3':
                    // updates service given id
                    query = "UPDATE Service";
                    stmt.executeQuery(query);
                    break;
                case '4':   
                    // exits menu
                    done=true;
                    break;
                default:
                    System.out.println("Not a valid option");
            }
        } while (!done);
}

public static void servicesMenu(){
    // text menu for changeServices
    CleanAndGo.topMenu();
    CleanAndGo.titlePadding(25);
    System.out.println("Welcome to Clean-And-Go Shop");
    CleanAndGo.titlePadding(27);
    System.out.println("2. Change Service");
    CleanAndGo.bottomMenu();
    CleanAndGo.titlePadding(25);
    System.out.println("1. Add new Service");
    CleanAndGo.titlePadding(35);
    System.out.println("2. Delete Service");
    CleanAndGo.titlePadding(33);
    System.out.println("3. Update Service");
    CleanAndGo.titlePadding(25);
    System.out.println("4. Exit");
}

public static void changeCustomers() throws SQLException{   
    // options menu to change customers
    boolean done = false;
        do {
            customersMenu();
            String user = CleanAndGo.readEntry("Userid: ");
            String password = CleanAndGo.readEntry("Password: ");
            String url = "jdbc:mysql://localhost:3306/CleanNGo?serverTimezone=UTC&useSSL=TRUE";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            System.out.print("Type in your option: ");
            System.out.flush();
            String ch = CleanAndGo.readLine();
            System.out.println();

            switch (ch.charAt(0)){
                case '1':
                    // inserts new customer
                    String query = "";
                    stmt.executeQuery(query);
                    break;
                case '2':
                    // deletes customer given id
                    query = "";
                    stmt.executeQuery(query);
                    break;
                case '3':
                    // updates customer given id
                    query = "";
                    stmt.executeQuery(query);
                    break;
                case '4':
                    // exits menu
                    done=true;
                    break;
                default:
                    System.out.println("Not a valid option");
            }
        } while (!done);
}

public static void customersMenu(){
    // text menu for changeCustomers
    CleanAndGo.topMenu();
    CleanAndGo.titlePadding(25);
    System.out.println("Welcome to Clean-And-Go Shop");
    CleanAndGo.titlePadding(27);
    System.out.println("3. Change Customers");
    CleanAndGo.bottomMenu();
    CleanAndGo.titlePadding(25);
    System.out.println("1. Add new Customer");
    CleanAndGo.titlePadding(35);
    System.out.println("2. Delete Customer");
    CleanAndGo.titlePadding(33);
    System.out.println("3. Update Customer");
    CleanAndGo.titlePadding(25);
    System.out.println("4. Exit");
}

public static void changeEmployees() throws SQLException{
    // options menu to change employees
    boolean done = false;
        do {
            customersMenu();
            System.out.println("Userid: ");
            System.out.flush();
            String user = CleanAndGo.readLine();

            System.out.println("Password: ");
            System.out.flush();
            String password = CleanAndGo.readLine();

            String url = "jdbc:mysql://localhost:3306/CleanNGo?serverTimezone=UTC&useSSL=TRUE";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            System.out.print("Type in your option: ");
            System.out.flush();
            String ch = CleanAndGo.readLine();
            System.out.println();

            switch (ch.charAt(0)){
                case '1':
                    // inserts new employee
                    String query = "";
                    stmt.executeQuery(query);
                    break;
                case '2':
                    // deletes employee given id
                    query = "";
                    stmt.executeQuery(query);
                    break;
                case '3':
                    // updates employee given id
                    query = "";
                    stmt.executeQuery(query);
                    break;
                case '4':
                    // exits menu
                    done=true;
                    break;
                default:
                    System.out.println("Not a valid option");
            }
        } while (!done);
}

public static void employeeMenu(){
    // text menu for changeEmployee
    CleanAndGo.topMenu();
    CleanAndGo.titlePadding(25);
    System.out.println("Welcome to Clean-And-Go Shop");
    CleanAndGo.titlePadding(27);
    System.out.println("4. Change Employee");
    CleanAndGo.bottomMenu();
    CleanAndGo.titlePadding(25);
    System.out.println("1. Add new Employee");
    CleanAndGo.titlePadding(35);
    System.out.println("2. Delete Employee");
    CleanAndGo.titlePadding(33);
    System.out.println("3. Update Employee");
    CleanAndGo.titlePadding(25);
    System.out.println("4. Exit");
}}
