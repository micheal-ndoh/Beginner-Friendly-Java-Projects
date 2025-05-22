import MathOperations.Addition;
import MathOperations.Divide;
import MathOperations.Factorial;
import MathOperations.Multiply;
import MathOperations.Substraction;

import java.util.Scanner;
import java.math.BigInteger;

public class Calculator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("-------------------------------------");
        System.out.println("|  Welcome to the Calculator App    |");
        System.out.println("-------------------------------------");

        while (true) {
            System.out.println("Enter your calculation:");
            System.out.println("Use: + for addition \n - for subtraction \n* for multiplication \n / for division \n ! for factorial");
            System.out.println("Type 'exit' or 'q' to quit.");
            System.out.print("\nInput: ");

            String input = scan.nextLine().replaceAll("\\s", "").toLowerCase();

            if (input.equals("exit") || input.equals("q")) {
                System.out.println("Exiting Calculator.....");
                break;
            }

            try {
                if (input.contains("!")) {
                    BigInteger n = new BigInteger(input.replace("!", ""));
                    BigInteger result = new Factorial().fact(n);
                    System.out.println("Result: " + result);
                } else {
                    String[] parts = input.split("(?<=[-+*/])|(?=[-+*/])");

                    if (parts.length != 3) {
                        System.out.println("\nInvalid input format. Please enter a valid calculation.");
                        continue;
                    }

                    BigInteger a = new BigInteger(parts[0]);
                    String operation = parts[1];
                    BigInteger b = new BigInteger(parts[2]);

                    BigInteger result;
                    switch (operation) {
                        case "+":
                            result = new Addition().add(a, b);
                            break;
                        case "-":
                            result = new Substraction().substract(a, b);
                            break;
                        case "*":
                            result = new Multiply().multiply(a, b);
                            break;
                        case "/":
                            if (b.equals(BigInteger.ZERO)) {
                                System.out.println("Division by zero is not allowed.");
                                continue;
                            }
                            result = new Divide().divide(a, b);
                            break;
                        default:
                            System.out.println("Unknown operator.");
                            continue;
                    }

                    System.out.println("Result: " + result);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number input.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println();
        }

        scan.close();
    }
}
