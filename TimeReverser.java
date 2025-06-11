//Name: Abdullah Aldahiree
//Project: TimeReverser
//Description: This java program simulates "stopping time" and making a digital clock run backward
import java.util.Scanner;
public class TimeReverser {
    public static void main (String[]args) throws InterruptedException {
        Scanner scanner = new Scanner (System.in);
        System.out.println("🕒 Enter the current time (e.g., 12:45:30 PM):");

        String timeInput = scanner.nextLine().trim();

        String reversedTime = reverseTime(timeInput);

        System.out.println("⏳ Time Reversed: " + reversedTime);

        System.out.println("\n🕰️ Simulating time going backwards:");

        simulateBackwardTime(timeInput, 5);  // simulate 5 steps back

        // === 🧊 Time Freeze Feature ===

        System.out.println("\n🧊 Type 'freeze' to stop time...");

        String freezeCommand = scanner.nextLine();

        if (freezeCommand.equalsIgnoreCase("freeze")) {

            System.out.println("🧊 Time is now frozen. Press Enter to resume...");

            scanner.nextLine(); // Wait for Enter

            System.out.println("▶️ Time resumed!");


            // Resume backward time simulation for 5 more steps

            System.out.println("\n🔁 Resuming time reversal:");

            simulateBackwardTime(timeInput, 5); // simulate 5 more steps

        }

    }

    // Reverse each component of the time

    public static String reverseTime(String time) {

        String[] parts = time.split(" ");

        String ampm = parts.length > 1 ? parts[1] : "";

        String[] timeParts = parts[0].split(":");

        StringBuilder reversed = new StringBuilder();

        for (String part : timeParts) {

            reversed.append(new StringBuilder(part).reverse().toString()).append(":");

        }

        reversed.deleteCharAt(reversed.length() - 1); // remove last ":"

        return reversed.toString() + (ampm.isEmpty() ? "" : " " + ampm);

    }

    // Simulate time going backward

    public static void simulateBackwardTime(String time, int steps) throws InterruptedException {

        String[] timeParts = time.split(" ")[0].split(":");

        int hour = Integer.parseInt(timeParts[0]);

        int minute = Integer.parseInt(timeParts[1]);

        int second = Integer.parseInt(timeParts[2]);

        for (int i = 0; i < steps; i++) {

            second--;

            if (second < 0) {

                second = 59;

                minute--;

                if (minute < 0) {

                    minute = 59;

                    hour--;

                    if (hour <= 0) hour = 12;

                }

            }

            String display = String.format("%02d:%02d:%02d", hour, minute, second);

            System.out.println("<< " + display + " >>");

            Thread.sleep(800); // delay to simulate ticking
        }
    }
}
    
