import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Week2Assignment {

    // --- Problem 1: ATM PIN Length Validator ---
    public static void checkPinLength(String pin) {
        if (pin != null && pin.length() == 4) {
            System.out.println("PIN length OK.");
        } else {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        }
    }

    // --- Problem 2: Word Reversal Encoder ---
    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder wordSb = new StringBuilder(words[i]);
            result.append(wordSb.reverse());
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    // --- Problem 3: Product Inventory CSV Parser ---
    public static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.println("Product: " + fields[0].trim() +
                " | SKU: " + fields[1].trim() +
                " | Qty: " + fields[2].trim());
    }

    // --- Problem 4: Library ISBN Normalizer & Validator ---
    public static String normalizeCode(String raw) {
        if (raw == null)
            return "";
        String trimmed = raw.trim();
        if (trimmed.length() < 3)
            return trimmed.toUpperCase();
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] ")
                .append("YEAR: ").append(year)
                .append(" | CATALOG: ").append(catalog);

        return sb.toString();
    }

    // --- Problem 5: Stop-Word-Filtered Word Frequency Report ---
    public static void printFilteredWordFrequency(String feedback) {
        String[] stopWordsArray = { "the", "was", "and", "a", "is", "of", "in" };
        List<String> stopWords = List.of(stopWordsArray);

        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleaned.split("\\s+");

        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty() || stopWords.contains(word)) {
                continue;
            }
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(freqMap.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // --- Main Method ---
    public static void main(String[] args) {
        System.out.println("=== 1. ATM PIN Length Validator ===");
        checkPinLength("482");
        checkPinLength("4820");

        System.out.println("\n=== 2. Word Reversal Encoder ===");
        System.out.println("Input: \"hello club\" -> Output: " + reverseEachWord("hello club"));

        System.out.println("\n=== 3. Product Inventory CSV Parser ===");
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
        parseInventoryRecord("Wireless Mouse,150");

        System.out.println("\n=== 4. Library ISBN Normalizer & Validator ===");
        String code1 = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(code1));

        String code2 = normalizeCode("12N2026004251");
        System.out.println(validateAndFormat(code2));

        System.out.println("\n=== 5. Stop-Word-Filtered Word Frequency Report ===");
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}