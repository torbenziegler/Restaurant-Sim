package de.hdm_stuttgart.mi.se2.restaurant.german;

import de.hdm_stuttgart.mi.se2.IDish;
import de.hdm_stuttgart.mi.se2.Inventory;
import de.hdm_stuttgart.mi.se2.Order;


/**
 * Creates dish Zwiebelrostbraten
 */
public class Zwiebelrostbraten implements IDish {

    String description = "Zwiebelrostbraten";
    int costs = 9;

    /**
     * Removes the ingredients of the dish from the inventory and adds its description and costs to the customers receipt
     */
    @Override
    public boolean removeFromInventory() {
        if (Inventory.ingredients.get("red wine") >= 200 && Inventory.ingredients.get("beef stock") >= 300 && Inventory.ingredients.get("roastbeef") >= 40) {
            Inventory.ingredients.put("red wine", Inventory.ingredients.get("red wine") - 200);
            Inventory.ingredients.put("beef stock", Inventory.ingredients.get("beef stock") - 300);
            Inventory.ingredients.put("roastbeef", Inventory.ingredients.get("roastbeef") - 40);

            Order add = new Order();
            add.addToCurrentOrder(description);
            add.addToOrderPrice(costs);
            return true;
        } else {
            return false;
        }
    }
}
