
//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.sql.Connection;
//import java.sql.Date;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Equipment {
    Equipment() {
        boolean done = false;
        do {
            equipmentSupplyMenu();
            System.out.print("Type in your option: ");
            System.out.flush();
            String ch = CleanAndGo.readLine();
            System.out.println();

            switch (ch.charAt(0)) {
                case '1':
                    System.out.println("Not implemented yet");
                    break;
                case '2':
                    System.out.println("Not implemented yet");
                    break;
                case '3':
                    System.out.println("Not implemented yet");
                    break;
                case '4':
                    System.out.println("Not implemented yet");
                    break;
                case '5':
                    // CleanAndGo mainMenu = new CleanAndGo();
                    done = true;
                    break;
                default:
                    System.out.println(" Not a valid option ");
            } // switch

        } while (!done);
    }

    public static void equipmentSupplyMenu() {
        CleanAndGo.topMenu();
        CleanAndGo.titlePadding(25);
        System.out.println("Welcome To Clean-And-Go Shop");
        CleanAndGo.titlePadding(27);
        System.out.println("1. Equipment & Supplies");
        CleanAndGo.bottomMenu();
        CleanAndGo.titlePadding(25);
        System.out.println("1. Analyze the progress of the business.");
        CleanAndGo.titlePadding(35);
        System.out.println("2. Equipment");
        CleanAndGo.titlePadding(33);
        System.out.println("3. Supplies");
        CleanAndGo.titlePadding(25);
        System.out.println("Go back to main menu");
    }

    public void findAllEquipment(Connection conn) throws SQLException, IOException {
        /*
         * In this method your SQL Query should return the ssn, Lname, FirstName and
         * Salary for all employees ordered by the highest salary
         */
        Equipment.equipmentSupplyMenu();
        // STEP1: CREATE VARIABLE OF TYPE STATEMENT

        Statement stmt = conn.createStatement();

        // STEP 2 DEFINE A STRING THAT IS = TO YOUR query SQL Statement

        String query = "select Name from CleaningSupplies";
        PreparedStatement p = conn.prepareStatement(query);
        p.clearParameters();

        // Step 3: Declare a variable with ResultSet type
        ResultSet r = p.executeQuery();
        // Execute your Query and store the return in the declared variable from step 3
        System.out.println("    equipment");
        System.out.println("--------------------------------------------------\n");

        // Write a loop to read all the returned rows from the query execution
        while (r.next()) {
            String name = r.getString(1);
            System.out.println("Name: " + name);
        }

        // Close the statement
        stmt.close();
    }

}
