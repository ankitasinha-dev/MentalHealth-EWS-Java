import java.io.*;
import java.util.*;

public class EWSLogic {
    // This list fixes the "history cannot be resolved" error
    private List<CheckIn> history = new ArrayList<>();
    private final String FILE_NAME = "mental_health_logs.txt";

    public void processNewEntry(CheckIn entry) {
        history.add(entry);
        analyze(entry);
        saveToFile(entry);
    }

    private void analyze(CheckIn entry) {
        if (entry.moodScore <= 3 || entry.journalEntry.contains("hurt")) {
            System.out.println("\n[!] ALERT: High distress detected.");
        }
    }

    // Fixes the "calculateAverageMood" and "generateWeeklyReport" errors
    public double calculateAverageMood() {
        if (history.isEmpty()) return 0;
        return history.stream().mapToInt(c -> c.moodScore).average().orElse(0);
    }

    public void generateWeeklyReport() {
        System.out.println("\n--- 📊 Weekly Report ---");
        System.out.println("Average Mood: " + calculateAverageMood());
    }

    // Fixes the "showHistory" error
    public void showHistory() {
        System.out.println("\n--- Full History ---");
        for (CheckIn c : history) System.out.println(c);
    }

    // Fixes the "showSafetyPlan" error
    public void showSafetyPlan() {
        System.out.println("\n--- 🛡️ Safety Plan ---");
        System.out.println("1. Deep breathing\n2. Call a friend\n3. Contact 988");
    }

    private void saveToFile(CheckIn entry) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(entry.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }
}