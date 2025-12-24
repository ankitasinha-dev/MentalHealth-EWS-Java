MindGuard: Mental Health Early Warning System
MindGuard is a Java-based desktop application designed to act as a digital safety net. It allows users to track their daily mood and thoughts while utilizing an "Early Warning" logic to detect high-risk keywords or significant mood drops.

 Key Features
Interactive Mood Slider: A graphical interface using Java Swing to quantify emotional states from 1-10.

Smart Sentiment Analysis: Scans journal entries for "red flag" keywords to provide immediate crisis resources.

Trend Analysis: Calculates mood averages and identifies when a user's current state is significantly lower than their baseline.

Dynamic UI Feedback: The application window changes color (Red/Yellow/Green) in real-time based on the mood slider position.

Local Data Persistence: Saves encrypted-style logs to mental_health_logs.txt for long-term health tracking.

 Folder Structure
The workspace is organized as follows:

src: Contains the source code files (CheckIn.java, EWSLogic.java, MentalHealthGUI.java).

bin: The folder where compiled output files (.class) are generated.

lib: A folder reserved for external dependencies.

 Getting Started
Open in VS Code: Ensure you have the "Extension Pack for Java" installed.

Run the GUI: Open MentalHealthGUI.java and click the Run button at the top right.

Check-in: Select your mood, write your thoughts, and click Submit.

View History: Use the History button to see your past entries printed in the console.

🛡️ Safety Disclaimer
This project is for educational purposes only. It is not a clinical tool. If you are in crisis, please contact emergency services or a crisis hotline like 988.
