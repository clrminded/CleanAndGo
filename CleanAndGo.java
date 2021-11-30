
class CleanAndGo {
    public static void main(String[] args) {
        topMenu();
        bottomMenu();
    }

    /*
     ************************************************************
     * Welcome To Clean-And-Go Shop
     * 2. Customers & Services
     ************************************************************
     */

    /*
     *****************************************************************************
     ***********
     * Welcome To Clean-And-Go Shop
     ***********
     *****************************************************************************
     * 1. Equipment and Supplies
     * 2. Customers and Services
     * 3. Employees
     * 4. Updates
     * 5. Quit
     * 
     */
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

    public static void titlePadding(int spaces) { // 25 spaces
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

    public static void printTitle(String menuTitle) {

        System.out.println("Welcome To Clean-And-Go Shop");

        if (menuTitle == "main") {
            System.out.println();
        } else {
            for (int i = 0; i < 28; i++) {
                System.out.print(" ");
            }
            System.out.println(menuTitle);
        }
    }

}
