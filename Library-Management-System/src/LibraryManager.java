import java.util.HashMap;
import java.util.Scanner;

import services.Book;
import services.bookManager;

public class LibraryManager {
    private static HashMap<Integer, Book> books = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int bookIdCounter = 1;

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. List Books");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> searchBook();
                case 4 -> listBooks();
                case 5 -> borrowBook();
                case 6 -> returnBook();
                case 0 -> System.out.println("Exiting..");
                default -> System.out.println("Invalid option.");
            }
        } while (choice != 0);
    }

   
}
