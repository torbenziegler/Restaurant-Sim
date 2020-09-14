package de.hdm_stuttgart.mi.se2.restaurant.german;

import de.hdm_stuttgart.mi.se2.IDish;
import de.hdm_stuttgart.mi.se2.Inventory;
import de.hdm_stuttgart.mi.se2.Order;


/**
 * Creates dish Kartoffelsuppe
 */
public class Kartoffelsuppe implements IDish {

    String description = "Kartoffelsuppe";
    int costs = 4;

    /**
     * Removes the ingredients of the dish from the inventory and adds its description and costs to the customers receipt
     */
    @Override
    public boolean removeFromInventory() {
        if (Inventory.ingredients.get("potato") >= 1000 && Inventory.ingredients.get("onion") >= 50 && Inventory.ingredients.get("broth") >= 1000) {
            Inventory.ingredients.put("potato", Inventory.ingredients.get("potato") - 1000);
            Inventory.ingredients.put("onion", Inventory.ingredients.get("onion") - 50);
            Inventory.ingredients.put("broth", Inventory.ingredients.get("broth") - 1000);

            Order add = new Order();
            add.addToCurrentOrder(description);
            add.addToOrderPrice(costs);
            return true;
        } else {
            return false;
        }
    }
}
