package quarter2.PracticalExam;

import java.util.Scanner;

public class mainmenu {

    public static class ViolationType {
        private String violationName;
        private String penalty;

        // Constructors
        public ViolationType() {}

        public ViolationType(String violationName, String penalty) {
            this.violationName = violationName;
            this.penalty = penalty;
        }

        // Getters and Setters
        public String getViolationName() {
            return violationName;
        }

        public void setViolationName(String violationName) {
            this.violationName = violationName;
        }

        public String getPenalty() {
            return penalty;
        }

        public void setPenalty(String penalty) {
            this.penalty = penalty;
        }

        public void runFeature(Scanner scanner) {
            System.out.println("=== SCHOOL VIOLATION TRACKER ===");

            System.out.print("Enter Violation Name (e.g., Improper Uniform): ");
            this.violationName = scanner.nextLine();
            System.out.println(this.violationName);

            System.out.print("Enter Sanction/Penalty (e.g., Warning / Community Service): ");
            this.penalty = scanner.nextLine();
            System.out.println(this.penalty);

            System.out.println("\n--- School Violation Record Summary ---");
            System.out.println("Violation Category: " + this.violationName);
            System.out.println("Assigned Sanction : " + this.penalty);
            System.out.println("Status            : Logged in System");
        }
    }

    public static class GenerateViolationReport {
        private String violationType;
        private String description;
        private String date;
        private String time;
        private String status; // Pending, Resolved, or Ongoing

        // Fields for generation/filtering options
        private String studentName;
        private String section;
        private String gradeLevel;
        private String filterChoice;

        // Constructors
        public GenerateViolationReport() {}

        public GenerateViolationReport(String violationType, String description, String date,
                                       String time, String status, String studentName,
                                       String section, String gradeLevel) {
            this.violationType = violationType;
            this.description = description;
            this.date = date;
            this.time = time;
            this.status = status;
            this.studentName = studentName;
            this.section = section;
            this.gradeLevel = gradeLevel;
        }

        // Getters and Setters
        public String getViolationType() { return violationType; }
        public void setViolationType(String violationType) { this.violationType = violationType; }

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }

        public String getDate() { return date; }
        public void setDate(String date) { this.date = date; }

        public String getTime() { return time; }
        public void setTime(String time) { this.time = time; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        public String getStudentName() { return studentName; }
        public void setStudentName(String studentName) { this.studentName = studentName; }

        public String getSection() { return section; }
        public void setSection(String section) { this.section = section; }

        public String getGradeLevel() { return gradeLevel; }
        public void setGradeLevel(String gradeLevel) { this.gradeLevel = gradeLevel; }

        /**
         * Scanner Golden Rule: Method accepts Scanner parameter.
         * Echo All Inputs: Explicitly prints each variable immediately after reading.
         */
        public void runFeature(Scanner scanner) {
            System.out.println("=== GENERATE VIOLATION REPORT ===");

            // Student Info
            System.out.print("Enter Student Name: ");
            this.studentName = scanner.nextLine();
            System.out.println(this.studentName); // Echo Input

            System.out.print("Enter Grade Level: ");
            this.gradeLevel = scanner.nextLine();
            System.out.println(this.gradeLevel); // Echo Input

            System.out.print("Enter Section: ");
            this.section = scanner.nextLine();
            System.out.println(this.section); // Echo Input

            // Violation Details
            System.out.print("Enter Violation Type (e.g., Improper Uniform): ");
            this.violationType = scanner.nextLine();
            System.out.println(this.violationType); // Echo Input

            System.out.print("Enter Description: ");
            this.description = scanner.nextLine();
            System.out.println(this.description); // Echo Input

            System.out.print("Enter Date (YYYY-MM-DD): ");
            this.date = scanner.nextLine();
            System.out.println(this.date); // Echo Input

            System.out.print("Enter Time (HH:MM AM/PM): ");
            this.time = scanner.nextLine();
            System.out.println(this.time); // Echo Input

            System.out.print("Enter Status (Pending, Resolved, or Ongoing): ");
            this.status = scanner.nextLine();
            System.out.println(this.status); // Echo Input

            // Report Generation Filter Option
            System.out.print("Generate report by (Student, Section, Grade Level, Violation Type, Date Range): ");
            this.filterChoice = scanner.nextLine();
            System.out.println(this.filterChoice); // Echo Input

            // Display Generated Violation Report Summary
            System.out.println("\n=================================");
            System.out.println("     OFFICIAL VIOLATION REPORT   ");
            System.out.println("=================================");
            System.out.println("Report Filter    : By " + this.filterChoice);
            System.out.println("Student Name     : " + this.studentName);
            System.out.println("Grade & Section  : Grade " + this.gradeLevel + " - " + this.section);
            System.out.println("Violation Type   : " + this.violationType);
            System.out.println("Description      : " + this.description);
            System.out.println("Date & Time      : " + this.date + " at " + this.time);
            System.out.println("Current Status   : " + this.status);
            System.out.println("=================================");
        }
    }
}
