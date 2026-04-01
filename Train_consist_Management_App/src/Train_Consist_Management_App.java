import java.util.LinkedHashSet;
import java.util.Set;

public class Train_Consist_Management_App {

    public static void main(String[] args) {

        // Welcome message
        System.out.println("=== Train Consist Management App ===");

        // Create LinkedHashSet for train formation
        Set<String> trainFormation = new LinkedHashSet<>();

        // Add bogies
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // Attempt to add duplicate
        trainFormation.add("Sleeper"); // duplicate (ignored)

        // Display final formation
        System.out.println("\nFinal Train Formation:");
        System.out.println(trainFormation);
    }
}