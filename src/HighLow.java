import java.util.Scanner;
public class HighLow {
    public static void main(String[] args) {
        int gameNumberMin = 1;
        int gameNumberMax = 100;
        int gameGuessLimit = 10;
        int gameNumber = (int)Math.floor(Math.random() * gameNumberMax + gameNumberMin);

        gameInstructions(gameNumberMin,gameNumberMax,gameGuessLimit);
        runGame(gameNumber,gameGuessLimit, gameNumberMin, gameNumberMax);
    }

    public static void gameInstructions(int gameNumberMin, int gameNumberMax, int gameGuessLimit){
        System.out.println("Let's Play HighLow!");
        System.out.printf("I've chosen a number between %s and %s %n", gameNumberMin, gameNumberMax);
        System.out.println("Guess a number and I will tell you if you got it correct,");
        System.out.println("Or if it's incorrect and is HIGHER or LOWER");
        System.out.printf("You get %s guesses %n", gameGuessLimit);
    }
    public static void runGame(int gameNumber, int gameGuessLimit, int minGuess, int maxGuess){
        int userGuessCount = 1;
        int userGuess;
        boolean correctGuess = false;

        while(userGuessCount <= gameGuessLimit && !correctGuess){
            userGuess = getUserGuess(minGuess, maxGuess);

            if(userGuess == gameNumber){
                System.out.println("You win!");
                correctGuess = true;

            } else if (userGuess > gameNumber) {
                System.out.println("Lower");

            } else {
                System.out.println("Higher");
            }

            System.out.printf("Guess %s of %s %n", userGuessCount, gameGuessLimit);
            userGuessCount += 1;
        }
    }

    public static int getUserGuess(int minGuess, int maxGuess){
        int userInput = 0;
        do{
            System.out.printf("What is your guess? (between %s and %s) %n", minGuess, maxGuess);
            userInput = validUserGuess();
        }while (userInput > maxGuess || userInput < minGuess);

        return userInput;
    }

    public static int validUserGuess(){
        Scanner scanner = new Scanner(System.in);
        boolean isInt = false;
        int userNum = 0;

        while(!isInt){
            if(scanner.hasNextInt()){
                userNum = scanner.nextInt();
                isInt = true;
            } else {
                System.out.println("Wrong input type, please insert an integer");
                scanner.next();
            }
        }

        return userNum;
    }
}
