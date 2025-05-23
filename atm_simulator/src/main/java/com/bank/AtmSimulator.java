package com.bank;

import java.util.Scanner;

public class AtmSimulator {

    /**
     * Main method to run the ATM simulator. It handles user authentication,
     * transaction selection, and input validation.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an account with a starting balance of $1000.00 and PIN "1234"
        Account account = new Account(10000.0, "*****");

        int attempts = 0; // Counter for incorrect PIN attempts
        boolean authenticated = false; // Tracks successful login

        // Authenticate user with a maximum of 3 PIN attempts
        while (attempts < 3) {
            System.out.print("\nEnter your PIN: ");
            String inputPin = scanner.nextLine();

            if (account.checkPin(inputPin)) {

                // Successful login
                System.out.println("Login successful.");
                authenticated = true;
                break;
            } else {
                // Failed login attempt
                attempts++;
                System.out.println("Incorrect PIN. Attempts left: " + (3 - attempts));
            }
        }

        if (!authenticated) {
            // Lock the account after 3 failed attempts
            System.out.println("Account locked due to too many incorrect attempts.");
            scanner.close();
            return;
        }

        // Display ATM menu in a loop until user exits
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("\nChoose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.printf("Your balance: $%.2f%n", account.getBalance());
                    break;

                case "2":
                    System.out.print("Enter deposit amount: ");
                    try {
                        double deposit = Double.parseDouble(scanner.nextLine());
                        if (deposit <= 0) {
                            System.out.println("Invalid amount.");
                        } else {
                            account.deposit(deposit);
                            System.out.println("Deposit successful.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                    }
                    break;

                case "3":
                    System.out.print("Enter withdrawal amount: ");
                    try {
                        double withdraw = Double.parseDouble(scanner.nextLine());
                        if (withdraw <= 0) {
                            System.out.println("Invalid amount.");
                        } else if (account.withdraw(withdraw)) {
                            System.out.println("Withdrawal successful.");
                        } else {
                            System.out.println("Insufficient funds.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                    }
                    break;

                case "4":
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;

                default:
                    // Handle invalid menu choice
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

}
