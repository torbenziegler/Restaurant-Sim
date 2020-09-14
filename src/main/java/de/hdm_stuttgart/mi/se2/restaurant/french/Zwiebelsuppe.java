package de.hdm_stuttgart.mi.se2.restaurant.french;

import de.hdm_stuttgart.mi.se2.IDish;
import de.hdm_stuttgart.mi.se2.Inventory;
import de.hdm_stuttgart.mi.se2.Order;


/**
 * Creates dish Zwiebelsuppe
 */
public class Zwiebelsuppe implements IDish {

    String description = "Zwiebelsuppe";
    int costs = 5;

    /**
     * Removes the ingredients of the dish from the inventory and adds its description and costs to the customers receipt
     */
    @Override
    public boolean removeFromInventory() {
        if (Inventory.ingredients.get("onion") >= 500 && Inventory.ingredients.get("flour") >= 20 && Inventory.ingredients.get("broth") >= 100 && Inventory.ingredients.get("cheese") >= 100) {
            Inventory.ingredients.put("onion", Inventory.ingredients.get("onion") - 500);
            Inventory.ingredients.put("flour", Inventory.ingredients.get("flour") - 20);
            Inventory.ingredients.put("broth", Inventory.ingredients.get("broth") - 100);
            Inventory.ingredients.put("cheese", Inventory.ingredients.get("cheese") - 100);

            Order add = new Order();
            add.addToCurrentOrder(description);
            add.addToOrderPrice(costs);
            return true;
        } else {
            return false;
        }


    }
}
