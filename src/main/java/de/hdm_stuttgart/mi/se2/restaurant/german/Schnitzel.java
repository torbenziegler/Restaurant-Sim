package de.hdm_stuttgart.mi.se2.restaurant.german;

import de.hdm_stuttgart.mi.se2.IDish;
import de.hdm_stuttgart.mi.se2.Inventory;
import de.hdm_stuttgart.mi.se2.Order;


/**
 * Creates dish Schnitzel
 */
public class Schnitzel implements IDish {

    String description = "Schnitzel";
    int costs = 8;

    /**
     * Removes the ingredients of the dish from the inventory and adds its description and costs to the customers receipt
     */
    @Override
    public boolean removeFromInventory() {
        if (Inventory.ingredients.get("meat") >= 500 && Inventory.ingredients.get("oil") >= 50 && Inventory.ingredients.get("flour") >= 200) {
            Inventory.ingredients.put("meat", Inventory.ingredients.get("meat") - 500);
            Inventory.ingredients.put("oil", Inventory.ingredients.get("oil") - 50);
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
