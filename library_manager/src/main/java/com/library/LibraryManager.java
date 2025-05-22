package com.library;

import java.util.Scanner;

import com.library.services.BookManager;

public class LibraryManager {

    private final BookManager bookManager;
    private final Scanner scanner;

    public LibraryManager() {
        this.bookManager = new BookManager();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println(" -------------------------------");
        System.out.println("|      Welcome to the           |");
        System.out.println("|  Library Management System    |");
        System.out.println(" -------------------------------\n");
        int choice = 0;
        do {
            System.out.println(" \n--------------------------------");
            System.out.println("| Select an option from the Menu |");
            System.out.println(" --------------------------------\n");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. List Books");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        bookManager.addBook(scanner);
                        break;
                    case 2:
                        bookManager.removeBook(scanner);
                        break;
                    case 3:
                        bookManager.searchBook(scanner);
                        break;
                    case 4:
                        bookManager.listBooks();
                        break;
                    case 5:
                        bookManager.borrowBook(scanner);
                        break;
                    case 6:
                        bookManager.returnBook(scanner);
                        break;
                    case 0:
                        System.out.println("Exiting..");
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                scanner.nextLine();
            }
        } while (choice != 0);
    }

    public static void main(String[] args) {
        new LibraryManager().run();
    }
}
