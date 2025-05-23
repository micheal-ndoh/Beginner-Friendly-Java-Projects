package com.bank;

public class Account {

    private final String pin;
    private double balance;

    /**
     * Constructs a new Account with an initial balance and a PIN.
     *
     * @param initialBalance the starting balance of the account
     * @param pin the PIN used for user authentication
     */
    public Account(double initialBalance, String pin) {
        this.balance = initialBalance;
        this.pin = pin;
    }

    /**
     * Verifies whether the provided PIN matches the account's stored PIN.
     *
     * @param inputPin the PIN to check
     * @return {@code true} if the PIN matches; {@code false} otherwise
     */
    public boolean checkPin(String inputPin) {
        return this.pin.equals(inputPin);
    }

    /**
     * Returns the current balance of the account.
     *
     * @return the account balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deposits a positive amount into the account.
     *
     * @param amount the amount to deposit
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    /**
     * Attempts to withdraw a specified amount from the account. The withdrawal
     * is successful only if the amount is positive and less than or equal to
     * the current balance.
     *
     * @param amount the amount to withdraw
     * @return {@code true} if the withdrawal was successful; {@code false}
     * otherwise
     */
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

}
