package de.hdm_stuttgart.mi.se2.restaurant.german;

import de.hdm_stuttgart.mi.se2.IDish;
import de.hdm_stuttgart.mi.se2.Inventory;
import de.hdm_stuttgart.mi.se2.Order;


/**
 * Creates dish Maultaschen
 */
public class Maultaschen implements IDish {

    String description = "Maultaschen";
    int costs = 5;

    /**
     * Removes the ingredients of the dish from the inventory and adds its description and costs to the customers receipt
     */
    @Override
    public boolean removeFromInventory() {
        if (Inventory.ingredients.get("water") >= 125 && Inventory.ingredients.get("mince") >= 200 && Inventory.ingredients.get("flour") >= 400 && Inventory.ingredients.get("spinach") >= 400 && Inventory.ingredients.get("eggs") >= 50 && Inventory.ingredients.get("meatsoup") >= 1500) {
            Inventory.ingredients.put("water", Inventory.ingredients.get("water") - 125);
            Inventory.ingredients.put("mince", Inventory.ingredients.get("mince") - 200);
            Inventory.ingredients.put("flour", Inventory.ingredients.get("flour") - 400);
            Inventory.ingredients.put("spinach", Inventory.ingredients.get("spinach") - 400);
            Inventory.ingredients.put("eggs", Inventory.ingredients.get("eggs") - 50);
            Inventory.ingredients.put("meatsoup", Inventory.ingredients.get("meatsoup") - 1500);

            Order add = new Order();
            add.addToCurrentOrder(description);
            add.addToOrderPrice(costs);
            return true;
        } else {
            return false;
        }
    }
}
