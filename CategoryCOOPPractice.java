public class CategoryCOOPPractice {

    // ==========================================
    // M1. Student Placement Record Management
    // ==========================================
    static class PlacementRecord {
        String studentName;
        String company;
        double packageLpa;

        public PlacementRecord(String studentName, String company, double packageLpa) {
            this.studentName = studentName;
            this.company = company;
            this.packageLpa = packageLpa;
        }

        public void printRecord() {
            System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
        }
    }

    // ==========================================
    // M2. Hostel Mess Wallet Management
    // ==========================================
    static class MessWallet {
        private double balance;

        public MessWallet(double openingBalance) {
            if (openingBalance < 0) {
                System.out.println("Warning: Opening balance cannot be negative. Initialized to 0.0.");
                this.balance = 0.0;
            } else {
                this.balance = openingBalance;
            }
        }

        public void topUp(double amount) {
            if (amount <= 0) {
                System.out.println("Top-up rejected: amount must be greater than 0");
            } else {
                this.balance += amount;
                System.out.println("Balance after top-up: " + this.balance);
            }
        }

        public void deduct(double amount) {
            if (amount > this.balance) {
                System.out.println("Deduct rejected: insufficient balance");
            } else {
                this.balance -= amount;
                System.out.println("Deduct successful. Remaining balance: " + this.balance);
            }
        }

        public double getBalance() {
            return this.balance;
        }
    }

    // ==========================================
    // M3. Course Credit Management
    // ==========================================
    static class Course {
        String code;
        String title;
        int credits;
        int labCredits;

        public Course(String code, String title, int credits, int labCredits) {
            this.code = code;
            this.title = title;
            this.credits = credits;
            this.labCredits = labCredits;
        }

        // Chains to 4-arg constructor via this(...)
        public Course(String code, String title, int credits) {
            this(code, title, credits, 0);
        }

        public int totalCredits() {
            return credits + labCredits;
        }
    }

    // ==========================================
    // M4. Library ID Card Management
    // ==========================================
    static class IdCard {
        String name;
        int booksIssued;

        public IdCard(String name, int booksIssued) {
            this.name = name;
            this.booksIssued = booksIssued;
        }
    }

    // ==========================================
    // M5. Student and College Information Management
    // ==========================================
    static class Student {
        String name;
        double attendance;
        static String collegeName = "SRM Institute of Science and Technology";
        static int studentCount = 0;

        public Student(String name, double attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++;
        }

        public static void printCollegeInfo() {
            System.out.println("College: " + collegeName);
            System.out.println("Total Students Count: " + studentCount);
        }
    }

    // --- Main Method Execution ---
    public static void main(String[] args) {
        System.out.println("=== M1. Student Placement Record Management ===");
        PlacementRecord[] records = {
                new PlacementRecord("Ravi", "TCS", 4.5),
                new PlacementRecord("Anitha", "Zoho", 6.2),
                new PlacementRecord("Karthik", "Infosys", 4.0)
        };
        for (PlacementRecord r : records) {
            r.printRecord();
        }

        System.out.println("\n=== M2. Hostel Mess Wallet Management ===");
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());

        System.out.println("\n=== M3. Course Credit Management ===");
        Course c1 = new Course("21CSC201J", "Data Structures", 4);
        Course c2 = new Course("21CSC205L", "DSA Lab", 3, 1);
        System.out.println(c1.code + " total credits: " + c1.totalCredits());
        System.out.println(c2.code + " total credits: " + c2.totalCredits());

        System.out.println("\n=== M4. Library ID Card Management ===");
        IdCard ravi = new IdCard("Ravi", 0);
        IdCard duplicate = ravi;
        duplicate.booksIssued = 3;
        IdCard separate = new IdCard("Ravi", 3);

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));

        System.out.println("\n=== M5. Student and College Information Management ===");
        Student s1 = new Student("Aarav", 85.5);
        Student s2 = new Student("Bhavna", 92.0);
        Student.printCollegeInfo();
    }
}
