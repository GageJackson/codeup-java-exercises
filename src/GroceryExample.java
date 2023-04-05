import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroceryExample {
    Input input = new Input();
    public static void main(String[] args) {
        GroceryExample groEx = new GroceryExample();
        groEx.createFile();

        int output = groEx.createCLI();
        System.out.println(output);
    }

    public void createFile() {
        String directory = "data";
        String filename = "info.txt";

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
        List<String> groceryList = Arrays.asList("coffee", "milk", "sugar", "watermelon");
        Path filepath = Paths.get("data", "groceries.txt");
        try {
            Files.write(filepath, groceryList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Path groceriesPath = Paths.get("data", "groceries.txt");
        //List<String> groceryList = null;
        try {
            groceryList = Files.readAllLines(groceriesPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < groceryList.size(); i += 1) {
            System.out.println((i + 1) + ": " + groceryList.get(i));
        }

        try {
            Files.write(
                    Paths.get("data", "groceries.txt"),
                    Arrays.asList("eggs"), // list with one item
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("data", "groceries.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String> newList = new ArrayList<>();

        for (String line : lines) {
            if (line.equals("milk")) {
                newList.add("cream");
                continue;
            }
            newList.add(line);
        }

        try {
            Files.write(Paths.get("data", "groceries.txt"), newList);
        } catch (IOException e) {
            throw new RuntimeException(e);
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

}
