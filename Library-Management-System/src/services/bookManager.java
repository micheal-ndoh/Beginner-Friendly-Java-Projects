package services;

import java.util.Scanner;

public class bookManager {

    private static Scanner scanner = new Scanner(System.in);

    public static void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        Book book = new Book(id, title, author);
        id.put(bookIdCounter, book);
        System.out.println("Book added with ID: " + bookIdCounter);
        bookIdCounter++;
    }

    public static void removeBook() {
        System.out.print("Enter book ID to remove: ");
        int id = scanner.nextInt();

        if (books.remove(id) != null) {
            System.out.println(" Book removed.");
        } else {
            System.out.println(" Book not found.");
        }
    }

    public static void searchBook() {
        System.out.print("Enter book ID to search: ");
        int id = scanner.nextInt();

        Book book = books.get(id);
        if (book != null) {
            System.out.println("Found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }

    public static void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }

        System.out.println("\n Book List:");
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    public static void borrowBook() {
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

    public static void returnBook() {
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
