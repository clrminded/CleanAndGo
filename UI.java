public class UI {

    public static void topMenu() {
        for (int i = 0; i < 77; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < 32; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < 11; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void titlePadding(int spaces) { // 25 spaces // for main
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
    }

    public static void bottomMenu() {
        for (int i = 0; i < 32; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < 11; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < 77; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void mainMenu() {
        topMenu();
        titlePadding(25);
        System.out.println("Welcome To Clean-And-Go Shop");
        bottomMenu();
        titlePadding(27);
        System.out.println("1. Equipment & Supplies");
        titlePadding(27);
        System.out.println("2. Customers & Services");
        titlePadding(32);
        System.out.println("3. Employees");
        titlePadding(33);
        System.out.println("4. Updates");
        titlePadding(34);
        System.out.println("5. Quit");
    }

    public static void equipmentSupplyMain() {
        topMenu();
        titlePadding(25);
        System.out.println("Welcome To Clean-And-Go Shop");
        titlePadding(27);
        System.out.println("1. Equipment & Supplies");
        bottomMenu();
        titlePadding(20);
        System.out.println("1. Analyze the progress of the business.");
        titlePadding(33);
        System.out.println("2. Equipment");
        titlePadding(33);
        System.out.println("3. Supplies");
        titlePadding(28);
        System.out.println("4. Go back to main menu");
    }

    public static void customersAndServiceMain() {
        topMenu();
        titlePadding(25);
        System.out.println("Welcome To Clean-And-Go Shop");
        titlePadding(27);
        System.out.println("2. Customers & Services");
        bottomMenu();
        titlePadding(20);
        System.out.println("1. Analyze the progress of the business");
        titlePadding(33);
        System.out.println("2. Services");
        titlePadding(33);
        System.out.println("3. Customers");
        titlePadding(28);
        System.out.println("4. Go back to main menu");
    }

    public static void csSubmenu1() {
        topMenu();
        titlePadding(27);
        System.out.println("Customers & Services");
        titlePadding(20);
        System.out.println("1. Analyze the progress of the business");
        bottomMenu();
        titlePadding(22);
        System.out.println("A. Total number of new customers.");
        titlePadding(20);
        System.out.println("B. Total number of service transactions.");
        titlePadding(21);
        System.out.println("C. Go back to customers & services menu");

    }

    public static void csSubmenu2() {
        topMenu();
        titlePadding(27);
        System.out.println("Customers & Services");
        titlePadding(30);
        System.out.println("2. Services");
        bottomMenu();
        titlePadding(27);
        System.out.println("A. Requested Services.");
        titlePadding(27);
        System.out.println("B. Service transactions.");
        titlePadding(23);
        System.out.println("C. Annual revenues from services");
        titlePadding(21);
        System.out.println("D. Go back to customers & services menu");
    }

    public static void csSubmenu3() {
        topMenu();
        titlePadding(27);
        System.out.println("Customers & Services");
        titlePadding(20);
        System.out.println("3. Customers");
        bottomMenu();
        titlePadding(22);
        System.out.println("A. Customer list for a service.");
        titlePadding(20);
        System.out.println("B. Customer number.");
        titlePadding(21);
        System.out.println("C. Go back to customers & services menu");

    }

    public static void employeeMain() {
        topMenu();
        titlePadding(25);
        System.out.println("Welcome To Clean-And-Go Shop");
        titlePadding(31);
        System.out.println("3. Employees");
        bottomMenu();
        titlePadding(28);
        System.out.println("1. Get Working Schedule");
        titlePadding(28);
        System.out.println("2. Go back to main menu");
    }

    public static void updatesMain() {
        topMenu();
        titlePadding(25);
        System.out.println("Welcome To Clean-And-Go Shop");
        titlePadding(32);
        System.out.println("4. Updates");
        bottomMenu();
        titlePadding(31);
        System.out.println("1. Insert new information");
        titlePadding(28);
        System.out.println("2. Delete some information");
        titlePadding(28);
        System.out.println("3. Update current information");
        titlePadding(28);
        System.out.println("4. Go back to main menu");
    }

    public static void updates1Submenu() {
        topMenu();
        titlePadding(25);
        System.out.println("Updates");
        titlePadding(32);
        System.out.println("1. Insert New Information");
        bottomMenu();
        titlePadding(31);
        System.out.println("A. Add new equipment");
        titlePadding(28);
        System.out.println("B. Add new service");
        titlePadding(28);
        System.out.println("C. Add new customer information");
        titlePadding(28);
        System.out.println("D. Add new employee information");
        titlePadding(28);
        System.out.println("E. Go back to Updates menu");
    }

    public static void updates2Submenu() {
        topMenu();
        titlePadding(25);
        System.out.println("Updates");
        titlePadding(32);
        System.out.println("2. Delete some information");
        bottomMenu();
        titlePadding(31);
        System.out.println("A. Delete specific eqipment");
        titlePadding(28);
        System.out.println("B. Delete specific service");
        titlePadding(28);
        System.out.println("C. Delete specific customer information");
        titlePadding(28);
        System.out.println("D. Delete specific employee information");
        titlePadding(28);
        System.out.println("E. Go back to Updates menu");
    }

    public static void updates3Submenu() {
        topMenu();
        titlePadding(25);
        System.out.println("Updates");
        titlePadding(32);
        System.out.println("3. Update Current Information");
        bottomMenu();
        titlePadding(31);
        System.out.println("A. Update specific eqipment");
        titlePadding(28);
        System.out.println("B. Update specific service");
        titlePadding(28);
        System.out.println("C. Update specific customer information");
        titlePadding(28);
        System.out.println("D. Update specific employee information");
        titlePadding(28);
        System.out.println("E. Go back to Updates menu");
    }

    public static void exitMain() {
        topMenu();
        titlePadding(20);
        System.out.println("Thank You For Visiting Clean-And-Go Shop");
        titlePadding(21);
        System.out.println("Have A Wonderful Day, See You Next Time");
        bottomMenu();
    }

}
