package de.hdm_stuttgart.mi.se2.restaurant.french;

import de.hdm_stuttgart.mi.se2.IDish;
import de.hdm_stuttgart.mi.se2.Inventory;
import de.hdm_stuttgart.mi.se2.Order;


/**
 * Creates dish French Toast
 */
public class FrenchToast implements IDish {

    String description = "French Toast";
    int costs = 5;

    /**
     * Removes the ingredients of the dish from the inventory and adds its description and costs to the customers receipt
     */
    @Override
    public boolean removeFromInventory() {
        if (Inventory.ingredients.get("toast") >= 500 && Inventory.ingredients.get("eggs") >= 20 && Inventory.ingredients.get("sugar") >= 200) {
            Inventory.ingredients.put("toast", Inventory.ingredients.get("toast") - 500);
            Inventory.ingredients.put("eggs", Inventory.ingredients.get("eggs") - 20);
            Inventory.ingredients.put("sugar", Inventory.ingredients.get("sugar") - 200);

            Order add = new Order();
            add.addToCurrentOrder(description);
            add.addToOrderPrice(costs);
            return true;
        } else {
            return false;
        }
    }
}
