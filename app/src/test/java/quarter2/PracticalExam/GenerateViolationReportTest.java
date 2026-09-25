package quarter2.PracticalExam;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class GenerateViolationReportTest {

    @Test
    public void testGenerateViolationReportIntegration() {
        // Dynamic Test Generation using StringBuilder, while loop, and if-else logic
        StringBuilder inputBuilder = new StringBuilder();
        int step = 0;

        while (step < 9) {
            if (step == 0) {
                inputBuilder.append("Mico talaoc").append("\n"); // Student Name
            } else if (step == 1) {
                inputBuilder.append("12").append("\n");            // Grade Level
            } else if (step == 2) {
                inputBuilder.append("St.Philip the apostle").append("\n");    // Section
            } else if (step == 3) {
                inputBuilder.append("Improper Uniform").append("\n"); // Violation Type
            } else if (step == 4) {
                inputBuilder.append("Wearing wrong pants (BLACK PANTS)").append("\n"); // Description
            } else if (step == 5) {
                inputBuilder.append("2026-09-25").append("\n");    // Date
            } else if (step == 6) {
                inputBuilder.append("06:50AM").append("\n");      // Time
            } else if (step == 7) {
                inputBuilder.append("Pending").append("\n");       // Status (Pending, Resolved, Ongoing)
            } else if (step ==8) {
                inputBuilder.append("Student").append("\n");       // Generate by option
            }
            step++;
        }

        // Stream Conversion: Convert generated string to ByteArrayInputStream
        ByteArrayInputStream testInputStream = new ByteArrayInputStream(inputBuilder.toString().getBytes());

        // Redirect System.in and pass scanner as parameter
        InputStream originalSystemIn = System.in;
        try {
            System.setIn(testInputStream);
            Scanner scanner = new Scanner(System.in);

            // Execute feature
            mainmenu.GenerateViolationReport reportGenerator = new mainmenu.GenerateViolationReport();
            reportGenerator.runFeature(scanner);
        } finally {
            System.setIn(originalSystemIn);
        }
    }
}
