import java.util.*;
import java.util.stream.*;

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

// Main Class
public class TrainConsistManagementApp {

    // Loop-based filtering
    public static List<Bogie> filterUsingLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // Stream-based filtering
    public static List<Bogie> filterUsingStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        // Create dataset (large for benchmarking)
        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Sleeper", (i % 100) + 1));
        }

        // ================= LOOP =================
        long startLoop = System.nanoTime();

        List<Bogie> loopResult = filterUsingLoop(bogies);

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // ================= STREAM =================
        long startStream = System.nanoTime();

        List<Bogie> streamResult = filterUsingStream(bogies);

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // ================= OUTPUT =================
        System.out.println("Loop Result Size: " + loopResult.size());
        System.out.println("Stream Result Size: " + streamResult.size());

        System.out.println("\nExecution Time:");
        System.out.println("Loop Time   : " + loopTime + " ns");
        System.out.println("Stream Time : " + streamTime + " ns");

        // Consistency check
        if (loopResult.size() == streamResult.size()) {
            System.out.println("\nResults are CONSISTENT ✅");
        } else {
            System.out.println("\nResults are NOT CONSISTENT ❌");
        }
    }
}