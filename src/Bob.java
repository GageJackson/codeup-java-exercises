import java.util.Scanner;
public class Bob {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want?");
        String userInput = scanner.nextLine();

        char userToneByPunctuation = ' ';
        if (userInput.length() > 0){
            userToneByPunctuation = userInput.charAt(userInput.length() - 1);
        }

        if(userToneByPunctuation == '!'){
            System.out.println("Whoa, chill out!!");
        }else if (userToneByPunctuation == '?'){
            System.out.println("Sure...");
        } else if (userToneByPunctuation == ' '){
            System.out.println("Fine! Be that way!");
        }else {
            System.out.println("Whatever...");
        }
    }
}
