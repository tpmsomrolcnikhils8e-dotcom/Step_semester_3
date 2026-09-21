import java.util.HashMap;
import java.util.Map;

public class Day2LiveCoding {

    // --- Problem 1: Vowel & Consonant Counter ---
    public static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        String lowerText = text.toLowerCase();

        for (int i = 0; i < lowerText.length(); i++) {
            char ch = lowerText.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    // --- Problem 2: CSV Student Record Parser ---
    public static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.println("Name: " + fields[0].trim() +
                " | Roll No: " + fields[1].trim() +
                " | Dept: " + fields[2].trim());
    }

    // --- Problem 3: File Extension Validator ---
    public static String validateFileExtension(String filename) {
        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String ext = filename.substring(lastDotIndex + 1);
        if (ext.equalsIgnoreCase("pdf") || ext.equalsIgnoreCase("docx") || ext.equalsIgnoreCase("zip")) {
            return "Accepted";
        }
        return "Rejected — invalid file type";
    }

    // --- Problem 4: Masked Phone Number Formatter ---
    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        String last4 = phone.substring(6);
        StringBuilder sb = new StringBuilder("XXXXXX");
        sb.append("-").append(last4);
        return sb.toString();
    }

    // --- Problem 5: Bank Transaction Reference Generator & Validator ---
    public static String normalizeReference(String raw) {
        if (raw == null)
            return "";
        String trimmed = raw.trim();
        if (trimmed.length() < 3)
            return trimmed.toUpperCase();
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String seq = reference.substring(9);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] ")
                .append("DATE: ").append(day).append("/").append(month).append("/").append(year)
                .append(" | SEQ: ").append(seq);

        return sb.toString();
    }

    // --- Main Method ---
    public static void main(String[] args) {
        System.out.println("=== 1. Vowel & Consonant Counter ===");
        countVowelsAndConsonants("Java Programming");

        System.out.println("\n=== 2. CSV Student Record Parser ===");
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        parseStudentRecord("Ananya Verma,CSE");

        System.out.println("\n=== 3. File Extension Validator ===");
        System.out.println("Assignment1.PDF -> " + validateFileExtension("Assignment1.PDF"));
        System.out.println("notes.txt -> " + validateFileExtension("notes.txt"));

        System.out.println("\n=== 4. Masked Phone Number Formatter ===");
        System.out.println("9876543210 -> " + maskPhoneNumber("9876543210"));
        System.out.println("98765 -> " + maskPhoneNumber("98765"));

        System.out.println("\n=== 5. Bank Transaction Reference Generator & Validator ===");
        String ref1 = normalizeReference(" hdf03022600042 ");
        System.out.println(validateAndFormat(ref1));

        String ref2 = normalizeReference("12F03022600042");
        System.out.println(validateAndFormat(ref2));
    }
}