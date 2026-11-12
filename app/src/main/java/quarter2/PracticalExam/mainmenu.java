package quarter2.PracticalExam;

import java.util.Scanner;

public class mainmenu {

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
        public void LogIn(Scanner scanner) {
            boolean isAuthenticated = false;

            while (!isAuthenticated) {
                System.out.println("--- LOG IN PAGE ---");

                System.out.print("Enter Username: ");
                String username = scanner.hasNextLine() ? scanner.nextLine().trim() : "";

                System.out.print("Enter Password: ");
                String password = scanner.hasNextLine() ? scanner.nextLine().trim() : "";

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
    public void menutestingfile(Scanner scanner) {
        displayMenu(scanner);
    }

    public void start(Scanner scanner) {
        displayMenu(scanner);
    }

    public void displayMenu(Scanner scanner) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=========================================");
            System.out.println("   SCHOOL VIOLATION TRACKER - MAIN MENU  ");
            System.out.println("=========================================");
            System.out.println("1. Log/Manage Violation Types");
            System.out.println("2. Generate Violation Report");
            System.out.println("3. Exit");

            // Read choice
            int choice = 0;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline leftover
                System.out.println(choice); // Echo Input requirement
            } else {
                String invalidInput = scanner.nextLine();
                System.out.println(invalidInput); // Echo invalid input
                System.out.println("Invalid input! Please enter a valid number.");
                continue;
            }

            // Route user choices
            switch (choice) {
                case 1:
                    System.out.println("\n>>> Navigating to Violation Type Module...");
                    ViolationType violationType = new ViolationType();
                    violationType.runFeature(scanner);
                    break;

                case 2:
                    System.out.println("\n>>> Navigating to Generate Violation Report Module...");
                    GenerateViolationReport reportGenerator = new GenerateViolationReport();
                    reportGenerator.runFeature(scanner);
                    break;

                case 3:
                    System.out.println("Exiting School Violation Tracker system. Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 3.");
                    break;
            }
        }
    }

    /**
     * Standard entry point if running directly as a standalone application.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mainmenu menu = new mainmenu();
        menu.displayMenu(scanner);
        scanner.close();
    }
}
