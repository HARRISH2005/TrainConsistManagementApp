import java.util.*;

// ================= Custom Runtime Exception =================
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// ================= Goods Bogie Class =================
class GoodsBogie {
    private String type;
    private String cargo;

    public GoodsBogie(String type) {
        this.type = type;
        this.cargo = "None";
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    // UC15: Safe Cargo Assignment with try-catch-finally
    public void assignCargo(String cargo) {
        try {
            // Business rule
            if (type.equalsIgnoreCase("Rectangular") &&
                    cargo.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "Unsafe Assignment: Petroleum cannot be assigned to Rectangular bogie"
                );
            }

            this.cargo = cargo;
            System.out.println("Cargo assigned successfully! ✅");

        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage() + " ❌");

        } finally {
            System.out.println("Operation completed (logged in finally block).\n");
        }
    }

    @Override
    public String toString() {
        return "GoodsBogie{type='" + type + "', cargo='" + cargo + "'}";
    }
}

// ================= Main Application =================
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<GoodsBogie> bogies = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== Train Consist Management (UC15) =====");
            System.out.println("1. Add Goods Bogie");
            System.out.println("2. Assign Cargo");
            System.out.println("3. View Bogies");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Bogie Type (Rectangular/Cylindrical): ");
                    String type = sc.nextLine();

                    bogies.add(new GoodsBogie(type));
                    System.out.println("Bogie added successfully! ✅");
                    break;

                case 2:
                    if (bogies.isEmpty()) {
                        System.out.println("No bogies available.");
                        break;
                    }

                    System.out.print("Enter Bogie Index (0 to " + (bogies.size() - 1) + "): ");
                    int index = sc.nextInt();
                    sc.nextLine();

                    if (index < 0 || index >= bogies.size()) {
                        System.out.println("Invalid index!");
                        break;
                    }

                    System.out.print("Enter Cargo: ");
                    String cargo = sc.nextLine();

                    bogies.get(index).assignCargo(cargo);
                    break;

                case 3:
                    if (bogies.isEmpty()) {
                        System.out.println("No bogies available.");
                    } else {
                        System.out.println("\nGoods Bogies:");
                        for (int i = 0; i < bogies.size(); i++) {
                            System.out.println(i + " -> " + bogies.get(i));
                        }
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