package util;
import java.util.Scanner;
public class Input {
    private Scanner scanner = new Scanner(System.in);

    public String getString(String prompt) {
        String userInput = "";
        userInput = validString();
        System.out.println(prompt);
        return userInput;
    }

    public String getString() {
        String userInput = "";
        userInput = validString();
        System.out.println("Say anything");
        return userInput;
    }

    public String validString() {
        boolean isString = false;
        String userString = "";

        while (!isString) {
            if (scanner.hasNext()) {
                userString = scanner.next();
                isString = true;
            } else {
                System.out.println("Please enter a String");
                scanner.next();
            }
        }
        return userString;
    }

    public boolean yesNo(String prompt) {
        System.out.println(prompt);
        String input = scanner.next();
        return input.equalsIgnoreCase("y") || input.equals("yeah") || input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("true");
    }

    public boolean yesNo() {
        System.out.println("Enter \"y\" to continue");
        String input = scanner.next();
        return input.equalsIgnoreCase("y") || input.equals("yeah") || input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("true");
    }

    public int getInt(int min, int max, String prompt) {
        int userInput = 0;
        do{
            System.out.println(prompt);
            userInput = validInt();
        }while (userInput > max || userInput < min);

        return userInput;
    }

    public int getInt(int min, int max) {
        int userInput = 0;
        do{
            System.out.printf("Please enter an integer between %s and %s %n", min, max);
            userInput = validInt();
        }while (userInput > max || userInput < min);

        return userInput;
    }

    public int getInt(String prompt) {
        System.out.println(prompt);
        return validInt();
    }

    public int getInt() {
        return validInt();
    }

    public int validInt() {
        boolean isInt = false;
        int userInt = 0;

        while (!isInt) {
            if (scanner.hasNextInt()) {
                userInt = scanner.nextInt();
                isInt = true;
            } else {
                System.out.println("Please enter an integer");
                scanner.next();
            }
        }
        return userInt;
    }

    public double getDouble(double min, double max, String prompt) {
        double userInput = 0;
        do{
            System.out.println(prompt);
            userInput = validDouble();
        }while (userInput > max || userInput < min);

        return userInput;
    }

    public double getDouble(double min, double max) {
        double userInput = 0;
        do{
            System.out.printf("Please enter an double between %s and %s %n", min, max);
            userInput = validDouble();
        }while (userInput > max || userInput < min);

        return userInput;
    }

    public double getDouble(String prompt) {
        System.out.println(prompt);
        return validDouble();
    }

    public double getDouble() {
        return validDouble();
    }

    public double validDouble() {
        boolean isDouble = false;
        double userDouble = 0;

        while (!isDouble) {
            if (scanner.hasNextDouble()) {
                userDouble = scanner.nextDouble();
                isDouble = true;
            } else {
                System.out.println("Please enter an double");
                scanner.next();
            }
        }
        return userDouble;
    }
}