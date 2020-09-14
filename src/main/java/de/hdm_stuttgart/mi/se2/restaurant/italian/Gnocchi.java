package de.hdm_stuttgart.mi.se2.restaurant.italian;

import de.hdm_stuttgart.mi.se2.IDish;
import de.hdm_stuttgart.mi.se2.Inventory;
import de.hdm_stuttgart.mi.se2.Order;

/**
 * Creates dish Gnocci
 */
public class Gnocchi implements IDish {

    String description = "Gnocci";
    int costs = 7;

    /**
     * Removes the ingredients of the dish from the inventory and adds its description and costs to the customers receipt
     */
    @Override
    public boolean removeFromInventory() {
        if (Inventory.ingredients.get("potato") >= 350 && Inventory.ingredients.get("eggs") >= 30 && Inventory.ingredients.get("flour") >= 100) {
            Inventory.ingredients.put("potato", Inventory.ingredients.get("potato") - 350);
            Inventory.ingredients.put("eggs", Inventory.ingredients.get("eggs") - 30);
            Inventory.ingredients.put("flour", Inventory.ingredients.get("flour") - 100);

            Order add = new Order();
            add.addToCurrentOrder(description);
            add.addToOrderPrice(costs);
            return true;
        } else {
            return false;
        }


    }
}
