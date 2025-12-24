import java.time.LocalDate;

public class CheckIn {
    public int moodScore;
    public String journalEntry;
    public String severity; // Needed for advanced features
    public LocalDate date;

    // Updated constructor to accept (int, String, String)
    public CheckIn(int moodScore, String journalEntry, String severity) {
        this.moodScore = moodScore;
        this.journalEntry = journalEntry;
        this.severity = severity;
        this.date = LocalDate.now();
    }

    @Override
    public String toString() {
        return date + " | Score: " + moodScore + " | Level: " + severity + " | Note: " + journalEntry;
    }
}
