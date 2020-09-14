package de.hdm_stuttgart.mi.se2.restaurant.german;

import de.hdm_stuttgart.mi.se2.IDish;
import de.hdm_stuttgart.mi.se2.Inventory;
import de.hdm_stuttgart.mi.se2.Order;


/**
 * Creates dish Käsespätzle
 */
public class Kaesespaetzle implements IDish {

    String description = "Käsespätzle";
    int costs = 6;

    /**
     * Removes the ingredients of the dish from the inventory and adds its description and costs to the customers receipt
     */
    @Override
    public boolean removeFromInventory() {
        if (Inventory.ingredients.get("cheese") >= 200 && Inventory.ingredients.get("cream") >= 400 && Inventory.ingredients.get("spaetzle") >= 1000 && Inventory.ingredients.get("onion") >= 50) {
            Inventory.ingredients.put("cheese", Inventory.ingredients.get("cheese") - 200);
            Inventory.ingredients.put("cream", Inventory.ingredients.get("cream") - 400);
            Inventory.ingredients.put("spaetzle", Inventory.ingredients.get("spaetzle") - 1000);
            Inventory.ingredients.put("onion", Inventory.ingredients.get("onion") - 50);

            Order add = new Order();
            add.addToCurrentOrder(description);
            add.addToOrderPrice(costs);
            return true;
        } else {
            return false;
        }

    }
}
