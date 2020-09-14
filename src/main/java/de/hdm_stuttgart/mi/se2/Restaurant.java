package de.hdm_stuttgart.mi.se2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * sets up the restaurant
 */
public class Restaurant {

    public static String cuisine;
    public static String location;

    /**
     * sets cuisine
     *
     * @param cuisine type of restaurant
     */
    public static void setCuisine(String cuisine) {
        Restaurant.cuisine = cuisine;
    }


    /**
     * sets location
     *
     * @param location location of restaurant
     */
    public static void setLocation(String location) {
        Restaurant.location = location;
    }


}
