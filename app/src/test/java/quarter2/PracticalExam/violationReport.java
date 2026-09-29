package quarter2.PracticalExam;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import java.io.ByteArrayInputStream;
public class violationReport {
    public static void violationReport(Scanner scanner) {
        boolean reasonReport = true;

        List<String> reasonForReports = Arrays.asList(
                "Minor",
                "Major",
                "Grave"
        );


        System.out.println("--- VIOLATION REPORT ---");

        while (reasonReport) {
            System.out.println("Reason for violation reports: " + String.join(", ", reasonForReports));
            String reason = scanner.nextLine();

            System.out.println("Please enter a reason: ");
            String reason1 = scanner.nextLine();


            boolean reasonisValid = false;
            {
                for (String validReason : reasonForReports) {
                    if (reason.equalsIgnoreCase(validReason)) {
                        reasonisValid = true;
                        break;
                    }
                }
                if (!reasonisValid) {
                    System.out.println("Please enter a valid reason");

                } else {
                    System.out.println("Violation report recorded");
                    System.out.println("Reason: " + reason1);
                }
                reasonReport = false;
            }
        }
    }
}

