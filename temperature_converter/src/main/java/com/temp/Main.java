package com.temp;   
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.print("Enter value: ");
        double value = scanner.nextDouble();

        System.out.print("From unit (C/F/K): ");
        char from = scanner.next().toUpperCase().charAt(0);

        System.out.print("To unit (C/F/K): ");
        char to = scanner.next().toUpperCase().charAt(0);

        double result = convert(value, from, to);
        System.out.printf("%.2f%c = %.2f%c\n", value, from, result, to);

        scanner.close();
    }

    public static double convert(double temp, char from, char to) {
        if (from == to) return temp;
        switch (from) {
            case 'C': return (to == 'F') ? temp * 9/5 + 32 : temp + 273.15;
            case 'F': return (to == 'C') ? (temp - 32) * 5/9 : (temp - 32) * 5/9 + 273.15;
            case 'K': return (to == 'C') ? temp - 273.15 : (temp - 273.15) * 9/5 + 32;
            default: throw new IllegalArgumentException("Invalid unit");
        }
    }
}