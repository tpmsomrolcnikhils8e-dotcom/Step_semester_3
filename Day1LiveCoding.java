import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Day1LiveCoding {

    // --- Problem 1: Rock-Paper-Scissors Game ---
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
                (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
                (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void runRockPaperScissors() {
        String[] choices = { "Rock", "Paper", "Scissors" };
        String[] playerMoves = { "Rock", "Paper", "Scissors", "Rock", "Paper" }; // Demo input
        Random random = new Random();

        int wins = 0, losses = 0, draws = 0;
        int totalRounds = 5;

        System.out.println("--- Rock-Paper-Scissors Arcade ---");
        System.out.printf("%-10s | %-12s | %-14s | %-15s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < totalRounds; i++) {
            String player = playerMoves[i];
            String computer = choices[random.nextInt(3)];
            String result = playRound(player, computer);

            if (result.equals("Player Wins"))
                wins++;
            else if (result.equals("Computer Wins"))
                losses++;
            else
                draws++;

            System.out.printf("%-10s | %-12s | %-14s | %-15s%n", "Round " + (i + 1), player, computer, result);
        }

        double winPct = ((double) wins / totalRounds) * 100;
        System.out.printf("%nFinal Summary: Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n%n",
                wins, losses, draws, winPct);
    }

    // --- Problem 2: Palindrome Checker (3 Approaches) ---
    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1)
            return true;
        if (text.charAt(0) != text.charAt(text.length() - 1))
            return false;
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] chars = text.toCharArray();
        char[] reversed = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }
        return Arrays.equals(chars, reversed);
    }

    public static void checkPalindrome(String text) {
        boolean iter = isPalindromeIterative(text);
        boolean recur = isPalindromeRecursive(text);
        boolean rev = isPalindromeArrayReversal(text);

        String iterRes = iter ? "Palindrome" : "Not Palindrome";
        String recurRes = recur ? "Palindrome" : "Not Palindrome";
        String revRes = rev ? "Palindrome" : "Not Palindrome";

        System.out.printf("Input: \"%s\" -> Iterative: %s | Recursive: %s | Array Reversal: %s%n",
                text, iterRes, recurRes, revRes);
    }

    // --- Problem 3: BMI Calculator for a Team ---
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5)
            return "Underweight";
        else if (bmi <= 24.9)
            return "Normal";
        else if (bmi <= 29.9)
            return "Overweight";
        else
            return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("--- Corporate Wellness Report ---");
        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-12s%n", "Person", "Height (m)", "Weight (kg)", "BMI",
                "Status");
        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("%-10s | %-12.2f | %-12.2f | %-8.2f | %-12s%n",
                    "Person " + (i + 1), heights[i], weights[i], bmi, status);
        }
        System.out.println();
    }

    // --- Problem 4: First Non-Repeating Character ---
    public static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : text.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        for (char c : text.toCharArray()) {
            if (counts.get(c) == 1)
                return c;
        }
        return '\0'; // Return null char if none found
    }

    // --- Problem 5: Reverse Customer Name ---
    public static String reverseCustomerName(String customerName) {
        StringBuilder sb = new StringBuilder(customerName);
        return sb.reverse().toString();
    }

    // --- Main Method ---
    public static void main(String[] args) {
        // 1. Rock Paper Scissors
        runRockPaperScissors();

        // 2. Palindrome Checker
        System.out.println("--- Palindrome Checker ---");
        checkPalindrome("madam");
        checkPalindrome("hello");
        System.out.println();

        // 3. BMI Report
        double[] heights = { 1.75, 1.60, 1.80, 1.65 };
        double[] weights = { 70.0, 90.0, 68.0, 52.0 };
        printWellnessReport(heights, weights);

        // 4. First Non-Repeating Character
        System.out.println("--- Unique Letter Hunt ---");
        char c1 = findFirstNonRepeatingChar("swiss");
        System.out.println("Input: \"swiss\" -> "
                + (c1 != '\0' ? "First Non-Repeating Character: '" + c1 + "'" : "No Non-Repeating Character Found"));
        char c2 = findFirstNonRepeatingChar("aabbcc");
        System.out.println("Input: \"aabbcc\" -> "
                + (c2 != '\0' ? "First Non-Repeating Character: '" + c2 + "'" : "No Non-Repeating Character Found"));
        System.out.println();

        // 5. Reverse Customer Name
        System.out.println("--- Customer Identity Verification ---");
        String originalName = "Sunil";
        String reversedName = reverseCustomerName(originalName);
        System.out.println("Original Name: " + originalName);
        System.out.println("Reversed Name: " + reversedName);
    }
}