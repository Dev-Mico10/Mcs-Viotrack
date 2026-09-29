package quarter2.PracticalExam;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class mainmenu2 {

    public void start(Scanner scanner) {
        displayMenu(scanner);
    }

    public static class ViolationType {
        public void runFeature(Scanner scanner) {
            System.out.print("Enter Violation Type: ");
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            System.out.print("Enter Sanction/Penalty: ");
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }
    }
    public static class LogInComponent {
        public static void LoggingIn(Scanner scanner) {
        }

        public void LogIn(Scanner scanner) {
            boolean isAuthenticated = false;

            while (!isAuthenticated) {
                System.out.println("--- LOG IN PAGE ---");

                System.out.print("Enter Username: ");
                String username = scanner.nextLine();

                System.out.print("Enter Password: ");
                String password = scanner.nextLine();

                if (username.equals("admin") && password.equals("12345")) {
                    System.out.println("Access Granted");
                    System.out.println("Opening User Dashboard...");
                    isAuthenticated = true;
                } else {
                    System.out.println("Invalid Username or Password");
                    System.out.println("Please enter a valid username and password.");
                }
            }
        }
    }

    public static class GenerateViolationReport {
        public void runFeature(Scanner scanner) {
            String[] prompts = {
                "Enter Student Name: ",
                "Enter Grade Level: ",
                "Enter Section: ",
                "Enter Violation Type: ",
                "Enter Description: ",
                "Enter Date: ",
                "Enter Time: ",
                "Enter Status: ",
                "Generate Report By: "
            };
            for (String prompt : prompts) {
                System.out.print(prompt);
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        }
    }

    /**
     * Scanner Golden Rule: Accepts a Scanner instance passed from the main runner/test stream.
     */
    public void displayMenu(Scanner scanner) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=========================================");
            System.out.println("   SCHOOL VIOLATION TRACKER - MAIN MENU  ");
            System.out.println("=========================================");
            System.out.println("1. Log/Manage Violation Types");
            System.out.println("2. Generate Violation Report");
            System.out.println("3. Exit");


            if (!scanner.hasNextLine()) {
                break;
            }
            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                LogInComponent.LoggingIn(scanner);
            } else if (choice.equals("2")) {
                violationReport.reasonReport(scanner);
            } else if (choice.equals("3")) {
                violationnamecomponents.validViolation(scanner);
                System.out.println("Exiting School Violation Tracker system.");
                exit = true;
            } else {
                System.out.println("PLEASE ENTER A VALID CHOICE");
            }
        }
    }
}