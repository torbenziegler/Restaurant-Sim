package de.hdm_stuttgart.mi.se2.restaurant.french;

import de.hdm_stuttgart.mi.se2.IDish;
import de.hdm_stuttgart.mi.se2.Inventory;
import de.hdm_stuttgart.mi.se2.Order;


/**
 * Creates dish Französischer Kartoffelsalat
 */
public class FranzoesischerKartoffelSalat implements IDish {

    String description = "Französischer Kartoffelsalat";
    int costs = 6;

    /**
     * Removes the ingredients of the dish from the inventory and adds its description and costs to the customers receipt
     */
    @Override
    public boolean removeFromInventory() {
        if (Inventory.ingredients.get("potato") >= 1000 && Inventory.ingredients.get("onion") >= 100 && Inventory.ingredients.get("broth") >= 20) {
            Inventory.ingredients.put("potato", Inventory.ingredients.get("potato") - 1000);
            Inventory.ingredients.put("onion", Inventory.ingredients.get("onion") - 100);
            Inventory.ingredients.put("broth", Inventory.ingredients.get("broth") - 20);

            Order add = new Order();
            add.addToCurrentOrder(description);
            add.addToOrderPrice(costs);
            return true;
        } else {
            return false;
        }


    }
}
