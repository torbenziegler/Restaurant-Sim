package de.hdm_stuttgart.mi.se2;


/**
 * Class is used to create ingredient objects
 */
public class Ingredient {

    public String name;
    public int amount;

    /**
     * Constructor to create an empty ingredient, used by the tableView
     */
    public Ingredient() {
        this.name = "";
        this.amount = 0;
    }

    /**
     * Constructor to create a specified ingredient
     *
     * @param name   name of ingredient
     * @param amount amount of ingredient
     */
    public Ingredient(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    /**
     * TableView in Inventory Manager GUI uses this method to get the names of ingredients
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of ingredient
     *
     * @param name name of ingredient
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * TableView in Inventory Manager GUI uses this method to get the amount of ingredients
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Sets amount of ingredient
     *
     * @param amount of ingredient
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
