import java.util.Scanner;
public class MethodsExercises {
    public static void main(String[] args) {
        int number1 = 100;
        int number2 = 7;

        float addedNumbers = addition(number1, number2);
        float subtractedNumbers = subtraction(number1, number2);
        float multipliedNumbers = multiplication(number1, number2);
        float dividedNumbers = division(number1, number2);
        float moddedNumbers = modulus(number1, number2);

        System.out.printf("Your numbers %s and %s added are %s, subtracted are %s, multiplied are %s, divided are %s, and modulus-ed are %s %n", number1, number2, addedNumbers, subtractedNumbers, multipliedNumbers, dividedNumbers, moddedNumbers);

//        int userNumber = getInteger(1,20);
//        System.out.printf("Your number is %s%n", userNumber);

//        findFactorial(userNumber);

//        System.out.println("Let's play with dice! Choose a number between 1-100 for the total of di faces");
//        int diSize = getInteger(1,100);
//        rollDice(diSize);
//        count(5);
    }

    public static float addition(float input1, float input2){
        return input1 + input2;
    }

    public static float subtraction(float input1, float input2){
        return input1 - input2;
    }

    public static float multiplication(float input1, float input2){
        return input1 * input2;
    }

    public static float division(float input1, float input2){
        return input1 / input2;
    }

    public static int modulus(int input1, int input2){
        return input1 % input2;
    }

    public static int getInteger(int min, int max){
        Scanner scanner = new Scanner(System.in);
        int userNumber = 0;
        int goodNumber = 0;
        System.out.println("-------------------------------");
        System.out.println("Enter a number between " + min + " and " + max);

        userNumber = scanner.nextInt();

        if(userNumber <= max && userNumber >= min){
            goodNumber = userNumber;
            System.out.printf("%s is an acceptable number%n", goodNumber);
            return goodNumber;
        } else {
            System.out.println("Nope, try again.");
            goodNumber = getInteger(1,20);
        }
        return goodNumber;
    }

    public static void findFactorial (int num){
        String outputString = "";
        long outputNum = 1;
        for(int i = 1; i <= num; i++){
            outputString += i + "! = 1";
            for(int j = 1; j <= i; j++){
                if(j == 1){
                    continue;
                } else if (j < i){
                    outputNum *= j;
                    outputString += " x " + j;
                } else {
                    outputNum *= j;
                    outputString += " x " + j + " = " + outputNum;
                }
            }
            outputString += "\n";
        }
        System.out.println(outputString);
    }

    public static void rollDice(int numberOfSides){
        Scanner scanner = new Scanner(System.in);
        boolean wouldLikeToRoll = true;

        System.out.println("Would you like to roll the dice? y/n");
        String userResponse = scanner.next();
        wouldLikeToRoll = userResponse.equals("y") || userResponse.equals("Y");

        while(wouldLikeToRoll){
            System.out.println("Cool! Let's roll them dice!!");
            int diRollResult1 = (int) Math.floor(Math.random() * numberOfSides + 1);
            int diRollResult2 = (int) Math.floor(Math.random() * numberOfSides + 1);

            System.out.printf("You rolled a %s and a %s on your two %s-sided dice!%n", diRollResult1, diRollResult2, numberOfSides);

            System.out.println("Would you like to roll again? y/n");
            String rollAgain = scanner.next();
            wouldLikeToRoll = rollAgain.equals("y") || rollAgain.equals("Y");
        }
    }
    public static void count(int n) {
        if (n <= 0) {
            System.out.println("All done!");
            return;
        }
        System.out.println(n);
        count(n - 1);
        count(n - 1);
    }

}
