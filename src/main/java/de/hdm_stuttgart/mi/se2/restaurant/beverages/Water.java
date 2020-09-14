package de.hdm_stuttgart.mi.se2.restaurant.beverages;

import de.hdm_stuttgart.mi.se2.IDish;
import de.hdm_stuttgart.mi.se2.Order;


/**
 * Creates dish Water
 */
public class Water implements IDish {

    String description = "Water";
    int costs = 1;

    /**
     * Removes the ingredients of the dish from the inventory and adds its description and costs to the customers receipt
     */
    @Override
    public boolean removeFromInventory() {
        Order add = new Order();
        add.addToCurrentOrder(description);
        add.addToOrderPrice(costs);
        return true;
    }
}
