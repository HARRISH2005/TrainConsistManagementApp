import java.util.*;
import java.util.stream.Collectors;

// Base Bogie class
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

    // Method to group bogies
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));
    }

    // Method to display grouped bogies
    public static void displayGroupedBogies(Map<String, List<Bogie>> groupedBogies) {
        if (groupedBogies.isEmpty()) {
            System.out.println("No bogies available to display.");
            return;
        }

        System.out.println("\nGrouped Bogies by Type:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\nType: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println(b);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Bogie> bogies = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== Train Consist Management =====");
            System.out.println("1. Add Bogie");
            System.out.println("2. View All Bogies");
            System.out.println("3. Group Bogies by Type");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

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
                        System.out.println("No bogies added yet.");
                    } else {
                        System.out.println("\nAll Bogies:");
                        for (Bogie b : bogies) {
                            System.out.println(b);
                        }
                    }
                    break;

                case 3:
                    Map<String, List<Bogie>> grouped = groupBogiesByType(bogies);
                    displayGroupedBogies(grouped);
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}