package de.hdm_stuttgart.mi.se2.restaurant.french;

import de.hdm_stuttgart.mi.se2.IDish;
import de.hdm_stuttgart.mi.se2.Inventory;
import de.hdm_stuttgart.mi.se2.Order;


/**
 * Creates dish Kräuterbaguette
 */
public class Kraeuterbaguette implements IDish {

    String description = "Kräuterbaguette";
    int costs = 4;

    /**
     * Removes the ingredients of the dish from the inventory and adds its description and costs to the customers receipt
     */
    @Override
    public boolean removeFromInventory() {
        if (Inventory.ingredients.get("baguette") >= 1000 && Inventory.ingredients.get("herbs") >= 200) {
            Inventory.ingredients.put("baguette", Inventory.ingredients.get("baguette") - 1000);
            Inventory.ingredients.put("herbs", Inventory.ingredients.get("herbs") - 200);

            Order add = new Order();
            add.addToCurrentOrder(description);
            add.addToOrderPrice(costs);
            return true;
        } else {
            return false;
        }
    }
}
