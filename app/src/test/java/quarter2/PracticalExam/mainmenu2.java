package quarter2.PracticalExam;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class mainmenu2 {
    public void LoggingIn(Scanner scanner) {
        boolean choice = true;

        do {
            System.out.println("\n=========================================");
            System.out.println("   SCHOOL VIOLATION TRACKER - MAIN MENU  ");
            System.out.println("=========================================");
            System.out.println("1. Log/Manage Violation Types");
            System.out.println("2. Generate Violation Report");
            System.out.println("3. Exit");

            String choosing = scanner.nextLine();

            if (choosing.equals("1")) {
                violationnamecomponents.runFeature(scanner);
            } else if (choosing.equals("2")) {
                violationReport.violationReport(scanner);
            } else if (choosing.equals("3")) {
                System.out.println("Exiting School Violation Tracker system.");
                choice = false;
            } else {
                System.out.println("PLEASE ENTER A VALID CHOICE");
            }
        } while(choice);
    }
}