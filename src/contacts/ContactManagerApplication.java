package contacts;
import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactManagerApplication {
    Input input = new Input();
    public static void main(String[] args) {
        ContactManagerApplication cma = new ContactManagerApplication();
        cma.setupFile();

        int userChoice = cma.createCLI();
        cma.doThing(userChoice);
    }

    public void setupFile(){
        String directory = "data";
        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        if (Files.notExists(dataDirectory)) {
            try {
                Files.createDirectories(dataDirectory);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (! Files.exists(dataFile)) {
            try {
                Files.createFile(dataFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int createCLI(){
        System.out.println("1. View contacts.");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit");
        return input.getInt(1,5,"Enter an option (1, 2, 3, 4 or 5):\n");
    }

    public void doThing(int userChoice){
        switch (userChoice) {
            case 1 -> viewContacts();
            case 2 -> addContact();
            case 3 -> searchContacts();
            case 4 -> deleteContact();
            default -> exit();
        }
    }

    public void viewContacts(){
        System.out.println("You are viewing contacts");
    }

    public void addContact(){
        System.out.println("You are adding contacts");
    }

    public void searchContacts(){
        System.out.println("You are searching contacts");
    }

    public void deleteContact(){
        System.out.println("You are deleting contacts");
    }

    public void exit(){
        System.out.println("You are exiting");
    }
}
