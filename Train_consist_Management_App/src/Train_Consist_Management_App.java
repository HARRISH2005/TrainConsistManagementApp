import java.util.HashSet;
import java.util.Set;

public class Train_Consist_Management_App {

    public static void main(String[] args) {

        // Welcome message
        System.out.println("=== Train Consist Management App ===");

        // Create HashSet for bogie IDs (ensures uniqueness)
        Set<String> bogieIds = new HashSet<>();

        // Add bogie IDs (including duplicates intentionally)
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        // Display unique bogie IDs
        System.out.println("\nUnique Bogie IDs:");
        System.out.println(bogieIds);

        // Program continues...
    }
}