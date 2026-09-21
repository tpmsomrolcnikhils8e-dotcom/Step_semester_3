import java.util.Arrays;

public class CategoryCPracticeProblems {

    // --- PROBLEM 1: Hackathon Score Curve Booster ---
    public static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    // --- PROBLEM 2: Duplicate Team Name Finder ---
    public static String findDuplicateTeam(String[] teamNames) {
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    // --- PROBLEM 3: Top-3 Podium Finder ---
    public static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score > first) {
                third = second;
                second = first;
                first = score;
            } else if (score > second) {
                third = second;
                second = score;
            } else if (score > third) {
                third = score;
            }
        }

        return new int[] { first, second, third };
    }

    // --- PROBLEM 4: Hackathon Seating Grid Optimizer ---
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0)
            return 0.0;
        double sum = 0;
        for (int score : row) {
            sum += score;
        }
        return sum / row.length;
    }

    public static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String zone = (avg >= threshold) ? "Buzzing Zone" : "Quiet Zone";
            sb.append("Row ").append(i).append(": ").append(zone);
            if (i < seatingScores.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    // --- PROBLEM 5: Placement Drive Shortlisting & Ranking Engine ---
    public static class Candidate implements Comparable<Candidate> {
        private String name;
        private double cgpa;
        private int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        public double getCompositeScore() {
            return (cgpa * 10) + codingScore;
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }

        public int getCodingScore() {
            return codingScore;
        }

        // Overloaded eligibility checks
        public static boolean isEligible(double cgpa) {
            return cgpa >= 7.5; // CGPA-only rule
        }

        public static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60; // Borderline CGPA + coding score rule
        }

        @Override
        public int compareTo(Candidate other) {
            // Sort by composite score descending
            return Double.compare(other.getCompositeScore(), this.getCompositeScore());
        }
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        int eligibleCount = 0;
        for (Candidate c : candidates) {
            if (Candidate.isEligible(c.getCgpa()) || Candidate.isEligible(c.getCgpa(), c.getCodingScore())) {
                eligibleCount++;
            }
        }

        Candidate[] shortlisted = new Candidate[eligibleCount];
        int idx = 0;
        for (Candidate c : candidates) {
            if (Candidate.isEligible(c.getCgpa()) || Candidate.isEligible(c.getCgpa(), c.getCodingScore())) {
                shortlisted[idx++] = c;
            }
        }

        Arrays.sort(shortlisted);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            sb.append(i + 1).append(". ")
                    .append(shortlisted[i].getName())
                    .append(" (").append(shortlisted[i].getCompositeScore()).append(")");
            if (i < shortlisted.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    // --- Main Method ---
    public static void main(String[] args) {
        System.out.println("=== Problem 1: Hackathon Score Curve Booster ===");
        int[] scores1 = { 70, 85, 60 };
        curveScores(scores1, 10);
        System.out.println(Arrays.toString(scores1));

        System.out.println("\n=== Problem 2: Duplicate Team Name Finder ===");
        System.out.println(findDuplicateTeam(new String[] { "ByteForce", "CodeCrafters", "ByteForce" }));
        System.out.println(findDuplicateTeam(new String[] { "ByteForce", "CodeCrafters", "NullPointers" }));

        System.out.println("\n=== Problem 3: Top-3 Podium Finder ===");
        System.out.println(Arrays.toString(findTopThreeScores(new int[] { 45, 82, 79, 90, 33, 90, 61 })));

        System.out.println("\n=== Problem 4: Hackathon Seating Grid Optimizer ===");
        int[][] seatingScores = {
                { 40, 50, 45 },
                { 85, 90, 95 },
                { 30, 20, 25 }
        };
        System.out.println(classifyRows(seatingScores, 60));

        System.out.println("\n=== Problem 5: Placement Drive Shortlisting & Ranking Engine ===");
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}