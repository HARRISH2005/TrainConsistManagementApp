import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.*;

// Bogie class
class Bogie {
    private String type;
    private int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Bogie{type='" + type + "', capacity=" + capacity + "}";
    }
}

// Main Application
public class TrainConsistManagementApp {

    // ================= UC9 =================
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));
    }

    // ================= UC10 =================
    public static int calculateTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
    }

    // ================= UC11 =================
    public static boolean validateTrainID(String trainId) {
        String regex = "TRN-\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(trainId);
        return matcher.matches();
    }

    public static boolean validateCargoCode(String cargoCode) {
        String regex = "PET-[A-Z]{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Bogie> bogies = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== Train Consist Management =====");
            System.out.println("1. Add Bogie");
            System.out.println("2. View All Bogies");
            System.out.println("3. Group Bogies (UC9)");
            System.out.println("4. Total Seats (UC10)");
            System.out.println("5. Validate Train ID & Cargo Code (UC11)");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Bogie Type (Sleeper/AC Chair/First Class): ");
                    String type = sc.nextLine();

                    System.out.print("Enter Capacity: ");
                    int capacity = sc.nextInt();

                    bogies.add(new Bogie(type, capacity));
                    System.out.println("Bogie added successfully!");
                    break;

                case 2:
                    if (bogies.isEmpty()) {
                        System.out.println("No bogies available.");
                    } else {
                        System.out.println("\nAll Bogies:");
                        bogies.forEach(System.out::println);
                    }
                    break;

                case 3:
                    Map<String, List<Bogie>> grouped = groupBogiesByType(bogies);
                    if (grouped.isEmpty()) {
                        System.out.println("No bogies to group.");
                    } else {
                        System.out.println("\nGrouped Bogies:");
                        grouped.forEach((k, v) -> {
                            System.out.println("\nType: " + k);
                            v.forEach(System.out::println);
                        });
                    }
                    break;

                case 4:
                    int total = calculateTotalSeats(bogies);
                    System.out.println("Total Seating Capacity: " + total);
                    break;

                case 5:
                    System.out.print("Enter Train ID (format TRN-1234): ");
                    String trainId = sc.nextLine();

                    System.out.print("Enter Cargo Code (format PET-AB): ");
                    String cargoCode = sc.nextLine();

                    boolean isTrainValid = validateTrainID(trainId);
                    boolean isCargoValid = validateCargoCode(cargoCode);

                    System.out.println("\nValidation Results:");
                    System.out.println("Train ID: " + (isTrainValid ? "Valid" : "Invalid"));
                    System.out.println("Cargo Code: " + (isCargoValid ? "Valid" : "Invalid"));
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}