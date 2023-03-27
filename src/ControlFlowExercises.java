import java.util.Scanner;

public class ControlFlowExercises {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i = 5;

        while (i <= 15){
            System.out.println(i);
            i++;
        }

        long squared = 2;

        do {
            System.out.println(squared);
            squared *= squared;
        }while(squared < 1000000);

        for(int j = 0; j < 100; j++){
            if(j % 15 == 0){
                System.out.println("FizzBuzz");
            } else if (j % 3 == 0){
                System.out.println("Fizz");
            } else if (j % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(j);
            }
        }

        int userInt = 0;

        do {
            System.out.println("Enter a Number 1-10");
            userInt = Integer.parseInt(scanner.nextLine());

            if(userInt <= 0 || userInt > 10){
                System.out.println("Nope, won't do it.");
                break;
            }

            System.out.println("number | squared | cubed");
            System.out.println("------ | ------- | -----");
            for(int k = 1; k < userInt + 1; k++){
                System.out.println(k + "      | " + k * k + "       | " + k*k*k + "    ");
            }
        }while(userInt > 0);

        boolean wantsToGrade = true;
        do {
            System.out.println("Enter a numerical grade from 0-100, and I will give you a letter grade");
            int userGrade = scanner.nextInt();

            if (userGrade < 0 || userGrade > 100) {
                System.out.println("Invalid input. Please enter a grade between 0 and 100.");
            } else if (userGrade < 60) {
                System.out.println("That grade is an F");
            } else if (userGrade < 67) {
                System.out.println("That grade is a D");
            } else if (userGrade < 80) {
                System.out.println("That grade is a C");
            } else if (userGrade < 88) {
                System.out.println("That grade is a B");
            } else {
                System.out.println("That grade is an A");
            }

            System.out.println("Do you want to enter another grade? y/n");
            String yesOrNo = scanner.next();
            wantsToGrade = yesOrNo.equals("y") || yesOrNo.equals("Y");
        }while(wantsToGrade);
    }
}
