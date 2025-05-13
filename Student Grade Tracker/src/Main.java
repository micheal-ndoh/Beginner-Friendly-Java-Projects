import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n Student Grade Tracker");
            System.out.println("1. Add student");
            System.out.println("2. Show all students");
            System.out.println("3. Show statistics");
            System.out.println("4. Save to CSV");
            System.out.println("5. Load from CSV");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> Management.addStudent();
                case 2 -> Management.showStudents();
                case 3 -> Management.showStatistics();
                case 4 -> Management.saveToFile();
                case 5 -> Management.loadFromFile();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

}
