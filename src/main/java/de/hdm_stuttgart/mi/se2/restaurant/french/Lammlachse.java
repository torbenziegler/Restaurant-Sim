package de.hdm_stuttgart.mi.se2.restaurant.french;

import de.hdm_stuttgart.mi.se2.IDish;
import de.hdm_stuttgart.mi.se2.Inventory;
import de.hdm_stuttgart.mi.se2.Order;


/**
 * Creates dish Lammlachse
 */
public class Lammlachse implements IDish {

    String description = "Lammlachse";
    int costs = 9;

    /**
     * Removes the ingredients of the dish from the inventory and adds its description and costs to the customers receipt
     */
    @Override
    public boolean removeFromInventory() {
        if (Inventory.ingredients.get("lamb salmon") >= 600 && Inventory.ingredients.get("potato") >= 300 && Inventory.ingredients.get("whipped cream") >= 200 && Inventory.ingredients.get("lamb stock") >= 400) {
            Inventory.ingredients.put("lamb salmon", Inventory.ingredients.get("lamb salmon") - 600);
            Inventory.ingredients.put("potato", Inventory.ingredients.get("potato") - 300);
            Inventory.ingredients.put("whipped cream", Inventory.ingredients.get("whipped cream") - 200);
            Inventory.ingredients.put("lamb stock", Inventory.ingredients.get("lamb stock") - 400);

            Order add = new Order();
            add.addToCurrentOrder(description);
            add.addToOrderPrice(costs);
            return true;
        } else {
            return false;
        }


    }
}
