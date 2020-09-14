package de.hdm_stuttgart.mi.se2;

/**
 * Interface for dish creation
 */
public interface IDish {

    String description = null;
    int costs = 0;

    /**
     * Removes the ingredients of the dish from the inventory and adds its description and costs to the customers receipt
     */
    boolean removeFromInventory();


}
