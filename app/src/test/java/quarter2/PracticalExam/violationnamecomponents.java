package quarter2.PracticalExam;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

    public class violationnamecomponents {
        public static void runFeature(Scanner scanner) {
            boolean validViolation = false;

            System.out.println("--- VIOLATION TYPE COMPONENT ---");

            while (!validViolation) {
                // Stop execution safely if the input stream runs out of lines
                if (!scanner.hasNextLine()) {
                    System.out.println("No more input available.");
                    break;
                }
                System.out.print("Enter Student ID: ");
                String studentID = scanner.nextLine().trim();

                if (!scanner.hasNextLine()) break;
                System.out.print("Enter violation name: ");
                String violationName = scanner.nextLine().trim();

                if (!scanner.hasNextLine()) break;
                System.out.print("Enter violation category (Minor / Major / Grave): ");
                String violationCategory = scanner.nextLine().trim().toLowerCase();

                System.out.println("\n--- PROCESS VIOLATION ---");

                if (studentID.isEmpty()) {
                    System.out.println("INVALID! Student ID cannot be empty.");
                    System.out.println("Try again.\n");
                } else if (violationName.isEmpty()) {
                    System.out.println("INVALID! Violation name cannot be empty.");
                    System.out.println("Try again.\n");
                } else if (violationCategory.equals("minor")
                        || violationCategory.equals("major")
                        || violationCategory.equals("grave")) {

                    System.out.println("VIOLATION RECORDED");
                    System.out.println("Student ID: " + studentID);
                    System.out.println("Violation Name: " + violationName);

                    String formattedCategory = violationCategory.substring(0, 1).toUpperCase()
                            + violationCategory.substring(1);

                    System.out.println("Category: " + formattedCategory);

                    validViolation = true;
                }
            }
        }
    }
