//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
//import java.sql.Date;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Updates {
    Updates() {
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
                    done=true;
                    break;
                default:
                    System.out.println("Not a valid option");
            }
        } while (!done);
    }
}

public static void updatesMenu() {
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

public static void changeEquipment(){
    boolean done = false;
        do {
            equipmentMenu();
            System.out.print("Type in your option: ");
            System.out.flush();
            String ch = CleanAndGo.readLine();
            System.out.println();

            switch (ch.charAt(0)){
                case '1':
                    Statement stmt = conn.createStatement();
                    System.out.print("Brand name: ");
                    System.out.flush();
                    String brand = CleanAndGo.readLine();
                    System.out.print("Purchase Date YYYY-MM-DD: ");
                    System.out.flush();
                    Date purchaseDate = CleanAndGo.readLine();
                    System.out.print("Purchase Price: ");
                    System.out.flush();
                    Double purchasePrice = CleanAndGo.readLine();
                    System.out.print("Equipment Type: ");
                    System.out.flush();
                    String equipmentType = CleanAndGo.readLine();
                    System.out.print("Equipment Lifespan (Months): ");
                    System.out.flush();
                    Double LifeSpanMonths = CleanAndGo.readLine();
                    System.out.print("Retire Date YYYY-MM-DD: ");
                    System.out.flush();
                    Date RetiredDate = CleanAndGo.readLine();
                    System.out.print("Supplier ID: ");
                    System.out.flush();
                    INT SupplierID = CleanAndGo.readLine();
                    System.out.print("Cycle Length in Minutes: ");
                    System.out.flush();
                    INT CycleLengthMin = CleanAndGo.readLine();


                    String query = "INSERT INTO Equipment(Brand, PurchaseDate, PurchasePrice, Type, LifeSpanMonths, RetiredDate, SupplierID, CycleLengthMin) "
                     + "VALUES (" + brand + ", " + purchaseDate + ", " + purchasePrice + ", " + equipmentType + ", " + LifeSpanMonths + ", "
                     + RetiredDate + ", " + SupplierID + ", " + CycleLengthMin + ")";
                    stmt.executeQuery(query);
                    System.out.println("Addition Complete!");
                    break;
                case '2':
                    System.out.println("Deletion Complete!");
                    break;
                case '3':
                    System.out.println("Update Complete!");
                    break;
                case '4':
                    done=true;
                    break;
                default:
                    System.out.println("Not a valid option");
            }
        } while (!done);
}

public static void equipmentMenu(){
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

public static void changeServices(){
    boolean done = false;
        do {
            servicesMenu();
            System.out.print("Type in your option: ");
            System.out.flush();
            String ch = CleanAndGo.readLine();
            System.out.println();

            switch (ch.charAt(0)){
                case '1':
                    
                    break;
                case '2':
                    
                    break;
                case '3':
                    
                    break;
                case '4':
                    done=true;
                    break;
                default:
                    System.out.println("Not a valid option");
            }
        } while (!done);
}

public static void servicesMenu(){
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

public static void changeCustomers(){
    boolean done = false;
        do {
            customersMenu();
            System.out.print("Type in your option: ");
            System.out.flush();
            String ch = CleanAndGo.readLine();
            System.out.println();

            switch (ch.charAt(0)){
                case '1':
                    
                    break;
                case '2':
                    
                    break;
                case '3':
                    
                    break;
                case '4':
                    done=true;
                    break;
                default:
                    System.out.println("Not a valid option");
            }
        } while (!done);
}

public static void customersMenu(){
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

public static void changeEmployees(){
    boolean done = false;
        do {
            customersMenu();
            System.out.print("Type in your option: ");
            System.out.flush();
            String ch = CleanAndGo.readLine();
            System.out.println();

            switch (ch.charAt(0)){
                case '1':
                    
                    break;
                case '2':
                    
                    break;
                case '3':
                    
                    break;
                case '4':
                    done=true;
                    break;
                default:
                    System.out.println("Not a valid option");
            }
        } while (!done);
}

public static void employeeMenu(){
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
}