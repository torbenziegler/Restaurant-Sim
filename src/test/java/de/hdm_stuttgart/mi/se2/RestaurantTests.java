package de.hdm_stuttgart.mi.se2;

import org.junit.Assert;
import org.junit.Test;


/**
 * JUnit tests for choosing restaurants
 */
public class RestaurantTests {

    /**
     * Testing whether cuisine is set
     */
    @Test
    public void setCuisineTest() {
        Restaurant.setCuisine("German Restaurant");
        Assert.assertEquals("German Restaurant", Restaurant.cuisine);
    }

    /**
     * Testing whether location is set
     */
    @Test
    public void setLocationTest() {
        Restaurant.setLocation("Heilbronn Hbf");
        Assert.assertEquals("Heilbronn Hbf", Restaurant.location);
    }

    /**
     * Testing whether cuisine and location are set
     */
    @Test
    public void Combined() {
        Restaurant.setCuisine("Italian Restaurant");
        Restaurant.setLocation("Heidelberg Altstadt");

        Assert.assertEquals("Italian Restaurant", Restaurant.cuisine);
        Assert.assertEquals("Heidelberg Altstadt", Restaurant.location);
    }

    /**
     * Negative test of setting cuisine and location
     */
    @Test
    public void CombinedNegative() {
        Restaurant.setCuisine("Spanish Restaurant");
        Restaurant.setLocation("Sevilla");

        Assert.assertNotEquals("German Restaurant", Restaurant.cuisine);
        Assert.assertNotEquals("Stuttgart Mitte", Restaurant.location);
    }

}
