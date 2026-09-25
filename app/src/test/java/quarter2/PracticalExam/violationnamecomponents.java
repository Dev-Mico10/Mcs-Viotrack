package quarter2.PracticalExam;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class violationnamecomponents {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        runFeature(scanner);

        scanner.close();
    }

    public static void runFeature(Scanner scanner) {

        boolean validViolation = false;

        System.out.println("--- VIOLATION TYPE COMPONENT ---");

        while (!validViolation) {


            System.out.print("Enter Student ID: ");
            String studentID = scanner.nextLine().trim();


            System.out.print("Enter violation name: ");
            String violationName = scanner.nextLine().trim();


            System.out.print("Enter penalty / disciplinary action: ");
            String penalty = scanner.nextLine().trim();


            System.out.print(
                    "Enter violation category (Minor / Major / Grave): "
            );
            String violationCategory =
                    scanner.nextLine().trim().toLowerCase();

            System.out.println("\n--- PROCESS VIOLATION ---");


            if (studentID.isEmpty()) {

                System.out.println(
                        "INVALID! Student ID cannot be empty."
                );
                System.out.println("Try again.\n");

            }


            else if (violationName.isEmpty()) {

                System.out.println(
                        "INVALID! Violation name cannot be empty."
                );
                System.out.println("Try again.\n");

            }


            else if (penalty.isEmpty()) {

                System.out.println(
                        "INVALID! Penalty cannot be empty."
                );
                System.out.println("Try again.\n");

            }


            else if (violationCategory.equals("minor")
                    || violationCategory.equals("major")
                    || violationCategory.equals("grave")) {

                System.out.println("VIOLATION RECORDED");
                System.out.println("Student ID: " + studentID);
                System.out.println("Violation Name: " + violationName);
                System.out.println("Penalty: " + penalty);


                String formattedCategory =
                        violationCategory.substring(0, 1).toUpperCase()
                                + violationCategory.substring(1);

                System.out.println(
                        "Category: " + formattedCategory
                );

                validViolation = true;

            }


            else {

                System.out.println(
                        "INVALID! Enter 'Minor', 'Major', or 'Grave'."
                );
                System.out.println("Try again.\n");
            }
        }
    }

    public static class ViolationTypeTest {

        @Test
        public void testViolationTypeFeature() {
            String input = "1001\nUniform Violation\nDetention\nMinor\n";
            Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
            runFeature(scanner);
        }

        @Test
        public void testMainMenuViolationType() {
            String input = "Minor\nDetention\n";
            Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
            mainmenu.ViolationType violationType = new mainmenu.ViolationType();
            violationType.runFeature(scanner);
        }
    }
}