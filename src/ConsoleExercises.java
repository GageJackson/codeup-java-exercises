import java.util.Scanner;

public class ConsoleExercises {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer: ");
        int userInt = scanner.nextInt();
        System.out.println("You entered: -->" + userInt);

        System.out.println("Enter 3 words: ");
        String userString1 = scanner.next();
        String userString2 = scanner.next();
        String userString3 = scanner.next();
        System.out.println(userString1 + ", " + userString2 + ", and " + userString3 + " are words");

        System.out.println("Tell me something funny: ");
        String somethingFunny = scanner.nextLine();
        System.out.println(somethingFunny + " is pretty funny!");

        System.out.println("Next, Let's find the specs of your current room");
        System.out.println("What is the length of your room in feet?");
        int roomLength = Integer.parseInt(scanner.nextLine());
        System.out.println("Very cool, Now we need the width: ");
        int roomWidth = Integer.parseInt((scanner.nextLine()));
        int roomPerimeter = roomLength * 2 + roomWidth * 2;
        int roomArea = roomLength * roomWidth;
        System.out.println("Wonderful.");
        System.out.println("Your room's perimeter is " + roomPerimeter + " feet.");
        System.out.println("Your room's ares is " + roomArea + " feet^2.");

    }
}
