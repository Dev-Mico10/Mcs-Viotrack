package quarter2.PracticalExam;

public class ViolationHistory {

    public static class Record {
        private final int id;
        private final String studentName;
        private final String violation;
        private final int points;
        private final String remarks;
        private final LocalDate date;

        public Record(int id, String studentName, String violation, int points, String remarks) {
            this.id = id;
            this.studentName = studentName;
            this.violation = violation;
            this.points = points;
            this.remarks = remarks;
            this.date = LocalDate.now();
        }

        public int getId() { return id; }
        public String getStudentName() { return studentName; }
        public String getViolation() { return violation; }
        public int getPoints() { return points; }
        public String getRemarks() { return remarks; }
        public LocalDate getDate() { return date; }

        @Override
        public String toString() {
            return String.format("#%-3d | %-15s | %-20s | %3d pts | %s | %s",
                    id, studentName, violation, points, date, remarks);
        }
    }

    private final ArrayList<Record> history = new ArrayList<>();
    private int nextId = 1;

    public void showMenu(Scanner sc) {
        boolean running = true;

        while (running) {
            printMenu();


            if (!sc.hasNext()) {
                break;
            }

            int choice = readInt(sc);

            switch (choice) {
                case 1:
                    addViolation(sc);
                    break;
                case 2:
                    viewAll();
                    break;
                case 3:
                    searchByStudent(sc);
                    break;
                case 4:
                    deleteRecord(sc);
                    break;
                case 5:
                    showTotalPoints(sc);
                    break;
                case 6:
                    clearHistory();
                    break;
                case 0:
                    System.out.println("Exiting Violation History...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n===== VIOLATION HISTORY =====");
        System.out.println("1. Add violation");
        System.out.println("2. View all history");
        System.out.println("3. Search by student");
        System.out.println("4. Delete a record");
        System.out.println("5. Total points of a student");
        System.out.println("6. Clear all history");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
    }

    private void addViolation(Scanner sc) {
        System.out.print("Student name: ");
        String name = readLine(sc);

        System.out.print("Violation: ");
        String violation = readLine(sc);

        System.out.print("Points: ");
        int points = readInt(sc);   // nextInt + leftover Enter cleared inside readInt

        System.out.print("Remarks: ");
        String remarks = readLine(sc);

        if (name.isEmpty() || violation.isEmpty() || points < 0) {
            System.out.println("Invalid entry. Violation not saved.");
            return;
        }

        history.add(new Record(nextId++, name, violation, points, remarks));
        System.out.println("Violation recorded successfully.");
    }

    private void viewAll() {
        if (history.isEmpty()) {
            System.out.println("No violation history yet.");
            return;
        }
        for (Record r : history) {
            System.out.println(r);
        }
        System.out.println("Total records: " + history.size());
    }

    private void searchByStudent(Scanner sc) {
        System.out.print("Student name: ");
        String name = readLine(sc);

        boolean found = false;
        for (Record r : history) {
            if (r.getStudentName().equalsIgnoreCase(name)) {
                System.out.println(r);
                found = true;
            }
        }

        if (found) {
            System.out.println("Violations found: " + countByStudent(name));
        } else {
            System.out.println("No violations found for " + name + ".");
        }
    }

    private void deleteRecord(Scanner sc) {
        System.out.print("Record ID to delete: ");
        int id = readInt(sc);

        for (int i = 0; i < history.size(); i++) {
            if (history.get(i).getId() == id) {
                history.remove(i);
                System.out.println("Record #" + id + " deleted.");
                return;
            }
        }
        System.out.println("Record #" + id + " not found.");
    }

    private void showTotalPoints(Scanner sc) {
        System.out.print("Student name: ");
        String name = readLine(sc);
        System.out.println(name + " has " + totalPointsByStudent(name) + " total violation points.");
    }

    private void clearHistory() {
        history.clear();
        System.out.println("All violation history cleared.");
    }

    public int countByStudent(String name) {
        int count = 0;
        for (Record r : history) {
            if (r.getStudentName().equalsIgnoreCase(name)) {
                count++;
            }
        }
        return count;
    }

    public int totalPointsByStudent(String name) {
        int total = 0;
        for (Record r : history) {
            if (r.getStudentName().equalsIgnoreCase(name)) {
                total += r.getPoints();
            }
        }
        return total;
    }

    public int getRecordCount() {
        return history.size();
    }
    private int readInt(Scanner sc) {
        int value = -1;
        if (sc.hasNextInt()) {
            value = sc.nextInt();
        } else if (sc.hasNext()) {
            sc.next();
        }
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
        return value;
    }
    private String readLine(Scanner sc) {
        return sc.hasNextLine() ? sc.nextLine().trim() : "";
    }
}

