public class CategoryCEncapsulationPractice {

    // ==========================================
    // Problem 1: The Piggy Bank
    // ==========================================
    static class PiggyBank {
        private final String bankId;
        private double savings;

        public PiggyBank(String bankId) {
            this.bankId = bankId;
            this.savings = 0.0;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                this.savings += amount;
                System.out.println("Deposited: " + amount + " | Current savings: " + this.savings);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }

        public void withdraw(double amount) {
            if (amount > this.savings) {
                System.out.println("Withdrawal of " + amount + " rejected. Insufficient savings! Current savings stays "
                        + this.savings);
            } else if (amount <= 0) {
                System.out.println("Withdrawal amount must be positive.");
            } else {
                this.savings -= amount;
                System.out.println("Withdrew: " + amount + " | Current savings: " + this.savings);
            }
        }

        public double getSavings() {
            return this.savings;
        }

        public String getBankId() {
            return this.bankId;
        }
    }

    // ==========================================
    // Problem 2: The Quiz Scorecard
    // ==========================================
    static class Scorecard {
        private final boolean[] answers;
        private int count;

        public Scorecard(int totalQuestions) {
            this.answers = new boolean[totalQuestions];
            this.count = 0;
        }

        public void recordAnswer(boolean isCorrect) {
            if (count < answers.length) {
                answers[count] = isCorrect;
                count++;
            } else {
                System.out.println("All question slots filled. Answer ignored.");
            }
        }

        public int getScore() {
            int score = 0;
            for (int i = 0; i < count; i++) {
                if (answers[i]) {
                    score++;
                }
            }
            return score;
        }
    }

    // ==========================================
    // Problem 3: The Nickname Tag
    // ==========================================
    static class NameTag {
        private final String firstName;
        private final String lastName;

        public NameTag(String fullName) {
            String[] parts = fullName.split(" ");
            this.firstName = parts[0];
            this.lastName = parts[1];
        }

        public String getNickname() {
            return firstName + " " + lastName.charAt(0) + ".";
        }
    }

    // ==========================================
    // Problem 4: The Locker Code
    // ==========================================
    static class Locker {
        private final int lockerNumber;
        private String combinationCode;

        public Locker(int lockerNumber, String initialCode) {
            this.lockerNumber = lockerNumber;
            this.combinationCode = initialCode;
        }

        public boolean changeCode(String oldCode, String newCode) {
            if (this.combinationCode.equals(oldCode)) {
                this.combinationCode = newCode;
                System.out.println("Locker " + lockerNumber + ": Code change successful.");
                return true;
            } else {
                System.out.println("Locker " + lockerNumber + ": Change code rejected! Incorrect old code.");
                return false;
            }
        }

        public int getLockerNumber() {
            return this.lockerNumber;
        }
    }

    // ==========================================
    // Problem 5: The Attendance Sheet
    // ==========================================
    static class AttendanceSheet {
        private final String[] presentStudents;
        private int count;

        public AttendanceSheet(int maxCapacity) {
            this.presentStudents = new String[maxCapacity];
            this.count = 0;
        }

        public void markPresent(String studentName) {
            if (isPresent(studentName)) {
                System.out.println(studentName + " is already marked present.");
                return;
            }
            if (count < presentStudents.length) {
                presentStudents[count] = studentName;
                count++;
                System.out.println("Marked present: " + studentName);
            } else {
                System.out.println("Attendance sheet is full!");
            }
        }

        public int getPresentCount() {
            return this.count;
        }

        public boolean isPresent(String studentName) {
            for (int i = 0; i < count; i++) {
                if (presentStudents[i].equals(studentName)) {
                    return true;
                }
            }
            return false;
        }
    }

    // --- Main Method ---
    public static void main(String[] args) {
        System.out.println("=== Problem 1: The Piggy Bank ===");
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);

        System.out.println("\n=== Problem 2: The Quiz Scorecard ===");
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("sc.getScore() -> " + sc.getScore());

        System.out.println("\n=== Problem 3: The Nickname Tag ===");
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("tag.getNickname() -> " + tag.getNickname());

        System.out.println("\n=== Problem 4: The Locker Code ===");
        Locker locker = new Locker(101, "1234");
        locker.changeCode("1234", "5678");
        locker.changeCode("0000", "9999");

        System.out.println("\n=== Problem 5: The Attendance Sheet ===");
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println("sheet.getPresentCount() -> " + sheet.getPresentCount());
        System.out.println("sheet.isPresent(\"Ben\") -> " + sheet.isPresent("Ben"));
        System.out.println("sheet.isPresent(\"Chen\") -> " + sheet.isPresent("Chen"));
    }
}