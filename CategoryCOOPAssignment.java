public class CategoryCOOPAssignment {

    // ==========================================
    // M1. Library Inventory Management
    // ==========================================
    static class BookInventory {
        String title;
        String author;
        int copiesAvailable;

        public BookInventory(String title, String author, int copiesAvailable) {
            this.title = title;
            this.author = author;
            this.copiesAvailable = copiesAvailable;
        }

        public void printEntry() {
            System.out.println(title + " by " + author + " - " + copiesAvailable + " copies available");
        }
    }

    // ==========================================
    // M2. Payroll Salary Management
    // ==========================================
    static class PayrollAccount {
        private double basicSalary;
        private double bonus;

        public PayrollAccount(double basicSalary) {
            if (basicSalary < 0) {
                System.out.println("Warning: Basic salary cannot be negative. Initialized to 0.0.");
                this.basicSalary = 0.0;
            } else {
                this.basicSalary = basicSalary;
            }
            this.bonus = 0.0;
        }

        public void creditBonus(double amount) {
            if (amount <= 0) {
                System.out.println("Bonus rejected: amount must be greater than 0");
            } else {
                this.bonus += amount;
                System.out.println("Bonus credited: Rs " + this.bonus);
            }
        }

        public void deductTax(double percent) {
            if (percent < 0 || percent > 100) {
                System.out.println("Tax deduction rejected: invalid percentage");
            } else {
                this.basicSalary -= (this.basicSalary * percent / 100.0);
                System.out.println("Tax deducted: " + percent + "%");
            }
        }

        public double getNetSalary() {
            return this.basicSalary + this.bonus;
        }
    }

    // ==========================================
    // M3. Employee Profile Creation
    // ==========================================
    static class Employee {
        String empId;
        String empName;
        double salary;
        boolean isIntern;

        public Employee(String empId, String empName, double salary) {
            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
            this.isIntern = false;
        }

        // Chains to 3-arg constructor via this(...)
        public Employee(String empId, String empName) {
            this(empId, empName, 0.0);
            this.isIntern = true;
        }

        public void printProfile() {
            System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
        }
    }

    // ==========================================
    // M4. Exam Hall Ticket Reference Management
    // ==========================================
    static class HallTicket {
        String studentName;
        int seatNumber;

        public HallTicket(String studentName, int seatNumber) {
            this.studentName = studentName;
            this.seatNumber = seatNumber;
        }
    }

    // ==========================================
    // M5. Employee and Company Information Management
    // ==========================================
    static class CompanyEmployee {
        String empName;
        double salary;
        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;

        public CompanyEmployee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        public static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    // --- Main Method Execution ---
    public static void main(String[] args) {
        System.out.println("=== M1. Library Inventory Management ===");
        BookInventory[] inventory = {
                new BookInventory("Clean Code", "Robert C. Martin", 3),
                new BookInventory("Effective Java", "Joshua Bloch", 5),
                new BookInventory("Refactoring", "Martin Fowler", 0),
                new BookInventory("Design Patterns", "GoF", 2)
        };
        for (BookInventory b : inventory) {
            b.printEntry();
        }

        System.out.println("\n=== M2. Payroll Salary Management ===");
        PayrollAccount payroll = new PayrollAccount(50000);
        payroll.creditBonus(5000);
        payroll.deductTax(10);
        System.out.println("Net salary: Rs " + payroll.getNetSalary());

        System.out.println("\n=== M3. Employee Profile Creation ===");
        Employee emp1 = new Employee("E-101", "Divya", 65000);
        Employee emp2 = new Employee("E-102", "Arjun");
        emp1.printProfile();
        emp2.printProfile();

        System.out.println("\n=== M4. Exam Hall Ticket Reference Management ===");
        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya;
        copy.seatNumber = 45;
        HallTicket separate = new HallTicket("Priya", 45);

        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));

        System.out.println("\n=== M5. Employee and Company Information Management ===");
        new CompanyEmployee("Amit", 45000);
        new CompanyEmployee("Sneha", 55000);
        new CompanyEmployee("Raj", 60000);
        CompanyEmployee.printCompanyInfo();
    }
}