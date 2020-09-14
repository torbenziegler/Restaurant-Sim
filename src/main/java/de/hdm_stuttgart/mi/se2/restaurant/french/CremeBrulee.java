package de.hdm_stuttgart.mi.se2.restaurant.french;

import de.hdm_stuttgart.mi.se2.IDish;
import de.hdm_stuttgart.mi.se2.Inventory;
import de.hdm_stuttgart.mi.se2.Order;


/**
 * Creates dish Crème brûlée
 */
public class CremeBrulee implements IDish {

    String description = "Crème brûlée";
    int costs = 3;

    /**
     * Removes the ingredients of the dish from the inventory and adds its description and costs to the customers receipt
     */
    @Override
    public boolean removeFromInventory() {
        if (Inventory.ingredients.get("cream") >= 400 && Inventory.ingredients.get("milk") >= 140 && Inventory.ingredients.get("sugar") >= 85 && Inventory.ingredients.get("eggs") >= 250) {
            Inventory.ingredients.put("cream", Inventory.ingredients.get("cream") - 400);
            Inventory.ingredients.put("milk", Inventory.ingredients.get("milk") - 140);
            Inventory.ingredients.put("sugar", Inventory.ingredients.get("sugar") - 85);
            Inventory.ingredients.put("eggs", Inventory.ingredients.get("eggs") - 250);

            Order add = new Order();
            add.addToCurrentOrder(description);
            add.addToOrderPrice(costs);
            return true;
        } else {
            return false;
        }


    }
}
