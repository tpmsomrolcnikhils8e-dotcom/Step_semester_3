
import java.util.*;
import java.time.LocalDate;

abstract class Plan {
    LocalDate startDate;

    Plan(String date) {
        startDate = LocalDate.parse(date);
    }

    abstract int validity();

    LocalDate renewalDate() {
        return startDate.plusDays(validity());
    }
}

class Basic extends Plan {
    Basic(String date) {
        super(date);
    }

    int validity() {
        return 30;
    }
}

class Standard extends Plan {
    Standard(String date) {
        super(date);
    }

    int validity() {
        return 90;
    }
}

class Premium extends Plan {
    Premium(String date) {
        super(date);
    }

    int validity() {
        return 365;
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            Plan p;

            switch (type) {
                case "BASIC":
                    p = new Basic(date);
                    break;
                case "STANDARD":
                    p = new Standard(date);
                    break;
                default:
                    p = new Premium(date);
            }

            System.out.println(name + ": " + p.renewalDate());
        }

        sc.close();
    }
}

