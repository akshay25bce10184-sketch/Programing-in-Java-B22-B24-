package Javafiles.util;

import java.util.Scanner;

public class InputValidator {

    private InputValidator() {
        // Utility class
    }

    public static int readInt(
            Scanner scanner,
            String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a valid integer.");
            }
        }
    }

    public static int readPositiveInt(
            Scanner scanner,
            String message) {

        while (true) {

            int value = readInt(scanner, message);

            if (value > 0) {
                return value;
            }

            System.out.println(
                    "Value must be greater than zero.");
        }
    }

    public static int readIntInRange(
            Scanner scanner,
            String message,
            int minimum,
            int maximum) {

        while (true) {

            int value = readInt(scanner, message);

            if (value >= minimum &&
                    value <= maximum) {

                return value;
            }

            System.out.println(
                    "Value must be between " +
                            minimum + " and " +
                            maximum + ".");
        }
    }

    public static double readDouble(
            Scanner scanner,
            String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            try {

                return Double.parseDouble(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a valid number.");
            }
        }
    }

    public static double readDoubleInRange(
            Scanner scanner,
            String message,
            double minimum,
            double maximum) {

        while (true) {

            double value = readDouble(scanner, message);

            if (value >= minimum &&
                    value <= maximum) {

                return value;
            }

            System.out.println(
                    "Value must be between " +
                            minimum + " and " +
                            maximum + ".");
        }
    }

    public static String readNonEmptyString(
            Scanner scanner,
            String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println(
                    "Input cannot be empty.");
        }
    }
}