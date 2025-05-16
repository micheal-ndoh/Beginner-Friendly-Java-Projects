import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to my temperature converter");
        System.out.println("Please enter the temperature you want to convert (e.g., 100C, 212F, 300K):");
        String input = scanner.nextLine();

        double temperature = Double.parseDouble(input.substring(0, input.length() - 1));
        char unit = input.charAt(input.length() - 1);

        System.out.println("Convert to which unit? (C/F/K):");
        char toUnit = scanner.next().charAt(0);

        scanner.close();

        double convertedTemperature;
        if (unit == 'C') {
            convertedTemperature = convertFromCelsius(temperature, toUnit);
        } else if (unit == 'F') {
            convertedTemperature = convertFromFahrenheit(temperature, toUnit);
        } else {
            convertedTemperature = convertFromKelvin(temperature, toUnit);
        }

        System.out.println("The temperature in " + toUnit + " is: " + convertedTemperature);
    }

    public static double convertFromCelsius(double temperature, char toUnit) {
        switch (toUnit) {
            case 'F':
                return (temperature * 9 / 5) + 32;
            case 'K':
                return temperature + 273.15;
            case 'C':
                return temperature;
            default:
                throw new IllegalArgumentException("Invalid target unit: " + toUnit);
        }
    }

    public static double convertFromFahrenheit(double temperature, char toUnit) {
        switch (toUnit) {
            case 'C':
                return (temperature - 32) * 5 / 9;
            case 'K':
                return (temperature - 32) * 5 / 9 + 273.15;
            case 'F':
                return temperature;
            default:
                throw new IllegalArgumentException("Invalid target unit: " + toUnit);
        }
    }

    public static double convertFromKelvin(double temperature, char toUnit) {
        switch (toUnit) {
            case 'C':
                return temperature - 273.15;
            case 'F':
                return (temperature - 273.15) * 9 / 5 + 32;
            case 'K':
                return temperature;
            default:
                throw new IllegalArgumentException("Invalid target unit: " + toUnit);
        }
    }
}