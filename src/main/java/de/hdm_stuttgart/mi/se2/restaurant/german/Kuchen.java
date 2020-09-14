package de.hdm_stuttgart.mi.se2.restaurant.german;

import de.hdm_stuttgart.mi.se2.IDish;
import de.hdm_stuttgart.mi.se2.Inventory;
import de.hdm_stuttgart.mi.se2.Order;


/**
 * Creates dish Kuchen
 */
public class Kuchen implements IDish {

    String description = "Kuchen";
    int costs = 3;

    /**
     * Removes the ingredients of the dish from the inventory and adds its description and costs to the customers receipt
     */
    @Override
    public boolean removeFromInventory() {
        if (Inventory.ingredients.get("water") >= 1000 && Inventory.ingredients.get("flour") >= 500 && Inventory.ingredients.get("eggs") >= 20 && Inventory.ingredients.get("sugar") >= 400) {
            Inventory.ingredients.put("water", Inventory.ingredients.get("water") - 1000);
            Inventory.ingredients.put("flour", Inventory.ingredients.get("flour") - 500);
            Inventory.ingredients.put("eggs", Inventory.ingredients.get("eggs") - 20);
            Inventory.ingredients.put("sugar", Inventory.ingredients.get("sugar") - 400);

            Order add = new Order();
            add.addToCurrentOrder(description);
            add.addToOrderPrice(costs);
            return true;
        } else {
            return false;
        }
    }
}
