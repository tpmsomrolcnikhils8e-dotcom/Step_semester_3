import java.util.Arrays;

public class CategoryCAssignmentProblems {

    // --- PROBLEM 1: Fantasy Team Score Multiplier ---
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] *= 2.0;
        playerScores[viceCaptainIndex] *= 1.5;
    }

    // --- PROBLEM 2: Duplicate Player Pick Checker ---
    public static String findDuplicatePick(String[] playerNames) {
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    // --- PROBLEM 3: Top Performer Tracker ---
    public static String findMinMaxSpread(int[] scores) {
        int min = scores[0];
        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;
        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }

    // --- PROBLEM 4: Match Day Grid Analyzer ---
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0)
            return 0.0;
        double sum = 0;
        for (int run : row) {
            sum += run;
        }
        return sum / row.length;
    }

    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String status = (avg >= threshold) ? "Power Surge" : "Normal";
            sb.append("Match ").append(i).append(": ").append(status);
            if (i < runsPerOver.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    // --- PROBLEM 5: Fantasy League Auto-Draft Ranking Engine ---
    public static class Player implements Comparable<Player> {
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        public String getName() {
            return name;
        }

        public int getMatchesPlayed() {
            return matchesPlayed;
        }

        public double getBattingAverage() {
            return battingAverage;
        }

        public boolean isInjured() {
            return injured;
        }

        // Overloaded draftability checks
        public static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10; // Established player rule
        }

        public static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 5 && !injured; // Newer player fitness rule
        }

        @Override
        public int compareTo(Player other) {
            // Rank by batting average (fantasy points indicator) descending
            return Double.compare(other.getBattingAverage(), this.getBattingAverage());
        }
    }

    public static String draftAndRank(Player[] players) {
        int draftableCount = 0;
        for (Player p : players) {
            if (Player.isDraftable(p.getMatchesPlayed()) || Player.isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftableCount++;
            }
        }

        Player[] draftable = new Player[draftableCount];
        int idx = 0;
        for (Player p : players) {
            if (Player.isDraftable(p.getMatchesPlayed()) || Player.isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftable[idx++] = p;
            }
        }

        Arrays.sort(draftable);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            sb.append(i + 1).append(". ").append(draftable[i].getName());
            if (i < draftable.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    // --- Main Method ---
    public static void main(String[] args) {
        System.out.println("=== Problem 1: Fantasy Team Score Multiplier ===");
        double[] scores = { 40, 55, 30, 62 };
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores));

        System.out.println("\n=== Problem 2: Duplicate Player Pick Checker ===");
        System.out.println(findDuplicatePick(new String[] { "Kohli", "Bumrah", "Kohli", "Rohit" }));
        System.out.println(findDuplicatePick(new String[] { "Kohli", "Bumrah", "Rohit" }));

        System.out.println("\n=== Problem 3: Top Performer Tracker ===");
        System.out.println(findMinMaxSpread(new int[] { 45, 82, 79, 90, 33, 90, 61 }));

        System.out.println("\n=== Problem 4: Match Day Grid Analyzer ===");
        int[][] runsPerOver = {
                { 4, 6, 8 },
                { 10, 12, 14 },
                { 2, 3, 1 }
        };
        System.out.println(classifyMatches(runsPerOver, 8));

        System.out.println("\n=== Problem 5: Fantasy League Auto-Draft Ranking Engine ===");
        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players));
    }
}
