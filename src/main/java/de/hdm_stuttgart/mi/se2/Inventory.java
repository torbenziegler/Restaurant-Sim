package de.hdm_stuttgart.mi.se2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Inventory for ingredients
 */
public class Inventory {


    /**
     * saves ingredients and uses them to calculate the current inventory
     */
    public static HashMap<String, Integer> ingredients = new HashMap<>();


    /**
     * gets ingredients from inventory
     */
    public static HashMap<String, Integer> getIngredients() {
        return ingredients;
    }


    /**
     * sets ingredients in inventory
     *
     * @param ingredients hashmap of ingredients
     */
    public static void setIngredients(HashMap<String, Integer> ingredients) {
        Inventory.ingredients = ingredients;
    }
}


