package Step_semester_3;

import java.util.Scanner;

public class Gradeclassifier {
    static void classifyWithAttendance(int marks, int attendance) {
        boolean criteria = attendance >= 75 && marks >= 40;
        if (criteria) {
            if (marks > 90) {
                System.out.println("Grade:A");
            } else if (marks > 75 && marks < 89) {
                System.out.println("Grade:B");
            } else if (marks > 60 && marks < 74) {
                System.out.println("Grade:C");
            } else {
                System.out.println("Grade:D");
            }

        }
        else{
            System.out.println("Detained\n");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the marks");
        int marks = sc.nextInt();
        System.out.println("Enter the Attendance Percentage");
        int attendance = sc.nextInt();
        classifyWithAttendance(marks, attendance);

    }

}
    
}
