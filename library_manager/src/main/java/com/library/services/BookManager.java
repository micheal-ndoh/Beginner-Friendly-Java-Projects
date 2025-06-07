package com.library.services;

import java.util.HashMap;
import java.util.Scanner;

public class BookManager {

    public final HashMap<Integer, Book> books = new HashMap<>();
    int bookIdCounter = 1;

    public void addBook(Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        Book book = new Book(bookIdCounter, title, author);
        books.put(bookIdCounter, book);
        System.out.println("Book added successfully. \n Book ID: " + bookIdCounter);
        bookIdCounter++;
    }

    public void removeBook(Scanner scanner) {
        System.out.print("\nEnter book ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (books.remove(id) != null) {
            System.out.println("Book with ID " + id + " removed successfully.");
            HashMap<Integer, Book> newBooks = new HashMap<>();
            int newId = 1;
            for (Book book : books.values()) {
                book.setId(newId);
                newBooks.put(newId, book);
                newId++;
            }
            books.clear();
            books.putAll(newBooks);
            bookIdCounter = newId;
        } else {
            System.out.println("Book not found.");
        }
    }

    public void searchBook(Scanner scanner) {
        System.out.print("Enter book ID to search: ");
        int id = scanner.nextInt();

        Book book = books.get(id);
        if (book != null) {
            System.out.println("Found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }

        System.out.println("\n Book List:");
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    public void borrowBook(Scanner scanner) {
        System.out.print("\nEnter book ID to borrow: ");
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

    public void returnBook(Scanner scanner) {
        System.out.print("\nEnter book ID to return: ");
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
    /* this comment /* // /** is not valid */
}
