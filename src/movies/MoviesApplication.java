package movies;
import util.Input;

import java.util.Arrays;

public class MoviesApplication {
    public static void main(String[] args) {
        Input input = new Input();
        boolean runProgram = true;

        do {
            showOptions();
            int userInput = input.getInt(0,5);
            String userOutput = getMovieGenre(userInput);

            if(userOutput.equals("exit")){
                runProgram = false;
                System.out.println("Thanks for watching!");
            } else {
                setMovieCollection(userOutput);
            }
        } while (runProgram);
    }

    public static void showOptions(){
        System.out.println("What would you like to do? \n");

        System.out.println("0 - exit");
        System.out.println("1 - view mall movies");
        System.out.println("2 - view movies in animated category");
        System.out.println("3 - view movies in drama category");
        System.out.println("4 - view movies in horror category");
        System.out.println("5 - view movies in scifi category \n");

        System.out.println("Enter your choice: ");
    }

    public static void setMovieCollection(String input){
        Movie [] movieCollection = new Movie[MoviesArray.findAll().length];

        for(int i = 0; i < MoviesArray.findAll().length; i ++){
            movieCollection[i] = MoviesArray.findAll()[i];

            if(movieCollection[i].getCategory().equals(input)){
                System.out.println(movieCollection[i].getName());
            } else if (input.equals("all")) {
                System.out.println(movieCollection[i].getName());
            }
        }
    }

    public static String getMovieGenre(int input){
        return switch (input) {
            case 1 -> "all";
            case 2 -> "animated";
            case 3 -> "drama";
            case 4 -> "horror";
            case 5 -> "scifi";
            default -> "exit";
        };
    }
}
