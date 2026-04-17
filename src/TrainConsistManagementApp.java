import java.util.*;

// Goods Bogie class
class GoodsBogie {
    private String type;
    private String cargo;

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "GoodsBogie{type='" + type + "', cargo='" + cargo + "'}";
    }
}

// Main Application
public class TrainConsistManagementApp {

    // UC12: Safety Validation
    public static boolean isTrainSafe(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b ->
                        !b.getType().equalsIgnoreCase("Cylindrical") ||
                                b.getCargo().equalsIgnoreCase("Petroleum")
                );
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<GoodsBogie> bogies = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== Train Safety Management (UC12) =====");
            System.out.println("1. Add Goods Bogie");
            System.out.println("2. View Bogies");
            System.out.println("3. Check Safety Compliance");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Bogie Type (Cylindrical/Open/Box): ");
                    String type = sc.nextLine();

                    System.out.print("Enter Cargo: ");
                    String cargo = sc.nextLine();

                    bogies.add(new GoodsBogie(type, cargo));
                    System.out.println("Bogie added successfully!");
                    break;

                case 2:
                    if (bogies.isEmpty()) {
                        System.out.println("No bogies available.");
                    } else {
                        System.out.println("\nList of Goods Bogies:");
                        bogies.forEach(System.out::println);
                    }
                    break;

                case 3:
                    boolean isSafe = isTrainSafe(bogies);

                    System.out.println("\nSafety Status:");
                    if (isSafe) {
                        System.out.println("Train is SAFETY COMPLIANT ✅");
                    } else {
                        System.out.println("Train is NOT SAFE ❌");
                    }
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}