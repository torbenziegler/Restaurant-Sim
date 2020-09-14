package de.hdm_stuttgart.mi.se2.restaurant.french;

import de.hdm_stuttgart.mi.se2.IDish;
import de.hdm_stuttgart.mi.se2.Inventory;
import de.hdm_stuttgart.mi.se2.Order;


/**
 * Creates dish Madeleines
 */
public class Madeleines implements IDish {

    String description = "Madeleines";
    int costs = 4;

    /**
     * Removes the ingredients of the dish from the inventory and adds its description and costs to the customers receipt
     */
    @Override
    public boolean removeFromInventory() {
        if (Inventory.ingredients.get("butter") >= 100 && Inventory.ingredients.get("eggs") >= 20 && Inventory.ingredients.get("sugar") >= 50 && Inventory.ingredients.get("flour") >= 200) {
            Inventory.ingredients.put("butter", Inventory.ingredients.get("butter") - 100);
            Inventory.ingredients.put("eggs", Inventory.ingredients.get("eggs") - 20);
            Inventory.ingredients.put("sugar", Inventory.ingredients.get("sugar") - 50);
            Inventory.ingredients.put("flour", Inventory.ingredients.get("flour") - 200);

            Order add = new Order();
            add.addToCurrentOrder(description);
            add.addToOrderPrice(costs);
            return true;
        } else {
            return false;
        }
    }
}
