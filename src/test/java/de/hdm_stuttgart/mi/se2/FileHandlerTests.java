package de.hdm_stuttgart.mi.se2;


import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;




/**
 * JUnit tests for testing the loading of text files
 */
public class FileHandlerTests {


    /**
     * Testing loading of italian inventory
     */
    @Test
    public void testLoadFilesItalianInventory() throws IOException {
        FileHandler testLoad0 = new FileHandler();
        testLoad0.loadFile("Italian Restaurant", "Stuttgart Vaihingen", Inventory.ingredients);
        Assert.assertEquals(26, Inventory.ingredients.size());   // Checks if HashMap was created with all its ingredients (correct size of map)
        Assert.assertNotEquals(5, Inventory.ingredients.size());
    }

    /**
     * Testing loading of german inventory
     */
    @Test
    public void testLoadFilesGermanInventory() throws IOException {
        FileHandler testLoad1 = new FileHandler();
        testLoad1.loadFile("German Restaurant", "Stuttgart Mitte", Inventory.ingredients);
        Assert.assertEquals(27, Inventory.ingredients.size());   // Checks if HashMap was created with all its ingredients (correct size of map)
        Assert.assertNotEquals(10, Inventory.ingredients.size());
    }


    /**
     * Testing loading of french inventory
     */
    @Test
    public void testLoadFilesFrenchInventory() throws IOException {
        FileHandler testLoad2 = new FileHandler();
        testLoad2.loadFile("French Restaurant", "Stuttgart Süd", Inventory.ingredients);
        Assert.assertEquals(33, Inventory.ingredients.size());   // Checks if HashMap was created with all its ingredients (correct size of map)
        Assert.assertNotEquals(1200, Inventory.ingredients.size());
    }

}




