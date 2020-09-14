package de.hdm_stuttgart.mi.se2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Class is used to create inventories
 */
public class FileHandler {

    /**
     * Creates map of ingredients from text file to test inventories
     *
     * @param cuisine   chosen restaurant
     * @param location  chosen location of restaurant
     * @param targetMap creats inventory into this targeted map
     */
    public void loadFile(String cuisine, String location, HashMap<String, Integer> targetMap) throws IOException {

        String filePath = "Inventory/" + cuisine + "/" + location + ".txt";

        String line;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                String value = parts[1];
                targetMap.put(key, Integer.parseInt(value));
            } else {
                System.out.println("ignoring line: " + line);
            }
        }

        reader.close();
    }


    /**
     * Creates objects from text file to create table views and inventory of ingredients
     *
     * @param cuisine  chosen restaurant
     * @param location chosen location of restaurant
     */
    public ObservableList loadInventory(String cuisine, String location) throws IOException {


        String filePath = "Inventory/" + cuisine + "/" + location + ".txt";

        ObservableList<Ingredient> ingredients = FXCollections.observableArrayList();

        String line;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                String value = parts[1];
                ingredients.add(new Ingredient(key, Integer.parseInt(value)));
            } else {
                System.out.println("ignoring line: " + line);
            }
        }

        reader.close();

        return ingredients;
    }

}
