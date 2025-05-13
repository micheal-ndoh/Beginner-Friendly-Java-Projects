import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Management {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();
   
    static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter grade: ");
        double grade = scanner.nextDouble();
        students.add(new Student(name, grade));
        System.out.println(" Student added.");
    }

    public static void showStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\nStudent List:");
        for (Student s : students) {
            System.out.println(s);
        }
    }

   public static void showStatistics() {
        if (students.isEmpty()) {
            System.out.println("No data to show statistics.");
            return;
        }

        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;

        for (Student s : students) {
            double grade = s.getGrade();
            total += grade;
            if (grade > highest) highest = grade;
            if (grade < lowest) lowest = grade;
        }

        double average = total / students.size();

        System.out.printf("\nStatistics:\nAverage: %.2f\nHighest: %.2f\nLowest: %.2f\n",
                average, highest, lowest);
    }

    public static void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("students.csv"))) {
            for (Student s : students) {
                pw.println(s.getName() + "," + s.getGrade());
            }
            System.out.println("Data saved to students.csv");
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    public static void loadFromFile() { {
        students.clear(); 
        try (BufferedReader br = new BufferedReader(new FileReader("students.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                double grade = Double.parseDouble(parts[1]);
                students.add(new Student(name, grade));
            }
            System.out.println("Data loaded from students.csv");
        } catch (IOException e) {
            System.out.println("Error loading file.");
        }
    }
}}
