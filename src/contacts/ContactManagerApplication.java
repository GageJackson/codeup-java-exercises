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
    boolean runProgram = true;
    public static void main(String[] args) {
        ContactManagerApplication cma = new ContactManagerApplication();
        cma.setupFile();

        do{
            int userChoice = cma.createCLI();
            cma.doThing(userChoice);
        }while (cma.runProgram);
        System.out.println("Have a good day!");
    }

    public void setupFile(){
        List<String> contactList = Arrays.asList("Gage Jackson,9038675309", "Hubert Lowry,9034567890");

        Path dataDirectory = getDataDirectory();
        Path dataFile = getDataFile();

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
                Files.write(dataFile, contactList);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Path getDataFile(){
        String directory = "data";
        String filename = "contacts.txt";
        return Paths.get(directory, filename);
    }

    public Path getDataDirectory(){
        String directory = "data";
        return Paths.get(directory);
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
        Path contactDataFile = getDataFile();
        List<String> contactList = null;

        try {
            contactList = Files.readAllLines(contactDataFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        handleContacts(contactList);

    }

    public void addContact(){
        String newContactName = input.getString("Add a new contact name");
        long newContactNumber = input.getLong("Add a new contact number");
        String newContact = newContactName + "," + newContactNumber;

        try {
            Files.write(
                    getDataFile(),
                    Arrays.asList(newContact),
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchContacts(){
        System.out.println("You are searching contacts");
    }

    public void deleteContact(){
        viewContacts();
        String removeContact = input.getString("Remove contact");


        List<String> lines = null;
        List<String> newList = new ArrayList<>();

        try {
            lines = Files.readAllLines(getDataFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        for (String line : lines) {
            if (line.contains(removeContact)) {
                continue;
            }
            newList.add(line);
        }

        try {
            Files.write(getDataFile(), newList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void exit(){
        runProgram = false;
    }

    public void handleContacts(List<String> contactList){
        int longestStringInt = 0;
        ArrayList<String> contactNames = new ArrayList<>();
        ArrayList<String> contactNumbers = new ArrayList<>();

        for (int i = 0; i < contactList.size(); i++) {
            String currentName = "";
            String currentNumber = "";

            String[] currentContact = contactList.get(i).split(",");
            currentName = currentContact[0];
            currentNumber = currentContact[1];

            if(currentName.length() > longestStringInt){
                longestStringInt = currentName.length();
            }

            contactNames.add(currentName);
            contactNumbers.add(formatPhoneNumber(currentNumber));
        }

        displayContacts( contactNames,  contactNumbers, longestStringInt);
    }

    public void displayContacts(ArrayList<String> contactNames, ArrayList<String> contactNumbers, int longestStringInt){
        String dashes = "";
        for (int i = 0; i < longestStringInt + 19; i++) {
            dashes += "-";
        }
        System.out.println(dashes);
        formatContacts("Name", "Phone Number", longestStringInt);

        System.out.println(dashes);
        for (int i = 0; i < contactNames.size(); i++) {
            formatContacts(contactNames.get(i),contactNumbers.get(i), longestStringInt);
        }
        System.out.println(dashes + "\n");
    }

    public void formatContacts(String contactName, String contactNumber, int nameFormat){
        String formattedContact = "| ";
        int numberFormat = 12;
        formattedContact += String.format("%-" + nameFormat + "." + nameFormat + "s", contactName);
        formattedContact += " | ";

        formattedContact += String.format("%-" + numberFormat + "." + numberFormat + "s", contactNumber);;
        formattedContact += " |";

        System.out.println(formattedContact);
    }

    public String formatPhoneNumber(String phoneNumber){
        String formattedPhoneNumber = "";
        String[] separatedNumber = phoneNumber.split("");
        formattedPhoneNumber = separatedNumber[0] + separatedNumber[1] + separatedNumber[2] + "-";

        if(phoneNumber.length() == 7){
            formattedPhoneNumber += separatedNumber[3] + separatedNumber[4] + separatedNumber[5] + separatedNumber[6];
        } else if (phoneNumber.length() == 10){
            formattedPhoneNumber += separatedNumber[3] + separatedNumber[4] + separatedNumber[5] + "-";
            formattedPhoneNumber += separatedNumber[6] + separatedNumber[7] + separatedNumber[8] + separatedNumber[9];
        } else {
            formattedPhoneNumber = phoneNumber;
        }

        return formattedPhoneNumber;
    }
}
