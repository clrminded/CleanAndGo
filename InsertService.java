import java.math.*;

public class InsertService {
    public static String selectServiceName() {
        String serviceName = "";
        System.out.println("Select one of the options available: ");
        System.out.println("1. Tier 1 Drying Service");
        System.out.println("2. Tier 2 Drying Service");
        System.out.println("3. Tier 3 Drying Service");
        System.out.println("4. Home Cleaning Service");
        System.out.println("5. Clothes Pressed");
        System.out.println("6. 2 Hour Coin Washing");
        System.out.println("7. 4 Hour Coin Washing");
        boolean nameChosen = false;
        do {

            System.out.flush();
            String itemName = Input.readLine();

            switch (itemName.charAt(0)) {
                case '1':
                    serviceName = "Tier 1 Drying Service";
                    nameChosen = true;
                    break;
                case '2':
                    serviceName = "Tier 2 Drying Service";
                    nameChosen = true;
                    break;
                case '3':
                    serviceName = "Tier 3 Drying Service";
                    nameChosen = true;
                    break;
                case '4':
                    serviceName = "Home Cleaning Service";
                    nameChosen = true;
                    break;
                case '5':
                    serviceName = "Clothes Pressed";
                    nameChosen = true;
                    break;
                case '6':
                    serviceName = "2 Hour Coin Washing";
                    nameChosen = true;
                    break;
                case '7':
                    serviceName = "4 Hour Coin Washing";
                    nameChosen = true;
                    break;
                default:
                    System.out.println("Please select a valid option");
            }
        } while (!nameChosen);

        return serviceName;
    };

    public static String selectServiceDesc() {
        System.out.print("Type in the service description: ");
        System.out.flush();
        String updates_ch = Input.readLine();
        return updates_ch;
    }

    public static Float selectServiceRate() {
        System.out.print("Type in the service rate: ");
        System.out.flush();
        Float updates_ch = Float.parseFloat(Input.readLine());
        BigDecimal value = new BigDecimal(updates_ch).setScale(2, RoundingMode.HALF_UP);
        return value.floatValue();
    }

    public static Double selectServiceDuration() {
        System.out.print("Type in the service duration: ");
        System.out.flush();
        Double updates_ch = Double.parseDouble(Input.readLine());
        return updates_ch;
    }
}
