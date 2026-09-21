public class Week1Assignment {

    // --- Problem 1: Exam Hall Seat Duplication Checker ---
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    break;
                }
            }
        }
        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    // --- Problem 2: Typing Speed Test Accuracy Checker ---
    public static void checkTypingAccuracy(String original, String typed) {
        int matches = 0;
        int firstMismatchPos = -1;
        char origChar = ' ', typedChar = ' ';

        int length = Math.min(original.length(), typed.length());
        for (int i = 0; i < length; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matches++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1; // 1-based index position
                origChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        double accuracy = ((double) matches / original.length()) * 100;
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%", matches, original.length(), accuracy);

        if (firstMismatchPos != -1) {
            System.out.printf(" | First Mismatch at position %d ('%c' vs '%c')%n", firstMismatchPos, origChar,
                    typedChar);
        } else {
            System.out.println(" | No Mismatches");
        }
    }

    // --- Problem 3: Traffic Signal Streak Analyzer ---
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty())
            return;

        char maxColor = signalLog.charAt(0);
        int maxStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                currentStreak++;
            } else {
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    maxColor = currentColor;
                }
                currentColor = signalLog.charAt(i);
                currentStreak = 1;
            }
        }

        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            maxColor = currentColor;
        }

        System.out.printf("Longest Streak: '%c' repeated %d times%n", maxColor, maxStreak);
    }

    // --- Problem 4: Warehouse Inventory Balancer ---
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0, totalB = 0;
        int highestQty = Integer.MIN_VALUE;
        String highestLocation = "";

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > highestQty) {
                highestQty = sectionA[i];
                highestLocation = "Section A, Item " + (i + 1);
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > highestQty) {
                highestQty = sectionB[i];
                highestLocation = "Section B, Item " + (i + 1);
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s)%n",
                totalA, totalB, status, highestQty, highestLocation);
    }

    // --- Problem 5: Movie Review Word Length Profiler ---
    public static void classifyWordLengths(String review) {
        String[] words = review.trim().split("\\s+");
        int shortWords = 0, mediumWords = 0, longWords = 0;

        for (String word : words) {
            // Remove non-alphanumeric punctuation marks if present
            String cleanWord = word.replaceAll("[^a-zA-Z0-9]", "");
            int len = cleanWord.length();

            if (len >= 1 && len <= 4)
                shortWords++;
            else if (len >= 5 && len <= 8)
                mediumWords++;
            else if (len >= 9)
                longWords++;
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortWords, mediumWords, longWords);
    }

    // --- Main Method ---
    public static void main(String[] args) {
        System.out.println("=== 1. Exam Hall Seat Duplication Checker ===");
        checkDuplicateSeats(new int[] { 101, 102, 103, 102, 105 });
        checkDuplicateSeats(new int[] { 101, 102, 103, 104, 105 });

        System.out.println("\n=== 2. Typing Speed Test Accuracy Checker ===");
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");

        System.out.println("\n=== 3. Traffic Signal Streak Analyzer ===");
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");

        System.out.println("\n=== 4. Warehouse Inventory Balancer ===");
        analyzeInventory(new int[] { 20, 15, 30 }, new int[] { 25, 10, 30 });

        System.out.println("\n=== 5. Movie Review Word Length Profiler ===");
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}