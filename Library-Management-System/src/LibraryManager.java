import java.util.*;

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

    private static void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        Book book = new Book(bookIdCounter, title, author);
        books.put(bookIdCounter, book);
        System.out.println("Book added with ID: " + bookIdCounter);
        bookIdCounter++;
    }

    private static void removeBook() {
        System.out.print("Enter book ID to remove: ");
        int id = scanner.nextInt();

        if (books.remove(id) != null) {
            System.out.println(" Book removed.");
        } else {
            System.out.println(" Book not found.");
        }
    }

    private static void searchBook() {
        System.out.print("Enter book ID to search: ");
        int id = scanner.nextInt();

        Book book = books.get(id);
        if (book != null) {
            System.out.println("Found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }

        System.out.println("\n Book List:");
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    private static void borrowBook() {
        System.out.print("Enter book ID to borrow: ");
        int id = scanner.nextInt();

        Book book = books.get(id);
        if (book == null) {
            System.out.println(" Book not found.");
        } else if (book.isBorrowed()) {
            System.out.println(" Book is already borrowed.");
        } else {
            book.borrow();
            System.out.println("You borrowed: " + book.getTitle());
        }
    }

    private static void returnBook() {
        System.out.print("Enter book ID to return: ");
        int id = scanner.nextInt();

        Book book = books.get(id);
        if (book == null) {
            System.out.println(" Book not found.");
        } else if (!book.isBorrowed()) {
            System.out.println(" This book wasn’t borrowed.");
        } else {
            book.returnBook();
            System.out.println(" Book returned: " + book.getTitle());
        }
    }
}
