import java.util.*;
import java.util.stream.Collectors;

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

    // UC9: Grouping
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));
    }

    // UC10: Total seats using reduce()
    public static int calculateTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)     // extract capacity
                .reduce(0, Integer::sum);   // sum all
    }

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
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Bogie Type: ");
                    String type = sc.nextLine();

                    System.out.print("Enter Capacity: ");
                    int capacity = sc.nextInt();

                    bogies.add(new Bogie(type, capacity));
                    System.out.println("Bogie added!");
                    break;

                case 2:
                    if (bogies.isEmpty()) {
                        System.out.println("No bogies available.");
                    } else {
                        bogies.forEach(System.out::println);
                    }
                    break;

                case 3:
                    Map<String, List<Bogie>> grouped = groupBogiesByType(bogies);
                    System.out.println("\nGrouped Bogies:");
                    grouped.forEach((k, v) -> {
                        System.out.println("\nType: " + k);
                        v.forEach(System.out::println);
                    });
                    break;

                case 4:
                    int total = calculateTotalSeats(bogies);
                    System.out.println("Total Seating Capacity: " + total);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}