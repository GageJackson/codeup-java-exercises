package util;
import java.util.Scanner;
public class Input {
    private Scanner scanner = new Scanner(System.in);

    public String getString(String prompt) {
        String userInput = "";
        System.out.println(prompt);
        userInput = validString();
        return userInput;
    }

    public String getString() {
        String userInput = "";
        System.out.println("Say anything");
        userInput = validString();
        return userInput;
    }

    public String validString() {
        boolean isString = false;
        String userString = "";

        while (!isString || userString.equals("") || userString.equals(" ")) {
            if (scanner.hasNext()) {
                userString = scanner.nextLine();
                isString = true;
            } else {
                System.out.println("Please enter a String");
                scanner.nextLine();
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

    public long getLong(long min, long max, String prompt) {
        long userInput = 0;
        do{
            System.out.println(prompt);
            userInput = validLong();
        }while (userInput > max || userInput < min);

        return userInput;
    }

    public long getLong(long min, long max) {
        long userInput = 0;
        do{
            System.out.printf("Please enter an integer between %s and %s %n", min, max);
            userInput = validLong();
        }while (userInput > max || userInput < min);

        return userInput;
    }

    public long getLong(String prompt) {
        System.out.println(prompt);
        return validLong();
    }

    public long getLong() {
        return validLong();
    }

    public long validLong() {
        boolean isLong = false;
        long userLong = 0;

        while (!isLong) {
            if (scanner.hasNextLong()) {
                userLong = scanner.nextLong();
                isLong = true;
            } else {
                System.out.println("Please enter a Long number");
                scanner.next();
            }
        }
        return userLong;
    }
}