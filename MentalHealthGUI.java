import javax.swing.*;
import java.awt.*;

public class MentalHealthGUI {
    private EWSLogic ews = new EWSLogic();
    private JFrame frame;
    private JSlider moodSlider;
    private JTextArea journalArea;

    public MentalHealthGUI() {
        // 1. Initialize the Main Window
        frame = new JFrame("MindGuard EWS - Digital Well-being");
        frame.setSize(550, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(15, 15));

        // 2. Top Section: Mood Input
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        JLabel header = new JLabel("How are you feeling right now?", JLabel.CENTER);
        header.setFont(new Font("SansSerif", Font.BOLD, 16));
        
        moodSlider = new JSlider(1, 10, 5);
        moodSlider.setMajorTickSpacing(1);
        moodSlider.setPaintTicks(true);
        moodSlider.setPaintLabels(true);
        
        topPanel.add(header);
        topPanel.add(moodSlider);
        frame.add(topPanel, BorderLayout.NORTH);

        // 3. Center Section: Journaling
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createTitledBorder("Daily Journal Entry"));
        journalArea = new JTextArea();
        journalArea.setLineWrap(true);
        journalArea.setWrapStyleWord(true);
        centerPanel.add(new JScrollPane(journalArea), BorderLayout.CENTER);
        frame.add(centerPanel, BorderLayout.CENTER);

        // 4. Bottom Section: Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton submitBtn = new JButton("Submit Entry");
        JButton historyBtn = new JButton("History & Reports");
        JButton safetyBtn = new JButton("Safety Plan");
        JButton helpBtn = new JButton("EMERGENCY HELP");

        // Styling the Emergency Button
        helpBtn.setBackground(new Color(220, 20, 60)); // Crimson Red
        helpBtn.setForeground(Color.WHITE);
        helpBtn.setFocusPainted(false);

        buttonPanel.add(submitBtn);
        buttonPanel.add(historyBtn);
        buttonPanel.add(safetyBtn);
        buttonPanel.add(helpBtn);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // --- Logic Linkage (Action Listeners) ---

        submitBtn.addActionListener(e -> {
            int score = moodSlider.getValue();
            String note = journalArea.getText();
            // Pass "PENDING" as the severity, EWSLogic will update it
            CheckIn entry = new CheckIn(score, note, "PENDING");
            ews.processNewEntry(entry);
            
            checkSeverityPopup(score, note);
            journalArea.setText(""); // Clear for next time
        });

        historyBtn.addActionListener(e -> {
            ews.showHistory();
            ews.generateWeeklyReport();
            JOptionPane.showMessageDialog(frame, "History and Weekly Report printed to the console.");
        });

        safetyBtn.addActionListener(e -> ews.showSafetyPlan());

        helpBtn.addActionListener(e -> {
            String msg = "National Crisis Hotline: 988\nCrisis Text Line: Text HOME to 741741";
            JOptionPane.showMessageDialog(frame, msg, "Emergency Resources", JOptionPane.ERROR_MESSAGE);
        });

        frame.setVisible(true);
    }

    private void checkSeverityPopup(int score, String note) {
        if (score <= 3 || note.toLowerCase().contains("hurt") || note.toLowerCase().contains("suicide")) {
            JOptionPane.showMessageDialog(frame, 
                "Alert: We've noticed patterns of high distress.\nPlease consider viewing your Safety Plan.", 
                "Early Warning Triggered", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "Entry saved successfully. Keep taking care of yourself!");
        }
    }

    public static void main(String[] args) {
        // Start the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new MentalHealthGUI());
    }
}