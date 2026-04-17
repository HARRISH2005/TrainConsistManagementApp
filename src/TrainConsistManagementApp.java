import java.util.*;

// ================= Custom Exception =================
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// ================= Passenger Bogie =================
class PassengerBogie {
    private String type;
    private int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
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
        return "PassengerBogie{type='" + type + "', capacity=" + capacity + "}";
    }
}

// ================= Main Application =================
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<PassengerBogie> bogies = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== Train Passenger Management (UC14) =====");
            System.out.println("1. Add Passenger Bogie");
            System.out.println("2. View All Bogies");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    try {
                        System.out.print("Enter Bogie Type (Sleeper/AC Chair/First Class): ");
                        String type = sc.nextLine();

                        System.out.print("Enter Capacity: ");
                        int capacity = sc.nextInt();

                        PassengerBogie bogie = new PassengerBogie(type, capacity);
                        bogies.add(bogie);

                        System.out.println("Bogie added successfully! ✅");

                    } catch (InvalidCapacityException e) {
                        System.out.println("Error: " + e.getMessage() + " ❌");
                    }
                    break;

                case 2:
                    if (bogies.isEmpty()) {
                        System.out.println("No bogies available.");
                    } else {
                        System.out.println("\nPassenger Bogies:");
                        bogies.forEach(System.out::println);
                    }
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}