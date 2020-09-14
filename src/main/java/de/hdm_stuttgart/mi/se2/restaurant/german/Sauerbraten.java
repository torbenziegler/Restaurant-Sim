package de.hdm_stuttgart.mi.se2.restaurant.german;

import de.hdm_stuttgart.mi.se2.IDish;
import de.hdm_stuttgart.mi.se2.Inventory;
import de.hdm_stuttgart.mi.se2.Order;


/**
 * Creates dish Sauerbraten
 */
public class Sauerbraten implements IDish {

    String description = "Sauerbraten";
    int costs = 11;

    /**
     * Removes the ingredients of the dish from the inventory and adds its description and costs to the customers receipt
     */
    @Override
    public boolean removeFromInventory() {
        if (Inventory.ingredients.get("water") >= 1000 && Inventory.ingredients.get("roastbeef") >= 500 && Inventory.ingredients.get("vinegar") >= 20 && Inventory.ingredients.get("red wine") >= 400) {
            Inventory.ingredients.put("water", Inventory.ingredients.get("water") - 1000);
            Inventory.ingredients.put("roastbeef", Inventory.ingredients.get("roastbeef") - 500);
            Inventory.ingredients.put("vinegar", Inventory.ingredients.get("vinegar") - 20);
            Inventory.ingredients.put("red wine", Inventory.ingredients.get("red wine") - 400);

            Order add = new Order();
            add.addToCurrentOrder(description);
            add.addToOrderPrice(costs);
            return true;
        } else {
            return false;
        }
    }
}
